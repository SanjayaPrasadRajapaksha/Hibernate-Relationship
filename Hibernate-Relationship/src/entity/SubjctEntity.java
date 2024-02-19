package entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class SubjctEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "student_subject", 
        joinColumns = { @JoinColumn(name = "subject_id") }, 
        inverseJoinColumns = {
        @JoinColumn(name = "student_id") })
    private List<StudentEntity> studentEntity;
}
