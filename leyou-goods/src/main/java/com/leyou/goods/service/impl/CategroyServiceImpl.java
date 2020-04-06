package com.leyou.goods.service.impl;

import com.leyou.api.pojo.Category;
import com.leyou.goods.mapper.CategroyMapper;
import com.leyou.goods.service.CategroyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: dc
 * @Date: 2020/4/5 20:21
 * @Description:
 */
@Service
public class CategroyServiceImpl implements CategroyService {

    @Autowired
    private CategroyMapper categroyMapper;

    /**
     * 根据父分类id查询商品分类
     * @param pid
     * @return
     */
    @Override
    public List<Category> categroyList(Long pid) {
        Category category = new Category();
        category.setParentId(pid);
        return categroyMapper.select(category);
    }
}
