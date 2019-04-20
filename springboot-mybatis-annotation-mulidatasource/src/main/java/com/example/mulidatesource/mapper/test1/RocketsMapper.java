package com.example.mulidatesource.mapper.test1;

import com.example.mulidatesource.entity.Rockets;

import java.util.HashMap;
import java.util.List;

public interface RocketsMapper {
    int deleteByPrimaryKey(Integer rocketsId);

    int insert(Rockets record);

    int insertSelective(Rockets record);

    Rockets selectByPrimaryKey(Integer rocketsId);

    int updateByPrimaryKeySelective(Rockets record);

    int updateByPrimaryKey(Rockets record);

    List<Rockets> findRokects(HashMap map);
}