package com.quizeserver.dto;

import lombok.Data;

@Data
public class TestResultDTO {

    private Long id;

    private int totalQuestions;

    private int correctAnswers;

    private Double percentage;

    private String testName;

    private String userName;


}
