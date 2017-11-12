package bdyb.org.generator.repository;

import bdyb.org.generator.domain.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarModelRepository extends JpaRepository<CarModel, Long> {
}
