package zw.co.afrosoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.domain.Student;
import zw.co.afrosoft.persistence.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    @Autowired
   StudentRepository studentRepository;

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }
}
