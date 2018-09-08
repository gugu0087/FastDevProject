package com.xyc.fastdevproject.apkUpdate;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.request.GetRequest;
import com.lzy.okserver.OkDownload;
import com.lzy.okserver.download.DownloadTask;
import com.xyc.fastdevproject.common.CommonParams;
import com.xyc.fastdevproject.utils.FileUtils;

import java.io.File;

/**
 * Create by Admin on 2018/9/8
 */
public class ApkDownLoad {

    private static ApkDownLoad instance = null;

    private ApkDownLoad() {

    }

    public static ApkDownLoad getInstance() {
        if (instance == null) {
            instance = new ApkDownLoad();
            initOptions();
        }
        return instance;
    }

    private static void initOptions() {
        String filePath = FileUtils.getFilePath(CommonParams.APK_PATH);
        OkDownload instance = OkDownload.getInstance();
        if (filePath != null) {
            instance.setFolder(filePath);
        }
        instance.getThreadPool().setCorePoolSize(3);

    }

    /**
     * 普通的文件下载
     * downloadProgress 已经回调在主线程了，可以直接刷新UI
     * LogDownloadListener x下载监听
     */
    public void downLoadFiles(String tag, String url) {
        GetRequest<File> fileGetRequest = OkGo.get(url);
        DownloadTask task = OkDownload.request(tag, fileGetRequest)
                .save()
                .register(new LogDownloadListener());//
        task.start();
    }
}
