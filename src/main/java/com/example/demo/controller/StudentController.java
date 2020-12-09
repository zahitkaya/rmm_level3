package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.services.StudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping(value = "school/v1")
public class StudentController {

    final StudentService studentService;


    @PostMapping("/students")
    public HttpEntity<Student> addStudent(@RequestBody Student addedStudent) {

        var student = studentService.addStudent(addedStudent);

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("/students")
    public HttpEntity<Student> updateStudent(@RequestBody Student newStudent) {
        var student = studentService.updateStudent(newStudent);
        return new ResponseEntity<>(student, HttpStatus.OK);

    }

    @GetMapping("/students")
    public  HttpEntity<List<Student>> getAllStudents() {
        var student = studentService.getAllStudents();
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public HttpEntity<Student> getStudentt(@PathVariable int id) {

        Student student = studentService.getStudent(id);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }




    /*
    @DeleteMapping("/students")
    public HttpEntity<Student> deleteStudent(@RequestHeader int id) {
        studentService.deleteStudent(id);

        var links = new Link[]{
                linkTo(methodOn(StudentController.class).addStudent(null)).withRel("Student").withType("POST"),
                linkTo(methodOn(StudentController.class).deleteStudent(id)).withRel("Student").withType("POST")



        };

    }

     */
    /*

    @GetMapping("/students")
    private HttpEntity<List> getAllStudents(){
        List studentList=studentService.getAllStudents();

        var links=new Link[]{
                linkTo(methodOn(StudentController.class).addStudent(null)).withRel("Student").withType("POST"),
                linkTo(methodOn(StudentController.class).getAllStudents()).withRel("Student").withType("GET")
        };
        studentList.add(links);
        return new ResponseEntity<>(studentList,HttpStatus.CREATED);
    }

     */


  /* @GetMapping("school/v1/students")
    public CollectionModel<Student> getStudentList(){
        var allStudents=studentService.getAllStudents();

        Link[] links=new Link[]{
                linkTo(methodOn(this.getClass()).createStudent(null))
                .withRel("Students")
                .withType("POST")
                .withDeprecation("Add student"),
                linkTo(methodOn(this.getClass()).getStudentList())
                        .withRel("Students")
                        .withType("GET")
                        .withDeprecation("get student")

        };
        return of(allStudents,links);
    }

    @PostMapping("school/v1/students")
    public Student createStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }



   */


}
