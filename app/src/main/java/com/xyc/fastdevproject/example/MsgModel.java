package com.xyc.fastdevproject.example;


import java.io.Serializable;

/**
 * Created by hasee on 2017/12/25.
 */

public class MsgModel implements Serializable {
    private Long id;//消息msgId
    private String title;//消息标题
    private Long createTime;//创建时间
    private String content;//消息内容
    private String creatorName;//创建人
    private int isRead;// 0.未读 1. 已读(int)
    private int systemType;// 系统消息类型: 0.系统通知 1.资讯通知'(Integer)
    private int noticeType;// 告警消息类型(Integer): 0.加粉警告 1.故障警告3.故障警告并且播报
    private int unReadMsgCount;

    public int getUnReadMsgCount() {
        return unReadMsgCount;
    }

    public void setUnReadMsgCount(int unReadMsgCount) {
        this.unReadMsgCount = unReadMsgCount;
    }

    public int getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(int noticeType) {
        this.noticeType = noticeType;
    }

    public int getSystemType() {
        return systemType;
    }

    public void setSystemType(int systemType) {
        this.systemType = systemType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    @Override
    public String toString() {
        return "MsgModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createTime=" + createTime +
                ", content='" + content + '\'' +
                ", creatorName='" + creatorName + '\'' +
                ", isRead=" + isRead +
                ", systemType=" + systemType +
                '}';
    }
}
