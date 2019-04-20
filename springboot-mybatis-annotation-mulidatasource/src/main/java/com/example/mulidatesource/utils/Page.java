package com.example.mulidatesource.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author wh
 * @description 分页工具类
 * @date 2019/4/19
 */
public class Page<T> extends HashMap implements Serializable{

    private static int nowPage; //当前页

    private static int rowNum; //每页显示行数

    public static void builder(String pageSize , String row){
        nowPage = Integer.valueOf(pageSize) <= 0 ? 1 : Integer.valueOf(pageSize);
        rowNum = Integer.valueOf(row) <= 0 ? 1 : Integer.valueOf(row);
        PageHelper.startPage(nowPage,rowNum,true);
    }

    public Page(PageInfo<T> pageInfo){
        this.put("pageinfo",pageInfo);
    }
}
