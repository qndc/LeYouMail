package com.leyou.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.api.pojo.Brand;
import com.leyou.common.pojo.PageResult;
import com.leyou.goods.mapper.BrandMapper;
import com.leyou.goods.service.BrandService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Auther: dc
 * @Date: 2020/4/6 12:12
 * @Description:
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;


    @Override
    public PageResult<Brand> queryByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc) {
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        //添加模糊查询
        if (StringUtils.isNotBlank(key)){
            criteria.andLike("name","%"+key+"%").orEqualTo("letter",key);
        }
        //添加分页查询
        PageHelper.startPage(page,rows);
        //添加排序:criteria中没有排序，example中有
        if (StringUtils.isNotBlank(sortBy)){
            example.setOrderByClause(sortBy + (desc?" desc":" asc"));
        }
        List<Brand> brandList = this.brandMapper.selectByExample(example);
        PageInfo<Brand> pageInfo = new PageInfo<>(brandList);
        return new PageResult<>(brandList,null,pageInfo.getTotal(),rows,page);
    }
}
