package com.codingdojo.coursePlatform.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

import com.codingdojo.coursePlatform.models.User;

@Entity
@Table(name="courses")

public class Course {

	 @Id
	 @GeneratedValue
	 private Long id;
	 @Size(min=1,max=255, message="Name can not be blank")
	 private String name;
	 @Size(min=1,max=255, message="Instructor can not be blank")
	 private String instructor;
	 private int maxPeople;
//	 private Date createdAt;
//	 private Date updatedAt;
	 
	 @ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(
	     name = "users_courses", 
	     joinColumns = @JoinColumn(name = "course_id"), 
	     inverseJoinColumns = @JoinColumn(name = "users_id")
	 )
	 private List<User> users;
	 public List<User> getUsers() {
	 	 return users;
	 }
	 public void setUsers(List<User> users) {
		 this.users = users;
	 }
		
	 @OneToMany(mappedBy="course", fetch=FetchType.LAZY)
	 private List<User> participants;
	 public List<User> getParticipants() {
		 return participants;
	 }
	 public void setParticipants(List<User> participants) {
		 this.participants = participants;
	 }
		
	 public Long getId() {
		return id;
	 }

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public int getMaxPeople() {
		return maxPeople;
	}

	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}
//
//	public Date getCreatedAt() {
//		return createdAt;
//	}
//
//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}
//
//	public Date getUpdatedAt() {
//		return updatedAt;
//	}
//
//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}
	
//    @PrePersist
//    protected void onCreate(){
//        this.createdAt = new Date();
//    }
//    @PreUpdate
//    protected void onUpdate(){
//        this.updatedAt = new Date();
//    }
//
	@Autowired
	public Course() {
	 }
	 
}