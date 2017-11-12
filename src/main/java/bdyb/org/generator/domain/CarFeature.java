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
public class CarFeature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carFeatureId;
    private String description;
}
