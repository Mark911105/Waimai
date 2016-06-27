package com.baidu.waimai.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * User: Administrator
 * Date: 2016/6/1
 * Time: 1:31
 */
public abstract class BaseActivity extends FragmentActivity {
    public    Activity        activity;
    protected FragmentManager fragmentManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());

        activity = this;
        fragmentManager = getSupportFragmentManager();
        initView();
    }

    public abstract int getContentView();

    public abstract void initView();

}
