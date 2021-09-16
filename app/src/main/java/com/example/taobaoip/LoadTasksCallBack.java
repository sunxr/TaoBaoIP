package com.example.taobaoip;

public interface LoadTasksCallBack<T> {

    void onSuccess(T t);
    void onStart();
    void onFailed();
    void onFinish();

}
