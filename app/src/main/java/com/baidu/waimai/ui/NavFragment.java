package com.baidu.waimai.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RadioGroup;
import com.baidu.waimai.R;
import com.baidu.waimai.listener.OnNavSelectListener;

import java.util.ArrayList;

/**
 * (
 * User: Administrator
 * Date: 2016/6/1
 * Time: 1:44
 */
public class NavFragment extends BaseFragment {

    public static NavFragment         navFragment;
    private       OnNavSelectListener onNavSelectListener;
    private       RadioGroup          rb_nav;
    private ArrayList<Integer> ids = new ArrayList<>();

    public static NavFragment newInstance() {
        if (navFragment == null) {
            navFragment= new NavFragment();
        }
        return navFragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initListener();
    }

    private void initView(View view) {
        rb_nav = (RadioGroup) view.findViewById(R.id.rb_nav);
        rb_nav.check(R.id.nav_home);
        ids.add(R.id.nav_home);
        ids.add(R.id.nav_order);
        ids.add(R.id.nav_me);
    }

    private void initListener() {
        rb_nav.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if (onNavSelectListener != null && ids.contains(checkedId) && !isContentChanged) {
                            onNavSelectListener.onitemclick(ids.indexOf(checkedId));
                        }
                    }
                }
                                         );
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_nav;
    }

    public OnNavSelectListener getOnNavSelectListener() {
        return onNavSelectListener;
    }

    public void setOnNavSelectListener(OnNavSelectListener onNavSelectListener) {
        this.onNavSelectListener = onNavSelectListener;
    }

    public boolean isContentChanged = false;

    public void onSelect(int position) {
        isContentChanged = true;
        rb_nav.check(ids.get(position));
    }
}
