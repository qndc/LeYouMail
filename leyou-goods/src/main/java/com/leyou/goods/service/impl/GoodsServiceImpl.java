package com.leyou.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.api.bo.SpuBo;
import com.leyou.api.pojo.*;
import com.leyou.common.pojo.PageResult;
import com.leyou.goods.mapper.*;
import com.leyou.goods.service.CategroyService;
import com.leyou.goods.service.GoodsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: dc
 * @Date: 2020/4/9 20:39
 * @Description:
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private SpuMapper spuMapper;
    @Autowired
    private SpuDetailMapper spuDetailMapper;
    @Autowired
    private CategroyMapper categroyMapper;
    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private SkuMapper skuMapper;
    @Autowired
    private StockMapper stockMapper;
    @Autowired
    private CategroyService categroyService;

    @Override
    public PageResult<SpuBo> querySpuByPage(String key, Boolean saleable, Integer page, Integer rows) {
        Example example = new Example(Spu.class);
        Example.Criteria criteria = example.createCriteria();
        //添加模糊查询
        if (StringUtils.isNotBlank(key)){
            criteria.andLike("title","%"+key+"%");
        }
        //添加是否上下架,判断布尔类型是否为空
        if (saleable != null){
            criteria.andEqualTo("saleable",saleable);
        }
        //添加分页
        PageHelper.startPage(page,rows);
        List<Spu> spus = this.spuMapper.selectByExample(example);
        PageInfo<Spu> info = new PageInfo<>(spus);
        //把List<Spu>转换成List<SpuBo>
        List<SpuBo> spuBos = spus.stream().map(spu -> {
            SpuBo spuBo = new SpuBo();
            //把spu所有的属性值copy给spubo
            BeanUtils.copyProperties(spu, spuBo);
            //根据spu中的品牌id、分类id查询出品牌名称和分类名称
            Brand brand = brandMapper.selectByPrimaryKey(spu.getBrandId());
            spuBo.setBname(brand.getName());
            List<String> names = this.categroyService.queryNamesByIds(Arrays.asList(spu.getCid1(), spu.getCid2(), spu.getCid3()));
            spuBo.setCname(StringUtils.join(names, "-"));
            return spuBo;
        }).collect(Collectors.toList());
        return new PageResult<>(spuBos,null,info.getTotal(),rows,page);
    }

    @Override
    @Transactional
    public void saveGoods(SpuBo spuBo) {
        //添加spu（共同属性的商品集）
        spuBo.setId(null);
        spuBo.setCreateTime(new Date());
        spuBo.setLastUpdateTime(spuBo.getCreateTime());
        spuBo.setValid(true);
        spuBo.setSaleable(true);
        this.spuMapper.insert(spuBo);
        //添加spu_detail（值）
        SpuDetail spuDetail = spuBo.getSpuDetail();
        spuDetail.setSpuId(spuBo.getId());
        this.spuDetailMapper.insert(spuDetail);
        List<Sku> skus = spuBo.getSkus();
        skus.forEach(sku -> {
            sku.setCreateTime(new Date());
            sku.setLastUpdateTime(sku.getCreateTime());
            sku.setId(null);
            sku.setSpuId(spuBo.getId());
            //添加sku（具体特性不同而细分的每个商品）
            this.skuMapper.insertSelective(sku);
            //添加stock（库存）
            Stock stock = new Stock();
            stock.setSkuId(sku.getId());
            stock.setStock(sku.getStock());
            this.stockMapper.insertSelective(stock);
        });
        this.skuMapper.insertList(skus);
    }

    @Override
    public SpuDetail queryDetailBySpuId(Long spuId) {
        return this.spuDetailMapper.selectByPrimaryKey(spuId);
    }

    @Override
    public List<Sku> querySkusBySpuId(Long spuId) {
        //查询sku
        Sku sku = new Sku();
        sku.setSpuId(spuId);
        //查询sku对应的库存
        List<Sku> skus = this.skuMapper.select(sku);
        skus.forEach(s -> {
            System.out.println(s);
            Stock stock = this.stockMapper.selectByPrimaryKey(s.getId());
            s.setStock(stock.getStock());
        });
        return skus;
    }
}
