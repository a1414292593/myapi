package com.myapi.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myapi.project.common.ErrorCode;
import com.myapi.project.exception.BusinessException;
import com.myapi.project.mapper.InterfaceInfoMapper;
import com.myapi.project.service.InterfaceInfoService;
import myapi.myapicommon.model.entity.InterfaceInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
* @author qianhe
* @description 针对表【interface_info(myapi.`interface_info`)】的数据库操作Service实现
* @createDate 2023-01-29 19:10:08
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService {
    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String username = interfaceInfo.getUsername();
        // 创建时，所有参数必须非空
        if (add) {
            if (StringUtils.isAnyBlank(username)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        if (StringUtils.isNotBlank(username) && username .length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称过长");
        }
    }
}




