package org.board.cop.boardcopendium01.domain;

import lombok.RequiredArgsConstructor;
import org.board.cop.boardcopendium01.domain.dto.PostsResponseDto;
import org.board.cop.boardcopendium01.domain.dto.PostsSaveRequestDto;
import org.board.cop.boardcopendium01.domain.dto.PostsUpdateRequestDto;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다."));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. "));
        return new PostsResponseDto(entity);

    }
}
