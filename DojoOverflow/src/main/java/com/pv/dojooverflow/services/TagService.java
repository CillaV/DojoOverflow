package com.pv.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pv.dojooverflow.models.Tag;
import com.pv.dojooverflow.repositories.TagRepository;

@Service
public class TagService {

	@Autowired
	private TagRepository tagRepo;
	
// create a tag
	public Tag createTag(Tag c) {
		return this.tagRepo.save(c);
	}
	
// show all tags
	public List<Tag> allTags() {
		return this.tagRepo.findAll();
	}
	
// show one tag
	public Tag showOneTag(Long id) {
		return this.tagRepo.findById(id).orElse(null);
	}
	
// 
	public Tag findSubject(String subject) {
		return this.tagRepo.findBySubject(subject);
	}

// string to split
	public ArrayList<Tag> splitTags(String tags) {
		ArrayList<Tag> questionTags = new ArrayList<>();
		
		String[] curTags = tags.split(", ");
		
		for(String t: curTags) {
			if(this.tagRepo.existsBySubject(t)) {
				Tag s = findSubject(t);
				questionTags.add(s);
			}
			else {
				Tag newTag = new Tag();
				newTag.setSubject(t);
				this.tagRepo.save(newTag);
				questionTags.add(findSubject(t));
			}
		}
		return questionTags;
	}

	
}
