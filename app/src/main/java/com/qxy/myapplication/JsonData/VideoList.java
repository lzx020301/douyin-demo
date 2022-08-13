package com.qxy.myapplication.JsonData;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Auto-generated: 2022-08-12 23:11:23
 *
 * @author json996.com
 * @website http://www.json996.com/json2java.html
 */
public class VideoList {

    private List<String> actors;
    private List<String> directors;
    @JsonProperty("discussion_hot")
    private int discussionHot;
    private int hot;
    private String id;
    @JsonProperty("influence_hot")
    private int influenceHot;
    @JsonProperty("maoyan_id")
    private String maoyanId;
    private String name;
    @JsonProperty("name_en")
    private String nameEn;
    private String poster;
    @JsonProperty("release_date")
    private Date releaseDate;
    @JsonProperty("search_hot")
    private int searchHot;
    @JsonProperty("topic_hot")
    private int topicHot;
    private int type;
    public void setActors(List<String> actors) {
        this.actors = actors;
    }
    public List<String> getActors() {
        return actors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }
    public List<String> getDirectors() {
        return directors;
    }

    public void setDiscussionHot(int discussionHot) {
        this.discussionHot = discussionHot;
    }
    public int getDiscussionHot() {
        return discussionHot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }
    public int getHot() {
        return hot;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setInfluenceHot(int influenceHot) {
        this.influenceHot = influenceHot;
    }
    public int getInfluenceHot() {
        return influenceHot;
    }

    public void setMaoyanId(String maoyanId) {
        this.maoyanId = maoyanId;
    }
    public String getMaoyanId() {
        return maoyanId;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }
    public String getNameEn() {
        return nameEn;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
    public String getPoster() {
        return poster;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setSearchHot(int searchHot) {
        this.searchHot = searchHot;
    }
    public int getSearchHot() {
        return searchHot;
    }

    public void setTopicHot(int topicHot) {
        this.topicHot = topicHot;
    }
    public int getTopicHot() {
        return topicHot;
    }

    public void setType(int type) {
        this.type = type;
    }
    public int getType() {
        return type;
    }

}
