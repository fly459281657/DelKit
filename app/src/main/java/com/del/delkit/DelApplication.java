package com.del.delkit;

import android.app.Application;

/**
 * Created by ${dmz} on 2017/6/27.
 */

public class DelApplication extends Application {

    public static boolean isDebug = true;

    @Override
    public void onCreate() {
        super.onCreate();
//        isDebug=getResources().getBoolean(R.string.is_debug);
    }
}
