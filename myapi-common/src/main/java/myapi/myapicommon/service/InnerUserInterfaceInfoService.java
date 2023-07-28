package myapi.myapicommon.service;


/**
* @author 86133
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2023-05-17 13:33:16
*/
public interface InnerUserInterfaceInfoService {

    /**
     * 调用接口统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);

    /**
     * 是否还有次数
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean hasCount(long interfaceInfoId, long userId);


}
