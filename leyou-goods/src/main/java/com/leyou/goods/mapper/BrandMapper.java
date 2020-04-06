package com.leyou.goods.mapper;

import com.leyou.api.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Auther: dc
 * @Date: 2020/4/6 12:20
 * @Description:
 */
public interface BrandMapper extends Mapper<Brand> {

    @Insert("insert into tb_category_brand(category_id,brand_id)values(#{cid},#{bid})")
    int saveCategoryAndBrand(@Param("cid") Long cid,@Param("bid") Long bid);

}
