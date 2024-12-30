package com.libraryforusers.domain;

import com.google.gson.annotations.Expose;

import java.util.Date;

public class BooklistDO {

    @Expose
    private int booklistId;
    @Expose
    private int bookId;
    @Expose
    private int lendingStatus;
    @Expose
    private Date createTime;
    @Expose
    private Date updateTime;

    public int getBooklistId() {
        return booklistId;
    }

    public void setBooklistId(int booklistId) {
        this.booklistId = booklistId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getLendingStatus() {
        return lendingStatus;
    }

    public void setLendingStatus(int lendingStatus) {
        this.lendingStatus = lendingStatus;
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
        return "BooklistDO{" +
                "booklistId=" + booklistId +
                ", bookId=" + bookId +
                ", lendingStatus=" + lendingStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
