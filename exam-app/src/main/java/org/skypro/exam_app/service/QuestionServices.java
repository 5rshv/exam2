package org.skypro.exam_app.service;

import org.skypro.exam_app.domain.Question;

import java.util.Collection;

public interface QuestionServices {
    Question addQuestion(String question, String answer);

    Question add(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();

    Question remove(Question question);
}
