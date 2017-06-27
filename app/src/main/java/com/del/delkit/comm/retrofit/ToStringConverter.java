package com.del.delkit.comm.retrofit;


import java.io.IOException;

import retrofit2.Converter;

/**
 * Created by ${dmz} on 2017/6/27.
 */

public class ToStringConverter implements Converter<String, String> {


    @Override
    public String convert(String value) throws IOException {
        return value;
    }

    


}
