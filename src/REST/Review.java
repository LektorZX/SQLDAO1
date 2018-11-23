package REST;
//id   BIGSERIAL PRIMARY KEY,
//        text CHARACTER VARYING,
//        restaraunt_id INTEGER,


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Review {
    private Long id;
    private String text;
    private Restaraunt restaraunt;




}
