package com.DYShunyaev.CourseWorkN1.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private long salary;

    public Employee() {
    }

    public Employee(String name, String surname, Date birthday, String department, Date dateGetJob, long salary) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.department = department;
        this.dateGetJob = dateGetJob;
        this.salary = salary;
    }
}
