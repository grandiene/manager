package employee.manager.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = Position.TABLE_NAME)
public class Position {
    public static final String TABLE_NAME = "position";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
    @SequenceGenerator(name = TABLE_NAME, sequenceName = "position_seq")
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String positionName;

    @Column(nullable = false)
    private Integer isDelete;

}
