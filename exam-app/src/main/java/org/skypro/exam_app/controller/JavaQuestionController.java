package org.skypro.exam_app.controller;

import org.skypro.exam_app.domain.Question;
import org.skypro.exam_app.service.JavaQuestionService;
import org.skypro.exam_app.service.QuestionServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class JavaQuestionController {
    private final QuestionServices javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/exam/java/add")
    public String addQuestion(@RequestParam("question") String QuestionText,
                              @RequestParam("answer") String QuestionAnswer) {
        Question question = new Question(QuestionText, QuestionAnswer);
        javaQuestionService.addQuestion(QuestionText, QuestionAnswer);
        return "Вопрос добавлен в пул";
    }

    @GetMapping("/exam/java/remove")
    public String removeQuestion(@RequestParam("question") String QuestionText,
                                 @RequestParam("answer") String QuestionAnswer) {
        javaQuestionService.remove(new Question(QuestionText, QuestionAnswer));
        return "Вопрос удален";
    }

    @GetMapping("/exam/java")
    public Collection<Question> getQuestions() {
        return javaQuestionService.getAll();
    }
}
