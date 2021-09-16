package com.example.taobaoip.ipinfo;

import com.example.taobaoip.BaseView;
import com.example.taobaoip.Model.IpInfo;

public interface IpInfoContract {

    interface Presenter {
        void getIpInfo(String ip);
    }

    interface View extends BaseView<Presenter> {
        void setIpInfo(IpInfo ipInfo);
        void showLoading();
        void hideLoading();
        void showError();
        boolean isActive();
    }

}
