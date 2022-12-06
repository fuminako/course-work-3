package com.skypro.coursework;

import com.skypro.coursework.domain.Question;
import com.skypro.coursework.exceptions.NotEnoughQuestionsException;
import com.skypro.coursework.service.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class JavaQuestionServiceTest {

    private JavaQuestionService javaQuestionService;

    private final List<Question> questions = List.of(
            new Question("test1", "t1"),
            new Question("test2", "t2"),
            new Question("test3", "t3"),
            new Question("test4", "t4"),
            new Question("test5", "t5")
    );

    @BeforeEach
    void setQuestions() {
        this.javaQuestionService = new JavaQuestionService();
        questions.forEach(javaQuestionService::addQuestion);
    }

    @Test
    void addQuestionTest() {
        Question question = new Question("Test", "test");
        Question q = this.javaQuestionService.addQuestion(question);
        assertThat(q).isEqualTo(question);
        assertThat(this.javaQuestionService.getAllQuestion().size()).isEqualTo(6);
    }

    @Test
    void removeQuestionTest() {
        Question question = this.questions.get(0);
        this.javaQuestionService.removeQuestion(question);
        assertThat(this.javaQuestionService.getAllQuestion().size()).isEqualTo(4);
    }

    @Test
    void getAllQuestionTest(){
        assertThat(this.javaQuestionService.getAllQuestion()).hasSize(5).containsAll(this.questions);
    }

    @Test
    void getRandomQuestionTest() {
        Question question = this.javaQuestionService.getRandomQuestion();
        assertThat(question).isIn(questions);
    }

    @Test
    void ListIsEmptyThenRandomQuestionReturnException() {
        this.javaQuestionService = new JavaQuestionService();
        assertThatThrownBy(() -> javaQuestionService.getRandomQuestion())
                .isInstanceOf(NotEnoughQuestionsException.class);
    }
}
