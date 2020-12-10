package com.service;

import com.dao.GoodsDao;
import com.dao.UsersDao;
import com.entity.Goods;
import com.entity.Tops;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author ：lyj
 * @date ：Created in 2020/12/7 0007 10:18
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class GoodService {
    @Autowired
    private GoodsDao goodDao;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TopService topService;
    /**
     * 获取总数
     */
    public int getCount(){
        return goodDao.selectCount();
    }
    /**
     * 或取列表
     * @param typeId
     * @return
     */
    /**
     * 通过id获取
     * @param
     * @param
     * @return
     */
    public Goods get(int id){
        return packGood(goodDao.select(id));
    }
    public List<Goods> getList(int page, int size){
        return packGood(goodDao.selectList(size*(page-1),size));
    }
    /**
     * 或取数量
     * @param typeId
     * @return
     */
    public long getCountByType(int typeId){
        return typeId>0 ? goodDao.selectCountByTypeId(typeId):this.getCount();
    }
    /**
     * 获取数量l
     */
    public long getCountByTopType(byte type){
        return goodDao.selectCountByTopType(type);
    }
    /**
     * 今日推荐
     */
    public List<Goods> getListByTopType(byte type,int page,int size){
        return packGood(goodDao.selectListByTopType(type,size * (page-1),size));
    }
    /**
 * 通过分类搜索
 */
public List<Goods> getListByType(int typeId, int page, int size){
    return typeId >0 ? packGood(goodDao.selectListByTypeId(typeId,size*(page-1), size)):this.getList(page ,size);
}
    public List<Goods> getListOrderSales(int page,int size){
        return packGood(goodDao.selectListOrderSales(size * (page-1),size));
    }
/**
 * 封装商品
 */
private List<Goods> packGood(List<Goods> list){
    for(Goods good : list){
        good=packGood(good);
    }
    return list;
}
/**
 * 封装商品
 */
 private Goods packGood(Goods good){
     if(good !=null){
         good.setType(typeService.get(good.getTypeId()));//类目信息
        good.setTop(Objects.nonNull(topService.getByGoodIdAndType(good.getId(),
        Tops.TYPE_TODAY )));
     }
     return good;
 }
}
