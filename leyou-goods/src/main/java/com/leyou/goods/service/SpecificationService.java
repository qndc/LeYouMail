package com.leyou.goods.service;

import com.leyou.api.pojo.SpecGroup;
import com.leyou.api.pojo.SpecParam;

import java.util.List;

/**
 * @Auther: dc
 * @Date: 2020/4/8 22:01
 * @Description:
 */
public interface SpecificationService {

    List<SpecGroup> SpecGroupList(Long cid);

    List<SpecParam> queryParams(Long gid, Long cid, Boolean generic, Boolean searching);
}
