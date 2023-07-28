package com.myapi.project.model.dto.userInterfaceInfo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * 更新请求
 *
 * @TableName product
 */
@Data
public class UserInterfaceInfoUpdateRequest implements Serializable {

    /**
     * 主键
     */
    private Integer id;


    /**
     * 总调用次数
     */
    private Integer total_num;

    /**
     * 剩余调用次数
     */
    private Integer left_num;

    /**
     * 0-正常, 1-禁用
     */
    private Integer status;

}
