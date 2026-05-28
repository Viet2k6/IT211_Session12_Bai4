package com.example.it211_session12_bai4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {

    private Long id;
    private String studentCode;
    private String fullName;
    private String major;
    private Double gpa;
}