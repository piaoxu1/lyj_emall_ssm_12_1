package com.service;

import com.dao.CartDao;
import com.entity.Carts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author ：lyj
 * @date ：Created in 2020/12/7 0007 10:27
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class CartService {
    @Autowired
    private CartDao cartDao;
    @Autowired
    private GoodService goodService;
    /**
     * 获取购物车总数
     */
    public int getCount(int userId){
      return 0;
   }
    /**
     * 添加购物车
     */
    public boolean save(int goodId,int userId){
        Carts cart=cartDao.selectByUserIdAndGoodId(userId,goodId);
        if(Objects.nonNull(cart)){//如果存在记录 数量+1
           return cartDao.updateAmonut(cart.getId(),1);
        }
        cart=new Carts();
        cart.setGoodId(goodId);
        cart.setUserId(userId);
        cart.setAmount(1);
        return cartDao.insert(cart);
    }
}
