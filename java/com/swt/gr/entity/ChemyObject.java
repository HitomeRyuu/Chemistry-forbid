package com.swt.gr.entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
/**
 * @author cwl
 * 用于创建返回值、建立边的类型、单点查询的ID、和传入的数据
 */
@Getter
@Setter
@ToString
public class ChemyObject {
    private List<String > typelist ;
    private Integer chemyid;
    private String chemyname;

    public List<String> gettypelist() {
        return typelist;
    }

}