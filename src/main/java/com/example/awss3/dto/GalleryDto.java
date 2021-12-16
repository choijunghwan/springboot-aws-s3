package com.example.awss3.dto;

import com.example.awss3.entity.GalleryEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GalleryDto {
    private Long id;
    private String title;
    private String filePath;
    private String imgFullPath;

    @Builder
    public GalleryDto(Long id, String title, String filePath, String imgFullPath) {
        this.id = id;
        this.title = title;
        this.filePath = filePath;
        this.imgFullPath = imgFullPath;
    }

    public GalleryEntity toEntity() {
        GalleryEntity entity = GalleryEntity.builder()
                .id(id)
                .title(title)
                .filePath(filePath)
                .build();
        return entity;
    }
}
