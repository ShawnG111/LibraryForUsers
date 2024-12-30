package com.libraryforusers.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.google.gson.annotations.Expose;

public class BookDO {

    @Expose
    @ExcelProperty("书籍序号")
    private int bookId;

    @Expose
    @ExcelProperty("书籍名称")
    private String bookName;

    @Expose
    @ExcelProperty("作者")
    private String author;

    @Expose
    @ExcelProperty("所属类型序号")
    private int typeId;

    @Expose
    @ExcelProperty("库存数量")
    private int storageNum;

    @Expose
    @ExcelProperty("总数量")
    private int totalNum;

    @Expose
    @ExcelProperty("封面图片")
    private byte[] image;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getStorageNum() {
        return storageNum;
    }

    public void setStorageNum(int storageNum) {
        this.storageNum = storageNum;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "BookDO{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", typeId=" + typeId +
                ", storageNum=" + storageNum +
                ", totalNum=" + totalNum +
                '}';
    }
}
