package com.qxy.myapplication;

import android.app.Application;

import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
import com.bytedance.sdk.open.douyin.DouYinOpenConfig;

public class InitProject extends Application {
    public static String clientkey;
    public static String clientsercet;
    public static String access_token;
    public static String open_id;
    public static String client_token;
    @Override
    public void onCreate() {
        super.onCreate();
        clientkey = "aw9jo9o9bzyuwqsu"; // 需要到开发者网站申请并替换
        clientsercet = "f1964a72e2e999b61454272d583daf35";
        access_token = "act.d7ca96ae041786d986425791f01a3b3e9ZkKzLmlRepcpuu1uAzCGpmIVGsJ";
        open_id = "_000FZx_2TZvLTBv_KGz7ChpZJy6Ms-jNBLW";
        DouYinOpenApiFactory.init(new DouYinOpenConfig(clientkey));
    }
}
