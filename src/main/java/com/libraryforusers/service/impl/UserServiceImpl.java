package com.libraryforusers.service.impl;

import com.libraryforusers.dao.UserDao;
import com.libraryforusers.domain.UserDO;
import com.libraryforusers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userMapper;


    @Override
    public Boolean add(UserDO user) {
        Map userNameMap = new HashMap();
        userNameMap.put("userName", user.getUserName());
        Map userPhoneMap = new HashMap();
        userPhoneMap.put("phoneNum", user.getPhoneNum());
        if (userMapper.count(userNameMap) != 0 || userMapper.count(userPhoneMap) != 0){
            return false;
        }
        userMapper.add(user.getUserName(), user.getPassword(), user.getPhoneNum(), user.getEmail());
        return true;
    }

    @Override
    public void remove(int id) {
        userMapper.remove(id);
    }

    @Override
    public void update(UserDO user) { userMapper.update(user); }

    @Override
    public void updateAdmin(UserDO user) {
        userMapper.updateAdmin(user);
    }

    @Override
    public int count(Map<String,Object> map){ return userMapper.count(map); }

    @Override
    public List<UserDO> checkAll() {
        return userMapper.checkAll();
    }

    @Override
    public UserDO check(Map<String,Object> map) {
        return userMapper.check(map);
    }

    @Override
    public List<UserDO> checkLike(Map<String,Object> map) {return userMapper.checkLike(map);}

    @Override
    public int countLike(Map<String,Object> map) {return userMapper.countLike(map);}

    @Override
    public Map countBorrowUser(String date) {return userMapper.countBorrowUser(date);}

    @Override
    public List<Map> countHistoryStatus() {return userMapper.countHistoryStatus();}

}
