package org.sopt.domain.course.dto.response;

import org.sopt.domain.course.domain.Course;
import org.sopt.domain.spot.domain.Spot;

import java.util.ArrayList;
import java.util.List;

public record GetCourseThumbnailResponse(
        Long courseId,
        String courseTitle,
        Boolean isBookmarked,
        String description,
        List<String> imageUrls,
        String recordDate
) {
    public static GetCourseThumbnailResponse from(Course course, Boolean isBookmarked) {
        List<Spot> spots = course.getSpots();

        List<String> imageUrls = (!spots.isEmpty() && spots.get(0).getImageUrls() != null)
                ? new ArrayList<>(spots.get(0).getImageUrls().subList(0, 2))
                : List.of();

        return new GetCourseThumbnailResponse(
                course.getId(),
                course.getCourseTitle(),
                isBookmarked,
                course.getDescription(),
                imageUrls,
                course.getRecordDate().toString().replace("-", ".")
        );
    }
}
