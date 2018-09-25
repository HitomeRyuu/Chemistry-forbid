package com.swt.gr.entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;

import java.util.List;
/**
 * @author cwl
 * 用于创建返回值、建立边的类型、单点查询的ID、和传入的数据
 */

@Getter
@Setter
@ToString
public class Type {
    private List<Forbid> changeEdge ;
    private String type1;
    private String type2;
    public List<Forbid> getChangeEdge() {
        return changeEdge;
    }
    public void setChangeEdge(List<Forbid> changeEdge) {
        this.changeEdge=changeEdge;
    }
}