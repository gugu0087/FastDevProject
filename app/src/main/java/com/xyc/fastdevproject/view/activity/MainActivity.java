package com.xyc.fastdevproject.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xyc.fastdevproject.R;
import com.xyc.fastdevproject.view.adapter.FragmentAdapter;
import com.xyc.fastdevproject.view.base.BaseActivity;
import com.xyc.fastdevproject.view.base.BaseFragment;
import com.xyc.fastdevproject.view.fragment.FirstFragment;
import com.xyc.fastdevproject.view.fragment.SecondFragment;
import com.xyc.fastdevproject.view.fragment.ThirdFragment;
import com.xyc.fastdevproject.view.views.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {
    // @BindView(R.id.viewPager)
    //NoScrollViewPager viewPager;
    @BindView(R.id.tvFirstTab)
    TextView tvFirstTab;
    @BindView(R.id.tvSecondTab)
    TextView tvSecondTab;
    @BindView(R.id.tvThirdTab)
    TextView tvThirdTab;
    @BindView(R.id.tvFourthTab)
    TextView tvFourthTab;

    @BindView(R.id.llFragment)
    LinearLayout llFragment;

    private List<Fragment> fragmentList;
    private FragmentAdapter adapter;

    private BaseFragment[] fragments = new BaseFragment[3];


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
        if (findFragment(BaseFragment.class) == null) {
            fragments[0] = new FirstFragment();
            fragments[1] = new SecondFragment();
            fragments[2] = new ThirdFragment();
            loadMultipleRootFragment(R.id.llFragment, 0,
                    fragments[0],
                    fragments[1],
                    fragments[2]);
        } else {
            fragments[0] = findFragment(FirstFragment.class);
            fragments[1] = findFragment(SecondFragment.class);
            fragments[2] = findFragment(ThirdFragment.class);
        }
        tvFourthTab.setVisibility(View.GONE);//隐藏一个

    }

    @OnClick({R.id.tvFirstTab, R.id.tvSecondTab, R.id.tvThirdTab, R.id.tvFourthTab})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvFirstTab:
                showHideFragment(fragments[0]);
                break;
            case R.id.tvSecondTab:
                showHideFragment(fragments[1]);
                break;
            case R.id.tvThirdTab:
                showHideFragment(fragments[2]);
                break;
            case R.id.tvFourthTab:

                break;
        }

    }
}
