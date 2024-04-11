package org.board.cop.boardcopendium01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BoardCopendium01Application {

    public static void main(String[] args) {
        SpringApplication.run(BoardCopendium01Application.class, args);
    }

}
