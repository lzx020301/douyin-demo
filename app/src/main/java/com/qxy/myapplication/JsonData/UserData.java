package com.qxy.myapplication.JsonData;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.qxy.myapplication.BR;


public class UserData {
    private String avatar;
    @JsonProperty("avatar_larger")
    private String avatarLarger;
    private String captcha;
    private String city;
    @JsonProperty("client_key")
    private String clientKey;
    private String country;
    @JsonProperty("desc_url")
    private String descUrl;
    private String description;
    private String district;
    @JsonProperty("e_account_role")
    private String eAccountRole;
    @JsonProperty("error_code")
    private int errorCode;
    private int gender;
    @JsonProperty("log_id")
    private String logId;
    private String nickname;
    @JsonProperty("open_id")
    private String openId;
    private String province;
    @JsonProperty("union_id")
    private String unionId;
    public UserData(){

    }

    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public String getAvatarLarger() {
        return avatarLarger;
    }
    public void setAvatarLarger(String avatarLarger) {
        this.avatarLarger = avatarLarger;
    }


    public String getCaptcha() {
        return captcha;
    }
    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }


    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }


    public String getClientKey() {
        return clientKey;
    }
    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }


    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }


    public String getDescUrl() {
        return descUrl;
    }
    public void setDescUrl(String descUrl) {
        this.descUrl = descUrl;
    }


    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }


    public String getEAccountRole() {
        return eAccountRole;
    }
    public void setEAccountRole(String eAccountRole) {
        this.eAccountRole = eAccountRole;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    public int getErrorCode() {
        return errorCode;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
    public int getGender() {
        return gender;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }
    public String getLogId() {
        return logId;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
    public String getOpenId() {
        return openId;
    }

    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }
    public String getUnionId() {
        return unionId;
    }
}
