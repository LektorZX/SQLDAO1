package DAO1;

import REST.Restaraunt;
import REST.Review;
import exeption.DAOExeption;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import util.ConnectionManager;

import java.sql.*;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Dao_Review {
    private static final Dao_Review INSTANSE = new Dao_Review();
    private static final String SAVE = "INSERT INTO review (text, restaraunt_id) VALUES (?,?)";

    public static Dao_Review getINSTANSE() {
        return INSTANSE;
    }

    public static Long save(@NonNull Review review) {
        Long id = null;
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE,Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, review.getText());
            preparedStatement.setInt(2,
                    Optional.ofNullable(review.getRestaraunt())
                            .map(Restaraunt::getId)
                            .orElse(null));
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            while (generatedKeys.next()){
                id=generatedKeys.getLong(1);
                review.setId(id);
            }
        } catch (SQLException e) {
            throw new DAOExeption(e);
        }
return id;
    }


}
