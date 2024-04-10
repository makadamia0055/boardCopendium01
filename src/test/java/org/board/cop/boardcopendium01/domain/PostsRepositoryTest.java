package org.board.cop.boardcopendium01.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanUp(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글_저장_불러오기(){
        //given
        String title ="테스트 게시글";
        String content = "테스트 게시글 내용";
        String author = "테스트 게시글 글쓴이";
        postsRepository.save(Posts.builder().title(title).content(content).author(author).build());

        //when
        List<Posts> list = postsRepository.findAll();

        //then
        Posts posts = list.get(0);
        assertEquals(posts.getTitle(), title);
        assertEquals(posts.getContent(), content);

    }


}