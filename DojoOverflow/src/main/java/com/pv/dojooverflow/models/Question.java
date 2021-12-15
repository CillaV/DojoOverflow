package com.pv.dojooverflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;




@Entity
@Table(name="questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// not leave empty
	// errors if named the same as class?
	private String aQuestion;
	
	@Column(updatable=false)
	private Date createdAt;
	
	private Date updatedAt;
	
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "tags_questions", 
        joinColumns = @JoinColumn(name = "question_id"), 
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
	
    // limit list to max 3
    // use of split to add commas -- .split
    // method 1* - no whitespace
	//    String CSV = "Google,Apple,Microsoft";
	//    String[] values = CSV.split(",");

    // method 2* - with whitespace
	//    String CSV = "Google, Apple, Microsoft"; 
	//    String[] values = CSV.split("\\s*,\\s*");

    private List<Tag> tags;

    @Transient
    private String frontEndTags;

	@OneToMany(mappedBy="question", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    
    private List<Answer> answers;
    
    
    public Question() {}
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getaQuestion() {
		return aQuestion;
	}
	public void setaQuestion(String aQuestion) {
		this.aQuestion = aQuestion;
	}

	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	public String getFrontEndTags() {
		return frontEndTags;
	}
	public void setFrontEndTags(String frontEndTags) {
		this.frontEndTags = frontEndTags;
	}
	
    

    
    
}
