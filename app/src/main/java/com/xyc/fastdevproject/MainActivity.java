package com.xyc.fastdevproject;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.xyc.fastdevproject.utils.ToastUtil;
import com.xyc.fastdevproject.view.activity.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {
    @BindView(R.id.tvTips)
    TextView tvTips;

    @Override
    protected int getCenterView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tvTips.setText("dsssd");
    }
    @OnClick({R.id.tvTips})
    public void setTips() {
        ToastUtil.showShort("hha");
    }
}
