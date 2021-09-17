package zw.co.afrosoft.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.domain.Student;
import zw.co.afrosoft.dto.InQueryRequest;
import zw.co.afrosoft.dto.StudentRequest;
import zw.co.afrosoft.dto.StudentResponse;
import zw.co.afrosoft.dto.UpdateStudentRequest;
import zw.co.afrosoft.service.StudentService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    Logger logger = LoggerFactory.getLogger(StudentController.class);


    @GetMapping("/getAll")
    public List<StudentResponse> getAllStudents(){

        /*
      
        logger.warn("Inside Warning");
        logger.error("Inside Error");
        logger.info("Inside Info");
        logger.trace("Inside Trace");
        logger.debug("Inside Debug");
         */

        List<Student> studentList = studentService.getAllStudent();
        List<StudentResponse> studentResponseList = new ArrayList<>();
        studentList.stream().forEach(
              student -> {
                  studentResponseList.add(new StudentResponse(student));
              }
        );
        return studentResponseList;
    }

    @PostMapping("/create")
    public StudentResponse createStudent(@Valid @RequestBody StudentRequest studentRequest){
        Student student = studentService.createStudent(studentRequest);
        return new StudentResponse(student);
    }

    @PutMapping("/update")
    public StudentResponse updateStudent(@Valid @RequestBody UpdateStudentRequest updateStudentRequest){
        Student student = studentService.updateStudent(updateStudentRequest);
        return new StudentResponse(student);
    }

    /*


    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("id") Long id){
        return studentService.deleteStudent(id);
    }
     */


    /*
        delete?id={id} -- RequestParam
        delete/{id} -- PathVariable
     */

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        return studentService.deleteStudent(id);
    }

    @GetMapping("/{firstname}")
    public List<StudentResponse> getByFirstName(@PathVariable("firstname") String firstname){
        List<Student> studentList = studentService.getStudentByFirstname(firstname);
        List<StudentResponse> studentResponseList = new ArrayList<>();
        studentList.stream().forEach( student -> studentResponseList.add( new StudentResponse(student)));
        return studentResponseList;
    }

    @GetMapping("/{firstname}/{lastname}")
    public List<StudentResponse> getByFirstNameAndLastName(@PathVariable String firstname, @PathVariable String lastname){
        List<Student> studentList = studentService.getStudentByFirstnameAndLastname(firstname, lastname);
        List<StudentResponse> studentResponseList = new ArrayList<>();
        studentList.stream().forEach(student -> studentResponseList.add(new StudentResponse(student)));
        return studentResponseList;
    }

    /*
        AND & IN Query in JPA is Similar
     */

    @GetMapping("/getFirstnameIn")
    public List<StudentResponse> getByFirstnameIn(@RequestBody InQueryRequest inQueryRequest){
        List<Student> studentList = studentService.getStudentByFirstnameIn(inQueryRequest);
        List<StudentResponse> studentResponseList = new ArrayList<>();
        studentList.stream().forEach(student -> studentResponseList.add(new StudentResponse(student)));
        return studentResponseList;
    }

    @GetMapping("/getStudentWithPagination")
    public List<StudentResponse> getAllStudentsWithPagination(@RequestParam int pageNo, @RequestParam int pageSize){
        List<Student> studentList =studentService.getAllStudentWithPagination(pageNo,pageSize);
        List<StudentResponse> studentResponseList = new ArrayList<>();
         studentList.stream().forEach(student ->studentResponseList.add(new StudentResponse(student)));
         return studentResponseList;
    }

    @GetMapping("/getByCity")
    public List<StudentResponse> getStudentsByCity(@RequestParam String city){
        List<Student> studentList = studentService.getStudentByCity(city);
        List<StudentResponse> studentResponseList = new ArrayList<>();
        studentList.stream().forEach(student -> studentResponseList.add(new StudentResponse(student)));
        return studentResponseList;
    }
}
