package com.artland.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author WaylanPunch
 * @email waylanpunch@gmail.com
 * @link https://github.com/WaylanPunch
 * @date 2017-10-31
 */
public class Media {

	private Long mediaId;
	private String mediaTitle;
	private String mediaSubUrl;
	private String mediaCoverImage;
	private String mediaDescription;
	private String mediaContent;
	private String mediaDimension;
	private String mediaResolution;
	private String mediaFormat;
	private String mediaDuration;
	private String mediaLicense;
	private Byte mediaStatus;
	private BigDecimal mediaPrice;
	private Long mediaPurchases;
	private Long mediaViews;
	private Long mediaDownloads;
	private Integer mediaCategoryId;
	private String mediaCategoryName;
	private String mediaTags;
	private Long mediaUserId;
	private Byte enableComment;
	private Byte isDeleted;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;

	public Long getMediaId() {
		return mediaId;
	}

	public void setMediaId(Long mediaId) {
		this.mediaId = mediaId;
	}

	public String getMediaTitle() {
		return mediaTitle;
	}

	public void setMediaTitle(String mediaTitle) {
		this.mediaTitle = mediaTitle == null ? null : mediaTitle.trim();
	}

	public String getMediaSubUrl() {
		return mediaSubUrl;
	}

	public void setMediaSubUrl(String mediaSubUrl) {
		this.mediaSubUrl = mediaSubUrl == null ? null : mediaSubUrl.trim();
	}

	public String getMediaCoverImage() {
		return mediaCoverImage;
	}

	public void setMediaCoverImage(String mediaCoverImage) {
		this.mediaCoverImage = mediaCoverImage == null ? null : mediaCoverImage.trim();
	}

	public String getMediaDescription() {
		return mediaDescription;
	}

	public void setMediaDescription(String mediaDescription) {
		this.mediaDescription = mediaDescription == null ? null : mediaDescription.trim();
	}

	public String getMediaContent() {
		return mediaContent;
	}

	public void setMediaContent(String mediaContent) {
		this.mediaContent = mediaContent == null ? null : mediaContent.trim();
	}

	public String getMediaDimension() {
		return mediaDimension;
	}

	public void setMediaDimension(String mediaDimension) {
		this.mediaDimension = mediaDimension;
	}

	public String getMediaResolution() {
		return mediaResolution;
	}

	public void setMediaResolution(String mediaResolution) {
		this.mediaResolution = mediaResolution;
	}

	public String getMediaFormat() {
		return mediaFormat;
	}

	public void setMediaFormat(String mediaFormat) {
		this.mediaFormat = mediaFormat == null ? null : mediaFormat.trim();
	}

	public String getMediaDuration() {
		return mediaDuration;
	}

	public void setMediaDuration(String mediaDuration) {
		this.mediaDuration = mediaDuration;
	}

	public String getMediaLicense() {
		return mediaLicense;
	}

	public void setMediaLicense(String mediaLicense) {
		this.mediaLicense = mediaLicense == null ? null : mediaLicense.trim();
	}

	public Byte getMediaStatus() {
		return mediaStatus;
	}

	public void setMediaStatus(Byte mediaStatus) {
		this.mediaStatus = mediaStatus;
	}

	public BigDecimal getMediaPrice() {
		return mediaPrice;
	}

	public void setMediaPrice(BigDecimal mediaPrice) {
		this.mediaPrice = mediaPrice;
	}

	public Long getMediaPurchases() {
		return mediaPurchases;
	}

	public void setMediaPurchases(Long mediaPurchases) {
		this.mediaPurchases = mediaPurchases;
	}

	public Long getMediaViews() {
		return mediaViews;
	}

	public void setMediaViews(Long mediaViews) {
		this.mediaViews = mediaViews;
	}

	public Long getMediaDownloads() {
		return mediaDownloads;
	}

	public void setMediaDownloads(Long mediaDownloads) {
		this.mediaDownloads = mediaDownloads;
	}

	public Integer getMediaCategoryId() {
		return mediaCategoryId;
	}

	public void setMediaCategoryId(Integer mediaCategoryId) {
		this.mediaCategoryId = mediaCategoryId;
	}

	public String getMediaCategoryName() {
		return mediaCategoryName;
	}

	public void setMediaCategoryName(String mediaCategoryName) {
		this.mediaCategoryName = mediaCategoryName == null ? null : mediaCategoryName.trim();
	}

	public String getMediaTags() {
		return mediaTags;
	}

	public void setMediaTags(String mediaTags) {
		this.mediaTags = mediaTags == null ? null : mediaTags.trim();
	}

	public Long getMediaUserId() {
		return mediaUserId;
	}

	public void setMediaUserId(Long mediaUserId) {
		this.mediaUserId = mediaUserId;
	}

	public Byte getEnableComment() {
		return enableComment;
	}

	public void setEnableComment(Byte enableComment) {
		this.enableComment = enableComment;
	}

	public Byte getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Byte isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Media{" +
				"mediaId=" + mediaId +
				", mediaTitle='" + mediaTitle + '\'' +
				", mediaSubUrl='" + mediaSubUrl + '\'' +
				", mediaCoverImage='" + mediaCoverImage + '\'' +
				", mediaDescription='" + mediaDescription + '\'' +
				", mediaContent='" + mediaContent + '\'' +
				", mediaDimension='" + mediaDimension + '\'' +
				", mediaResolution='" + mediaResolution + '\'' +
				", mediaFormat='" + mediaFormat + '\'' +
				", mediaDuration='" + mediaDuration + '\'' +
				", mediaLicense='" + mediaLicense + '\'' +
				", mediaStatus=" + mediaStatus +
				", mediaPrice=" + mediaPrice +
				", mediaPurchases=" + mediaPurchases +
				", mediaViews=" + mediaViews +
				", mediaDownloads=" + mediaDownloads +
				", mediaCategoryId=" + mediaCategoryId +
				", mediaCategoryName='" + mediaCategoryName + '\'' +
				", mediaTags='" + mediaTags + '\'' +
				", mediaUserId=" + mediaUserId +
				", enableComment=" + enableComment +
				", isDeleted=" + isDeleted +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				'}';
	}
}