package com.leyou.upload.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: dc
 * @Date: 2020/4/6 23:00
 * @Description:
 */
public interface UploadService {

    String upload(MultipartFile file);
}
