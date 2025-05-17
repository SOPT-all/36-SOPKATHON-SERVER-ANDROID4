package org.sopt.domain.course.dto.response;

import java.util.List;
import org.sopt.domain.spot.domain.Spot;
import org.sopt.domain.spot.dto.SpotDto;

public record GetCourseDetailsResponse(
        String nickname,
        String courseTitle,
        List<SpotDto> spotList // ✅ 여기 직접 spotList로
) {
    public static GetCourseDetailsResponse of(
            String nickname,
            String courseTitle,
            List<Spot> spotList
    ) {
        List<SpotDto> spotDtos = spotList.stream()
                .map(SpotDto::from)
                .toList();
        return new GetCourseDetailsResponse(nickname, courseTitle, spotDtos);
    }
}
