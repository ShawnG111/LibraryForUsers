package com.libraryforusers.service;

import com.libraryforusers.domain.BookDO;
import com.libraryforusers.domain.BooklistDO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface BookService {

    Boolean add(BookDO book);

    void addList(int bookId);

    BookDO checkId(int bookId);

    void updateRedis(int bookId);

    List<BookDO> checkLike(Map<String,Object> map);

    Integer countLike(Map<String,Object> map);

    List<BooklistDO> checkList(int bookId);

    BooklistDO checkListId(int booklistId);

    int getStorage(int bookId);

    int getTotal(int bookId);

    void updateStorage(int bookId, int storageNum);

    void updateTotal(int bookId, int totalNum);

    void updateStatus(int booklistId, int lendingStatus);

    void update(BookDO bookDO);

    Boolean delete(int booklistId);

    List<Map<String, Object>> checkTopNum();

    Map<String, Integer> countLendingStatus();
}
