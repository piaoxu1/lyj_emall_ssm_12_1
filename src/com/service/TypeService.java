package com.service;

import com.dao.TypesDao;
import com.entity.Types;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/12/7 0007 9:52
 * @description：
 * @modified By：
 * @version: $类型服务
 */
@Service
public class TypeService {
    @Autowired
    private TypesDao typeDao;
    /**
     * 获取列表
     */
 public List<Types> getList(){
     return  typeDao.selectList();
 }
    /**
     * 通过id查询
     */
    public Types get(int id){
        return typeDao.select(id);
    }
///**
// * 添加
// */
//public boolean add(Types type){
//    return typeDao.insert(type);
//}
}
