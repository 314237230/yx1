package yx.service.impl;

import yx.dao.UserDao;
import yx.dao.impl.userDaoimpl;
import yx.entity.User;
import yx.service.UserService;

import java.util.List;

/**
 * @author:三金
 * @Date:2019/10/18 10:05
 */
public class UserServiceimpl implements UserService {
    @Override//通过调用dao包返回用户集合
    public List<User> getName(String name, String pwd) {
        UserDao userDaoimpl = new userDaoimpl();
        List<User> users=userDaoimpl.getUser(name,pwd);
            return users;
    }
}
