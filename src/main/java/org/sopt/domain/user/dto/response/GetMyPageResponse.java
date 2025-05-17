package org.sopt.domain.user.dto.response;

import java.util.List;
import org.sopt.domain.course.domain.Course;
import org.sopt.domain.course.dto.CourseSummaryDto;
import org.sopt.domain.user.domain.User;

public record GetMyPageResponse(
        String nickname,
        String profileImageUrl,
        List<CourseSummaryDto> courseList
) {
    public static GetMyPageResponse of(User user, List<Course> courses) {
        List<CourseSummaryDto> courseList = courses.stream()
                .map(CourseSummaryDto::from)
                .toList();

        return new GetMyPageResponse(
                user.getNickname(),
                user.getProfileImageUrl(),
                courseList
        );
    }
}