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
     * 通过用户名获取
     */
    public Users getByUsername(String username){
        return usersDao.selectByusername(username);
    }
    /**
     * 通过用户名和密码获取
     */
    public Users getByUsernameAndPassword(String username,String password){
        return usersDao.selectByUsernameAndPassword(username, SafeUtil.encode(password));
    }
    /**
     * 通过id获取
     */
    public Users get(int id){
        return usersDao.select(id);
    }
    /**
     * 更新
     */
    public boolean updatePassword(int id,String password){
        return usersDao.updatePassword(id,SafeUtil.encode(password));
    }
    /**
     * user
     */
    public boolean update(int id,String name,String phone,String address){
        Users user=new Users();
        user.setId(id);
        user.setName(name);
        user.setPhone(phone);
        user.setAddress(address);
        return usersDao.update(user);
    }
}
