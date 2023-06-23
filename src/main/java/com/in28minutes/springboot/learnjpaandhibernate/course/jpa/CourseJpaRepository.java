package com.in28minutes.springboot.learnjpaandhibernate.course.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

import jakarta.persistence.EntityManager;

@Repository
public class CourseJpaRepository {

	@Autowired
	private EntityManager em;

	public void insert(Course c) {
		em.merge(c);
	}

	public Course find(int sno) {
		return em.find(Course.class, sno);
	}

	public void delete(int sno) {
		Course c1 = em.find(Course.class, sno);
		em.remove(c1);
	}

}
