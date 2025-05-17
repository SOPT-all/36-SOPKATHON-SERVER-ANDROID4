package org.sopt.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.sopt.domain.user.domain.User;
import org.sopt.domain.user.dto.response.GetUserListResponse;
import org.sopt.domain.user.repository.UserRepository;
import org.sopt.global.exception.BusinessException;
import org.sopt.global.exception.ErrorCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public GetUserListResponse getCuratorList(final Long userId) {
        List<User> curatorList = userRepository.findAll();
        if (userRepository.findById(userId).isEmpty()) throw new BusinessException(ErrorCode.NOT_FOUND_USER_EXCEPTION);
        return GetUserListResponse.of(curatorList);
    }
}
