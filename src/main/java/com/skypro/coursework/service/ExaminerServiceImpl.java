package com.skypro.coursework.service;

import com.skypro.coursework.exceptions.NotEnoughQuestionsException;
import com.skypro.coursework.service.service_interface.ExaminerService;
import com.skypro.coursework.domain.Question;
import com.skypro.coursework.service.service_interface.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getAllQuestion(int amount) {
        Set<Question> questions = new HashSet<>();
        if (questionService.getAllQuestion().size() <amount){
            throw new NotEnoughQuestionsException("Недостаточно вопросов в списке");
        }
        while (questions.size()<amount){
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}
