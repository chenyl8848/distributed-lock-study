package com.cyl.distributedlock.service.impl;

import com.cyl.distributedlock.pojo.Stock;
import com.cyl.distributedlock.service.IStockService;
import org.springframework.stereotype.Service;

/**
 * @author cyl
 * @date 2023-06-16 10:03
 * @description 库存接口实现类
 */
@Service
public class StockServiceImpl implements IStockService {

    private static Stock stock = new Stock();

    @Override
    public void deductStock() {
        stock.setCount(stock.getCount() - 1);
        System.out.println("库存余量:" + stock.getCount());
    }
}
