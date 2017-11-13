package bdyb.org.generator.domain;

import bdyb.org.generator.enums.Gender;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String phoneNumber;
    private String name;
    private String surname;
    private Integer age;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    private String voivodeship;

    @OneToMany(mappedBy = "customer")
    private Set<Sale> sales;

}
