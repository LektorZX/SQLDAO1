package Servis;

import DAO1.Dao_Rest;
import REST.Restaraunt;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class RestServis {
    private static final RestServis INSTANSE=new RestServis();


    public static RestServis getINSTANSE() {
        return INSTANSE;
    }
    public List<Restaraunt> getAll(){
        return Dao_Rest.getInstanse().getAll();
    }

}
