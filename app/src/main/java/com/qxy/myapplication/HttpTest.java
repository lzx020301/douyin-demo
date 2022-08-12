package com.qxy.myapplication;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qxy.myapplication.JsonData.UserMessage;

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

    public void getToken(String code) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().get().url("https://open.douyin.com/oauth/access_token?client_secret=" + InitProject.clientsercet + "&code="+ code + "&grant_type=authorization_code&client_key=" + InitProject.clientkey).build();
        Call call = okHttpClient.newCall(request);


                try {
                    Response execute = call.execute();
                    System.out.println(execute.body().string());
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
                    System.out.println(userMessage.getData().getNickname());
                    System.out.println(str_json);

                } catch (IOException e) {
                    e.printStackTrace();
                }

    }
}
