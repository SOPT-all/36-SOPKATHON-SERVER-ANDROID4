package org.sopt.domain.bookmark.service;

import lombok.RequiredArgsConstructor;
import org.sopt.domain.bookmark.domain.Bookmark;
import org.sopt.domain.bookmark.respository.BookmarkRepository;
import org.sopt.domain.course.domain.Course;
import org.sopt.domain.course.repository.CourseRepository;
import org.sopt.domain.user.domain.User;
import org.sopt.domain.user.repository.UserRepository;
import org.sopt.global.exception.BusinessException;
import org.sopt.global.exception.ErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookmarkService {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final BookmarkRepository bookmarkRepository;

    public void create(Long userId, Long courseId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(ErrorCode.NOT_FOUND_USER_EXCEPTION));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new BusinessException(ErrorCode.COURSE_NOT_FOUND));

        if (bookmarkRepository.existsByUserAndCourse(user, course)) {
            throw new BusinessException(ErrorCode.ALREADY_BOOKMARKED);
        }

        bookmarkRepository.save(Bookmark.create(user, course));
    }
}