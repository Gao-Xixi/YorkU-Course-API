package com.xixi.yorkucourseapi.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "course")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "subject")
    private String subject;
    @Column(name = "number")
    private String number;
    @Column(name = "credit")
    private double credit;
    @Column(name = "title")
    private String title;
    @Column(name = "detail")
    private String detail;
}
