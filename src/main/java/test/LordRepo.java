package test;

import org.springframework.data.jpa.repository.JpaRepository;



public interface LordRepo extends JpaRepository<Lord, Long> {
    Iterable<Lord> findAllByPlanetSetNull();
    Iterable<Lord> findAllByOrderByAgeAsc();
}
