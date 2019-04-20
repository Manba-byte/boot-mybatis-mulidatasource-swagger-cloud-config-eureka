package com.example.mulidatesource.controller;

import com.example.mulidatesource.entity.Rockets;
import com.example.mulidatesource.mapper.test1.RocketsMapper;
import com.example.mulidatesource.utils.Page;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author wh
 * @description
 * @date 2019/4/18
 */
@Api(value = "火箭队官网API")
@RestController
@RequestMapping("/rokects")
public class RokectsController {
    @Autowired
    private RocketsMapper rocketsMapper;

    @DeleteMapping("/deleteByPrimaryKey")
    @ApiOperation(value = "根据球员编号删除球员信息")
    @ApiImplicitParam(name = "rocketsId" , value = "队员id编号" , dataType = "string" , paramType = "query" , required = true)
    public int deleteByPrimaryKey(Integer rocketsId){
        System.out.println(rocketsId);
        return rocketsMapper.deleteByPrimaryKey(rocketsId);
    }

    @ApiOperation(value = "添加球员信息")
    @PostMapping("/insertSelective")
    public int insertSelective(Rockets record){
        return rocketsMapper.insertSelective(record);
    }

    @GetMapping("/selectByPrimaryKey")
    @ApiOperation("根据id查询球员信息")
    @ApiImplicitParam(name = "rocketsId" , value = "队员id编号" , dataType = "string" , paramType = "query" , required = true)
    public Rockets selectByPrimaryKey(Integer rocketsId){

        return rocketsMapper.selectByPrimaryKey(rocketsId);
    }

    @PostMapping("/insert")
    @ApiOperation("添加球员信息")
    public int insert(Rockets record){
        return rocketsMapper.insert(record);
    }

    @PutMapping("/updateByPrimaryKeySelective")
    @ApiOperation("修改球员信息")
    public int updateByPrimaryKeySelective(Rockets record){
        return rocketsMapper.updateByPrimaryKeySelective(record);
    }

    @PutMapping("/updateByPrimaryKey")
    @ApiOperation("修改球员信息")
    public int updateByPrimaryKey(Rockets record){
        return rocketsMapper.updateByPrimaryKey(record);
    }

    @GetMapping("/selectRokects")
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageSize" , value = "当前页码" , dataType = "string" , paramType = "query" , required = true),
            @ApiImplicitParam(name="row" , value = "每页显示行数" , dataType = "string" , paramType = "query" , required = true)}
    )
    public Object selectRokects(String pageSize , String row){
        /*Integer p = Integer.valueOf(pageSize);
        Integer r = Integer.valueOf(row);
        Page<Object> objects = PageHelper.startPage(p, r);
        long total = objects.getTotal();
        System.out.println(total);
        List<Rockets> list = rocketsMapper.selectRockets();
        PageInfo<Rockets> pageInfo = new PageInfo(list);
        return pageInfo;*/

        HashMap map = new HashMap();
        //将参数添加至map,用于mapper层执行sql[如果sql需要参数的话],
        //通过page.builder校验参数,并调用startPage方法
        map.put("page",pageSize);
        map.put("row",row);
        Page.builder(pageSize,row);
        List<Rockets> list = rocketsMapper.findRokects(map);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }
}
