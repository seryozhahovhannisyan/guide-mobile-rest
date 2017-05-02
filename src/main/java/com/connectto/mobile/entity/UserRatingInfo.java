package com.connectto.mobile.entity;

import com.connectto.mobile.common.util.StringHelper;

import java.util.Properties;

/**
 * Created by htdev001 on 3/24/15.
 */
public class UserRatingInfo {

    private Long id;
    private Long userId;
    private String password;
    private String rating;
    private String channelCategory;
    private int watchingChannel;
    private int noRating;

    public UserRatingInfo() {
    }

    public UserRatingInfo(Properties properties) {
        password =  StringHelper.isBlank(properties.getProperty("password")) ? "1111" : properties.getProperty("password");
        rating =  StringHelper.isBlank(properties.getProperty("rating")) ? "" : properties.getProperty("rating");
        channelCategory =  StringHelper.isBlank(properties.getProperty("channelCategory")) ? "" : properties.getProperty("channelCategory");

        try {
            noRating = StringHelper.isBlank(properties.getProperty("noRating")) ? 1 : Integer.parseInt(properties.getProperty("noRating"));
        }catch (Exception e){
            noRating = 1;
        }

        try {
            watchingChannel = StringHelper.isBlank(properties.getProperty("watchingChannel")) ? 0 : Integer.parseInt(properties.getProperty("watchingChannel"));
        }catch (Exception e){
            watchingChannel = 0;
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getNoRating() {
        return noRating;
    }

    public void setNoRating(int noRating) {
        this.noRating = noRating;
    }

    public String getChannelCategory() {
        return channelCategory;
    }

    public void setChannelCategory(String channelCategory) {
        this.channelCategory = channelCategory;
    }

    public int getWatchingChannel() {
        return watchingChannel;
    }

    public void setWatchingChannel(int watchingChannel) {
        this.watchingChannel = watchingChannel;
    }
}
