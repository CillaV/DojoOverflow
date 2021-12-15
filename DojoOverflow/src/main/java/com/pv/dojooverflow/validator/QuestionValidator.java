package com.pv.dojooverflow.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.pv.dojooverflow.models.Question;

@Component
public class QuestionValidator {

    // 1

    public boolean supports(Class<?> clazz) {
        return Question.class.equals(clazz);
    }
    
    // 2
    
    public void validateTags(Object target, Errors errors) {
        Question question = (Question) target;
        
        String[] tags = question.getFrontEndTags().split(", ");
        if(tags.length > 3) {
        	errors.rejectValue("frontEndTags", "Too Many", "Must have 3 tags or less.");
        }
    }
    
//    public void validateQuestion(Object target, Errors errors) {
//    	Question aQuestion = (Question)target;
//    	
//    	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "question", "Must have a question.");
//    	
//    	if(aQuestion == null) {
//    		errors.rejectValue("aQuestion", "Missing Question", "Must have a question.");
//
//    	}
//    	
//    	ValidationUtils.rejectIfEmpty("question", "Missing Question", "Must have a question.");
//
//    }
}
