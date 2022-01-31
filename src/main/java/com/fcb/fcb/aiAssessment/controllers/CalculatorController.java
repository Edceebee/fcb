package com.fcb.fcb.aiAssessment.controllers;

import com.fcb.fcb.aiAssessment.entities.Calculation;
import com.fcb.fcb.aiAssessment.entities.CalculatorDto;
import com.fcb.fcb.aiAssessment.service.CalculationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    @Autowired
    CalculationService calculationService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/")
    public Calculation calculateValues (@RequestBody CalculatorDto calculatorDto) {
        Calculation newCalculation = modelMapper.map(calculatorDto, Calculation.class);
        calculationService.calculateValues(newCalculation);

        modelMapper.map(newCalculation, Calculation.class);
        return newCalculation;

    }

    @GetMapping("")
    public List<Calculation> getAllCalculations () {
        return calculationService.getAllcalculations();
    }
}
