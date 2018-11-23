package DAO1;

import REST.Restaraunt;
import org.junit.Test;

import static org.junit.Assert.*;

public class Dao_RestTest {
    private Dao_Rest dao=Dao_Rest.getInstanse();
    @Test
    public void cheskDao_restSave(){
        Restaraunt builder = Restaraunt.builder()
                .name("test12")
                .build();
        dao.save(builder);
        assertNotNull("проверка ",builder.getId());//проверка если айди = нал то что то не так
    }

}