package bdyb.org.generator.domain;

import bdyb.org.generator.enums.CarStatus;
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
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;
    @Enumerated(value = EnumType.STRING)
    private CarStatus carStatus;
    private Long currentMileage;
    private Long askingPrice;
    private Integer productionYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "colour_id")
    private Colour colour;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_model_id")
    private CarModel carModel;

    @OneToOne(mappedBy = "car")
    private Sale sale;
}
