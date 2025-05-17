package org.sopt.domain.course.dto;

import org.sopt.domain.course.domain.Course;

public record CourseSummaryDto(
        String courseTitle,
        String description
) {
    public static CourseSummaryDto from(Course course) {
        return new CourseSummaryDto(
                course.getCourseTitle(),
                course.getDescription()
        );
    }
}
