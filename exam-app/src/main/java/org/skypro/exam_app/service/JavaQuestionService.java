package org.skypro.exam_app.service;

import org.skypro.exam_app.domain.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionServices {

    private final Random random = new Random();
    private final Set<Question> javaQuestion = new LinkedHashSet<>();

    @Override
    public Collection<Question> getAll() {
        return new ArrayList<>(javaQuestion);
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> list = new ArrayList<>(javaQuestion);
        int number = random.nextInt(getAll().size());
        return list.get(number);
    }


    @Override
    public Question addQuestion(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        javaQuestion.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        javaQuestion.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        javaQuestion.remove(question);
        return question;
    }

}
