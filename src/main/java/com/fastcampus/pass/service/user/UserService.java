package com.fastcampus.pass.service.user;

import com.fastcampus.pass.repository.user.UserEntity;
import com.fastcampus.pass.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUser(String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);

        return UserModelMapper.INSTANCE.map(userEntity);
    }
}
