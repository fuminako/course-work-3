package com.skypro.coursework;

import com.skypro.coursework.domain.Question;
import com.skypro.coursework.exceptions.NotEnoughQuestionsException;
import com.skypro.coursework.service.ExaminerServiceImpl;


import com.skypro.coursework.service.service_interface.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



import java.util.Collections;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExamControllerTest {

    @Mock
    QuestionService questionService;
    @InjectMocks
    ExaminerServiceImpl examinerService;

    @Test
    void whenAmountOfQuestionIsSufficientThenGetQuestionReturnExactAmount() {
        List<Question> questionList = List.of(
                new Question("test1", "t1"),
                new Question("test2", "t2"),
                new Question("test3", "t3")
        );
        when(questionService.getAllQuestion()).thenReturn(questionList);
        when(questionService.getRandomQuestion()).thenReturn(questionList.get(0), questionList.get(1));

        assertThat(examinerService.getAllQuestion(2)).hasSize(2).containsOnly(questionList.get(1), questionList.get(0));
    }

    @Test
    void whenAmountOfQuestionIsSufficientThenMethodThrowsException(){
        when(questionService.getAllQuestion()).thenReturn(Collections.emptyList());
        assertThatThrownBy(()->examinerService.getAllQuestion(100)).isInstanceOf(NotEnoughQuestionsException.class);
    }


}
