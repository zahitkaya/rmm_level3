package com.example.demo.model;

import com.example.demo.controller.StudentController;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
public class Student extends RepresentationModel<Student> implements Serializable {

    int id;
    String name;
    String address;
    double gpa;

     static List<Link> links=new ArrayList<>();

    @Override
     public Links getLinks() {
         Link[] embeddedLinks = new Link[]{
                linkTo(methodOn(StudentController.class).addStudent(null)).withRel("Student").withType("POST").withDeprecation("GetPost"),
                linkTo(methodOn(StudentController.class).updateStudent(null)).withRel("Student").withType("PUT"),
                linkTo(methodOn(StudentController.class).getStudentt(4)).withRel("Student").withRel("GET").withDeprecation("Get Student By ID"),
                linkTo(methodOn(StudentController.class).getAllStudents()).withRel("Student").withRel("GET").withDeprecation("Get All Students"),


        };

        links.addAll(Arrays.asList(embeddedLinks));

         return Links.of(this.links);
    }
    /*
    @JsonRawValue
    @JsonValue
    public String studentInfo(){
        return "{\n" +
                "  \"name\" : \""+name+"\",\n" +
                "  \"id\" : "+id+",\n" +
                "  \"address\" : \""+address+"\"\n" +
                "}";
    }

     */

}
