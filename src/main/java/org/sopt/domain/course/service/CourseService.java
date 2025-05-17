package org.sopt.domain.course.service;

import lombok.RequiredArgsConstructor;
import org.sopt.domain.course.domain.Course;
import org.sopt.domain.course.dto.response.GetCourseDetailsResponse;
import org.sopt.domain.course.repository.CourseRepository;
import org.sopt.global.exception.BusinessException;
import org.sopt.global.exception.ErrorCode;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public GetCourseDetailsResponse getCourseDetail(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new BusinessException(ErrorCode.COURSE_NOT_FOUND));




    }
}