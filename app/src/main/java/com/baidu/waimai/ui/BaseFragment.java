package com.baidu.waimai.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * User: Administrator
 * Date: 2016/6/1
 * Time: 1:31
 */
public abstract class BaseFragment extends Fragment {
    public    Context         context;
    protected FragmentManager fragmentManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(getContentView(), container, false);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        fragmentManager = getChildFragmentManager();
    }

    public abstract int getContentView();
}
