package com.qxy.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
import com.qxy.myapplication.JsonData.UserData;
import com.qxy.myapplication.JsonData.VideoRoot;
import com.qxy.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    DouYinOpenApi douYinOpenApi;
    public static int flags = 0;
    public static TextView tv_username;
    public VideoRoot videoRoot;
    public VideoRoot dsjRoot;
    public VideoRoot zyRoot;
    UserData userData = new UserData();
    String url = "https://open.douyin.com/oauth/userinfo/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this , R.layout.activity_main);
        douYinOpenApi = DouYinOpenApiFactory.create(this);
        findViewById(R.id.btu_tiao).setOnClickListener(this);
        findViewById(R.id.dsj_tiao).setOnClickListener(this);
        findViewById(R.id.zy_tiao).setOnClickListener(this);
        //getToken();
        getClient();
        getVideoList();
        getDianshijuList();
        getZongyiList();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btu_tiao:
                Intent intent = new Intent(MainActivity.this ,MainActivity2.class);
                Bundle bd = new Bundle();
                for(int i=0;i<10;i++){
                    bd.putString("title" + i ,videoRoot.getData().getList().get(i).getName());
                    bd.putString("actors" + i ,videoRoot.getData().getList().get(i).getActors().get(0));
                    bd.putString("poster" + i ,videoRoot.getData().getList().get(i).getPoster());
                }
                intent.putExtras(bd);
                startActivity(intent);
                break;
            case R.id.dsj_tiao:
                Intent intent2 = new Intent(MainActivity.this ,MainActivity3.class);
                Bundle bd2 = new Bundle();
                for(int i=0;i<10;i++){
                    bd2.putString("title" + i ,dsjRoot.getData().getList().get(i).getName());
                    bd2.putString("actors" + i ,dsjRoot.getData().getList().get(i).getActors().get(0));
                    bd2.putString("poster" + i ,dsjRoot.getData().getList().get(i).getPoster());
                }
                intent2.putExtras(bd2);
                startActivity(intent2);
                break;
            case R.id.zy_tiao:
                Intent intent3 = new Intent(MainActivity.this ,MainActivity4.class);
                Bundle bd3 = new Bundle();
                for(int i=0;i<10;i++){
                    bd3.putString("title" + i ,zyRoot.getData().getList().get(i).getName());
                    bd3.putString("actors" + i ,zyRoot.getData().getList().get(i).getDirectors().get(0));
                    bd3.putString("poster" + i ,zyRoot.getData().getList().get(i).getPoster());
                }
                intent3.putExtras(bd3);
                startActivity(intent3);
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

//    public void getVideoList(){
//        HttpTest httpTest = new HttpTest();
//
//        new Thread(new Runnable(){
//            @Override
//            public void run() {
//                System.out.println("------------getVideoList------------");
//                httpTest.testVideo(1);
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        //MainActivity.tv_username.setText(HttpTest.userMessage.getData().getNickname());
//                        System.out.println(HttpTest.videoRoot.getData().getList().get(0).getName());
//                    }
//                });
//            }
//        }).start();
//    }
    public void getVideoList(){
        JsonString jsonString = new JsonString();
        JSONObject jsonObject = JSONObject.parseObject(jsonString.getVideoString());
        videoRoot = JSON.toJavaObject(jsonObject , VideoRoot.class);
        System.out.println(videoRoot.getData().getList().get(1).getName());
    }
    public void getDianshijuList(){
        JsonString jsonString = new JsonString();
        JSONObject jsonObject = JSONObject.parseObject(jsonString.getDianshiju());
        dsjRoot = JSON.toJavaObject(jsonObject , VideoRoot.class);
        System.out.println(dsjRoot.getData().getList().get(1).getName());
    }
    public void getZongyiList(){
        JsonString jsonString = new JsonString();
        JSONObject jsonObject = JSONObject.parseObject(jsonString.getZongyi());
        zyRoot = JSON.toJavaObject(jsonObject , VideoRoot.class);
        System.out.println(zyRoot.getData().getList().get(1).getDirectors().get(0));
    }

    public boolean getToken(){
        Authorization.Request request = new Authorization.Request();
        request.scope = "trial.whitelist,user_info";
        return douYinOpenApi.authorize(request);
    }
}

