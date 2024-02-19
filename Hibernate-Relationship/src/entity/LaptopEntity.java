package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "laptop")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LaptopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "model",nullable = false,length = 50)
    private String model;
    @Column(name = "brand" ,nullable = false,length = 50)
    private String brand;

    @OneToOne(mappedBy = "laptopEntity",targetEntity = StudentEntity.class)
    private StudentEntity studentEntity;
}
