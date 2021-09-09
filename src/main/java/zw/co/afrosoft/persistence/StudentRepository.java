package zw.co.afrosoft.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import zw.co.afrosoft.domain.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
