package com.myapi.project.model.dto.userInterfaceInfo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 创建请求
 *
 * @TableName product
 */
@Data
public class UserInterfaceInfoAddRequest implements Serializable {

    /**
     * 调用用户id
     */
    private Integer userId;

    /**
     * 接口id
     */
    private Integer interfaceInfoId;

    /**
     * 总调用次数
     */
    private Integer total_num;

    /**
     * 剩余调用次数
     */
    private Integer left_num;

}
