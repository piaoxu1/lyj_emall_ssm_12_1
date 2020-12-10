package com.service;

import com.dao.TopsDao;
import com.entity.Tops;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：lyj
 * @date ：Created in 2020/12/8 0008 14:41
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class TopService {
    @Autowired
    private TopsDao topDao;
    /**
     * 通过商品ID获取
     */
    public Tops getByGoodIdAndType(int goodId,byte type){
        return topDao.selectByGoodIdAndType(goodId, type);
    }
}
