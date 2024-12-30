package com.libraryforusers;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.libraryforusers.dao.UserDao;
import com.libraryforusers.domain.UserDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LibraryForUsersApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void pageTest() {
        PageHelper.startPage(1, 10);
        List<UserDO> list = userDao.checkAll();
        PageInfo page = new PageInfo(list);
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getPageNum());
    }

}
