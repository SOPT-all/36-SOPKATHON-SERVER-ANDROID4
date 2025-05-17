package org.sopt.domain.course.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.domain.course.dto.response.GetCourseDetailsResponse;
import org.sopt.domain.course.service.CourseService;
import org.sopt.global.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/{courseId}")
    public ResponseEntity<ApiResponse<GetCourseDetailsResponse>> getCourseDetails(
            @PathVariable("courseId") Long courseId
    ) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        courseService.getCourseDetail(courseId)
                )

        );
    }

}