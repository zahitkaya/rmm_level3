package com.example.demo.services;

import com.example.demo.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
public class StudentService {

    private  HashMap<Integer, Student> studentHashMap = new HashMap<>();


    @PostConstruct
    public void addUser() {

        Student student1 = Student.builder()
                .address("Fatih")
                .name("Zahit")
                .id(10)
                .build();
        Student student2 = Student.builder()
                .address("Merkez")
                .name("Emre")
                .id(4)
                .build();

        studentHashMap.put(student1.getId(), student1);
        studentHashMap.put(student2.getId(), student2);

    }

    public  int getMaximumId() {
        int max = 0;
        for (int id : studentHashMap.keySet()) {
            if (max <= id) {
                max = id;
            }
        }
        return max;
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>(this.studentHashMap.values());
        return students;
    }

    public Student addStudent(Student student) {
        studentHashMap.put(student.getId(), student);
        return student;
    }

    public Student updateStudent(Student student) {
        studentHashMap.put(student.getId(), student);

        return student;
    }

    public void deleteStudent(int id) {
        studentHashMap.remove(id);
    }

    public Student getStudent(int id) {
        return studentHashMap.get(id);
    }

}
