package com.qxy.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
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
        findViewById(R.id.btu_tiao).setOnClickListener(this);
        //getToken();
        getClient();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_userinfo:
                //getUserInfo();
                getVideoList();
                break;
            case R.id.btu_tiao:
                Intent intent = new Intent(MainActivity.this ,MainActivity2.class);
                Bundle bd = new Bundle();
                int size = HttpTest.videoRoot.getData().getList().size();
                System.out.println(size);
                for(int i=0;i<10;i++){
                    bd.putString("title" + i ,HttpTest.videoRoot.getData().getList().get(i).getName());
                    bd.putString("actors" + i ,HttpTest.videoRoot.getData().getList().get(i).getActors().get(0));
                    bd.putString("poster" + i ,HttpTest.videoRoot.getData().getList().get(i).getPoster());
                }
                intent.putExtras(bd);
                startActivity(intent);
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

    public void getClient(){
        HttpTest httpTest = new HttpTest();

        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("------------getuserinfo------------");
                httpTest.getClientKey();
            }
        }).start();
    }

    public void getVideoList(){
        HttpTest httpTest = new HttpTest();

        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("------------getVideoList------------");
                httpTest.testVideo(1);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //MainActivity.tv_username.setText(HttpTest.userMessage.getData().getNickname());
                        System.out.println(HttpTest.videoRoot.getData().getList().get(0).getName());
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

