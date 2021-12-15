package com.pv.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pv.dojooverflow.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
	
	List<Question> findAll();
	
	// list of question with tags -- already in class model
	
	// find one question and show tags and show answers -- included in class model

}
