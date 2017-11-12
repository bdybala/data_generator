package bdyb.org.generator.repository;

import bdyb.org.generator.domain.CarFeature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarFeatureRepository extends JpaRepository<CarFeature, Long> {
}
