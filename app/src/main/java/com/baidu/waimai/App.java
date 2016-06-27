package com.baidu.waimai;

import android.app.Application;

/**
 * User: KdMobiB
 * Date: 2016/6/1
 * Time: 15:30
 */
public class App extends Application {
    public static Application app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
