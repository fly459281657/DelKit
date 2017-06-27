package com.del.delkit.comm.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * retrofit框架  定义的联网接口
 * <p>
 * Created by ${dmz} on 2017/6/26.
 */

public interface NetService {

    @GET("/")
    Call<String> getMvpRespnose();

}
