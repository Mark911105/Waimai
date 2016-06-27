package com.baidu.waimai.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.waimai.R;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.waimai.listener.OnNavSelectListener;

import java.util.ArrayList;

/**
 * User: KdMobiB
 * Date: 2016/6/1
 * Time: 17:07
 */
public class ContainFragment extends BaseFragment {
    private ViewPager vp;
    private ArrayList<BaseFragment> fragments = new ArrayList<>();
    private       OnNavSelectListener onNavSelectListener;
    public static ContainFragment     contentFragment;

    public static ContainFragment newInstance() {
        if (contentFragment == null) {
            contentFragment = new ContainFragment();
        }
        return contentFragment;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_contain;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        fragments.add(HomeFragment.newInstance());
        fragments.add(HomeFragment.newInstance());
        fragments.add(HomeFragment.newInstance());
        vp = (ViewPager) view.findViewById(R.id.vp_contain);
        vp.setPageMargin(0);
        vp.setAdapter(new PagerAdapter(fragmentManager));
        vp.setOnPageChangeListener(
                new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        if (onNavSelectListener != null && !isNavChanged) {
                            onNavSelectListener.onitemclick(position);
                        }
                        isNavChanged = false;
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                }
                                  );
    }


    public class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

        }
    }

    public void setOnNavSelectListener(OnNavSelectListener onNavSelectListener) {
        this.onNavSelectListener = onNavSelectListener;
    }

    public boolean isNavChanged = false;//判断是否点击了nav按钮

    public void onSeclect(int position) {
        isNavChanged = true;
        vp.setCurrentItem(position);
    }
}
