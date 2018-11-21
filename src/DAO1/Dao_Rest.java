package DAO1;

import REST.Restaraunt;
import exeption.DAOExeption;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import util.ConnectionManager;

import java.sql.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Dao_Rest {

    private static final Dao_Rest INSTANSE = new Dao_Rest();
    private static final String SAVE = "INSERT INTO restaraunt(name) VALUES (?);";

    public static Dao_Rest getInstanse() {
        return INSTANSE;
    }

    public Integer save(Restaraunt restaraunt) {
        Integer id = null;
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, restaraunt.getName());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
                restaraunt.setId(id);
            }

        } catch (SQLException e) {
            throw new DAOExeption(e);
        }


        return id;

    }


}
