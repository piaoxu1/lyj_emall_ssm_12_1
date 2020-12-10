package com.dao;

import com.entity.Carts;
import org.apache.ibatis.annotations.*;

/**
 * @author ：lyj
 * @date ：Created in 2020/12/9 0009 11:32
 * @description：
 * @modified By：
 * @version: $
 */
public  interface CartDao {
    @Select("select * from carts where user_id=#{userId} and good_id=#{goodId} limit 1")
    Carts selectByUserIdAndGoodId(@Param("userId")int userId,@Param("goodId")int goodId);

    @Insert("insert into carts (amount,good_id,user_id) values (#{amount},#{goodId},#{userId})")
    @SelectKey(keyProperty="id",statement="SELECT LAST_INSERT_ID()",
    before = false,resultType = Integer.class)
    public boolean insert(Carts carts);

    @Update("update carts set amount=amount+#{amount} where id=#{id}")
    public boolean updateAmonut(@Param("id")int id,@Param("amount")int amount);

    @Update("delete from carts where id=#{id}")
    public boolean delete(int id);

    @Update("delete from carts where user_id#{userId}")
    public boolean deleteByUserId(int userId);
}
