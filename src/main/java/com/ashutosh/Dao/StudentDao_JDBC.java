package com.ashutosh.Dao;

import com.ashutosh.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("jdbc")
public class StudentDao_JDBC implements StudentDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static List<Student> students;

    @Override
    public Collection<Student> getAllStudents() {
        String sql="Select * from student";
        List<Map<String, Object>> str = jdbcTemplate.queryForList(sql);
        students = new ArrayList<>();
        for (Map<String,Object> item: str) {
            Student student = new Student();
            for (Map.Entry<String, Object> entry : item.entrySet()) {

                if ("id".equals(entry.getKey())){
                    student.setId((Integer) entry.getValue());
                }

                if ("name".equals(entry.getKey())){
                    student.setName((String) entry.getValue());
                }

                if ("course".equals(entry.getKey())){
                    student.setCourse((String) entry.getValue());
                }
            }
            students.add(student);
        }
        return students;
    }

    @Override
    public Student getStudentByID(int id) {
        return null;
    }

    @Override
    public void removeStudentByID(int id) {

    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void insertStudent(Student student) {

    }
}
