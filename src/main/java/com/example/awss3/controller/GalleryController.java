package com.example.awss3.controller;

import com.example.awss3.dto.GalleryDto;
import com.example.awss3.service.GalleryService;
import com.example.awss3.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class GalleryController {

    private final S3Service s3Service;
    private final GalleryService galleryService;

    @GetMapping("/gallery")
    public String dispWrite(Model model) {
        List<GalleryDto> galleryDtoList = galleryService.getList();

        model.addAttribute("galleryList", galleryDtoList);

        return "/gallery";
    }

    @PostMapping("/gallery")
    public String execWrite(GalleryDto galleryDto, MultipartFile file) throws IOException {
        String imgPath = s3Service.upload(file);
        galleryDto.setFilePath(imgPath);

        galleryService.savePost(galleryDto);

        return "redirect:/gallery";
    }
}
