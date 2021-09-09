package zw.co.afrosoft.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import zw.co.afrosoft.domain.Student;

@Getter
@Setter
public class StudentResponse {
    @JsonIgnore
    private Long id;
    private String firstname;
    private String lastname;
    private String email;

    public StudentResponse(Student student){
        this.firstname= student.getFirstname();
        this.lastname=student.getLastname();
        this.email=student.getEmail();
    }

}
