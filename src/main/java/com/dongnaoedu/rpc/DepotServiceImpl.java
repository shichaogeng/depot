package com.dongnaoedu.rpc;

import com.dongnaoedu.service.DepotManager;
import com.dongnaoedu.vo.GoodTransferVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * shichaogeng
 * 创建日期：2017/10/26
 * 创建时间: 17:32
 * 远程rpc接口的实现
 */
@Component
public class DepotServiceImpl implements DepotService {

    @Autowired
    private DepotManager depotManager;

    @Override
    public void changeDepot(GoodTransferVo goodTransferVo) {
        depotManager.operDepot(goodTransferVo);
    }
}
