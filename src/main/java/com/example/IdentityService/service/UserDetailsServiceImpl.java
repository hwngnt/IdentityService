package com.example.IdentityService.service;

import com.example.IdentityService.exception.AppException;
import com.example.IdentityService.exception.ErrorCode;
import com.example.IdentityService.model.User;
import com.example.IdentityService.model.UserDetailsImpl;
import com.example.IdentityService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        return UserDetailsImpl.build(user);
    }
}
