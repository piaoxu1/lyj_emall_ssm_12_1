package com.service;

import com.dao.UsersDao;
import com.entity.Users;
import com.utils.SafeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户service
 */
@Service
public class UserService {
    @Autowired
    private UsersDao usersDao;
    /**
     * 添加
     */
  public boolean add(Users user){
      user.setPassword(SafeUtil.encode(user.getPassword()));
      return usersDao.insert(user);
  }
    /**
     * 通过用户吗名获取
     */
    public Users getByUsername(String username){
        return usersDao.selectByUsername(username);
    }
    /**
     * 通过用户名和密码获取
     */
    public Users getByUsernameAndPassword(String username,String password){
        return usersDao.selectByUsernameAndPassword(username, SafeUtil.encode(password));
    }

}
