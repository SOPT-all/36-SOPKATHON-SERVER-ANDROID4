package org.sopt.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.sopt.domain.bookmark.domain.Bookmark;
import org.sopt.domain.bookmark.respository.BookmarkRepository;
import org.sopt.domain.course.domain.Course;
import org.sopt.domain.user.domain.User;
import org.sopt.domain.user.dto.response.GetMyPageResponse;
import org.sopt.domain.user.dto.response.GetUserListResponse;
import org.sopt.domain.user.repository.UserRepository;
import org.sopt.global.exception.BusinessException;
import org.sopt.global.exception.ErrorCode;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BookmarkRepository bookmarkRepository;

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
}
