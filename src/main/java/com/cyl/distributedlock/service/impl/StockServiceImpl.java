package com.cyl.distributedlock.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyl.distributedlock.mapper.StockMapper;
import com.cyl.distributedlock.pojo.Stock;
import com.cyl.distributedlock.service.IStockService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cyl
 * @date 2023-06-16 10:03
 * @description 库存接口实现类
 */
@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements IStockService {

//    private static Stock stock = new Stock();

    private static Lock lock = new ReentrantLock();

    @Override
    public void deductStock() {
        Stock stock = getById(1);

        if (Objects.nonNull(stock) && stock.getCount() > 0) {
            stock.setCount(stock.getCount() - 1);
            updateById(stock);
        }
    }

    @Override
    public synchronized void deductStockWithSynchronized() {
        Stock stock = getById(1);

        if (Objects.nonNull(stock) && stock.getCount() > 0) {
            stock.setCount(stock.getCount() - 1);
            updateById(stock);
        }
    }

    @Override
    public void deductStockWithLock() {
        lock.lock();
        try {
            Stock stock = getById(1);

            if (Objects.nonNull(stock) && stock.getCount() > 0) {
                stock.setCount(stock.getCount() - 1);
                updateById(stock);
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void lockFailedByMultipleCases() {
        lock.lock();
        try {
            Stock stock = getById(1);

            if (Objects.nonNull(stock) && stock.getCount() > 0) {
                stock.setCount(stock.getCount() - 1);
                updateById(stock);
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void lockFailedByTransaction() {
        lock.lock();
        try {
            Stock stock = getById(1);

            if (Objects.nonNull(stock) && stock.getCount() > 0) {
                stock.setCount(stock.getCount() - 1);
                updateById(stock);
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void lockFailedByCluster() {
        lock.lock();
        try {
            Stock stock = getById(1);

            if (Objects.nonNull(stock) && stock.getCount() > 0) {
                stock.setCount(stock.getCount() - 1);
                updateById(stock);
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void deductStockWithUpdate() {
        StockMapper stockMapper = getBaseMapper();
        stockMapper.updateCount("1");
    }
}
