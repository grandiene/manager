package employee.manager.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = Employee.TABLE_NAME)
@Data
public class Employee {
    public static final String TABLE_NAME = "employee";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = TABLE_NAME, sequenceName = "employee_seq")
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String birthDate;

    @ManyToOne
    @JoinColumn(name = "id_position",insertable = false, updatable = false, nullable = false)
    private Position position;

    @Column(name = "id_position", nullable = false)
    private Integer idPosition;

    @Column(unique = true, nullable = false)
    private Integer nip;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private Integer isDelete;



}
