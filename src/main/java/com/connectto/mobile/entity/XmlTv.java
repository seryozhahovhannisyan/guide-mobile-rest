package com.connectto.mobile.entity;

import com.connectto.general.util.Utils;

import java.util.Date;

/**
 * Created by htdev001 on 2/4/15.
 */
public class XmlTv {

    private int id;
    private int xmlType;
    private Date startTime;
    private Date stopTime;
    private String channel;
    private String title;
    private String dsc;
    private String category;
    private String language;
    private String origLanguage;
    private String episodeNum;
    private String director;
    private String actor;
    private String writer;
    private String producer;
    private String date;
    private String video;
    private String audio;
    private String rating;
    private String starRating;
    private String icon;

    private Date guideStartTime;
    private Date guideStopTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getXmlType() {
        return xmlType;
    }

    public void setXmlType(int xmlType) {
        this.xmlType = xmlType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getOrigLanguage() {
        return origLanguage;
    }

    public void setOrigLanguage(String origLanguage) {
        this.origLanguage = origLanguage;
    }

    public String getEpisodeNum() {
        return episodeNum;
    }

    public void setEpisodeNum(String episodeNum) {
        this.episodeNum = episodeNum;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStarRating() {
        return starRating;
    }

    public void setStarRating(String starRating) {
        this.starRating = starRating;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getGuideStartTime() {
        return Utils.toGuideDate(guideStartTime);
    }

    public String getGuideStopTime() {
        return Utils.toGuideDate(guideStopTime);
    }

    //

    public void setGuideStartTime(Date guideStartTime) {
        this.guideStartTime = guideStartTime;
    }

    public void setGuideStopTime(Date guideStopTime) {
        this.guideStopTime = guideStopTime;
    }
}
