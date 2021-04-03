package test;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class MainControllerTest {

    @Autowired
    private MainController mainController;
    @MockBean
    LordRepo lordRepo;
    @MockBean
    PlanetRepo planetRepo;
    @Test
    void showAll() {
        lordRepo.findAll();
        planetRepo.findAll();
        Mockito.verify(lordRepo, Mockito.times(1)).findAll();
        Mockito.verify(planetRepo, Mockito.times(1)).findAll();
    }

    @Test
    void addLord() {
        Lord lord = new Lord();
        lordRepo.save(lord);
        Mockito.verify(lordRepo, Mockito.times(1)).save(lord);
    }

    @Test
    void addPlanet() {
        Planet planet = new Planet();
        planetRepo.save(planet);
        Mockito.verify(planetRepo, Mockito.times(1)).save(planet);
    }

    @Test
    void setThings() {
        Planet planet = new Planet(1L, "Test", new Lord());
        planetRepo.save(planet);
        planetRepo.findById(1L);
        Mockito.verify(planetRepo, Mockito.times(1)).findById(1L);
    }

    @Test
    void editThings() {
        Planet planet = new Planet(1L, "Test", new Lord());
        planetRepo.save(planet);
        Mockito.verify(planetRepo, Mockito.times(1)).save(planet);
    }

    @Test
    void deleteThings() {
        Planet planet = new Planet(1L, "Test", new Lord());
        planetRepo.save(planet);
        planetRepo.deleteById(planet.getId());
        Mockito.verify(planetRepo, Mockito.times(1)).deleteById(planet.getId());
    }

    @Test
    void findYoung() {
        Lord lord = new Lord (1L, "test", 20);
        lordRepo.save(lord);
        lordRepo.findAllByOrderByAgeAsc();
        Mockito.verify(lordRepo, Mockito.times(1)).findAllByOrderByAgeAsc();
    }

    @Test
    void findFree() {
        Lord lord = new Lord (1L, "test", 20);
        lordRepo.save(lord);
        lordRepo.findAllByPlanetSetNull();
        Mockito.verify(lordRepo, Mockito.times(1)).findAllByPlanetSetNull();
    }
}