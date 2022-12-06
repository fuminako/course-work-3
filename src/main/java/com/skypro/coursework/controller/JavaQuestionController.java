package com.skypro.coursework.controller;

import com.skypro.coursework.domain.Question;
import com.skypro.coursework.service.service_interface.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping
    public Collection<Question> getAllQuestion() {
        return this.service.getAllQuestion();
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        return this.service.addQuestion(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                   @RequestParam("answer") String answer) {
        Question questionObject = new Question(question, answer);
        return this.service.removeQuestion(questionObject);
    }

}
