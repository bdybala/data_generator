package bdyb.org.generator.generation;

import bdyb.org.generator.config.Constants;
import bdyb.org.generator.domain.Customer;
import bdyb.org.generator.enums.Gender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CustomersData {

    public static final List<Customer> NEW_CUSTOMERS;
    private static final Random random = new Random();

    static {
        NEW_CUSTOMERS = new ArrayList<>();
        for (int i = 0; i < Constants.CUSTOMERS_NUMBER; i++) {
            NEW_CUSTOMERS.add(Customer.builder()
                    .phoneNumber("789456132")
                    .name("FirstName" + i)
                    .surname("LastName" + i)
                    .age(getAge())
                    .gender(getGender())
                    .voivodeship(getVoivodeship())
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
        return voivodeships.get(random.nextInt(16));
    }

    private static Gender getGender() {
        return random.nextBoolean() ? Gender.MALE : Gender.FEMALE;
    }

    private static int getAge() {
        return random.nextInt(Constants.CUSTOMER_MAX_AGE - 18) + 18;
    }

}
