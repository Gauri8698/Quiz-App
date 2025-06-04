package com.quizeserver.entities;

import com.quizeserver.dto.TestResultDTO;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class TestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int totalQuestions;

    private int correctAnswers;

    private Double percentage;

    @ManyToOne
    @JoinColumn(name = "tes_id")
    private Test test;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public TestResultDTO getDto(){
        TestResultDTO dto = new TestResultDTO();

        dto.setId(id);
        dto.setTotalQuestions(totalQuestions);
        dto.setCorrectAnswers(correctAnswers);
        dto.setPercentage(percentage);
        dto.setTestName(test.getTitle());
        dto.setUserName(user.getName());
        return dto;
    }


}
