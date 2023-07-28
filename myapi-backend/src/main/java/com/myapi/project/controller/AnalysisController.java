package com.myapi.project.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.myapi.project.annotation.AuthCheck;
import com.myapi.project.common.BaseResponse;
import com.myapi.project.common.ErrorCode;
import com.myapi.project.common.ResultUtils;
import com.myapi.project.exception.BusinessException;
import com.myapi.project.mapper.UserInterfaceInfoMapper;
import com.myapi.project.service.InterfaceInfoService;
import lombok.extern.slf4j.Slf4j;
import myapi.myapicommon.model.entity.InterfaceInfo;
import myapi.myapicommon.model.entity.UserInterfaceInfo;
import myapi.myapicommon.model.vo.InterfaceInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 分析控制器
 */
@RestController
@RequestMapping("/analysis")
@Slf4j
public class AnalysisController {

    @Resource
    private UserInterfaceInfoMapper userinterfaceInfoMapper;

    @Resource
    private InterfaceInfoService interfaceInfoService;


    @GetMapping("/top/interface/invoke")
    @AuthCheck(mustRole = "admin")
    public BaseResponse<List<InterfaceInfoVo>> listTopInvokeInterfaceInfo() {
        List<UserInterfaceInfo> userInterfaceInfoList = userinterfaceInfoMapper.listTopInvokeInterfaceInfo(3);
        Map<Long, List<UserInterfaceInfo>> interfaceInfoIdObjmap = userInterfaceInfoList.stream()
                .collect(Collectors.groupingBy(UserInterfaceInfo::getInterfaceInfoId));
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", interfaceInfoIdObjmap.keySet());
        List<InterfaceInfo> interfaceInfoList = interfaceInfoService.list(queryWrapper);
        if (CollectionUtil.isEmpty(interfaceInfoList)) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        List<InterfaceInfoVo> infoVoList = interfaceInfoList.stream()
                .map(interfaceInfo -> {
                    InterfaceInfoVo interfaceInfoVo = new InterfaceInfoVo();
                    BeanUtils.copyProperties(interfaceInfo, interfaceInfoVo);
                    int totalNum = interfaceInfoIdObjmap.get(interfaceInfo.getId()).get(0).getTotalNum();
                    interfaceInfoVo.setTotalNum(totalNum);
                    return interfaceInfoVo;
                }).collect(Collectors.toList());
        return ResultUtils.success(infoVoList);
    }

}
