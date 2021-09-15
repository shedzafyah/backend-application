package zw.co.afrosoft.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import zw.co.afrosoft.domain.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findStudentByFirstname(String firstname);

    List<Student> findStudentByFirstnameAndLastname(String firstname,String Lastname);

    List<Student> findStudentByFirstnameIn(List<String> firstnames);

    @Query("FROM Student Where firstname=:firstname AND lastname=:lastname")
    List<Student> getByFirstNameAndLastname(String firstname,String lastname);

    /*
        UPDATE
        DELETE
     */

    @Query("FROM Student s INNER JOIN Address a on a.id=s.id WHERE a.city=:city")
    List<Student> getStudentsByCity(String city);

}
