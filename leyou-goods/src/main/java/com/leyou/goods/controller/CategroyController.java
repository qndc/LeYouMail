package com.leyou.goods.controller;

import com.leyou.api.pojo.Category;
import com.leyou.goods.service.CategroyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Auther: dc
 * @Date: 2020/4/5 20:22
 * @Description:
 */
@Controller
@RequestMapping("categroy")
public class CategroyController {

    @Autowired
    private CategroyService categroyService;

    @GetMapping("list")
    public ResponseEntity<List<Category>> list(@RequestParam(value = "pid",defaultValue = "0") Long pid){
        System.out.println(pid);
        if (pid == null || pid < 0){
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            return ResponseEntity.badRequest().build();
        }
        List<Category> list = categroyService.categroyList(pid);
        if (CollectionUtils.isEmpty(list)){
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
    }

}
