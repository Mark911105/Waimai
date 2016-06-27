package com.baidu.waimai.widget;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.*;
import com.baidu.waimai.R;
import com.baidu.waimai.Utils.Utils;

/**
 * User: KdMobiB
 * Date: 2016/6/1
 * Time: 17:58
 */
public class HomeLabelView extends TextView {
    private Context context;
    private int space = 4, tvSize = 6;

    public HomeLabelView(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    private void initView() {
        setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        setBackgroundResource(R.color.background);
        setPadding(Utils.dip2px(space), Utils.dip2px(space+2), Utils.dip2px(space), Utils.dip2px(space+2));
        setTextSize(Utils.dip2px(tvSize));
        setTextColor(getResources().getColor(R.color.nav_tv));
        setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
    }
}
