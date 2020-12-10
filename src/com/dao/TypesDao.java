package com.dao;

import com.entity.Types;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @author ：lyj
 * @date ：Created in 2020/12/7 0007 9:56
 * @description：
 * @modified By：
 * @version: $
 */
public interface
TypesDao {
    @Select("select * from types order by num")
    public List<Types> selectList();

    @Select("select * from types where id=#{id}")
    public Types select(int id);

}
