package org.sopt.domain.course.dto.response;

import org.sopt.domain.course.domain.Course;
import org.sopt.domain.user.domain.User;

import java.util.List;

public record GetCourseResponse(
        String nickname,
        String description,
        String profileImageUrl,
        List<GetCourseThumbnailResponse> courseList
) {
    public static GetCourseResponse from(User user, List<GetCourseThumbnailResponse> courseList) {
        return new GetCourseResponse(
                user.getNickname(),
                user.getDescription(),
                user.getProfileImageUrl(),
                courseList
        );
    }
}
