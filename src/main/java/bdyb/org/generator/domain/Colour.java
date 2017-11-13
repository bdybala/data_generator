package bdyb.org.generator.domain;

import bdyb.org.generator.enums.VarnishType;
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
public class Colour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long colourId;
    private String description;
    @Enumerated(EnumType.STRING)
    private VarnishType varnishType;

}
