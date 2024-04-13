package org.board.cop.boardcopendium01.web;

import lombok.RequiredArgsConstructor;
import org.board.cop.boardcopendium01.domain.PostsService;
import org.board.cop.boardcopendium01.domain.dto.PostsResponseDto;
import org.board.cop.boardcopendium01.domain.dto.PostsSaveRequestDto;
import org.board.cop.boardcopendium01.domain.dto.PostsUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;

    }

}
