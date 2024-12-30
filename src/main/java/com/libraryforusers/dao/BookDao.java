package com.libraryforusers.dao;

import com.libraryforusers.domain.BookDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookDao {

    void add(BookDO book);

    List<BookDO> checkLike(Map<String,Object> map);

    BookDO check(int bookId);

    int countLike(Map<String,Object> map);

    int count(String bookName);

    int getStorage(int bookId);

    int getTotal(int bookId);

    void updateStorage(@Param("bookId") int bookId, @Param("storageNum") int storageNum);

    void updateTotal(@Param("bookId") int bookId, @Param("totalNum") int totalNum);

    void update(BookDO book);

}
