package com.example.it211_session12_bai4.service;

import com.example.it211_session12_bai4.model.Student;
import com.example.it211_session12_bai4.exception.StudentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();
    private Long currentId = 1L;

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Student addStudent(Student student) {
        student.setId(currentId++);
        students.add(student);
        return student;
    }

    public Student updateStudent(Long id, Student updatedStudent) {

        Student student = getStudentById(id);

        student.setStudentCode(updatedStudent.getStudentCode());
        student.setFullName(updatedStudent.getFullName());
        student.setMajor(updatedStudent.getMajor());
        student.setGpa(updatedStudent.getGpa());

        return student;
    }

    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        students.remove(student);
    }
}