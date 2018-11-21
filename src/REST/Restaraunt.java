package REST;

import lombok.*;

@Builder
@Data
@EqualsAndHashCode(of="id")
@NoArgsConstructor
@AllArgsConstructor

public class Restaraunt {
    private Integer id;
    private String name;


}
