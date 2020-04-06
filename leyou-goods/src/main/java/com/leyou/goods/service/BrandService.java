package com.leyou.goods.service;

import com.leyou.api.pojo.Brand;
import com.leyou.common.pojo.PageResult;

/**
 * @Auther: dc
 * @Date: 2020/4/6 12:11
 * @Description:
 */
public interface BrandService {
    PageResult<Brand> queryByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc);
}
