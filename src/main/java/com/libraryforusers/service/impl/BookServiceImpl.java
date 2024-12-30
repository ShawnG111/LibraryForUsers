package com.libraryforusers.service.impl;

import com.google.gson.Gson;
import com.libraryforusers.dao.BookDao;
import com.libraryforusers.dao.BooklistDao;
import com.libraryforusers.dao.HistoryDao;
import com.libraryforusers.domain.BookDO;
import com.libraryforusers.domain.BooklistDO;
import com.libraryforusers.service.BookService;
import com.libraryforusers.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookMapper;
    @Autowired
    BooklistDao booklistMapper;
    @Autowired
    HistoryDao historyMapper;

    @Autowired
    RedisUtils redisUtils;

    @Override
    public Boolean add(BookDO bookDO) {
        if(bookMapper.count(bookDO.getBookName())!=0){
            return false;
        }
        bookMapper.add(bookDO);
        for(int i=0; i<bookDO.getTotalNum(); i++){
            booklistMapper.add(bookDO.getBookId());
        }
        return true;
    }

    @Override
    public void addList(int bookId) {booklistMapper.add(bookId);}

    @Override
    public BookDO checkId(int bookId) {
        Gson gson = new Gson();
        if(redisUtils.get("book"+bookId) != null){
            redisUtils.expire("book"+bookId,300);
            return gson.fromJson((String) redisUtils.get("book"+bookId),BookDO.class);
        }
        BookDO bookData = bookMapper.check(bookId);
        redisUtils.set("book"+bookId,gson.toJson(bookData),300);
        return bookData;
    }

    @Override
    public void updateRedis(int bookId) {
        Gson gson = new Gson();
        redisUtils.set("book"+bookId,gson.toJson(bookMapper.check(bookId)),300);
    }

    @Override
    public List<BookDO> checkLike(Map<String,Object> map) {return bookMapper.checkLike(map);}

    @Override
    public Integer countLike(Map<String,Object> map) {return bookMapper.countLike(map);}

    @Override
    public List<BooklistDO> checkList(int bookId) {return booklistMapper.check(bookId);}

    @Override
    public BooklistDO checkListId(int booklistId) {return booklistMapper.checkId(booklistId);}

    @Override
    public int getStorage(int bookId) {return bookMapper.getStorage(bookId);}

    @Override
    public int getTotal(int bookId) {return bookMapper.getTotal(bookId);}

    @Override
    public void updateStorage(int bookId, int storage) {bookMapper.updateStorage(bookId, storage);}

    @Override
    public void updateTotal(int bookId, int total) {bookMapper.updateTotal(bookId, total);}

    @Override
    public void updateStatus(int booklistId, int lendingStatus) {booklistMapper.update(lendingStatus, booklistId);}

    @Override
    public void update(BookDO bookDO) {bookMapper.update(bookDO);}

    @Override
    public Boolean delete(int booklistId) {
        if(booklistMapper.checkId(booklistId).getLendingStatus()==1){
            return false;
        }
        booklistMapper.delete(booklistId);
        return true;
    }

    @Override
    public List<Map<String, Object>> checkTopNum() {return historyMapper.checkTopNum();}

    @Override
    public Map<String, Integer> countLendingStatus() {
        Map<String, Integer> resultMap = new HashMap<String, Integer>();
        resultMap.put("lendingCount", (Integer)booklistMapper.countLendingStatus(1));
        resultMap.put("notLendingCount", (Integer)booklistMapper.countLendingStatus(0));
        return resultMap;
    }

}
