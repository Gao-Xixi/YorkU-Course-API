package com.xixi.yorkucourseapi.repository;

import com.xixi.yorkucourseapi.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CourseRepo extends JpaRepository<Course, Long>{
        Course findBySubjectLikeAndNumber(String subject, String code);
        List<Course> findAllBySubjectLike(String subject);
        List<Course> findAllBySubjectLikeAndNumberStartsWith(String subject, String initialNumber);
        List<Course> findAllByTitleLike(String subject);
        List<Course> findAllBySubjectLikeAndCredit(String subject, double credit);

        List<Course> findAllBySubjectContainingIgnoreCase(String subject);

        List<Course> findAllBySubjectContainingIgnoreCaseAndNumberStartsWith(String subject, String initialNumber);

        List<Course> findAllByTitleContainingIgnoreCase(String subject);

        List<Course> findAllBySubjectContainingIgnoreCaseAndCredit(String subject, double credit);

        List<Course> findAllBySubjectContainingIgnoreCaseAndNumberStartingWith(String subject, String initialNumber);

        List<Course> findAllBySubjectLikeIgnoreCaseAndNumberStartingWith(String subject, String initialNumber);


        List<Course> findAllBySubjectContainingIgnoreCaseAndTitleContainingIgnoreCase(String subject, String title);

        List<Course> findAllBySubjectContainingIgnoreCaseAndTitleContainingIgnoreCaseAndNumberStartingWith(String subject, String title, String number);
}

