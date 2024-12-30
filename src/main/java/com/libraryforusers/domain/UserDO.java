package com.libraryforusers.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.google.gson.annotations.Expose;

import java.util.Date;

public class UserDO {

    @Expose
    @ExcelProperty("用户编号")
    private int userId;

    @Expose
    @ExcelProperty("用户名")
    private String userName;

    @Expose
    @ExcelProperty("电话号码")
    private long phoneNum;

    @Expose
    @ExcelIgnore
    private String password;

    @Expose
    @ExcelProperty("管理员状态")
    private int administrator;

    @Expose
    @ExcelProperty("历史状态")
    private Integer historyStatus;

    @Expose
    @ExcelProperty("注册时间")
    private Date createTime;

    @Expose
    @ExcelProperty("变更时间")
    private Date updateTime;

    @Expose
    @ExcelProperty("用户邮箱")
    private String email;

    @Expose
    @ExcelProperty("逾期次数")
    private int overdueCount;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) { this.userId = userId; }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(long phoneNum) { this.phoneNum = phoneNum; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAdministrator() {
        return administrator;
    }

    public void setAdministrator(int administrator) {
        this.administrator = administrator;
    }

    public Integer getHistoryStatus() {
        return historyStatus;
    }

    public void setHistoryStatus(Integer historyStatus) {
        this.historyStatus = historyStatus;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getOverdueCount() {
        return overdueCount;
    }

    public void setOverdueCount(int overdueCount) {
        this.overdueCount = overdueCount;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", phoneNum=" + phoneNum +
                ", password='" + password + '\'' +
                ", administrator=" + administrator +
                ", historyStatus=" + historyStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
