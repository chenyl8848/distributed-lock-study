package com.cyl.distributedlock.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author cyl
 * @date 2023-06-16 9:35
 * @description 库存实体类
 */
@Data
@TableName(value = "stock")
public class Stock {

    /** 主键 */
    @TableId
    private Long id;

    /** 商品编码 */
    @TableField(value = "product_code")
    private String productCode;

    /** 仓库编码 */
    @TableField(value = "stock_code")
    private String stockCode;

    /** 库存 */
    @TableField(value = "count")
    private Integer count;
}
