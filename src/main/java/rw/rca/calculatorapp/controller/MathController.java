package rw.rca.calculatorapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.rca.calculatorapp.dto.DoMathRequest;
import rw.rca.calculatorapp.exception.InvalidOperationException;
import rw.rca.calculatorapp.payload.ApiResponse;
import rw.rca.calculatorapp.service.IMathService;

@RestController
@RequestMapping("/api/v1/math")
public class MathController {

    private final IMathService mathService;

    public MathController(IMathService mathService) {
        this.mathService = mathService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> doMath(@RequestBody DoMathRequest dto){
        return ResponseEntity.ok(ApiResponse.success(mathService.doMath(dto.getOperand1(),dto.getOperand2(),dto.getOperation())));
    }
}
