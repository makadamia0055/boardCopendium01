package org.board.cop.boardcopendium01.domain.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;



@SpringBootTest
class UserDomainTest {


    @Autowired
    UserRepository userRepository;

    @Test
    public void User등록및조회테스트(){
        //given
        UserDomain user = userRepository.save(UserDomain
                .builder()
                .email("mail@naver.com")
                .name("프픙이")
                .password("pw")

                .build()
        );
        String userEmail = user.getEmail();
        //when
        UserDomain byEmail = userRepository.findByEmail(userEmail).get();
        //then
        assertThat(user.getEmail()).isEqualTo(byEmail.getEmail());
        assertThat(user.getName()).isEqualTo(byEmail.getName());
        assertThat(user.getPassword()).isEqualTo(byEmail.getPassword());

    }
}