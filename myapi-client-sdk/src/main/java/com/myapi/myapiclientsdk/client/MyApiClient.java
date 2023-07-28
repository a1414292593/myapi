package com.myapi.myapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import myapi.myapicommon.model.entity.InterfaceInfo;

import java.util.HashMap;
import java.util.Map;

import static com.myapi.myapiclientsdk.utils.SignUtil.getSign;

/**
 * 调用第三方接口的客户端
 *
 * @author czy
 */
public class MyApiClient {

    private static final String GATEWAY_HOST = "http://localhost:8090";

    private String accessKey;

    private String secretKey;

    public MyApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String postInterface(String userRequestParams, InterfaceInfo interfaceInfo) {
        String username = interfaceInfo.getUsername();
        String apiAddress = interfaceInfo.getUrl().replace(interfaceInfo.getHost(), "");
        HttpResponse response = HttpRequest.post(GATEWAY_HOST + apiAddress)
                .addHeaders(getHeaderMap(userRequestParams, username))
                .body(userRequestParams)
                .execute();
        System.out.println(response.getStatus());
        String result = response.body();
        System.out.println(result);
        return result;
    }

    private Map<String, String> getHeaderMap(String body, String name) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("accessKey", accessKey);
        map.put("nonce", RandomUtil.randomNumbers(4));
        map.put("body", body);
        map.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        map.put("sign", getSign(body, secretKey));
        map.put("name", name);
        return map;
    }




}
