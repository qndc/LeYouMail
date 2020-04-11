package com.leyou.goods.service.impl;

import com.leyou.api.pojo.Category;
import com.leyou.goods.mapper.CategroyMapper;
import com.leyou.goods.service.CategroyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * 根据多级分类id查询分类名称
     * @param ids
     * @return
     */
    @Override
    public List<String> queryNamesByIds(List<Long> ids) {
        List<Category> categories = this.categroyMapper.selectByIdList(ids);
        return categories.stream().map(category -> category.getName()).collect(Collectors.toList());
    }
}
