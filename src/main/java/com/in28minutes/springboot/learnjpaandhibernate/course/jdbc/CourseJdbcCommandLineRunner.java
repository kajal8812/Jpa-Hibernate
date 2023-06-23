package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseJdbcRepository r;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		r.insert(new Course(2, "rinki"));
		r.insert(new Course(1, "reena"));
		r.insert(new Course(3, "ravi"));
		r.delete(1);

		System.out.println(r.select(2));
		System.out.println(r.select(3));
	}

}
