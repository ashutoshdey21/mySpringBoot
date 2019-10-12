package com.ashutosh.Dao;

import com.ashutosh.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository("jdbc")
public class StudentDao_JDBC implements StudentDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static Map <Integer, Student> studentsMap;

    @Override
    public Collection<Student> getAllStudents() {
        String sql="Select * from student";
        List<Map<String, Object>> str = jdbcTemplate.queryForList(sql);
        studentsMap=new HashMap<Integer, Student>();
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
            studentsMap.put(student.getId(),(student));
        }
        return this.studentsMap.values();
    }

    @Override
    public Student getStudentByID(int id) {
        return this.studentsMap.get(id);
    }

    @Override
    public void removeStudentByID(int id) {
        String sql="DELETE FROM student WHERE id="+id;
        //System.out.println(sql);
        System.out.println(jdbcTemplate.update(sql)+" row(s) deleted");

    }

    @Override
    public void updateStudent(Student student) {

        String sql="UPDATE student \n" +
                "SET \n" +
                "    name = '"+student.getName()+"',\n" +
                "    course = '"+student.getCourse()+"'\n" +
                "WHERE\n" +
                "    id = "+student.getId();
        System.out.println(jdbcTemplate.update(sql)+" row(s) updated");

    }

    @Override
    public void insertStudent(Student student) {
        String sql="insert into student(id, name, course) values " +
                "("+student.getId()+", \""+student.getName()+"\", \""+student.getCourse()+"\");";
        /*System.out.println(sql);*/
        System.out.println(jdbcTemplate.update(sql)+" row(s) inserted");

    }
}
