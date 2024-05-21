package com.zerobase.board.domain;

import com.zerobase.board.infrastructure.persistence.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @AfterEach
    public void clear() {
        userRepository.deleteAll();
    }

    @Test
    public void 유저_생성_가져오기() {
        String username = "alphagoldksm90"; //"" 예시
        String rawPassword = "tmdals1025"; //"" 예시
        String encPassword = encoder.encode(rawPassword);
        userRepository.save(User.builder().username(username).password(encPassword).nickname("알파골드TV").email("alphagoldksm90@naver.com").role(Role.USER).build());

        List<User> userList = userRepository.findAll();

        User user = userList.get(0);

        assertThat(user.getUsername()).isEqualTo(username);
        assertThat(user.getPassword()).isEqualTo(encPassword);
    }
}