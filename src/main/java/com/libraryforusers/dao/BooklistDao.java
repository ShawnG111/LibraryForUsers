package com.libraryforusers.dao;

import com.libraryforusers.domain.BooklistDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BooklistDao {

    void add(int bookId);

    List<BooklistDO> check(int bookId);

    BooklistDO checkId(int bookId);

    void update(@Param("lendingStatus") int lendingStatus, @Param("booklistId") int booklistId);

    void delete(int booklistId);

    int countLendingStatus(int lendingStatus);

}
