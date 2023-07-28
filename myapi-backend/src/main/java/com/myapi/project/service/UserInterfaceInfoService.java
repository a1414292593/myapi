package com.myapi.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import myapi.myapicommon.model.entity.UserInterfaceInfo;

public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    boolean invokeCount(long interfaceInfoId, long userId);

    boolean hasCount(long interfaceInfoId, long userId);
}
