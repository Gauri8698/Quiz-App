package com.quizeserver.controller;

import com.quizeserver.dto.QuestionDTO;
import com.quizeserver.dto.SubmitTestDTO;
import com.quizeserver.dto.TestDTO;
import com.quizeserver.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/test")
@CrossOrigin(origins = "http://localhost:4200")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping()
    public ResponseEntity<?> createTest(@RequestBody TestDTO dto){
        try {
            return new ResponseEntity<>(testService.createTest(dto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/question")
    public ResponseEntity<?> addQuestionTest(@RequestBody QuestionDTO dto){
        try {
            return new ResponseEntity<>(testService.addQuestionInTest(dto),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<?> getAllTest(){
        try {
            return new ResponseEntity<>(testService.getAllTests(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAllQuestions(@PathVariable Long id){
        try {
            return new ResponseEntity<>(testService.getAllQuestionsByTest(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/submit-test")
    public ResponseEntity<?> submitTest(@RequestBody SubmitTestDTO dto){
        try {
            return new ResponseEntity<>(testService.submitTest(dto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/test-result")
    public ResponseEntity<?> getAllTestResults(){
        try {
            return new ResponseEntity<>(testService.getAllTestResults(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/test-result/{id}")
    public ResponseEntity<?> getAllTestResultsOfUser(@PathVariable Long id){
        try {
            return new ResponseEntity<>(testService.getAllTestResultOfUser(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }



}
