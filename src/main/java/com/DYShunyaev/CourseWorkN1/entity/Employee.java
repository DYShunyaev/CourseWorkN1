package com.DYShunyaev.CourseWorkN1.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private Date birthday;

    @Column
    private String department;

    @Column
    private Date dateGetJob;

    @Column
    private int salary;
}
