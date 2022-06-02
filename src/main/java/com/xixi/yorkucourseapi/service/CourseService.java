package com.xixi.yorkucourseapi.service;

import com.xixi.yorkucourseapi.entity.Course;

import java.util.List;
import java.util.NoSuchElementException;

public interface CourseService {

        List<Course> fetchCourseList();
        Course fetchCourseBySubjectAndNumber(String subject, String number) throws NoSuchElementException;
        Course fetchCourseById(Long id) throws NoSuchElementException;
        List<Course> fetchCourseBySubject(String subject);
        List<Course> fetchCourseBySubjectAndFirstNumber(String subject, String initialNumber);
        List<Course> fetchCourseByTitle(String subject);
        List<Course> fetchCourseBySubjectLikeAndCredit(String subject, double credit);
        List<Course> fetchCourseBySubjectAndTitle(String subject, String title);
        List<Course> fetchCourseBySubjectAndTitleAndFirstNumber(String subject, String title,String number);

        List<Course> fetchCourseByCredit(double credit);
}
