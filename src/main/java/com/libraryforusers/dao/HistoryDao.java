package com.libraryforusers.dao;

import com.libraryforusers.domain.HistoryDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface HistoryDao {

    void add (HistoryDO history);

    void update (HistoryDO history);

    HistoryDO check (Map<String, Object> map);

    void updateOverdue (int maxBorrowDay);

    List<HistoryDO> checkBook (int bookId);

    List<HistoryDO> checkLike (Map<String, Object> map);

    List<Map<String, Object>> checkLikeInfo (Map<String, Object> map);

    int countLike (Map<String, Object> map);

    List<Map<String, Object>> overdueInfo (int maxBorrowDay);

    List<Map<String, Object>> checkTopNum ();

    List<Map> countWeekLending ();

    List<Map> countWeekReturning ();

    List<Map> getStatusOverdue ();

}