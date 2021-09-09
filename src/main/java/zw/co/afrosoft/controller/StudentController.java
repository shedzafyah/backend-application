package zw.co.afrosoft.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.afrosoft.response.StudentResponse;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Value("${app.name}:Default name")
    private String name;

    @GetMapping("/get")
    public StudentResponse display(){
        StudentResponse studentResponse = new StudentResponse(1L, "Shelton","Shamuyarira");
        return studentResponse;
    }
}
