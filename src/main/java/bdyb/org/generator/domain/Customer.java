package bdyb.org.generator.domain;

import bdyb.org.generator.enums.Gender;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    private String email;
    private String phoneNumber;
    private String name;
    private String surname;
    private Date birthday;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "customer")
    private List<Sale> sales;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;
}
