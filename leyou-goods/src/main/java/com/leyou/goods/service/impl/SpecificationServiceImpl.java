package com.leyou.goods.service.impl;

import com.leyou.api.pojo.SpecGroup;
import com.leyou.api.pojo.SpecParam;
import com.leyou.goods.mapper.SpecGroupMapper;
import com.leyou.goods.mapper.SpecParamMapper;
import com.leyou.goods.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: dc
 * @Date: 2020/4/8 22:01
 * @Description:
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    private SpecGroupMapper specGroupMapper;
    @Autowired
    private SpecParamMapper specParamMapper;

    @Override
    public List<SpecGroup> SpecGroupList(Long cid) {
        SpecGroup specGroup = new SpecGroup();
        specGroup.setCid(cid);
        return specGroupMapper.select(specGroup);
    }

    /**
     * 如果param中有属性为null，则不会把属性作为查询条件，因此该方法具备通用性，即可根据gid查询，也可根据cid查询
     * @param gid
     * @param cid
     * @param generic
     * @param searching
     * @return
     */
    @Override
    public List<SpecParam> queryParams(Long gid, Long cid, Boolean generic, Boolean searching) {
        SpecParam record = new SpecParam();
        record.setGroupId(gid).setCid(cid).setGeneric(generic).setSearching(searching);
        return this.specParamMapper.select(record);
    }
}
