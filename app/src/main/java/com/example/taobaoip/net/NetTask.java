package com.example.taobaoip.net;

import com.example.taobaoip.LoadTasksCallBack;

public interface NetTask<T> {

    void execute(T data, LoadTasksCallBack callBack);

}
