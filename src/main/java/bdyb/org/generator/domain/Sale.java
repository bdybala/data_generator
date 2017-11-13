package bdyb.org.generator.domain;

import bdyb.org.generator.enums.PaymentType;
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
    @Enumerated(value = EnumType.STRING)
    private PaymentType paymentType;
    private String carFeatures;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
