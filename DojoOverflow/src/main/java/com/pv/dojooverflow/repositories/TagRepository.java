package com.pv.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pv.dojooverflow.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
	
	// needed? -- already included in question model
	List<Tag> findAll();
	
	boolean existsBySubject(String subject);
	
	Tag findBySubject(String subject);

}
