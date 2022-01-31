package com.fcb.fcb.aiAssessment.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Calculation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ArrayList<Integer> values;

    private String operation;

    private double reportedAnswer;

    private double actualAnswer;

    private boolean correct;
}
