package com.libraryforusers.domain;

import com.google.gson.annotations.Expose;

import java.util.Date;

public class HistoryDO {

    @Expose
    private int historyId;
    @Expose
    private int bookId;
    @Expose
    private int booklistId;
    @Expose
    private int userId;
    @Expose
    private Date beginTime;
    @Expose
    private Date endTime;
    @Expose
    private int historyStatus;
    @Expose
    private int overdueStatus;

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBooklistId() {
        return booklistId;
    }

    public void setBooklistId(int booklistId) {
        this.booklistId = booklistId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) { this.endTime = endTime; }

    public int getHistoryStatus() {
        return historyStatus;
    }

    public void setHistoryStatus(int historyStatus) {
        this.historyStatus = historyStatus;
    }

    public int getOverdueStatus() { return overdueStatus; }

    public void setOverdueStatus(int overdueStatus) { this.overdueStatus = overdueStatus; }

    @Override
    public String toString() {
        return "HistoryDO{" +
                "historyId=" + historyId +
                ", bookId=" + bookId +
                ", booklistId=" + booklistId +
                ", userId=" + userId +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", historyStatus=" + historyStatus +
                '}';
    }
}
