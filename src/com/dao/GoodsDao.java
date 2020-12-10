package com.dao;

import com.entity.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/12/7 0007 11:57
 * @description：
 * @modified By：
 * @version: $
 */
public interface GoodsDao {
    @Select("select * from goods where id=#{id}")
    public Goods select(int id);
    @Select("select * from goods order by sales desc limit #{begin},#{size}")
    public List<Goods> selectListOrderSales(@Param("begin")int begin,@Param("size")int size);

    @Select("select count(*) from goods g join tops t on g.id=t.good_id where t.type=#{type}")
    public int selectCountByTopType(@Param("type")byte type);

    @Select("select * from goods g join tops t on g.id=t.good_id where t.type =#{type} order by t.id desc limit #{begin},#{size}")
    public List<Goods> selectListByTopType(@Param("type")byte type,@Param("begin")int begin,@Param("size")int size);
    @Select("select count(*) from goods")
    public int selectCount();

    @Select("select * from goods order by id desc limit #{begin},#{size}")
    public List<Goods> selectList(@Param("begin")int begin, @Param("size")int size);

    @Select("select * from goods where  type_id=#{typeId} order by id desc limit #{begin},#{size}")
    public List<Goods> selectListBytypeId(@Param("typeId")int typeId,
                                          @Param("begin")int begin,@Param("size")int size);

    @Select("select * from goods where type_id=#{typeId} order by id desc limit #{begin},#{size}")
    public List<Goods> selectListByTypeId(@Param("typeId")int typeId,@Param("begin")int begin,@Param("size")int size);

    @Select("select count(*) from goods where type_id=#{typeId}")
    public int selectCountByTypeId(@Param("typeId")int typeId);

}
