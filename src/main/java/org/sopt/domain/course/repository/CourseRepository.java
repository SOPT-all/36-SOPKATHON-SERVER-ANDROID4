package org.sopt.domain.course.repository;

import org.sopt.domain.course.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c FROM Course c JOIN FETCH c.spots WHERE c.id = :courseId")
    Optional<Course> findByIdWithSpots(Long courseId);

    @Query("""
        SELECT DISTINCT c FROM Course c
        LEFT JOIN FETCH c.spots
        WHERE c.user.id = :userId
        ORDER BY c.recordDate DESC
    """)
    List<Course> findAllWithSpotsByUserIdOrderByRecordDateDesc(@Param("userId") Long userId);

}
