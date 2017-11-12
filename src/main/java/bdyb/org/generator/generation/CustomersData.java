package bdyb.org.generator.generation;

import bdyb.org.generator.config.Constants;
import bdyb.org.generator.dto.NewCustomerDto;
import bdyb.org.generator.enums.Gender;
import org.joda.time.DateTime;

import java.util.*;

public class CustomersData {

    public static final List<NewCustomerDto> NEW_CUSTOMERS;

    static {
        NEW_CUSTOMERS = new ArrayList<>();
        for (int i = 0; i < Constants.CUSTOMERS_NUMBER; i++) {
            NEW_CUSTOMERS.add(NewCustomerDto.builder()
                    .email("email" + i + "@example.com")
                    .phoneNumber("789456132")
                    .name("FirstName" + i)
                    .surname("LastName" + i)
                    .birthday(getBirthday())
                    .gender(getGender())
                    .addressLineOne("nevermind" + i)
                    .townCity("nevermind" + i)
                    .stateCountyProvince(getVoivodeship())
                    .country("Polska")
                    .zipCode("10-100")
                    .build());
        }
    }

    private static String getVoivodeship() {
        List<String> voivodeships = new ArrayList<>();
        voivodeships.addAll(Arrays.asList(
                "dolnośląskie",
                "kujawsko-pomorskie",
                "lubelskie",
                "lubuskie",
                "łódzkie",
                "małopolskie",
                "mazowieckie",
                "opolskie",
                "podkarpackie",
                "podlaskie",
                "pomorskie",
                "śląskie",
                "świętokrzyskie",
                "warmińsko-mazurskie",
                "wielkopolskie",
                "zachodniopomorskie"));
        return voivodeships.get(new Random().nextInt(16));
    }

    private static Gender getGender() {
        Random random = new Random();
        return random.nextBoolean() ? Gender.MALE : Gender.FEMALE;
    }


    private static Date getBirthday() {
        return new DateTime(new Date()).withTimeAtStartOfDay().minusYears(18).minusYears(new Random().nextInt(Constants.CUSTOMER_MAX_AGE + 18)).toDate();
    }
}
