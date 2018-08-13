package com.xyc.fastdevproject.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xyc.fastdevproject.R;
import com.xyc.fastdevproject.utils.NetworkUtils;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gugu on 2018/6/29.
 */

public abstract class BaseFragment extends Fragment {
    protected View containView;
    private View mAddContentView;
    private View mAddHeaderView;
    /*    private LinearLayout llEmptyPage;
        private TextView tvConnectTip;*/
    private LinearLayout llCenterView;
    @BindView(R.id.llEmptyPage)
    LinearLayout llEmptyPage;
    @BindView(R.id.tvConnectTip)
    TextView tvConnectTip;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        containView = inflater.inflate(R.layout.frag_base_layout, null);

        LinearLayout llCenterView = containView.findViewById(R.id.llCenterView);

        if (setFrgContainView() != 0) {
            llCenterView.removeAllViews();
            mAddContentView = LayoutInflater.from(getActivity()).inflate(setFrgContainView(), null);
        }
        ButterKnife.bind(this, mAddContentView);

        initView();
        initData();
        setNetErrorView();

        llEmptyPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reLoadData();
            }
        });
        return containView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    /**
     * 是否显示网络错误页面
     *
     * @param
     */
    public void setNetErrorView() {
        boolean isNetConnect = NetworkUtils.isNetworkConnected(getActivity());
        if (isNetConnect) {
            llCenterView.setVisibility(View.VISIBLE);
            llEmptyPage.setVisibility(View.GONE);
        } else {
            llEmptyPage.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 是否显示空白页面
     *
     * @param
     */
    public void setEmptyView(boolean isEmpty, String errorTip) {
        if (isEmpty) {
            llCenterView.setVisibility(View.VISIBLE);
            llEmptyPage.setVisibility(View.VISIBLE);
            if (errorTip == null) {
                return;
            }
            tvConnectTip.setText(errorTip);
        } else {
            llEmptyPage.setVisibility(View.GONE);
            llCenterView.setVisibility(View.VISIBLE);
        }

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }

    }

    /**
     * 一些View的相关操作
     */
    protected abstract void initView();

    protected abstract void initData();

    protected abstract void reLoadData();


    /**
     * 此方法用于设置内容布局页面
     *
     * @return 布局文件资源ID
     */
    protected abstract int setFrgContainView();


    public View getmAddContentView() {
        return mAddContentView;
    }
}

