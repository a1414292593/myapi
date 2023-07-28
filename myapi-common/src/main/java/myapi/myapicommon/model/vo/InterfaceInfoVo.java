package myapi.myapicommon.model.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import myapi.myapicommon.model.entity.InterfaceInfo;

/**
 * 接口信息封装视图
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class InterfaceInfoVo extends InterfaceInfo {

    /**
     * 调用次数
     */
    private Integer totalNum;

}
