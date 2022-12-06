package com.skypro.coursework.controller;

import com.skypro.coursework.exceptions.NotEnoughQuestionsException;
import com.skypro.coursework.service.service_interface.ExaminerService;
import com.skypro.coursework.domain.Question;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ExamController {

    private final ExaminerService examinerService;

    @ExceptionHandler(NotEnoughQuestionsException.class)
    public ResponseEntity<String> handleException() {
        return ResponseEntity.badRequest().body("Недостаточно вопросов");
    }

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/exam/{amount}")
    public Collection<Question> getQuestion(@PathVariable("amount") int amount) {
        return this.examinerService.getAllQuestion(amount);
    }
}
