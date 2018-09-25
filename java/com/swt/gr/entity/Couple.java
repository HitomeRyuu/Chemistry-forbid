package com.swt.gr.entity;
import com.alibaba.fastjson.JSONArray;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;

import java.util.List;
import java.util.Map;

/**
 * @author cwl
 * 用于创建返回值、建立边的类型、单点查询的ID、和传入的数据
 */
@Getter
@Setter
@ToString
@Builder
public class Couple {
    private List chemy1;
    private List chemy2;
}