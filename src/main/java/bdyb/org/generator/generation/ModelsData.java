package bdyb.org.generator.generation;

import bdyb.org.generator.dto.ManufacturerAndModelDto;

import java.util.ArrayList;
import java.util.List;

public class ModelsData {
    public static final List<ManufacturerAndModelDto> PASSENGER_CAR_MODELS;
    public static final List<ManufacturerAndModelDto> OFF_ROAD_CAR_MODELS;
    public static final List<ManufacturerAndModelDto> TRUCK_CAR_MODELS;

    static {
        PASSENGER_CAR_MODELS = new ArrayList<>();
        OFF_ROAD_CAR_MODELS = new ArrayList<>();
        TRUCK_CAR_MODELS = new ArrayList<>();
        // Oldsmobile
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Oldsmobile").model("Curved Dash").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Oldsmobile").model("Cutlass").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Oldsmobile").model("Cutlass Supreme").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Oldsmobile").model("Cutlass Calais").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Oldsmobile").model("Cutlass Ciera").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Oldsmobile").model("Custom Cruiser").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Oldsmobile").model("Toronado").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Oldsmobile").model("Aurora").build());
        // Ford
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Ford").model("999").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Ford").model("Aspire").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Ford").model("Bronco").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Ford").model("Contour").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Ford").model("Crestline").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Ford").model("Crown Victoria").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Ford").model("Custom").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Ford").model("Escort").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Ford").model("Focus").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Ford").model("Freestyle").build());
        // Lamborghini
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Lamborghini").model("Miura P400").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Lamborghini").model("Espada Prototype").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Lamborghini").model("Islero 400 GT").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Lamborghini").model("Jarama 400 GT").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Lamborghini").model("Miura Jota").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Lamborghini").model("Countach LP5000").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Lamborghini").model("Urraco P250").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Lamborghini").model("Urraco Rallye").build());
        // Alfa Romeo
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Alfa Romeo").model("4C").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Alfa Romeo").model("Giulietta").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Alfa Romeo").model("Giulia").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Alfa Romeo").model("MiTo").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Alfa Romeo").model("Stelvio").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Alfa Romeo").model("33 Stradale").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Alfa Romeo").model("Arna").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Alfa Romeo").model("Spider Duetto").build());
        PASSENGER_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Alfa Romeo").model("Sprint").build());

        // Off-Roads
        OFF_ROAD_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Chevrolet").model("Colorado ZR2").build());
        OFF_ROAD_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Toyota").model("4Runner TRD Pro").build());
        OFF_ROAD_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Toyota").model("Land Cruiser").build());
        OFF_ROAD_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Toyota").model("FJ").build());
        OFF_ROAD_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Jeep").model("Wrangler Rubicon").build());
        OFF_ROAD_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Jeep").model("Grand Cherokee Overland").build());
        OFF_ROAD_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("RAM").model("Power Wagon").build());
        OFF_ROAD_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("RAM").model("Rebel").build());
        OFF_ROAD_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Ford").model("Raptor").build());
        OFF_ROAD_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Ford").model("Super Duty").build());
        OFF_ROAD_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Land Rover").model("Range Rover").build());
        OFF_ROAD_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Mercedes-Benz").model("G500").build());

        // Trucks
        TRUCK_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Chevrolet").model("Colorado").build());
        TRUCK_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Chevrolet").model("Silverado 1500").build());
        TRUCK_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Chevrolet").model("Silverado 2500HD").build());
        TRUCK_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Chevrolet").model("Silverado 3500HD").build());
        TRUCK_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Ford").model("F-150").build());
        TRUCK_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Ford").model("F-150 Raptor").build());
        TRUCK_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Ford").model("F-250 Super Duty").build());
        TRUCK_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Ford").model("F-350 Super Duty").build());
        TRUCK_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Ford").model("F-450 Super Duty").build());
        TRUCK_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("GMC").model("Sierra 3500HD").build());
        TRUCK_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("RAM").model("3500").build());
        TRUCK_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("RAM").model("1500").build());
        TRUCK_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Nissan").model("Titan").build());
        TRUCK_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Nissan").model("Titan XD").build());
        TRUCK_CAR_MODELS.add(ManufacturerAndModelDto.builder().manufacturer("Nissan").model("Frontier").build());
    }
}
