package bdyb.org.generator.generation;

import bdyb.org.generator.config.Constants;
import bdyb.org.generator.domain.*;
import bdyb.org.generator.dto.ManufacturerAndModelDto;
import bdyb.org.generator.dto.NewCustomerDto;
import bdyb.org.generator.enums.CarStatus;
import bdyb.org.generator.enums.CarType;
import bdyb.org.generator.enums.Colour;
import bdyb.org.generator.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class GenerateData {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CarFeatureRepository carFeatureRepository;
    @Autowired
    private CarModelRepository carModelRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private SaleRepository saleRepository;

    private static final int CARS_NUMBER = 100000;

    @Bean
    public boolean generate() {
        generateCarModels();
        generateCarFeatures();
        generateCustomers();
        generateCars();
        return true;
    }

    private void generateCars() {
        List<CarModel> allModels = carModelRepository.findAll();
        int modelsQuantity = allModels.size();
        for (int i = 0; i < CARS_NUMBER; i++) {
            carRepository.save(Car.builder()
                    .carStatus(CarStatus.FOR_SALE)
                    .currentMileage(new Random().nextLong()% Constants.CAR_MAX_MILEAGE)
                    .askingPrice(Math.abs(new Random().nextLong()%Constants.CAR_MAX_ASKING_PRICE))
                    .productionYear(Math.abs(new Random().nextInt(Constants.CAR_PRODUCTION_UP_BOUNDARY - Constants.CAR_PRODUCTION_DOWN_BOUNDARY) + Constants.CAR_PRODUCTION_DOWN_BOUNDARY))
                    .colour(Colour.values()[new Random().nextInt(Colour.values().length)])
                    .carModel(allModels.get(new Random().nextInt(modelsQuantity)))
                    .build());
        }

    }

    private void generateCarModels() {
        // passenger
        for (ManufacturerAndModelDto modelDto : ModelsData.PASSENGER_CAR_MODELS) {
            carModelRepository.save(CarModel.builder()
                    .carType(CarType.PASSENGER_CAR)
                    .manufacturer(modelDto.getManufacturer())
                    .name(modelDto.getModel())
                    .build());
        }
        // off-road
        for (ManufacturerAndModelDto modelDto : ModelsData.OFF_ROAD_CAR_MODELS) {
            carModelRepository.save(CarModel.builder()
                    .carType(CarType.OFF_ROAD_CAR)
                    .manufacturer(modelDto.getManufacturer())
                    .name(modelDto.getModel())
                    .build());
        }
        // truck
        for (ManufacturerAndModelDto modelDto : ModelsData.TRUCK_CAR_MODELS) {
            carModelRepository.save(CarModel.builder()
                    .carType(CarType.TRUCK)
                    .manufacturer(modelDto.getManufacturer())
                    .name(modelDto.getModel())
                    .build());
        }
    }

    private void generateCarFeatures() {
        for (String carFeature : CarFeaturesData.CAR_FEATURES) {
            carFeatureRepository.save(CarFeature.builder().description(carFeature).build());
        }
    }

    private void generateCustomers() {
        for (NewCustomerDto newCustomer : CustomersData.NEW_CUSTOMERS) {
            customerRepository.save(Customer.builder()
                    .email(newCustomer.getEmail())
                    .phoneNumber(newCustomer.getPhoneNumber())
                    .name(newCustomer.getName())
                    .surname(newCustomer.getSurname())
                    .birthday(newCustomer.getBirthday())
                    .gender(newCustomer.getGender())
                    .address(addressRepository.save(Address.builder()
                            .addressLineOne(newCustomer.getAddressLineOne())
                            .addressLineTwo(newCustomer.getAddressLineTwo())
                            .addressLineThree(newCustomer.getAddressLineThree())
                            .addressLineFour(newCustomer.getAddressLineFour())
                            .townCity(newCustomer.getTownCity())
                            .stateCountyProvince(newCustomer.getStateCountyProvince())
                            .country(newCustomer.getCountry())
                            .zipCode(newCustomer.getZipCode())
                            .build()))
                    .build());
        }
    }

}
