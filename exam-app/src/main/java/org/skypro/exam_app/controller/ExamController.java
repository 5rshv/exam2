package org.skypro.exam_app.controller;

import org.skypro.exam_app.domain.Question;
import org.skypro.exam_app.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/exam")
    public Collection<Question> getQuestions(@RequestParam("amount")int amount) {
        return examinerService.getQuestionServices(amount);
    }
}
