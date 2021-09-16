package com.example.taobaoip.net;

import com.example.taobaoip.LoadTasksCallBack;
import com.example.taobaoip.Model.IpInfo;

import cn.finalteam.okhttpfinal.BaseHttpRequestCallback;
import cn.finalteam.okhttpfinal.HttpRequest;
import cn.finalteam.okhttpfinal.RequestParams;

public class IpInfoTask implements NetTask<String> {

    private static IpInfoTask INSTANCE = null;
    private static final String HOST = "https://ip.taobao.com/outGetIpInfo";
    private LoadTasksCallBack loadTasksCallBack;

    private IpInfoTask() { }

    public static IpInfoTask getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new IpInfoTask();
        }
        return INSTANCE;
    }

    @Override
    public void execute(String data, LoadTasksCallBack callBack) {
        RequestParams requestParams = new RequestParams();
        requestParams.addFormDataPart("ip",data);
        HttpRequest.post(HOST, requestParams, new BaseHttpRequestCallback<IpInfo>() {
            @Override
            public void onStart() {
                super.onStart();
                loadTasksCallBack.onStart();
            }

            @Override
            protected void onSuccess(IpInfo ipInfo) {
                super.onSuccess(ipInfo);
                loadTasksCallBack.onSuccess(ipInfo);
            }

            @Override
            public void onFinish() {
                super.onFinish();
                loadTasksCallBack.onFinish();
            }

            @Override
            public void onFailure(int errorCode, String msg) {
                super.onFailure(errorCode, msg);
                loadTasksCallBack.onFailed();
            }
        });
    }
}
