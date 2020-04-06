package com.leyou.goods.service;

import com.leyou.api.pojo.Category;

import java.util.List;

/**
 * @Auther: dc
 * @Date: 2020/4/5 20:20
 * @Description:
 */
public interface CategroyService {


    List<Category> categroyList(Long pid);
}
