package com.xixi.yorkucourseapi.controller;

import com.xixi.yorkucourseapi.service.CourseService;
import com.xixi.yorkucourseapi.entity.Course;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RequestMapping(value="/api/")
@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;
    private final Logger LOGGER = LoggerFactory.getLogger(Course.class);
    @GetMapping(value="/grades")
    public ResponseEntity<List<Course>> fetchCourseList(){
        LOGGER.info("Inside fetchCourse of Controller");
        List<Course> courses = courseService.fetchCourseList();
        return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
    }
    @GetMapping(value="/grade/id/{id}")
    public ResponseEntity<Course> fetchCourseBySubjectAndNumber(@PathVariable("id") Long id){
        LOGGER.info("Inside fetchCourseById of Controller");
        try{
            final Course course = courseService.fetchCourseById(id);
            return new ResponseEntity<Course>(course, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(value="/grade/subject/number/{subject}/{number}")
    public ResponseEntity<Course> fetchCourseBySubjectAndNumber(@PathVariable("subject") String subject,
                                                       @PathVariable("number") String number){
        LOGGER.info("Inside fetchCourseBySubjectAndNumber of Controller");
        try{
            final Course course = courseService.fetchCourseBySubjectAndNumber(subject, number);
            return new ResponseEntity<Course>(course, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value="/grades/subject/{subject}")
    public ResponseEntity<List<Course>> fetchCourseListBySubject(@PathVariable("subject") String subject){
        LOGGER.info("Inside fetchCourseBySubject of Controller");
        List<Course> courses = courseService.fetchCourseBySubject(subject);
        return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
    }
    @GetMapping(value="/grades/title/{title}")
    public ResponseEntity<List<Course>> fetchCourseListByTitle(@PathVariable("title") String title){
        LOGGER.info("Inside fetchCourseByTitle of Controller");
        List<Course> courses = courseService.fetchCourseByTitle(title);
        return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
    }
    @GetMapping(value="/grades/subject/number/{subject}/{number}")
    public ResponseEntity<List<Course>> fetchCourseListBySubjectAndFirstNumber(@PathVariable("subject") String subject,
                                                                               @PathVariable("number") String number){
        LOGGER.info("Inside fetchCourseByTitle of Controller");
        List<Course> courses = courseService.fetchCourseBySubjectAndFirstNumber(subject, number);
        return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
    }
    @GetMapping(value="/grades/subject/title/{subject}/{title}")
    public ResponseEntity<List<Course>> fetchCourseListBySubjectAndTitle(@PathVariable("subject") String subject,
                                                                               @PathVariable("title") String number){
        LOGGER.info("Inside fetchCourseByTitle of Controller");
        List<Course> courses = courseService.fetchCourseBySubjectAndTitle(subject, number);
        return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
    }
    @GetMapping(value="/grades/subject/number/title/{subject}/{number}/{title}")
    public ResponseEntity<List<Course>> fetchCourseListBySubjectAndTitle(@PathVariable("subject") String subject,
                                                                         @PathVariable("title") String title,
                                                                         @PathVariable("number") String number){
        LOGGER.info("Inside fetchCourseByTitle of Controller");
        List<Course> courses = courseService.fetchCourseBySubjectAndTitleAndFirstNumber(subject, title, number);
        return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
    }
}
