package com.example.mulidatesource.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
@ApiModel(value = "Rokets")
public class Rockets implements Serializable {
    @ApiModelProperty(value = "球员编号",example = "1")
    private Integer rocketsId;
    @ApiModelProperty(value = "球员姓名",name = "rocketsName",dataType = "String")
    private String rocketsName;
    @ApiModelProperty(value = "球员场上位置",name = "rocketsLoc",dataType = "String")
    private String rocketsLoc;

    private static final long serialVersionUID = 1L;

    public Integer getRocketsId() {
        return rocketsId;
    }

    public void setRocketsId(Integer rocketsId) {
        this.rocketsId = rocketsId;
    }

    public String getRocketsName() {
        return rocketsName;
    }

    public void setRocketsName(String rocketsName) {
        this.rocketsName = rocketsName == null ? null : rocketsName.trim();
    }

    public String getRocketsLoc() {
        return rocketsLoc;
    }

    public void setRocketsLoc(String rocketsLoc) {
        this.rocketsLoc = rocketsLoc == null ? null : rocketsLoc.trim();
    }
}