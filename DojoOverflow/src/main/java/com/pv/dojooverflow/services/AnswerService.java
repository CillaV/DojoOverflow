package com.pv.dojooverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pv.dojooverflow.models.Answer;
import com.pv.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepository answerRepo;
	
// create a answer
	public Answer createAnswer(Answer c) {
		return this.answerRepo.save(c);
	}
	
// show all answers
	public List<Answer> allAnswers() {
		return this.answerRepo.findAll();
	}
	
// show one answer
	public Answer showOneAnswer(Long id) {
		return this.answerRepo.findById(id).orElse(null);
	}
	

	
}
