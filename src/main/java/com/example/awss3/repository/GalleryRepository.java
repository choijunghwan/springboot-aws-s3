package com.example.awss3.repository;

import com.example.awss3.entity.GalleryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface GalleryRepository extends JpaRepository<GalleryEntity, Long> {
}
