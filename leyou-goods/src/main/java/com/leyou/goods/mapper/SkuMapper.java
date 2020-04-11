package com.leyou.goods.mapper;

import com.leyou.api.pojo.Sku;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * @Auther: dc
 * @Date: 2020/4/10 23:27
 * @Description:
 */
public interface SkuMapper extends Mapper<Sku>, InsertListMapper<Sku> {

}
