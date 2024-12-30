package com.libraryforusers.dao;

import com.libraryforusers.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {

    void add(@Param("userName")String userName, @Param("password")String password, @Param("phoneNum")long phoneNum, @Param("email")String email);

    void remove(@Param("userId")int userId);

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
