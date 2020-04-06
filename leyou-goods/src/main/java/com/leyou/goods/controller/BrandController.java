package com.leyou.goods.controller;

import com.leyou.api.pojo.Brand;
import com.leyou.common.pojo.PageResult;
import com.leyou.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: dc
 * @Date: 2020/4/6 12:11
 * @Description:
 */
@Controller
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     *
     * @param key 搜索条件
     * @param page 当前页
     * @param rows 每页显示条数
     * @param sortBy 排序字段
     * @param desc  是否排序
     * @return
     */
    @GetMapping("/page")
    public ResponseEntity<PageResult<Brand>> getByPage(
            @RequestParam(value = "key",required = false) String key,
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "rows",defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy",required = false) String sortBy,
            @RequestParam(value = "desc",required = false) Boolean desc
    ){
        PageResult<Brand> result = brandService.queryByPage(key,page,rows,sortBy,desc);
        if (result == null || CollectionUtils.isEmpty(result.getItems())){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

}
