package com.valik98.security.services;

import com.valik98.security.entity.User;
import com.valik98.security.mappers.UserMapper;
import com.valik98.security.model.UserModel;
import com.valik98.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository<String> userRepository;

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        MessageFormat.format("User with username: {0} does not exist!", username)
                ));
    }

    public UserModel register(UserModel userModel) {
        User user = userRepository.save(
                userMapper.toUser(userModel)
        );

        return userMapper.toUserModel(user);
    }
}
