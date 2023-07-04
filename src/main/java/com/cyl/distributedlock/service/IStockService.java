package com.cyl.distributedlock.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cyl.distributedlock.pojo.Stock;

/**
 * @author cyl
 * @date 2023-06-16 10:02
 * @description 库存接口
 */
public interface IStockService extends IService<Stock> {

    /**
     * 扣减库存
     */
    public void deductStock();

    /**
     * 用 synchronized 关键字扣减库存
     */
    public void deductStockWithSynchronized();

    /**
     * 用 lock 扣减库存
     */
    public void deductStockWithLock();

    /**
     * 多例模式下锁失效
     */
    public void lockFailedByMultipleCases();

    /**
     * 事务模式下锁失效
     */
    public void lockFailedByTransaction();

    /**
     * 集群模式下锁失效
     */
    public void lockFailedByCluster();

    /**
     * 使用更新语句扣减库存，利用 mysql 锁来解决超卖的问题
     */
    public void deductStockWithUpdate();

}
