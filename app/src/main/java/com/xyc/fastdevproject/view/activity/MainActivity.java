package com.xyc.fastdevproject.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.xyc.fastdevproject.R;
import com.xyc.fastdevproject.view.adapter.FragmentAdapter;
import com.xyc.fastdevproject.view.base.BaseActivity;
import com.xyc.fastdevproject.view.base.NoScrollViewPager;
import com.xyc.fastdevproject.view.fragment.FirstFragment;
import com.xyc.fastdevproject.view.fragment.FourthFragment;
import com.xyc.fastdevproject.view.fragment.SecondFragment;
import com.xyc.fastdevproject.view.fragment.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

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
    private List<Fragment> fragmentList;
    private FragmentAdapter adapter;

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
        initData();
    }

    private void initData() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new FirstFragment());
        fragmentList.add(new SecondFragment());
        fragmentList.add(new ThirdFragment());
        tvFourthTab.setVisibility(View.GONE);//隐藏一个
        adapter = new FragmentAdapter(fragmentList, getSupportFragmentManager());
        viewPager.setAdapter(adapter);

    }

    @OnClick({R.id.tvFirstTab, R.id.tvSecondTab, R.id.tvThirdTab, R.id.tvFourthTab})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvFirstTab:
                viewPager.setCurrentItem(0);
                break;
            case R.id.tvSecondTab:
                viewPager.setCurrentItem(1);
                break;
            case R.id.tvThirdTab:
                viewPager.setCurrentItem(2);
                break;
            case R.id.tvFourthTab:

                break;
        }

    }
}
