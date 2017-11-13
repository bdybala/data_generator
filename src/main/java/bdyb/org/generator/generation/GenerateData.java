package bdyb.org.generator.generation;

import bdyb.org.generator.config.Constants;
import bdyb.org.generator.domain.Car;
import bdyb.org.generator.domain.CarModel;
import bdyb.org.generator.domain.Customer;
import bdyb.org.generator.domain.Sale;
import bdyb.org.generator.dto.ManufacturerAndModelDto;
import bdyb.org.generator.enums.*;
import bdyb.org.generator.repository.CarModelRepository;
import bdyb.org.generator.repository.CarRepository;
import bdyb.org.generator.repository.CustomerRepository;
import bdyb.org.generator.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class GenerateData {

    private final Random random = new Random();

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
        generateCustomers();
        generateCars();
        generateSales();
        return true;
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

    private void generateCustomers() {
        for (Customer newCustomer : CustomersData.NEW_CUSTOMERS) {
            customerRepository.save(newCustomer);
        }
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

    void generateSales() {
        List<Customer> customers = customerRepository.findAll();
        List<Car> cars = carRepository.findAll();
        for (int i = 0; i < Constants.SALES_NUMBER; i++) {
            saleRepository.save(Sale.builder()
                    .saleStatus(SaleStatus.values()[random.nextInt(SaleStatus.values().length)])
                    .carFeatures(getCarFeatures())
                    .customer(getCustomer(customers))
                    .car(getCar(cars))
                    .build());
        }
    }

    private Customer getCustomer(List<Customer> customers) {
        return customers.get(random.nextInt(customers.size()));
    }

    private String getCarFeatures() {
        String features = "";
        for (CarFeature feature : CarFeature.values()) {
            if (random.nextBoolean()) {
                features = features.concat(feature.toString() + ";");
            }
        }
        return features;
    }

    private Car getCar(List<Car> cars) {
        Car removedCar = cars.remove(random.nextInt(cars.size()));
        removedCar.setCarStatus(random.nextBoolean() ? CarStatus.RESERVED : CarStatus.RESERVED);
        return carRepository.save(removedCar);
    }


}
