package zw.co.afrosoft.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateStudentRequest {
    @NotNull(message = " Student id must not be null")
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
}
