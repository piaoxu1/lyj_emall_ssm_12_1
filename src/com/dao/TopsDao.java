package com.dao;

import com.entity.Tops;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author ：lyj
 * @date ：Created in 2020/12/8 0008 14:40
 * @description：
 * @modified By：
 * @version: $
 */
public interface TopsDao {
    @Select("select * from tops where good_id=#{goodId} and type=#{type}")
    public Tops selectByGoodIdAndType(@Param("goodId")int gooId,@Param("type")byte type);
}
