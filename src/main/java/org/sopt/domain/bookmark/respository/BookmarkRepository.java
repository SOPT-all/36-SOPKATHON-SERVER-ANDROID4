package org.sopt.domain.bookmark.respository;

import org.sopt.domain.bookmark.domain.Bookmark;
import org.sopt.domain.course.domain.Course;
import org.sopt.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    boolean existsByUserAndCourse(User user, Course course);
}
