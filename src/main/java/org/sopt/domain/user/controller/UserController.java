package org.sopt.domain.user.controller;

import org.sopt.domain.user.dto.response.GetMyPageResponse;
import org.sopt.domain.course.dto.response.GetCourseResponse;
import org.sopt.domain.user.dto.response.GetUserListResponse;
import org.sopt.domain.user.service.UserService;
import org.sopt.global.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/curators")
    public ResponseEntity<ApiResponse<GetUserListResponse>> getCuratorList(
            @RequestHeader("userId") Long userId
    ) {
        return ResponseEntity.ok(
                ApiResponse.ok(userService.getCuratorList(userId))
        );
    }

    @GetMapping("/users/me")
    public ResponseEntity<ApiResponse<GetMyPageResponse>> getMyPage(
            @RequestHeader("userId") Long userId
    ) {
        return ResponseEntity.ok(
                ApiResponse.ok(userService.getMyPageData(userId))
        );
    }


    @GetMapping("/user/{userId}/course")
    public ApiResponse<GetCourseResponse> getCuratorInformationAndList(
            @RequestHeader("userId") Long headerUserId,
            @PathVariable("userId") Long pathUserId
    ) {
        return ApiResponse.ok(userService.getCuratorInformationAndCourseList(headerUserId,pathUserId));
    }

}
