package org.sopt.domain.user.dto.response;

import org.sopt.domain.user.domain.User;

import java.util.List;

public record GetUserListResponse(List<GetUserResponse> curatorList) {
    public static GetUserListResponse of(List<User> userList) {
        List<GetUserResponse> convertedList = userList.stream()
                .map(GetUserResponse::from)
                .toList();
        return new GetUserListResponse(convertedList);
    }
}
