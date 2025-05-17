package org.sopt.domain.course.repository;

import java.util.Optional;
import org.sopt.domain.course.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c FROM Course c JOIN FETCH c.spots WHERE c.id = :courseId")
    Optional<Course> findByIdWithSpots(Long courseId);
}
