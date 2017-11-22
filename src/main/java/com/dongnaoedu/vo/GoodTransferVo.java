package com.dongnaoedu.vo;

import java.io.Serializable;

/**
 * shichaogeng
 * 创建日期：2017/10/26
 * 创建时间: 17:15
 * 传输商品库存变化的实体
 */
public class GoodTransferVo  implements Serializable {

    private String goodsId;
    private int changeAmount;
    private boolean inOrOut;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public int getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(int changeAmount) {
        this.changeAmount = changeAmount;
    }

    public boolean isInOrOut() {
        return inOrOut;
    }

    public void setInOrOut(boolean inOrOut) {
        this.inOrOut = inOrOut;
    }
}
