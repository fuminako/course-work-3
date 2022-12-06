package com.skypro.coursework.service.service_interface;

import com.skypro.coursework.domain.Question;

import java.util.Collection;

public interface QuestionService {

    public Question addQuestion(String question, String answer);

    public Question addQuestion(Question question);

    public Question removeQuestion(Question question);

    public Collection<Question> getAllQuestion();

    public Question getRandomQuestion();

}
