package com.example.mulidatesource.mapper.test2;

import com.example.mulidatesource.entity.Lakers;

public interface LakersMapper {
    int deleteByPrimaryKey(Integer lakersId);

    int insert(Lakers record);

    int insertSelective(Lakers record);

    Lakers selectByPrimaryKey(Integer lakersId);

    int updateByPrimaryKeySelective(Lakers record);

    int updateByPrimaryKey(Lakers record);
}