package com.example.oaes_student.controller;

import com.example.oaes_student.entity.Permissions;
import com.example.oaes_student.entity.Student;
import com.example.oaes_student.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private UserService userService;

    @PostMapping("/{userID}")
    public String getPermissions(@RequestBody Permissions permissions, @PathVariable long userID) throws Exception {
        if(permissions.isMicAndCamera() && permissions.isTermsAndConditions()){
            Student student = (Student) userService.getUserById(userID);
            System.out.println(student);
            if(student.getTestStatus()==0) {
                RestTemplate template = new RestTemplate();
                String res = template.getForObject("http://localhost:9091/exam/subscribe/"+student.getUserID(), String.class);
                System.out.println(res);
                return "Please wait while exam coordinator starts your test";
            }
            else return "Test has been started";
        }
        else return "Please accept the conditions";
    }
}
