package com.gengsc.service;

import com.gengsc.vo.GoodTransferVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * shichaogeng
 * 创建日期：2017/10/26
 * 创建时间: 17:33
 * 库存服务管理
 */
@Service
public class DepotManager {

    @Autowired
    private Depot depot;

    public void operDepot(GoodTransferVo goodTransferVo){
        if(goodTransferVo.isInOrOut()){
            depot.inDepot(goodTransferVo.getGoodsId(),goodTransferVo.getChangeAmount());
        }else{
            depot.outDepot(goodTransferVo.getGoodsId(),goodTransferVo.getChangeAmount());
        }
    }

//    public boolean isEmpty(String goodsId){
//        return depot.getGoodsAmount(goodsId)==0?true:false;
//    }



}
