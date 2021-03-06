package com.artland.entity;

import java.io.Serializable;
import java.util.Date;

public class TagRelation implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_tag_relation.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_tag_relation.blog_id
     *
     * @mbg.generated
     */
    private Long blogId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_tag_relation.media_id
     *
     * @mbg.generated
     */
    private Long mediaId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_tag_relation.tag_id
     *
     * @mbg.generated
     */
    private Integer tagId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_tag_relation.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_tag_relation.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tb_tag_relation
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_tag_relation
     *
     * @mbg.generated
     */
    public TagRelation(Long id, Long blogId, Long mediaId, Integer tagId, Date createTime, Integer userId) {
        this.id = id;
        this.blogId = blogId;
        this.mediaId = mediaId;
        this.tagId = tagId;
        this.createTime = createTime;
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_tag_relation
     *
     * @mbg.generated
     */
    public TagRelation() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_tag_relation.id
     *
     * @return the value of tb_tag_relation.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_tag_relation.id
     *
     * @param id the value for tb_tag_relation.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_tag_relation.blog_id
     *
     * @return the value of tb_tag_relation.blog_id
     *
     * @mbg.generated
     */
    public Long getBlogId() {
        return blogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_tag_relation.blog_id
     *
     * @param blogId the value for tb_tag_relation.blog_id
     *
     * @mbg.generated
     */
    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_tag_relation.media_id
     *
     * @return the value of tb_tag_relation.media_id
     *
     * @mbg.generated
     */
    public Long getMediaId() {
        return mediaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_tag_relation.media_id
     *
     * @param mediaId the value for tb_tag_relation.media_id
     *
     * @mbg.generated
     */
    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_tag_relation.tag_id
     *
     * @return the value of tb_tag_relation.tag_id
     *
     * @mbg.generated
     */
    public Integer getTagId() {
        return tagId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_tag_relation.tag_id
     *
     * @param tagId the value for tb_tag_relation.tag_id
     *
     * @mbg.generated
     */
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_tag_relation.create_time
     *
     * @return the value of tb_tag_relation.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_tag_relation.create_time
     *
     * @param createTime the value for tb_tag_relation.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_tag_relation.user_id
     *
     * @return the value of tb_tag_relation.user_id
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_tag_relation.user_id
     *
     * @param userId the value for tb_tag_relation.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_tag_relation
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", blogId=").append(blogId);
        sb.append(", mediaId=").append(mediaId);
        sb.append(", tagId=").append(tagId);
        sb.append(", createTime=").append(createTime);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}