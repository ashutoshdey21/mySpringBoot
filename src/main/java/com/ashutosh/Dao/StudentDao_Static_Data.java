package com.ashutosh.Dao;

import com.ashutosh.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentDao_Static_Data implements StudentDao {

    private static Map <Integer, Student> students;

    static {
        students=new HashMap<Integer, Student>(){
            {
                put(1,new Student(001,"Prakhar","SER 501"));
                put(2,new Student(002,"Ashutosh","SER 511"));
                put(3,new Student(003,"Shantanu","SER 531"));
                put(4,new Student(004,"Pooshpendu","SER 501"));
            }
        };
    }
    @Override
    public Collection<Student> getAllStudents(){
        return this.students.values();
    }

    @Override
    public Student getStudentByID(int id){
        return this.students.get(id);

    }

    @Override
    public void removeStudentByID(int id) {
        this.students.remove(id);
    }

    @Override
    public void updateStudent(Student student){
        Student update_student=students.get(student.getId());
        update_student.setCourse(student.getCourse());
        update_student.setName(student.getName());
        students.put(student.getId(),update_student);
    }

    @Override
    public void insertStudent(Student student) {
        this.students.put(student.getId(), student);
    }
}

