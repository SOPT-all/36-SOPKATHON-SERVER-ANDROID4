package org.sopt.domain.bookmark.respository;

import org.sopt.domain.bookmark.domain.Bookmark;
import org.sopt.domain.course.domain.Course;
import org.sopt.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    boolean existsByUserAndCourse(User user, Course course);

    Optional<Bookmark> findByUserAndCourse(User user, Course course);

    @Query("SELECT b FROM Bookmark b JOIN FETCH b.course WHERE b.user = :user")
    List<Bookmark> findAllByUserWithCourse(@Param("user") User user);

    @Query("SELECT b.course.id FROM Bookmark b WHERE b.user.id = :userId")
    List<Long> findCourseIdsBookmarkedByUserId(@Param("userId") Long userId);
}
