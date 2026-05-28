package com.example.it211_session12_bai4.controller;
import com.example.it211_session12_bai4.service.StudentService;
import com.example.it211_session12_bai4.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@Slf4j
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {

        log.info("Nhận request lấy danh sách sinh viên");

        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {

        log.info("Nhận request lấy sinh viên theo id: {}", id);

        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {

        log.info("Nhận request thêm sinh viên");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.addStudent(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long id,
            @RequestBody Student student
    ) {

        log.info("Nhận request cập nhật sinh viên id: {}", id);

        return ResponseEntity.ok(studentService.updateStudent(id, student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {

        log.info("Nhận request xóa sinh viên id: {}", id);

        studentService.deleteStudent(id);

        return ResponseEntity.noContent().build();
    }
}
