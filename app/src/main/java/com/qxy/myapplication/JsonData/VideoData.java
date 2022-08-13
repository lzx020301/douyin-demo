package com.qxy.myapplication.JsonData;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Auto-generated: 2022-08-12 23:11:23
 *
 * @author json996.com
 * @website http://www.json996.com/json2java.html
 */
public class VideoData {

    @JsonProperty("active_time")
    private Date activeTime;
    private String description;
    @JsonProperty("error_code")
    private int errorCode;
    private List<VideoList> list;
    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }
    public Date getActiveTime() {
        return activeTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    public int getErrorCode() {
        return errorCode;
    }

    public void setList(List<VideoList> list) {
        this.list = list;
    }
    public List<VideoList> getList() {
        return list;
    }

}
