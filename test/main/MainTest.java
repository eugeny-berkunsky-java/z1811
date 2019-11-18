package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void numMax() {
        int expected = 3;
        int res = main.numMax(new double[]{3, 2, 1, 8, 4, 7});
        assertEquals(expected, res);
    }

    @Test
    void numMin() {
        int expected = 2;
        int res = main.numMin(new double[]{3, 2, 1, 8, 4, 7});
        assertEquals(expected, res);
    }

    @Test
    void sum() {
        double expected = 25.7;
        double res = main.sum(new double[]{3.2, 2.1, 1.1, 8.1, 4.1, 7.1});
        assertEquals(expected, res, 1e-9);
    }
}