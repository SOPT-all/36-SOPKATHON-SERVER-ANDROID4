package org.sopt.domain.course.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.domain.course.domain.Course;
import org.sopt.domain.course.dto.response.GetCourseDetailsResponse;
import org.sopt.domain.course.repository.CourseRepository;
import org.sopt.domain.spot.domain.Spot;
import org.sopt.global.exception.BusinessException;
import org.sopt.global.exception.ErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    @Transactional(readOnly = true)
    public GetCourseDetailsResponse getCourseDetail(Long courseId) {
        Course course = courseRepository.findByIdWithSpots(courseId)
                .orElseThrow(() -> new BusinessException(ErrorCode.COURSE_NOT_FOUND));

        List<Spot> spots = course.getSpots();

        return GetCourseDetailsResponse.of(
                course.getUser().getNickname(),
                course.getCourseTitle(),
                spots // 예시
        );
    }
}