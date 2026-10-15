package com.example.Zspring;

import org.springframework.web.bind.annotation.GetMapping;

public class StudentController {
    

    @GetMapping("/students")
    public List<Students> searchStudents(@RequestParam String branch, @RequestParam int year) {
        // Logic to search for students based on branch and year
        List<Students> students = new ArrayList<>();
        // Add logic to populate the students list based on the parameters
        return students;
    }

    @GetMapping("/topper")
    
}
