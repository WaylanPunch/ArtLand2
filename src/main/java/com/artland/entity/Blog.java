package com.artland.entity;

import java.io.Serializable;
import java.util.Date;

public class Blog implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_blog.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_blog.title
     *
     * @mbg.generated
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_blog.sub_url
     *
     * @mbg.generated
     */
    private String subUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_blog.cover_image
     *
     * @mbg.generated
     */
    private String coverImage;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_blog.category_id
     *
     * @mbg.generated
     */
    private Integer categoryId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_blog.category_name
     *
     * @mbg.generated
     */
    private String categoryName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_blog.tags
     *
     * @mbg.generated
     */
    private String tags;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_blog.status
     *
     * @mbg.generated
     */
    private Byte status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_blog.views
     *
     * @mbg.generated
     */
    private Long views;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_blog.enable_comment
     *
     * @mbg.generated
     */
    private Byte enableComment;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_blog.is_deleted
     *
     * @mbg.generated
     */
    private Byte isDeleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_blog.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_blog.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_blog.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_blog.content
     *
     * @mbg.generated
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tb_blog
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_blog
     *
     * @mbg.generated
     */
    public Blog(Long id, String title, String subUrl, String coverImage, Integer categoryId, String categoryName, String tags, Byte status, Long views, Byte enableComment, Byte isDeleted, Date createTime, Date updateTime, Integer userId) {
        this.id = id;
        this.title = title;
        this.subUrl = subUrl;
        this.coverImage = coverImage;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.tags = tags;
        this.status = status;
        this.views = views;
        this.enableComment = enableComment;
        this.isDeleted = isDeleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_blog
     *
     * @mbg.generated
     */
    public Blog(Long id, String title, String subUrl, String coverImage, Integer categoryId, String categoryName, String tags, Byte status, Long views, Byte enableComment, Byte isDeleted, Date createTime, Date updateTime, Integer userId, String content) {
        this.id = id;
        this.title = title;
        this.subUrl = subUrl;
        this.coverImage = coverImage;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.tags = tags;
        this.status = status;
        this.views = views;
        this.enableComment = enableComment;
        this.isDeleted = isDeleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.userId = userId;
        this.content = content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_blog
     *
     * @mbg.generated
     */
    public Blog() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_blog.id
     *
     * @return the value of tb_blog.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_blog.id
     *
     * @param id the value for tb_blog.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_blog.title
     *
     * @return the value of tb_blog.title
     *
     * @mbg.generated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_blog.title
     *
     * @param title the value for tb_blog.title
     *
     * @mbg.generated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_blog.sub_url
     *
     * @return the value of tb_blog.sub_url
     *
     * @mbg.generated
     */
    public String getSubUrl() {
        return subUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_blog.sub_url
     *
     * @param subUrl the value for tb_blog.sub_url
     *
     * @mbg.generated
     */
    public void setSubUrl(String subUrl) {
        this.subUrl = subUrl == null ? null : subUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_blog.cover_image
     *
     * @return the value of tb_blog.cover_image
     *
     * @mbg.generated
     */
    public String getCoverImage() {
        return coverImage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_blog.cover_image
     *
     * @param coverImage the value for tb_blog.cover_image
     *
     * @mbg.generated
     */
    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage == null ? null : coverImage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_blog.category_id
     *
     * @return the value of tb_blog.category_id
     *
     * @mbg.generated
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_blog.category_id
     *
     * @param categoryId the value for tb_blog.category_id
     *
     * @mbg.generated
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_blog.category_name
     *
     * @return the value of tb_blog.category_name
     *
     * @mbg.generated
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_blog.category_name
     *
     * @param categoryName the value for tb_blog.category_name
     *
     * @mbg.generated
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_blog.tags
     *
     * @return the value of tb_blog.tags
     *
     * @mbg.generated
     */
    public String getTags() {
        return tags;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_blog.tags
     *
     * @param tags the value for tb_blog.tags
     *
     * @mbg.generated
     */
    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_blog.status
     *
     * @return the value of tb_blog.status
     *
     * @mbg.generated
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_blog.status
     *
     * @param status the value for tb_blog.status
     *
     * @mbg.generated
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_blog.views
     *
     * @return the value of tb_blog.views
     *
     * @mbg.generated
     */
    public Long getViews() {
        return views;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_blog.views
     *
     * @param views the value for tb_blog.views
     *
     * @mbg.generated
     */
    public void setViews(Long views) {
        this.views = views;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_blog.enable_comment
     *
     * @return the value of tb_blog.enable_comment
     *
     * @mbg.generated
     */
    public Byte getEnableComment() {
        return enableComment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_blog.enable_comment
     *
     * @param enableComment the value for tb_blog.enable_comment
     *
     * @mbg.generated
     */
    public void setEnableComment(Byte enableComment) {
        this.enableComment = enableComment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_blog.is_deleted
     *
     * @return the value of tb_blog.is_deleted
     *
     * @mbg.generated
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_blog.is_deleted
     *
     * @param isDeleted the value for tb_blog.is_deleted
     *
     * @mbg.generated
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_blog.create_time
     *
     * @return the value of tb_blog.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_blog.create_time
     *
     * @param createTime the value for tb_blog.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_blog.update_time
     *
     * @return the value of tb_blog.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_blog.update_time
     *
     * @param updateTime the value for tb_blog.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_blog.user_id
     *
     * @return the value of tb_blog.user_id
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_blog.user_id
     *
     * @param userId the value for tb_blog.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_blog.content
     *
     * @return the value of tb_blog.content
     *
     * @mbg.generated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_blog.content
     *
     * @param content the value for tb_blog.content
     *
     * @mbg.generated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_blog
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
        sb.append(", title=").append(title);
        sb.append(", subUrl=").append(subUrl);
        sb.append(", coverImage=").append(coverImage);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", tags=").append(tags);
        sb.append(", status=").append(status);
        sb.append(", views=").append(views);
        sb.append(", enableComment=").append(enableComment);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", userId=").append(userId);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}