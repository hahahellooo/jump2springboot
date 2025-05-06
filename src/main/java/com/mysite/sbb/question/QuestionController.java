package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;

// prefix를 '/question'으로 고정
@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
    
    // private final QuestionRepository questionRepository;

    // Repository 대신 Service로 연결
    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Question> questionList = this.questionService.getList();
        // List<Question> questionList = this.questionRepository.findAll();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }

    // 질문 상세 페이지 URL 매핑
    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        // return "question_detail";
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }
    // question_list.html과 웹페이지 연결
    // @GetMapping("/question/list")
    // // @ResponseBody 사용 대신 question_list.html 템플릿 return
    // public String list() {
    //     return "question_list";
    // }   
}
