package DAO1;
import REST.Restaraunt;
import REST.Review;
import exeption.DAOExeption;
import org.junit.Test;
import util.ConnectionManager;

import java.sql.*;

import static org.junit.Assert.*;
//проверка сохранения комментов
public class Dao_ReviewTest {
    private static Integer id=null;//айди ресторана по которому лепим коммент
    private static final String REST="test1";//имя рсторана
    private Dao_Review dao =Dao_Review.getINSTANSE();
    private static final String GET_ID="SELECT * FROM restaraunt WHERE restaraunt.name='test1'";
@Test
    public void checkReviewSaving() {
    getId();//находим айди ресторана по имени меняем нашайди нулл на нужный
    Review build = Review.builder()
            .text("some message 12")//коммент
            .restaraunt(Restaraunt.builder().id(id).build())//ставим айди и собираем обьект
            .build();
    Dao_Review.save(build);//передаем обьект в метод который проверяем
    assertNotNull(build.getId());//проверка что айдишник прошел и не нал
    }
    @Test
    public void getId(){
        try (Connection connection = ConnectionManager.get();//создали соединение
             Statement statement = connection.createStatement())//берем обьект для запросов в бд
             {
                 ResultSet resultSet = statement.executeQuery(GET_ID);//берем поле айди(запрос в бд)
                 while (resultSet.next())
                 id=resultSet.getInt(1);//заносим айди в нашу переменную используем выше
             }catch (SQLException e){
            throw new DAOExeption(e);
        }
        System.out.println(id);

    }
}