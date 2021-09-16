package com.example.taobaoip.ipinfo;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.taobaoip.Model.IpData;
import com.example.taobaoip.Model.IpInfo;
import com.example.taobaoip.R;

public class IpInfoFragment extends Fragment implements IpInfoContract.View {

    private TextView tv_country;
    private TextView tv_area;
    private TextView tv_city;
    private Button bt_ipinfo;
    private Dialog mDialog;
    private IpInfoContract.Presenter mPresenter;

    public static IpInfoFragment newInstance() {
        return new IpInfoFragment();
    }

    @Override
    public void setPresenter(IpInfoContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mDialog = new ProgressDialog(getActivity());
        mDialog.setTitle("获取数据中");
        bt_ipinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getIpInfo("210.75.225.254");
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_ipinfo,container,false);
        tv_country = (TextView) root.findViewById(R.id.tv_country);
        tv_area = (TextView) root.findViewById(R.id.tv_area);
        tv_city = (TextView) root.findViewById(R.id.tv_city);
        bt_ipinfo = (Button) root.findViewById(R.id.bt_ipinfo);
        return root;
    }

    @Override
    public void setIpInfo(IpInfo ipInfo) {
        if (ipInfo != null && ipInfo.getData() != null) {
            IpData ipData = ipInfo.getData();
            tv_country.setText(ipData.getCountry());
            tv_area.setText(ipData.getArea());
            tv_city.setText(ipData.getCity());
        }
    }

    @Override
    public void showLoading() {
        mDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    @Override
    public void showError() {
        Toast.makeText(getActivity().getApplicationContext(), "网络错误",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }
}
