package com.fcb.fcb.aiAssessment.service;

import com.fcb.fcb.aiAssessment.entities.Calculation;
import com.fcb.fcb.aiAssessment.repository.CalculationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CalculationService {

    @Autowired
    CalculationRepository calculationRepository;

    public void calculateValues(Calculation calculation) {

            if (Objects.equals(calculation.getOperation(), "+")) {
                int sum = 0;
                for (int num : calculation.getValues()) {
                    sum = sum + num;
                }
                calculation.setActualAnswer(sum);
                if (calculation.getActualAnswer() == calculation.getReportedAnswer()) {
                    calculation.setCorrect(true);
                }
            }

            if (Objects.equals(calculation.getOperation(), "μ")) {
                double total = 0;
                for (int i = 0; i < calculation.getValues().size(); i++) {
                    total = total + calculation.getValues().get(i);
                }
                double average = total / calculation.getValues().size();
                calculation.setActualAnswer(average);
                if (calculation.getActualAnswer() == calculation.getReportedAnswer()) {
                    calculation.setCorrect(true);
                }
            }

            if (Objects.equals(calculation.getOperation(), "SD")) {
                double sum = 0;
                double mean;
                for (int i = 0; i < calculation.getValues().size(); i++) {
                    sum = sum + calculation.getValues().get(i);
                }
                mean = sum / calculation.getValues().size();
                sum = 0;
                for (int i = 0; i < calculation.getValues().size(); i++) {
                    sum = Math.pow((calculation.getValues().get(1) - mean), 2);
                }
                mean = sum / (calculation.getValues().size() - 1);
                double deviation = Math.sqrt(mean);

                calculation.setActualAnswer(deviation);
                if (calculation.getActualAnswer() == calculation.getReportedAnswer()) {
                    calculation.setCorrect(true);
                }
            }

        calculationRepository.save(calculation);
    }

    public List<Calculation> getAllcalculations() {
        List<Calculation> allCalculations =  calculationRepository.findAll();
        return allCalculations;
    }

}
