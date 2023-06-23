package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

@Repository
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate j;

	public static String iq = """
			insert into t1(sno,name) values(?,?)
			""";

	public static String iq1 = """
			delete from t1 where sno=?
			""";

	public static String iq2 = """
			select *  from t1 where sno=?
			""";

	public void insert(Course c) {
		j.update(iq, c.getSno(), c.getName());

	}

	public void delete(int sno) {
		j.update(iq1, sno);

	}

	public Course select(int sno) {
		return j.queryForObject(iq2, new BeanPropertyRowMapper<>(Course.class), sno);

	}

}
