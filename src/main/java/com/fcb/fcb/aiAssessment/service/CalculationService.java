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
                double averageAnswer = Math.round(average * 100.0) / 100.0;
                calculation.setActualAnswer(averageAnswer);
                if (calculation.getActualAnswer() == calculation.getReportedAnswer()) {
                    calculation.setCorrect(true);
                }
            }

            if (Objects.equals(calculation.getOperation(), "SD")) {
                double sum = 0.0, standardDeviation = 0.0;
                int length = calculation.getValues().size();

                for(double num : calculation.getValues()) {
                    sum += num;
                }
                double mean = sum/length;
                for(double num: calculation.getValues()) {
                    standardDeviation += Math.pow(num - mean, 2);
                }

                double answer =  Math.sqrt(standardDeviation/length);
                double sdAnswer = Math.round(answer * 100.0) / 100.0;

                calculation.setActualAnswer(sdAnswer);
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



