package com.skypro.coursework.service.service_interface;

import com.skypro.coursework.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    public Collection<Question> getAllQuestion(int amount);
}
