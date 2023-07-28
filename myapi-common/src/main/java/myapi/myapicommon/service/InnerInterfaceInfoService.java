package myapi.myapicommon.service;

import myapi.myapicommon.model.entity. InterfaceInfo;

/**
* @author qianhe
* @description 针对表【interface_info(myapi.`interface_info`)】的数据库操作Service
* @createDate 2023-01-29 19:10:08
*/
public interface InnerInterfaceInfoService {


     /**
      * 从数据库中查询接口是否存在
      */
     InterfaceInfo getInterfaceInfo(String path, String method);

     /**
      * 通过接口名字获取服务器地址
      * @param name
      * @return
      */
     String getHostByName(String name);
}
