package com.edisonmaciel.dslearn.services;

import com.edisonmaciel.dslearn.dto.UserDTO;
import com.edisonmaciel.dslearn.entities.User;
import com.edisonmaciel.dslearn.repositories.UserRepository;
import com.edisonmaciel.dslearn.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    private final AuthService authService;

    @Transactional(readOnly = true)
    public UserDTO findById(final Long id) {
        authService.validateSelfOrAdmin(id);
        Optional<User> obj = userRepository.findById(id);
        User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new UserDTO(entity);
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final var user = userRepository.findByEmail(username);
        if (user == null) {
            logger.error("User not found: " + username);
            throw new UsernameNotFoundException("Email not found");
        }
        logger.info("User found: " + username);
        return user;
    }

}
