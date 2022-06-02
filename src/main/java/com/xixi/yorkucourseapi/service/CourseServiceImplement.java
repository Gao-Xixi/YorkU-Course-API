package com.xixi.yorkucourseapi.service;

import com.xixi.yorkucourseapi.repository.CourseRepo;
import com.xixi.yorkucourseapi.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CourseServiceImplement implements CourseService{


        @Autowired
        private CourseRepo courseRepo;
        @Override
        public List<Course> fetchCourseList() {
            return courseRepo.findAll();
        }

        @Override
        public Course fetchCourseBySubjectAndNumber(String subject, String number) throws NoSuchElementException {
            Course course = courseRepo.findBySubjectContainingIgnoreCaseAndNumber(subject, number);

            if (course == null) {
                throw new NoSuchElementException();
            }
            return course;
        }

    @Override
    public Course fetchCourseById(Long id) throws NoSuchElementException {
        Optional<Course> course = courseRepo.findById(id);

        if (!course.isPresent()) {
            throw new NoSuchElementException();
        }
        return course.get();
    }

    @Override
    public List<Course> fetchCourseBySubject(String subject) {
        return courseRepo.findAllBySubjectContainingIgnoreCase(subject);
    }
    @Override
    public List<Course> fetchCourseBySubjectAndFirstNumber(String subject, String number) {
        return courseRepo.findAllBySubjectContainingIgnoreCaseAndNumberStartingWith(subject, number);
    }
    @Override
    public List<Course> fetchCourseByTitle(String title) {
        return courseRepo.findAllByTitleContainingIgnoreCase(title);
    }
    @Override
    public List<Course> fetchCourseBySubjectAndTitle(String subject, String title) {
        return courseRepo.findAllBySubjectContainingIgnoreCaseAndTitleContainingIgnoreCase(subject,title);
    }

    @Override
    public List<Course> fetchCourseBySubjectAndTitleAndFirstNumber(String subject, String title, String number) {
        return courseRepo.findAllBySubjectContainingIgnoreCaseAndTitleContainingIgnoreCaseAndNumberStartingWith(subject,title,number);
    }

    @Override
    public List<Course> fetchCourseByCredit(double credit) {
        return courseRepo.findAllByCredit(credit);
    }

    @Override
    public List<Course> fetchCourseBySubjectLikeAndCredit(String subject, double credit) {
        return courseRepo.findAllBySubjectContainingIgnoreCaseAndCredit(subject, credit);
    }

}
