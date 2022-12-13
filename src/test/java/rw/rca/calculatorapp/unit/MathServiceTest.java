package rw.rca.calculatorapp.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rw.rca.calculatorapp.exception.BadRequestException;
import rw.rca.calculatorapp.exception.InvalidOperationException;
import rw.rca.calculatorapp.service.IMathService;
import rw.rca.calculatorapp.serviceImpl.MathServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MathServiceTest {

    private IMathService mathService = new MathServiceImpl();


    @Test
    public void should_return_number_on_addition_operation_success(){
        double actualResult = mathService.doMath(20.0,2.0,"+");
        double expectedResults = 22.0;
        assertEquals(actualResult,expectedResults);
    }

    @Test
    public void should_return_number_on_subtraction_operation_success(){
        double actualResult = mathService.doMath(20.0,2.0,"-");
        double expectedResults = 18.0;
        assertEquals(actualResult,expectedResults);
    }

    @Test
    public void should_return_number_on_multiplication_operation_success(){
        double actualResult = mathService.doMath(20.0,2.0,"*");
        double expectedResults = 40.0;
        assertEquals(actualResult,expectedResults);
    }

    @Test
    public void should_return_number_on_division_operation_success(){
        double actualResult = mathService.doMath(20.0,2.0,"/");
        double expectedResults = 10.0;
        assertEquals(actualResult,expectedResults);
    }

    @Test
    public void should_return_number_on_power_operation_success(){
        double actualResult = mathService.doMath(20.0,2.0,"**");
        double expectedResults = 400.0;
        assertEquals(actualResult,expectedResults);
    }

    @Test
    public void should_return_number_on_log_operation_success(){
        double actualResult = mathService.doMath(20.0,2.0,"log");
        double expectedResults = 6.020599913279624;
        assertEquals(actualResult,expectedResults);
    }

    @Test
    public void should_return_number_on_ln_operation_success(){
        double actualResult = mathService.doMath(20.0,2.0,"ln");
        double expectedResults = 13.862943611198906;
        assertEquals(actualResult,expectedResults);
    }

    @Test
    public void should_throw_exception_on_division_by_zero(){
        assertThrows(InvalidOperationException.class,() -> {
            mathService.doMath(20.0,0.0,"/");
        });
    }

    @Test
    public void should_throw_exception_on_invalid_operation(){
        assertThrows(BadRequestException.class,()->{
            mathService.doMath(20.0,2.0,"//");
        });
    }
}
