package com.dongnaoedu.rpc;

import com.dongnaoedu.vo.GoodTransferVo;

/**
 * shichaogeng
 * 创建日期：2017/10/26
 * 创建时间: 17:03
 * 远程rpc接口
 */
public interface DepotService {
    void changeDepot(GoodTransferVo goodTransferVo);
}