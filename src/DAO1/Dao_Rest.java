package DAO1;

import REST.Restaraunt;
import exeption.DAOExeption;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Dao_Rest {

    private static final Dao_Rest INSTANSE = new Dao_Rest();
    private static final String SAVE = "INSERT INTO restaraunt(name) VALUES (?);";
    private static final String GET_ALL="SELECT id,name FROM restaraunt ";

    public static Dao_Rest getInstanse() {
        return INSTANSE;
    }

    public List<Restaraunt> getAll(){
        List<Restaraunt> rest=new ArrayList<>();

        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                rest.add(new Restaraunt().builder()
                .id(resultSet.getInt(1))
                .name(resultSet.getString("name"))
                .build());
            }


        } catch (SQLException e) {
            new DAOExeption(e);
        }
        for (Restaraunt restaraunt : rest) {
            System.out.println(restaraunt);
        }
        return rest;


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
