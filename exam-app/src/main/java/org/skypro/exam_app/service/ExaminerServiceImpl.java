package org.skypro.exam_app.service;

import org.skypro.exam_app.domain.Question;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final JavaQuestionService javaService;


    public ExaminerServiceImpl(JavaQuestionService javaService) {
        this.javaService = javaService;
    }

    @Override
    public Collection<Question> getQuestionServices(int amount){
        int size  = javaService.getAll().size();
        if(size < amount){
            throw new IllegalArgumentException("Что-то ты напутал");
        }

        Set<Question> setQuestion =  new HashSet<>();

        while(setQuestion.size() < amount) {
            setQuestion.add(javaService.getRandomQuestion());
        }
        return  setQuestion;
    }
}
