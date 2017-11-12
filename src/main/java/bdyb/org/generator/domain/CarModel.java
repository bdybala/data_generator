package bdyb.org.generator.domain;

import bdyb.org.generator.enums.CarType;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carModelId;
    private String manufacturer;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private CarType carType;
}
