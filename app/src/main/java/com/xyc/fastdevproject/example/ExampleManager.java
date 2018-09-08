package com.xyc.fastdevproject.example;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Log;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.BitmapCallback;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.xyc.fastdevproject.common.CommonParams;
import com.xyc.okhttplibrary.okgo.DialogCallback;
import com.xyc.okhttplibrary.okgo.JsonCallback;
import com.xyc.okhttplibrary.utils.PreferencesUtils;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Create by Admin on 2018/9/6
 */
public class ExampleManager {
    private static ExampleManager instance = null;

    private ExampleManager() {

    }

    public static ExampleManager getInstance() {
        if (instance == null) {
            instance = new ExampleManager();
        }
        return instance;
    }

    /**
     * post 请求例子，，表单提交，参数自己传就是了
     * 需要解析什么类型的对象数据，只需要传对应的javabean，，User
     * onSuccess 方法里 要拿到对象只需要 response.body()
     */
    public void getUserInfo() {
        JSONObject params = new JSONObject();
        try {
            params.put("loginName", "test0117BD");
            params.put("password", "a123456");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        OkGo.<User>post(ExCommonUrl.LOGIN)
                .tag(this)
                .upJson(params)
                .execute(new JsonCallback<User>() {
                    @Override
                    public void onSuccess(Response<User> response) {
                        String token = response.body().getToken();
                        PreferencesUtils.putString(CommonParams.USER_TOKEN,token);
                    }
                });
    }

    /**
     * get 请求例子
     * 这个是自带请求进度弹窗的，需要传的参数外部传入就好
     *
     * @param context
     */
    public void getMessageWithDialog(String params1, String params2, Activity context) {
        OkGo.<ComListModel<MsgModel>>get(ExCommonUrl.getMessageListData)
                .tag(this)
                .params("pageSize", 20)//
                .params("pageNumber", 0)//
                .execute(new DialogCallback<ComListModel<MsgModel>>(context) {
                    @Override
                    public void onSuccess(Response<ComListModel<MsgModel>> response) {
                        Log.d("admin", "onSuccess: thread=" + Thread.currentThread().getName());
                        Log.d("admin", "onSuccess:response=" + response.body().getData());
                    }

                    @Override
                    public void onError(Response<ComListModel<MsgModel>> response) {
                        super.onError(response);
                        Log.d("admin", "onError: thread=" + Thread.currentThread().getName());

                        Log.d("admin", "onError: code=" + response.code());
                    }
                });
    }

    /**
     * get 请求例子
     * 这个是不带请求进度弹窗的，需要传的参数外部传入就好
     * ComListModel<T> 统一的返回格式的时候用这种
     *
     * @param context
     */
    public void getMessage(String params1, String params2, Activity context) {
        OkGo.<ComListModel<MsgModel>>get(ExCommonUrl.user_test)
                .tag(this)
                .params("params1", params1)//
                .params("params2", params2)//
                .execute(new JsonCallback<ComListModel<MsgModel>>() {
                    @Override
                    public void onSuccess(Response<ComListModel<MsgModel>> response) {
                        Log.d("admin", "onSuccess: thread=" + Thread.currentThread().getName());
                        Log.d("admin", "onSuccess:response=" + response.body().getData());
                    }

                    @Override
                    public void onError(Response<ComListModel<MsgModel>> response) {
                        super.onError(response);
                        Log.d("admin", "onError: thread=" + Thread.currentThread().getName());

                        Log.d("admin", "onError: code=" + response.code());
                    }
                });
    }

    /**
     * 网络请求一个bitmap的时候。返回bitmap
     */
    public void getBitmap() {
        OkGo.<Bitmap>get(ExCommonUrl.user_test)
                .tag(this)
                .execute(new BitmapCallback() {
                    @Override
                    public void onSuccess(Response<Bitmap> response) {

                    }
                });
    }

    /**
     * 普通的文件下载
     * downloadProgress 已经回调在主线程了，可以直接刷新UI
     */
    public void downLoadFiles() {
        OkGo.<File>get(ExCommonUrl.user_test)
                .tag(this)
                .execute(new FileCallback() {
                    @Override
                    public void onSuccess(Response<File> response) {
                        // file 为文件数据

                    }

                    @Override
                    public void downloadProgress(Progress progress) {
                        //这里是进度回调，在主线程
                    }
                });
    }

    /**
     * 上传文件，
     * 返回值类型，不一定是string，，可以是对象什么的，
     * key1 ,key2表示可以同时传多个文件，
     * key3表示，一个key，可以传多个文件
     */
    public void uploadFile() {
        List<File> files = new ArrayList<>();
        OkGo.<String>post(ExCommonUrl.GET_APK_VERSION_INFO)
                .tag(this)
                .isMultipart(false)
                .params("key1", new File("filePath1"))
                .params("key2", new File("filePath2"))
                .addFileParams("key3", files)
                .execute(new JsonCallback<String>() {
                    @Override
                    public void onSuccess(Response<String> response) {

                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                    }
                });
    }
}
