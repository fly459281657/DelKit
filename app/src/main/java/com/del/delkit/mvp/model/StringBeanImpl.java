package com.del.delkit.mvp.model;


import android.support.annotation.Nullable;

import com.del.delkit.comm.retrofit.NetService;
import com.del.delkit.comm.util.L;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * 数据获取
 * <p>
 * 使用retrofit框架获取数据
 * <p>
 * Created by ${dmz} on 2017/6/26.
 */

public class StringBeanImpl implements StringBean {


    /**
     * 获取数据
     *
     * @param url        请求的url
     * @param onBackCall 数据的回调
     */
    @Override
    public void getData(String url, final OnBackCall onBackCall) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.baidu.com")
//                .client(new OkHttpClient().newBuilder().build())
                .addConverterFactory(new Converter.Factory() {
                    @Nullable
                    @Override
                    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
//                        return super.responseBodyConverter(type, annotations, retrofit);
                        return new Converter<ResponseBody, String>() {
                            @Override
                            public String convert(ResponseBody value) throws IOException {
                                return value.string();
//                                return null;
                            }
                        };
                    }
                })
                .build();
        NetService netService = retrofit.create(NetService.class);
        Call<String> call = netService.getMvpRespnose();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                L.e("成功=" + response.body() + "--" + response.toString());
                onBackCall.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                L.e("失败=" + t.getMessage());
                onBackCall.onFail(t.getMessage());
            }
        });
    }
}
