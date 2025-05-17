package org.sopt.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.sopt.domain.bookmark.domain.Bookmark;
import org.sopt.domain.bookmark.respository.BookmarkRepository;
import org.sopt.domain.course.domain.Course;
import org.sopt.domain.course.dto.response.GetCourseResponse;
import org.sopt.domain.course.dto.response.GetCourseThumbnailResponse;
import org.sopt.domain.course.repository.CourseRepository;
import org.sopt.domain.user.domain.User;
import org.sopt.domain.user.dto.response.GetMyPageResponse;
import org.sopt.domain.user.dto.response.GetUserListResponse;
import org.sopt.domain.user.repository.UserRepository;
import org.sopt.global.exception.BusinessException;
import org.sopt.global.exception.ErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BookmarkRepository bookmarkRepository;
    private final CourseRepository courseRepository;

    public GetUserListResponse getCuratorList(final Long userId) {
        List<User> curatorList = userRepository.findAll();
        if (userRepository.findById(userId).isEmpty()) throw new BusinessException(ErrorCode.NOT_FOUND_USER_EXCEPTION);
        return GetUserListResponse.of(curatorList);
    }

    public GetMyPageResponse getMyPageData(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(ErrorCode.NOT_FOUND_USER_EXCEPTION));

        List<Course> courseList = bookmarkRepository.findAllByUserWithCourse(user).stream()
                .map(Bookmark::getCourse)
                .toList();

        return GetMyPageResponse.of(user, courseList);
    }

    public GetCourseResponse getCuratorInformationAndCourseList(final Long headerUserId, final Long pathUserId) {
        userRepository.findById(headerUserId)
                .orElseThrow(() -> new BusinessException(ErrorCode.NOT_FOUND_USER_EXCEPTION));

        User pathUser = userRepository.findById(pathUserId)
                .orElseThrow(() -> new BusinessException(ErrorCode.NOT_FOUND_USER_EXCEPTION));
        List<Long> bookmarkedCourseIds = bookmarkRepository.findCourseIdsBookmarkedByUserId(headerUserId);

        List<GetCourseThumbnailResponse> courseList = courseRepository
                .findAllWithSpotsByUserIdOrderByRecordDateDesc(pathUserId)
                .stream()
                .map(course -> GetCourseThumbnailResponse.from(
                        course,
                        bookmarkedCourseIds.contains(course.getId())
                ))
                .toList();

        //List<Course> bookmarkList = bookmarkRepository.findAllBookmarkedCoursesByUserId(pathUserId);
        //return GetCourseResponse.from(pathUser, courseList, bookmarkList);
        return GetCourseResponse.from(pathUser, courseList);
    }
}
