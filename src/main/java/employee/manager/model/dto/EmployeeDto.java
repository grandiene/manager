package employee.manager.model.dto;

import employee.manager.model.entity.Employee;
import employee.manager.model.entity.Position;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@Data
public class EmployeeDto {

    private Integer id;
    private String name;
    private String birthDate;
    private Integer idPosition;
    private Integer nip;
    private String gender;

}
