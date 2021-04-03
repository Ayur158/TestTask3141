package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class PlanetTest {

    @Test
    void testEquals() {
        Lord lord = new Lord();
        Planet planet1 = new Planet(1L, "Earth", lord);
        Planet planet2 = new Planet(1L, "Earth", lord);
        Assertions.assertTrue(planet1.equals(planet2));
    }
}