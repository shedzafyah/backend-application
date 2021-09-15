package zw.co.afrosoft.domain;

import lombok.*;
import zw.co.afrosoft.dto.StudentRequest;
import zw.co.afrosoft.dto.UpdateStudentRequest;

import javax.persistence.*;
import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;

    public Address(StudentRequest studentRequest){
        this.street=studentRequest.getStreet();
        this.city=studentRequest.getCity();
    }
}
