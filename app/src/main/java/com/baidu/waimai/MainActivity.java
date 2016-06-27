package com.baidu.waimai;

import com.baidu.waimai.listener.OnNavSelectListener;
import com.baidu.waimai.ui.BaseActivity;
import com.baidu.waimai.ui.ContainFragment;
import com.baidu.waimai.ui.NavFragment;


public class MainActivity extends BaseActivity {
    private NavFragment     navFragment;
    private ContainFragment containFragment;

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        navFragment = NavFragment.newInstance();
        containFragment = ContainFragment.newInstance();
        fragmentManager.beginTransaction()
                .add(R.id.fl_nav, navFragment)
                .add(R.id.fl_content, containFragment)
                .commit();
        navFragment.setOnNavSelectListener(
                new OnNavSelectListener() {
                    @Override
                    public void onitemclick(int position) {
                        containFragment.onSeclect(position);
                    }
                }
                                          );
        containFragment.setOnNavSelectListener(
                new OnNavSelectListener() {
                    @Override
                    public void onitemclick(int position) {
                        navFragment.onSelect(position);
                    }
                }
                                              );
    }
}
