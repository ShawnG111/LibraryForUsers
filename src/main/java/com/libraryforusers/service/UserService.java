package com.libraryforusers.service;

import com.libraryforusers.domain.UserDO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {

    Boolean add(UserDO user);

    void remove(int id);

    void update(UserDO user);

    void updateAdmin(UserDO user);

    int count(Map<String,Object> map);

    List<UserDO> checkAll();

    UserDO check(Map<String,Object> map);

    List<UserDO> checkLike(Map<String,Object> map);

    int countLike(Map<String,Object> map);

    Map countBorrowUser(String date);

    List<Map> countHistoryStatus();
}
