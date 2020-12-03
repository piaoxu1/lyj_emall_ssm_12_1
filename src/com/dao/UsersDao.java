package com.dao;

import com.entity.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户dao
 */
public interface UsersDao {
    //查表中记录总数
    @Select("select count(*) from users")
    public Long selectCount();

    @Select("select * from users order by id desc limit #{begin} ,#{size}")
    public List<Users> selectList(@Param("begin")int begin,@Param("size")int size);

    //通过id查询
    @Select("select * from users where id #{id}")
    public Users select(int id);

    @Select("select * from users where username=#{username}")
    public  Users selectByUsername(String username);

    @Select("select * from users where username=#{username} and password=#{password}")
    public Users selectByUsernameAndPassword(@Param("username")String username,
                                             @Param("password")String password);

    @Insert("insert into users (username, password , name ,phone ,address )" +
            "value (#{username} ,#{password},#{name},#{phone},#{address})")
    @SelectKey(keyProperty = "id",statement = "select last_inset_id()",before = false,
            resultType = Integer.class)
    public boolean insert(Users user);

  @Update("update users set name=#{name}, phone=#{phone}, address=#{address} where id=#{id}")
    public boolean update(Users user);

}
