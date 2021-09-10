package zw.co.afrosoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.domain.Student;
import zw.co.afrosoft.dto.StudentRequest;
import zw.co.afrosoft.dto.UpdateStudentRequest;
import zw.co.afrosoft.persistence.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
   StudentRepository studentRepository;

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student createStudent(StudentRequest studentRequest){
        Student student= new Student(studentRequest);
        studentRepository.save(student);
        return student;
    }
    public Student updateStudent(UpdateStudentRequest updateStudentRequest){
        Student student = studentRepository.findById(updateStudentRequest.getId()).get();
        if (updateStudentRequest.getFirstname().isEmpty() && updateStudentRequest.getFirstname()!=null){
            student.setFirstname(updateStudentRequest.getFirstname());
        }
        student = studentRepository.save(student);
        return student;
    }
}
