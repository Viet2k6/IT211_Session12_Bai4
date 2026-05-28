package com.example.it211_session12_bai4.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(Long id) {
        super("Không tìm thấy sinh viên với id: " + id);
    }
}