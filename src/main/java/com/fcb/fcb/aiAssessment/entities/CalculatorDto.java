package com.fcb.fcb.aiAssessment.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculatorDto {

    private ArrayList<Integer> values;

    private String operation;

    private String reportedAnswer;

}
