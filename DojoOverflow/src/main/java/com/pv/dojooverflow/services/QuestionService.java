package com.pv.dojooverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pv.dojooverflow.models.Answer;
import com.pv.dojooverflow.models.Question;
import com.pv.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepo;
	
	@Autowired
	private TagService tagService;
	
	
// create a question
	public Question createQuestion(Question c) {
		c.setTags(tagService.splitTags(c.getFrontEndTags()));
		return this.questionRepo.save(c);
	}
	
// show all questions
	public List<Question> allQuestions() {
		return this.questionRepo.findAll();
	}
	
// show one question
	public Question showOneQuestion(Long id) {
		return this.questionRepo.findById(id).orElse(null);
	}
	
// add answer to question list
	public void addAnswerToQuestionList(Question question, Answer answer) {
		List<Answer> answers = question.getAnswers();
		answers.add(answer);
		this.questionRepo.save(question);
	}
	
}
