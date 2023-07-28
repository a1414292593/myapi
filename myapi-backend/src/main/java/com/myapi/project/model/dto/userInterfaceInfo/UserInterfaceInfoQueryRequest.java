package com.myapi.project.model.dto.userInterfaceInfo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.myapi.project.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 查询请求
 *
 * @author czy
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserInterfaceInfoQueryRequest extends PageRequest implements Serializable {

    /**
     * 主键
     */
    private Integer id;

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

    /**
     * 0-正常, 1-禁用
     */
    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}
