package com.example.awss3.repository;

import com.example.awss3.entity.GalleryEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class GalleryRepositoryTest {

    @Autowired
    private GalleryRepository galleryRepository;

    @Test
    public void save() {
        GalleryEntity entity = GalleryEntity.builder()
                .id(1L)
                .title("title")
                .filePath("path")
                .build();

        galleryRepository.save(entity);

        GalleryEntity findGallery = galleryRepository.findById(1L).get();

//        assertThat(findGallery).isEqualTo(entity);
        assertThat(findGallery.getTitle()).isEqualTo("title");
        assertThat(findGallery.getFilePath()).isEqualTo("path");
    }
}