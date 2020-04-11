package com.leyou.goods.mapper;

import com.leyou.api.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Auther: dc
 * @Date: 2020/4/6 12:20
 * @Description:
 */
public interface BrandMapper extends Mapper<Brand> {

    @Insert("insert into tb_category_brand(category_id,brand_id)values(#{cid},#{bid})")
    int saveCategoryAndBrand(@Param("cid") Long cid,@Param("bid") Long bid);

    @Select("SELECT * FROM tb_brand b INNER JOIN tb_category_brand cb ON b.`id` = cb.`brand_id` WHERE cb.`category_id` = #{cid}")
    List<Brand> queryBrandByCid(@Param("cid") Long cid);

}
