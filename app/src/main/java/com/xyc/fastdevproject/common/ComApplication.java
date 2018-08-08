package com.xyc.fastdevproject.common;

import android.app.Activity;
import android.app.Application;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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
       // CrashManager.getInstance().init(this); //初始化本地崩溃日志收集
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
                if(activity == currentActivity){
                    return;
                }
                removeActivity(activity);
                activity.finish();
            }
        }
    }

    /**
     * 获取当前的activity
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
