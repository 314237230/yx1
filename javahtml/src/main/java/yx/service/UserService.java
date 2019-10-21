package yx.service;

import yx.entity.User;

import java.util.List;

/**
 * @author:三金
 * @Date:2019/10/18 10:02
 */
public interface UserService {
    List<User> getName(String name, String pwd);
}
