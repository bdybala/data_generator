package bdyb.org.generator.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class ManufacturerAndModelDto {
    private String manufacturer;
    private String model;
}
