package com.del.delkit.mvp.model;


import com.del.delkit.comm.retrofit.NetService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NetService netService = retrofit.create(NetService.class);
        Call<String> call = netService.getMvpRespnose("");
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                onBackCall.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                onBackCall.onFail(t.getMessage());
            }
        });
    }
}
