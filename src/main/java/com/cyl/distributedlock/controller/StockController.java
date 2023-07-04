package com.cyl.distributedlock.controller;

import com.cyl.distributedlock.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cyl
 * @date 2023-06-16 10:07
 * @description 库存接口
 */
@RestController
public class StockController {

    @Autowired
    private IStockService stockService;

    @GetMapping("/deductStock")
    public String deductStock() {
        stockService.deductStock();
        return "ok!";
    }

    @GetMapping("/deductStockWithSynchronized")
    public String deductStockWithSynchronized() {
        stockService.deductStockWithSynchronized();
        return "ok!";
    }


    @GetMapping("/deductStockWithLock")
    public String deductStockWithLock() {
        stockService.deductStockWithLock();
        return "ok!";
    }

    @GetMapping("/lockFailedByMultipleCases")
    public String lockFailedByMultipleCases() {
        stockService.lockFailedByMultipleCases();
        return "ok!";
    }

    @GetMapping("/lockFailedByTransaction")
    public String lockFailedByTransaction() {
        stockService.lockFailedByTransaction();
        return "ok!";
    }

    @GetMapping("/lockFailedByCluster")
    public String lockFailedByCluster() {
        stockService.lockFailedByCluster();
        return "ok!";
    }

    @GetMapping("/deductWithUpdate")
    public String deductWithUpdate() {
        stockService.deductStockWithUpdate();
        return "ok!";
    }
}
