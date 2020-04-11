package com.leyou.common.pojo;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: dc
 * @Date: 2020/4/8 19:12
 * @Description:
 */
public class LeyouConst {

    //图片上传枚举类型
    public static final List<String> CONTENT_TYPES = Arrays.asList("image/gif","image/jpeg","image/tiff","image/png");
    //图片上传微服务域名
    public static final String UPLOAD_SERVER = "http://image.leyou.com/";
}
