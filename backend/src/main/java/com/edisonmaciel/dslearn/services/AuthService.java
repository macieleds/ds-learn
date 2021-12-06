package com.edisonmaciel.dslearn.services;

import com.edisonmaciel.dslearn.entities.User;
import com.edisonmaciel.dslearn.repositories.UserRepository;
import com.edisonmaciel.dslearn.services.exceptions.ForbiddenException;
import com.edisonmaciel.dslearn.services.exceptions.UnaothorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public User authenticated() {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            return userRepository.findByEmail(username);
        } catch (Exception e) {
            throw new UnaothorizedException("Invalid user");
        }
    }

    public void validateSelfOrAdmin(Long userId){
        User user = authenticated();
        if (!user.getId().equals(userId) && !user.hasRole("ROLE_ADMIN")) {
            throw new ForbiddenException("Access denied");
        }
    }
}
