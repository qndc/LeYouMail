package com.leyou.api.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "tb_spec_group")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cid;

    private String name;

    //标记该字段不是数据表中的字段
    @Transient
    private List<SpecParam> params;

}