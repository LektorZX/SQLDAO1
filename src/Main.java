import DAO1.Dao_Rest;
import REST.Restaraunt;

import javax.sound.midi.SoundbankResource;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        driver();
//        Restaraunt restaraunt=Restaraunt.builder()
//                .name("first")
//                .build();
        Dao_Rest instanse = Dao_Rest.getInstanse();
//        instanse.save(restaraunt);
//        System.out.println(restaraunt.getName()+" "+restaraunt.getId());
        List<Restaraunt> all = instanse.getAll();

    }
    private static void driver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
