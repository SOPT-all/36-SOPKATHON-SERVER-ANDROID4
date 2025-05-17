package org.sopt.domain.user.controller;

import org.sopt.domain.user.dto.response.GetUserListResponse;
import org.sopt.domain.user.service.UserService;
import org.sopt.global.dto.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/curators")
    public ApiResponse<GetUserListResponse> getCuratorList(
            @RequestHeader("userId") Long userId
    ) {
        return ApiResponse.ok(userService.getCuratorList(userId));
    }
}
