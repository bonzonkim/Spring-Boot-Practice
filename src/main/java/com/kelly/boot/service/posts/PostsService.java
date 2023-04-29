package com.kelly.boot.service.posts;

import com.kelly.boot.domain.posts.Posts;
import com.kelly.boot.domain.posts.PostsRepository;
import com.kelly.boot.web.dto.PostsResponseDto;
import com.kelly.boot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsSaveRequestDto requestDto) {
        Posts posts = PostsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No such posts" + id));
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No such posts" + id));
        return new PostsResponseDto(entity);
    }
    }
