package com.example.handleError.dto;

import com.example.handleError.entity.Post;
import lombok.Builder;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

public class PostData {
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String content;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public PostData() {}

    @Builder
    public PostData(Long id, @NotBlank String title, @NotBlank String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public static PostData of(Post post){
        return PostData.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }

    public static List<PostData> of(List<Post> postList){
        return postList.stream()
                .map(post -> PostData.of(post))
                .collect(Collectors.toList());
    }
}

