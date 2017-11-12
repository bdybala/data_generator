package bdyb.org.generator.domain;

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
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String addressLineOne;
    private String addressLineTwo;
    private String addressLineThree;
    private String addressLineFour;
    private String townCity;
    private String stateCountyProvince;
    private String country;
    private String zipCode;

    @OneToOne(mappedBy = "address")
    private Customer customer;
}
