package com.example.awss3.service;

import com.example.awss3.dto.GalleryDto;
import com.example.awss3.entity.GalleryEntity;
import com.example.awss3.repository.GalleryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GalleryService {

    private final S3Service s3Service;
    private final GalleryRepository galleryRepository;

    public void savePost(GalleryDto galleryDto) {
        galleryRepository.save(galleryDto.toEntity());
    }

    public List<GalleryDto> getList() {
        List<GalleryEntity> galleryEntityList = galleryRepository.findAll();
        List<GalleryDto> galleryDtoList = new ArrayList<>();

        for (GalleryEntity galleryEntity : galleryEntityList) {
            galleryDtoList.add(convertEntityToDto(galleryEntity));
        }

        return galleryDtoList;
    }

    private GalleryDto convertEntityToDto(GalleryEntity galleryEntity) {
        return GalleryDto.builder()
                .id(galleryEntity.getId())
                .title(galleryEntity.getTitle())
                .filePath(galleryEntity.getFilePath())
                .imgFullPath("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getFilePath())
                .build();
    }
}
