package com.xyc.fastdevproject.common;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.util.Log;

import com.xyc.fastdevproject.R;
import com.xyc.fastdevproject.okhttp.MyOkhttpUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import me.weyye.hipermission.HiPermission;
import me.weyye.hipermission.PermissionCallback;
import me.weyye.hipermission.PermissionItem;

/**
 * Created by hasee on 2018/8/8.
 */

public class ComApplication extends Application {
    public static ComApplication mzjApplication;
    public List<Activity> mActivityList = null;

    /**
     * 在这里做一些全局的初始化操作
     */
    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationHolder.getInstance().setAppContext(this);
         CrashManager.getInstance().init(this); //初始化本地崩溃日志收集
        checkPermission();
        MyOkhttpUtils.initOkhttp(this);
    }

    /**
     * 获取application实例
     *
     * @return
     */
    public static ComApplication getApp() {
        return mzjApplication;
    }

    /**
     * 初始化需要申请的权限
     *
     * @return
     */
    private List<PermissionItem> initPermissionList() {
        List<PermissionItem> permissionItems = new ArrayList<>();
        permissionItems.add(new PermissionItem(Manifest.permission.WRITE_EXTERNAL_STORAGE, "存储权限", R.drawable.permission_ic_storage));
        return permissionItems;
    }

    /**
     * 安卓6.0动态检查权限
     *
     * @param
     */
    private void checkPermission() {
        List<PermissionItem> permissionItems = initPermissionList();
        if (permissionItems == null || permissionItems.size() == 0) {
            return;
        }
        HiPermission.create(this)
                .title("权限申请")
                .permissions(permissionItems)
                .msg("权限申请")
                .animStyle(R.style.PermissionAnimScale)
                .style(R.style.PermissionDefaultBlueStyle)
                .checkMutiPermission(new PermissionCallback() {
                    @Override
                    public void onClose() {
                        Log.d("xyc", "onClose: 1");
                    }

                    @Override
                    public void onFinish() {
                    }

                    @Override
                    public void onDeny(String permission, int position) {
                        Log.d("xyc", "onDeny:1 ");
                    }

                    @Override
                    public void onGuarantee(String permission, int position) {
                        Log.d("xyc", "onGuarantee:1 ");
                    }
                });
    }

    /**
     * 添加activity
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        if (mActivityList == null) {
            mActivityList = new CopyOnWriteArrayList<>();
        }

        if (activity != null) {

            mActivityList.add(activity);
        }
    }

    /**
     * 退出栈中所有的activity，用于退出登录
     */
    public void removeAllActivity() {
        if (mActivityList != null) {
            for (Activity activity : mActivityList) {
                removeActivity(activity);
                activity.finish();
            }
        }
    }

    /**
     * 退出栈中所有的activity，用于退出登录
     */
    public void removeAllActivity(Activity currentActivity) {
        if (mActivityList != null) {
            for (Activity activity : mActivityList) {
                if (activity == currentActivity) {
                    return;
                }
                removeActivity(activity);
                activity.finish();
            }
        }
    }

    /**
     * 获取当前的activity
     *
     * @return
     */
    public Activity getCurrentActivity() {
        if (mActivityList != null) {
            if (mActivityList.size() > 0) {
                return mActivityList.get(mActivityList.size() - 1);
            }
        }
        return null;
    }

    /**
     * 移除activity
     *
     * @param activity
     */
    public void removeActivity(Activity activity) {
        if (mActivityList != null && activity != null) {
            mActivityList.remove(activity);
        }
    }
}
