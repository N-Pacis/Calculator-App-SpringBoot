package rw.rca.calculatorapp;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import rw.rca.calculatorapp.e2e.MathControllerTest;
import rw.rca.calculatorapp.unit.MathServiceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MathControllerTest.class,
        MathServiceTest.class
})
class CalculatorAppApplicationTests {
    @Test
    void contextLoads() {
    }
}
