package com.triplebro.aran.sandw.managers;

import android.content.Context;
import android.os.Message;
import android.util.Log;

import com.triplebro.aran.sandw.handlers.RegisterHandler;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RegisterManager {

    private Context context;
    private RegisterHandler registerHandler;

    public RegisterManager(Context context, RegisterHandler registerHandler) {
        this.context = context;
        this.registerHandler = registerHandler;
    }

    public void register(String nickname, String email, String password) {
        sendRequest(nickname, email, password);
    }

    private void sendRequest(final String nickname, final String email, final String password) {
        new Thread() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request;
                    request = new Request.Builder().url("https://thethreestooges.cn:1225/login/change/pwd")
                            .post(new FormBody.Builder().add("nickname", nickname).add("email", email)
                                    .add("password", password).build()).build();
                    Response response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                        String res = response.body().string();
                        Log.i("ServerBackCode(服务器返回):", res);
                        //TODO 判断服务器返回值
                        Message message = new Message();
                        message.obj = res;
                        registerHandler.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}