package com.swt.gr.entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;


import com.alibaba.fastjson.JSONArray;

import java.util.List;

/**
 * @author Administrator
 */
@Setter
@Getter
@ToString


public class Tempchemy {
    public String innerName;
    public JSONArray innerArr;
    }
