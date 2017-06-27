package com.del.delkit.comm.util;

import android.util.Log;

import com.del.delkit.DelApplication;

/**
 * 打印的工具类
 * <p>
 * Created by ${dmz} on 2017/6/27.
 */

public class L {

    private static final String TAG = "del";

    public static void e(String message) {
        if (DelApplication.isDebug)
            Log.e(TAG, message);
    }

}
