package com.myapi.project.service;


import com.baomidou.mybatisplus.extension.service.IService;
import myapi.myapicommon.model.entity.InterfaceInfo;

/**
* @author qianhe
* @description 针对表【interface_info(myapi.`interface_info`)】的数据库操作Service
* @createDate 2023-01-29 19:10:08
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

     void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
