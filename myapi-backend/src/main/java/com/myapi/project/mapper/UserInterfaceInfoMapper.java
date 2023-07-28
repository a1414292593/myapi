package com.myapi.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import myapi.myapicommon.model.entity.UserInterfaceInfo;

import javax.annotation.Resource;
import java.util.List;

/**
* @author 86133
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Mapper
* @createDate 2023-05-17 13:33:16
* @Entity com.myapi.project.model.entity.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {


    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);

}




