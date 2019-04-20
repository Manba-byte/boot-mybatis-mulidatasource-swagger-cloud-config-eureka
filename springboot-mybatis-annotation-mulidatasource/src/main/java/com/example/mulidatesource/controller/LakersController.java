package com.example.mulidatesource.controller;

import com.example.mulidatesource.entity.Lakers;
import com.example.mulidatesource.mapper.test2.LakersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wh
 * @description
 * @date 2019/4/18
 */
@RestController
@RequestMapping("/lakers")
public class LakersController {
    @Autowired
    private LakersMapper lakersMapper;
    @RequestMapping("/deleteByPrimaryKey")
    public int deleteByPrimaryKey(Integer lakersId){
        return lakersMapper.deleteByPrimaryKey(lakersId);
    }

    @RequestMapping("/insert")
    public int insert(Lakers record){
        return lakersMapper.insert(record);
    }

    @RequestMapping("/insertSelective")
    public int insertSelective(Lakers record){
        return lakersMapper.insertSelective(record);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Lakers selectByPrimaryKey(Integer lakersId){
        return lakersMapper.selectByPrimaryKey(lakersId);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Lakers record){
        return lakersMapper.updateByPrimaryKeySelective(record);
    }

    @RequestMapping("/updateByPrimaryKey")
    int updateByPrimaryKey(Lakers record){
        return lakersMapper.updateByPrimaryKey(record);
    }
}
