package com.gengsc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

/**
 * shichaogeng
 * 创建日期：2017/10/26
 * 创建时间: 16:19
 * 库存数据服务
 */
@Service
public class Depot {

    private static Logger logger = LoggerFactory.getLogger(Depot.class);

    private ConcurrentHashMap<String,Integer> goodsData =
            new ConcurrentHashMap<String, Integer>();

    @PostConstruct
    public void initDepot(){
        goodsData.put("001",1000);
        goodsData.put("002",500);
        goodsData.put("003",600);
        goodsData.put("004",700);
    }


    /*使用jdk1.8以下的用这个方法
    public synchronized void inDepot(String goodsId,int addAmout){
        int amount = goodsData.get(goodsId)+addAmout;
        goodsData.put(goodsId,amount);
    }
    */
    //增加库存
    public void inDepot(String goodsId,int addAmout){
        logger.info("+++++++++++++++++增加商品："+goodsId+"库存,数量为："+addAmout);
        int newValue = goodsData.compute(goodsId, new BiFunction<String, Integer, Integer>() {
            public Integer apply(String s, Integer integer) {
                return integer == null ? addAmout : integer + addAmout;
            }
        });
        logger.info("+++++++++++++++++商品："+goodsId+"库存,数量变为："+newValue);
    }

     /*使用jdk1.8以下的用这个方法
    public synchronized void outDepot(String goodsId,int reduceAmout){
        int amount = goodsData.get(goodsId)-reduceAmout;
        goodsData.put(goodsId,amount);
    }
    */
    //减少库存
    public void outDepot(String goodsId,int reduceAmout){
        logger.info("-------------------减少商品："+goodsId+"库存,数量为："+reduceAmout);
        int newValue = goodsData.compute(goodsId, new BiFunction<String, Integer, Integer>() {
            public Integer apply(String s, Integer integer) {
                return integer == null ? 0 : integer - reduceAmout;
            }
        });
        logger.info("-------------------商品："+goodsId+"库存,数量变为："+newValue);
    }

    public int getGoodsAmount(String goodsId){
        return goodsData.get(goodsId);
    }
}
