package com.mysite.sbb.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String username, String email, String password) {
        SiteUser user = new SiteUser();
        user.setUsername(username);
        user.setEmail(email); //email.toLowerCase() 설정 시 대소문자 중복 문제 차단 가능
        user.setPassword(passwordEncoder.encode(password)); //비밀번호 암호화
        this.userRepository.save(user);
        return user;
    }
}
