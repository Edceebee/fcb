package com.fcb.fcb.aiAssessment;

import com.fcb.fcb.aiAssessment.entities.Calculation;
import com.fcb.fcb.aiAssessment.service.CalculationService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class ApplicationTests {

    @Autowired
    CalculationService calculationService;

    @Test
    void testThatWeCanAddNumbersInAnArray() {
        Calculation calculation = new Calculation();
        ArrayList<Integer> values = new ArrayList<>(List.of(1,2,3,4));
        calculation.setOperation("+");
        calculation.setReportedAnswer(19);
        calculation.setValues(values);

        calculationService.calculateValues(calculation);
        assertThat(calculation).isNotNull();
        log.info("calculation entity -> {}", calculation);
        assertThat(calculation.getActualAnswer()).isEqualTo(10);
        assertThat(calculation.getReportedAnswer()).isEqualTo(19);
        assertThat(calculation.getOperation()).isEqualTo("+");
        assertThat(calculation.isCorrect()).isEqualTo(false);

    }

    @Test
    void testThatWeCanGetAverageNumbersInAnArray() {
        Calculation calculation = new Calculation();
        ArrayList<Integer> values = new ArrayList<>(List.of(2,5,7,5,3,4,5,6,7,8,9,4,3,4));
        calculation.setOperation("μ");
        calculation.setReportedAnswer(7);
        calculation.setValues(values);

        calculationService.calculateValues(calculation);
        assertThat(calculation).isNotNull();
        log.info("calculation entity -> {}", calculation);
        assertThat(calculation.getActualAnswer()).isEqualTo(5.142857142857143);
        assertThat(calculation.getReportedAnswer()).isEqualTo(7);
        assertThat(calculation.getOperation()).isEqualTo("μ");
        assertThat(calculation.isCorrect()).isEqualTo(false);
    }


    @Test
    void testThatWeCanGetStandardDeviationInAnArray() {
        Calculation calculation = new Calculation();
        ArrayList<Integer> values = new ArrayList<>(List.of(2,5,7,5,3,4,5,6));
        calculation.setOperation("SD");
        calculation.setReportedAnswer(15);
        calculation.setValues(values);

        calculationService.calculateValues(calculation);
        assertThat(calculation).isNotNull();
        log.info("calculation entity -> {}", calculation);

        assertThat(calculation.getReportedAnswer()).isEqualTo(15);
        assertThat(calculation.getOperation()).isEqualTo("SD");
        assertThat(calculation.isCorrect()).isEqualTo(false);
        assertThat(calculation.getActualAnswer()).isEqualTo(calculation.getActualAnswer());
    }


}
