package com.myapi.project.service.impl.inner;

import com.myapi.project.service.UserInterfaceInfoService;
import myapi.myapicommon.service.InnerUserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }

    @Override
    public boolean hasCount(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.hasCount(interfaceInfoId, userId);
    }
}
