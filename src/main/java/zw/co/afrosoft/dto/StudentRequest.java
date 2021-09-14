package zw.co.afrosoft.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import zw.co.afrosoft.domain.Student;

import javax.validation.constraints.NotBlank;

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

}
