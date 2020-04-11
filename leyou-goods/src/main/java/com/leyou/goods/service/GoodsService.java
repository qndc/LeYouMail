package com.leyou.goods.service;

import com.leyou.api.bo.SpuBo;
import com.leyou.api.pojo.Sku;
import com.leyou.api.pojo.SpuDetail;
import com.leyou.common.pojo.PageResult;

import java.util.List;

/**
 * @Auther: dc
 * @Date: 2020/4/9 20:39
 * @Description:
 */
public interface GoodsService {

    PageResult<SpuBo> querySpuByPage(String key, Boolean saleable, Integer page, Integer rows);

    void saveGoods(SpuBo spuBo);

    SpuDetail queryDetailBySpuId(Long spuId);

    List<Sku> querySkusBySpuId(Long spuId);
}
