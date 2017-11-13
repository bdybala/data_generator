package bdyb.org.generator.generation;

import bdyb.org.generator.config.Constants;
import bdyb.org.generator.domain.*;
import bdyb.org.generator.dto.ManufacturerAndModelDto;
import bdyb.org.generator.dto.NewCustomerDto;
import bdyb.org.generator.enums.CarStatus;
import bdyb.org.generator.enums.CarType;
import bdyb.org.generator.enums.Colour;
import bdyb.org.generator.enums.SaleStatus;
import bdyb.org.generator.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Component
public class GenerateData {

    private final Random random = new Random();

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


    @Bean
    public boolean generate() {
        generateCarModels();
        generateCarFeatures();
        generateCustomers();
        generateCars();
        generateSales();
        return true;
    }

    void generateSales() {
        List<Customer> customers = customerRepository.findAll();
        List<CarFeature> carFeatures = carFeatureRepository.findAll();
        List<Car> cars = carRepository.findAll();
        for (int i = 0; i < Constants.SALES_NUMBER; i++) {
            saleRepository.save(Sale.builder()
                    .saleStatus(SaleStatus.values()[random.nextInt(SaleStatus.values().length)])
                    .customer(getCustomer(customers))
                    .carFeatures(getCarFeatures(carFeatures))
                    .car(getCar(cars))
                    .build());
        }
    }

    private Car getCar(List<Car> cars) {
        Car removedCar = cars.remove(random.nextInt(cars.size()));
        removedCar.setCarStatus(random.nextBoolean() ? CarStatus.RESERVED : CarStatus.SOLD);
        return carRepository.save(removedCar);
    }

    private Set<CarFeature> getCarFeatures(List<CarFeature> carFeatures) {
        int numberOfFeatures = carFeatures.size();
        HashSet<CarFeature> featuresToAdd = new HashSet<>();
        for (int i = 0; i < random.nextInt(numberOfFeatures); i++) {
            featuresToAdd.add(carFeatures.get(random.nextInt(numberOfFeatures)));
        }
        return featuresToAdd;
    }

    private Customer getCustomer(List<Customer> customers) {
        return customers.get(random.nextInt(customers.size()));
    }


    private void generateCars() {
        List<CarModel> allModels = carModelRepository.findAll();
        int modelsQuantity = allModels.size();
        for (int i = 0; i < Constants.CARS_NUMBER; i++) {
            carRepository.save(Car.builder()
                    .carStatus(CarStatus.FOR_SALE)
                    .currentMileage(random.nextLong() % Constants.CAR_MAX_MILEAGE)
                    .askingPrice(Math.abs(random.nextLong() % Constants.CAR_MAX_ASKING_PRICE))
                    .productionYear(Math.abs(random.nextInt(Constants.CAR_PRODUCTION_UP_BOUNDARY - Constants.CAR_PRODUCTION_DOWN_BOUNDARY) + Constants.CAR_PRODUCTION_DOWN_BOUNDARY))
                    .colour(Colour.values()[random.nextInt(Colour.values().length)])
                    .carModel(allModels.get(random.nextInt(modelsQuantity)))
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
