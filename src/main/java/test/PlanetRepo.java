package test;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepo extends JpaRepository<Planet, Long> {
}
