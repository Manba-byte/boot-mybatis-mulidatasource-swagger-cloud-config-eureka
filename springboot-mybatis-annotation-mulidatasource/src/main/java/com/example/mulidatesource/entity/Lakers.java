package com.example.mulidatesource.entity;

import java.io.Serializable;

public class Lakers implements Serializable {
    private Integer lakersId;

    private String lakersName;

    private String lakersLoc;

    private static final long serialVersionUID = 1L;

    public Integer getLakersId() {
        return lakersId;
    }

    public void setLakersId(Integer lakersId) {
        this.lakersId = lakersId;
    }

    public String getLakersName() {
        return lakersName;
    }

    public void setLakersName(String lakersName) {
        this.lakersName = lakersName == null ? null : lakersName.trim();
    }

    public String getLakersLoc() {
        return lakersLoc;
    }

    public void setLakersLoc(String lakersLoc) {
        this.lakersLoc = lakersLoc == null ? null : lakersLoc.trim();
    }
}