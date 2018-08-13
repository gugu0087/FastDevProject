package com.xyc.fastdevproject.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.xyc.fastdevproject.R;
import com.xyc.fastdevproject.view.base.BaseActivity;
import com.xyc.fastdevproject.view.base.NoScrollViewPager;
import com.xyc.fastdevproject.view.fragment.FirstFragment;
import com.xyc.fastdevproject.view.fragment.FourthFragment;
import com.xyc.fastdevproject.view.fragment.SecondFragment;
import com.xyc.fastdevproject.view.fragment.ThirdFragment;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {
    @BindView(R.id.viewPager)
    NoScrollViewPager viewPager;
    @BindView(R.id.tvFirstTab)
    TextView tvFirstTab;
    @BindView(R.id.tvSecondTab)
    TextView tvSecondTab;
    @BindView(R.id.tvThirdTab)
    TextView tvThirdTab;
    @BindView(R.id.tvFourthTab)
    TextView tvFourthTab;
    public Fragment[] frags = new Fragment[4];

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

    }

    @OnClick({R.id.tvFirstTab, R.id.tvSecondTab, R.id.tvThirdTab, R.id.tvFourthTab})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvFirstTab:
                if (frags[0] == null) {
                    frags[0] = new FirstFragment();
                }
                break;
            case R.id.tvSecondTab:
                if (frags[1] == null) {
                    frags[1] = new SecondFragment();
                }
                break;
            case R.id.tvThirdTab:
                if (frags[2] == null) {
                    frags[2] = new ThirdFragment();
                }
                break;
            case R.id.tvFourthTab:
                if (frags[3] == null) {
                    frags[3] = new FourthFragment();
                }
                break;
        }

    }
}
