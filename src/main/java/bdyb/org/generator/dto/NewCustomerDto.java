package bdyb.org.generator.dto;

import bdyb.org.generator.enums.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@Builder
@ToString
public class NewCustomerDto {
    // customer
    private String email;
    private String phoneNumber;
    private String name;
    private String surname;
    private Date birthday;
    private Gender gender;
    // address
    private String addressLineOne;
    private String addressLineTwo;
    private String addressLineThree;
    private String addressLineFour;
    private String townCity;
    private String stateCountyProvince;
    private String country;
    private String zipCode;

}
