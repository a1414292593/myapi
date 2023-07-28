package myapi.myapicommon.service;


import myapi.myapicommon.model.entity.User;

/**
 * 用户服务
 *
 * @author czy
 */
public interface InnerUserService {


    /**
     * 根据accessKey查询用户
     */

    User getInvokeUser(String accessKey);
}
