package com.skypro.coursework.service;

import com.skypro.coursework.domain.Question;
import com.skypro.coursework.exceptions.InvalidDataOrEmptyValuesException;
import com.skypro.coursework.exceptions.NotEnoughQuestionsException;
import com.skypro.coursework.service.service_interface.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    Set<Question> questionSet = new HashSet<>();
    private final Random RANDOM = new Random();

    @Override
    public Question addQuestion(String question, String answer) {
        Question questionObject = new Question(question, answer);
        validQuestion(questionObject);

        questionSet.add(questionObject);
        return questionObject;
    }

    @Override
    public Question addQuestion(Question question) {
        validQuestion(question);

        questionSet.add(question);
        return question;
    }

    @Override
    public Question removeQuestion(Question question) {
        validQuestion(question);

        questionSet.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAllQuestion() {
        return Collections.unmodifiableCollection(questionSet);
    }

    @Override
    public Question getRandomQuestion() {
        if (questionSet.isEmpty()) {
            throw new NotEnoughQuestionsException("Нет вопросов в списке");
        }
        return questionSet.stream().skip(RANDOM.nextInt(0, questionSet.size())).findFirst().orElseThrow();
    }

    private void validQuestion(Question question) {
        if (question == null) {
            throw new InvalidDataOrEmptyValuesException("Недостаточно информации");
        }
    }

}
