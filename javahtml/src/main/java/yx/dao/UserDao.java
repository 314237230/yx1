package yx.dao;

import yx.entity.User;

import java.util.List;

/**
 * @author:三金
 * @Date:2019/10/17 19:18
 */
public interface UserDao {
    //查询数据
    List<User> getUser(String name, String pwd);

}
