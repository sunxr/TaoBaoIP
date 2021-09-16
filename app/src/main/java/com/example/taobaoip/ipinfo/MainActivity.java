package com.example.taobaoip.ipinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.taobaoip.util.ActivityUtils;
import com.example.taobaoip.net.IpInfoTask;
import com.example.taobaoip.R;

public class MainActivity extends AppCompatActivity {

    private IpInfoPresenter ipInfoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IpInfoFragment ipInfoFragment = (IpInfoFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (ipInfoFragment == null) {
            ipInfoFragment = IpInfoFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),ipInfoFragment,R.id.contentFrame);
        }
        IpInfoTask ipInfoTask = IpInfoTask.getInstance();
        ipInfoPresenter = new IpInfoPresenter(ipInfoTask, ipInfoFragment);
        ipInfoFragment.setPresenter(ipInfoPresenter);
    }
}