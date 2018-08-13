package com.xyc.fastdevproject.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xyc.fastdevproject.R;
import com.xyc.fastdevproject.utils.ToastUtil;
import com.xyc.fastdevproject.view.base.BaseActivity;

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
    protected void initHeader() {
        setHeaderTitle("测试页面");
        setRightIconVisibility(View.VISIBLE);

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
