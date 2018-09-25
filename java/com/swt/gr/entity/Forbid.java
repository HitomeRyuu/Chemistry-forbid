package com.swt.gr.entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author cwl
 * 用于建立最后两点和边的类型以及边的个数
 */
@Getter
@Setter
@Builder
@ToString
public class Forbid {
    private String a;
    private String b;
    private int c;}
