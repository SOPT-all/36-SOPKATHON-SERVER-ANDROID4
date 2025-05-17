package org.sopt.domain.course.dto.response;

import software.amazon.awssdk.annotations.NotNull;

public record GetCourseDetailsResponse(
        String nickname,
        String profileImageUrl,


) {

}
