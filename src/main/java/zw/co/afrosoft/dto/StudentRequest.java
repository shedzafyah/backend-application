package zw.co.afrosoft.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import zw.co.afrosoft.domain.Student;
import zw.co.afrosoft.domain.Subject;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class StudentRequest {
    @JsonProperty("firstname")
    @NotBlank(message = "firstname is reqiuired")
    private String first_name;

    @NotBlank(message = "lastname is reqiuired")
    private String lastname;

    @NotBlank(message = "email is reqiuired")
    private String email;

    private String street;

    private String city;

    private List<Subject> subjects;

}
