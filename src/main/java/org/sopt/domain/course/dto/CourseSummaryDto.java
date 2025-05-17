package org.sopt.domain.course.dto;

import org.sopt.domain.course.domain.Course;
import org.sopt.domain.spot.domain.Spot;

import java.util.ArrayList;
import java.util.List;

public record CourseSummaryDto(
        String courseTitle,
        String description,
        List<String> imageUrls
) {
    public static CourseSummaryDto from(Course course) {
        List<Spot> spots = course.getSpots();

        List<String> imageUrls = (!spots.isEmpty() && spots.get(0).getImageUrls() != null)
                ? new ArrayList<>(spots.get(0).getImageUrls().subList(0, 2))
                : List.of();

        return new CourseSummaryDto(
                course.getCourseTitle(),
                course.getDescription(),
                imageUrls
        );
    }
}
