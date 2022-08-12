package com.qxy.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
import com.qxy.myapplication.JsonData.UserData;
import com.qxy.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    DouYinOpenApi douYinOpenApi;
    public static int flags = 0;
    public static TextView tv_username;
    UserData userData = new UserData();
    String url = "https://open.douyin.com/oauth/userinfo/";
    User user = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this , R.layout.activity_main);
        activityMainBinding.setUser(user);
        douYinOpenApi = DouYinOpenApiFactory.create(this);
        tv_username = findViewById(R.id.tv_username);
        findViewById(R.id.btn_userinfo).setOnClickListener(this);
        getToken();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_userinfo:
                getUserInfo();
                break;
        }
    }

    public void getUserInfo(){
        HttpTest httpTest = new HttpTest();

        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("------------getuserinfo------------");
                httpTest.getUserInfo(url);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        MainActivity.tv_username.setText(HttpTest.userMessage.getData().getNickname());
                        user.setName(HttpTest.userMessage.getData().getNickname());
                    }
                });
            }
        }).start();
    }

    public boolean getToken(){
        Authorization.Request request = new Authorization.Request();
        request.scope = "trial.whitelist,user_info";
        return douYinOpenApi.authorize(request);
    }

}