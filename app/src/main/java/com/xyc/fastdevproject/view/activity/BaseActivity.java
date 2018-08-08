package com.xyc.fastdevproject.view.activity;

import android.support.constraint.solver.widgets.ConstraintWidgetContainer;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xyc.fastdevproject.R;
import com.xyc.fastdevproject.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public abstract class BaseActivity extends AppCompatActivity {

    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.tvTitleBar)
    View tvTitleBar;
    @BindView(R.id.rlBaseTitleLayout)
    RelativeLayout rlBaseTitleLayout;
    @BindView(R.id.ivGoBack)
    ImageView ivGoBack;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.ivNext)
    ImageView ivNext;
    @BindView(R.id.tvNext)
    TextView tvNext;
    @BindView(R.id.llHeaderOpr)
    LinearLayout llHeaderOpr;
    @BindView(R.id.llCenterView)
    LinearLayout llCenterView;
    @BindView(R.id.llEmptyPage)
    LinearLayout llEmptyPage;
    @BindView(R.id.rlAddSelectContain)
    RelativeLayout rlAddSelectContain;

    protected abstract int getCenterView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getVew());
        ButterKnife.bind(this);
    }

    private View getVew() {
        View mContainView = LayoutInflater.from(this).inflate(R.layout.activity_base, null);
        LayoutInflater inflater = getLayoutInflater();
        if (getCenterView() != 0) {
            View mAddView = inflater.inflate(getCenterView(), null);
            LinearLayout llCenterView = mContainView.findViewById(R.id.llCenterView);
            llCenterView.addView(mAddView, new ViewGroup.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
        }
        return mContainView;
    }

    @OnClick({R.id.ivGoBack, R.id.ivNext, R.id.tvNext, R.id.llEmptyPage})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivGoBack:
                ToastUtil.showShort("1");
                break;
            case R.id.ivNext:

                break;
            case R.id.tvNext:
                break;
            case R.id.llEmptyPage:
                break;
        }
    }
}
