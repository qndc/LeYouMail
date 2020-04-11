package com.leyou.upload.service.impl;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.leyou.common.pojo.LeyouConst;
import com.leyou.upload.controller.UploadController;
import com.leyou.upload.service.UploadService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: dc
 * @Date: 2020/4/6 23:00
 * @Description:
 */
@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private ThumbImageConfig thumbImageConfig;

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadServiceImpl.class);

    @Override
    public String upload(MultipartFile file) {

        try {
            //文件类型校验
            String contentType = file.getContentType();
            if (!LeyouConst.CONTENT_TYPES.contains(contentType)){
                LOGGER.info("文件上传失败:{},文件类型不合法!",file.getOriginalFilename());
                return null;
            }
            //校验文件内容,ImageIO读取文件内容，如果不是文件BufferedImage则为空，一般用于图片验证码返回前端
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            if (bufferedImage == null){
                LOGGER.info("文件上传失败:{},文件内容不合法!",file.getOriginalFilename());
                return null;
            }
            //上传并保存图片，参数：1-上传的文件流 2-文件的大小 3-文件的后缀 4-可以不管他
            //StringUtils.substringAfterLast(str,separator)
            String fileExtName = StringUtils.substringAfterLast(file.getOriginalFilename(), ".");
            StorePath storePath = this.storageClient.uploadFile(
                    file.getInputStream(), file.getSize(), fileExtName, null);
            //带组名的图片路径
            String fullPath = storePath.getFullPath();
            return LeyouConst.UPLOAD_SERVER + fullPath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
