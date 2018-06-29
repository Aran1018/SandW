package com.triplebro.aran.sandw.modules;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * Created by Aran on 2018/6/11.
 * 那当自己都萎靡到
 * 无法被依靠的时候该如何振作？
 * <p>
 * 除过自己心中笃信的那一点不灭的光亮
 * 我觉得这世间再没有别的东西比它值得被如此依靠。
 */

public class AransModules extends ReactContextBaseJavaModule {
    private Context mContext;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public AransModules(ReactApplicationContext reactContext) {
        super(reactContext);
        mContext = reactContext;
    }

    @Override
    public String getName() {
        return "AransModules";
    }

    @ReactMethod
    public void rnCallNative(String msg){

        Toast.makeText(mContext,msg,Toast.LENGTH_SHORT).show();

    }

    @ReactMethod
    public void giveRnData(Callback callback){

        callback.invoke(data);
        System.out.println("--------------------------------"+data);

    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String, Object> params = new HashMap<>();
        params.put("aa","hahaha");
        params.put("bb","xixixi");
        return params;
    }
}
