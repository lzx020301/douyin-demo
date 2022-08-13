package com.qxy.myapplication;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qxy.myapplication.JsonData.UserMessage;
import com.qxy.myapplication.JsonData.VideoRoot;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpTest
{

    public static UserMessage userMessage;
    public static VideoRoot videoRoot;

    public void getToken(String code) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().get().url("https://open.douyin.com/oauth/access_token?client_secret=" + InitProject.clientsercet + "&code="+ code + "&grant_type=authorization_code&client_key=" + InitProject.clientkey).build();
        Call call = okHttpClient.newCall(request);
                try {
                    Response execute = call.execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
    }

    public void getUserInfo(String url){
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        RequestBody requestBody = new FormBody.Builder().add("access_token" ,InitProject.access_token)
                .add("open_id" ,InitProject.open_id)
                .build();

        Request request = new Request.Builder().post(requestBody).url(url).build();
        Call call = okHttpClient.newCall(request);

                try {
                    Response execute = call.execute();
                    String str = execute.body().string();
                    String str_json = JSON.toJSONString(str);
                    ObjectMapper objectMapper = new ObjectMapper();
                    userMessage = objectMapper.readValue(str ,UserMessage.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }

    }

    public void getClientKey(){
        String url = "https://open.douyin.com/oauth/client_token/";
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        RequestBody requestBody = new FormBody.Builder().add("client_key" ,InitProject.clientkey)
                .add("client_secret" ,InitProject.clientsercet)
                .add("grant_type" ,"client_credential")
                .build();
        Request request = new Request.Builder().post(requestBody).url(url).build();
        Call call = okHttpClient.newCall(request);
        try {
            Response execute = call.execute();
            String str = execute.body().string();
            InitProject.client_token = str.substring(25 ,89);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testVideo(int type){
        String url = "https://open.douyin.com/discovery/ent/rank/item/?type=" + type;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().get().addHeader("access-token" ,InitProject.client_token).url(url).build();

        Call call = okHttpClient.newCall(request);
        try {
            Response execute = call.execute();
            String str = execute.body().string();
            System.out.println(execute.body().string());
            JSONObject jsonObject = JSONObject.parseObject(str);
            videoRoot = JSON.toJavaObject(jsonObject ,VideoRoot.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
