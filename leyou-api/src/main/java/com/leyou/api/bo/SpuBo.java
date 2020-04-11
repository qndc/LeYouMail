package com.leyou.api.bo;

import com.leyou.api.pojo.Sku;
import com.leyou.api.pojo.Spu;
import com.leyou.api.pojo.SpuDetail;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Auther: dc
 * @Date: 2020/4/9 20:44
 * @Description:
 */
public class SpuBo extends Spu {

    private String cname;
    private String bname;

    private List<Sku> skus;
    private SpuDetail spuDetail;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }

    public SpuDetail getSpuDetail() {
        return spuDetail;
    }

    public void setSpuDetail(SpuDetail spuDetail) {
        this.spuDetail = spuDetail;
    }
}
