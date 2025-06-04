package com.quizeserver.service.test;

import com.quizeserver.dto.*;
import com.quizeserver.entities.Test;

import java.util.List;

public interface TestService {

    TestDTO createTest(TestDTO dto);

    QuestionDTO addQuestionInTest(QuestionDTO dto);

    List<TestDTO> getAllTests();

    TestDetailsDTO getAllQuestionsByTest(Long id);

    TestResultDTO submitTest(SubmitTestDTO request);

    List<TestResultDTO> getAllTestResults();

    List<TestResultDTO> getAllTestResultOfUser(Long userId);
}
