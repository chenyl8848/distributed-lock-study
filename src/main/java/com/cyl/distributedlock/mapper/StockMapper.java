package com.cyl.distributedlock.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyl.distributedlock.pojo.Stock;
import org.apache.ibatis.annotations.Update;

/**
 * @author cyl
 * @date 2023-07-04 9:58
 * @description 库存 mapper
 */
public interface StockMapper extends BaseMapper<Stock> {

    @Update("update stock set count = count - 1 where product_code = ${productCode} and count > 0 ")
    public void updateCount(String productCode);
}
