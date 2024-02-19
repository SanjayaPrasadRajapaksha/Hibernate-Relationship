package entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private Integer id;
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "address", nullable = false, length = 250)
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "laptop_id", nullable = false)
    private LaptopEntity laptopEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "batch_id", nullable = false)
    private BatchEntity batchEntity;

    @ManyToMany(mappedBy = "studentEntity", targetEntity = SubjctEntity.class)
    private List<SubjctEntity> subjctEntity;
}
