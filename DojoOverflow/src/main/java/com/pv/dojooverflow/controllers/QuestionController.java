package com.pv.dojooverflow.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pv.dojooverflow.models.Answer;
import com.pv.dojooverflow.models.Question;
import com.pv.dojooverflow.services.AnswerService;
import com.pv.dojooverflow.services.QuestionService;
import com.pv.dojooverflow.validator.QuestionValidator;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;
	
	@Autowired 
	private QuestionValidator validator;

// show all questions
	@GetMapping("/questions")
	public String index(Model model) {
		model.addAttribute("questions", this.questionService.allQuestions());
		return "index.jsp";
	}

// show question form	
	@GetMapping("/questions/new") 
	public String newQuestion(@ModelAttribute("question") Question question) {
//		model.addAttribute("question", this.questionService.allQuestions());
		return "newQuestion.jsp";
	}

// create new question
	@PostMapping("/questions/new")
	public String createQuestion(@Valid @ModelAttribute("question") Question question, BindingResult result) {
//		validator.validateQuestion(question, result);
		validator.validateTags(question, result);
		if(result.hasErrors()) {
			return "newQuestion.jsp";
		}
		else  {
			this.questionService.createQuestion(question);
			return "redirect:/questions";
		}
	}


// show one question
	@GetMapping("/questions/{id}")
	public String showQuestion(@PathVariable("id") Long id, Model model, @ModelAttribute("answer") Answer answer) {
		model.addAttribute("question", this.questionService.showOneQuestion(id));
		// can also use already existing method - getter from model
		return "showQuestion.jsp";
	}
	
	

// add answer to question
	@PostMapping("/questions/{questionId}/new/answer")
	public String addAnswerToQuestion(@PathVariable("questionId") Long questionId, @Valid @ModelAttribute("answer") Answer answer, BindingResult result) {
		if(result.hasErrors()) {
			return "showQuestion.jsp";
		}
		else {
			Question newQuestion = this.questionService.showOneQuestion(questionId);
			answer.setQuestion(newQuestion);
			answer = this.answerService.createAnswer(answer);
//			Question question = this.questionService.showOneQuestion(id);
//			Answer tAnswer = this.answerService.showOneAnswer(answer)
//			this.questionService.addAnswerToQuestionList(question, answer);

		}
		return "redirect:/questions/{questionId}";
	}
	
	
}
