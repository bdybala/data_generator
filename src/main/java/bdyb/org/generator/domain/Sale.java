package bdyb.org.generator.domain;

import bdyb.org.generator.enums.SaleStatus;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salesId;
    @Enumerated(value = EnumType.STRING)
    private SaleStatus saleStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany(cascade = {
            CascadeType.MERGE
    })
    @JoinTable(name = "sale_car_feature",
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "car_feature_id"))
    private Set<CarFeature> carFeatures;
}
