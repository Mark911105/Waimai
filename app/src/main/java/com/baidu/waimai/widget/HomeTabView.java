package com.baidu.waimai.widget;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.waimai.R;

/**
 * User: KdMobiB
 * Date: 2016/6/1
 * Time: 17:58
 */
public class HomeTabView extends TextView {
    private Context context;
    private int     space, tvSize;
    private String tabs;

    public HomeTabView(Context context, String tabs) {
        super(context);
        this.context = context;
        this.tabs = tabs;
        initView();
    }

    private void initView() {
        space = (int) context.getResources().getDimension(R.dimen.space_small);
        tvSize = (int) context.getResources().getDimension(R.dimen.space_small);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(space, 0, 0, 0);
        setLayoutParams(lp);
        setBackgroundResource(R.drawable.home_tabs_item);
        setPadding(space, space, space, space);
        setTextSize(tvSize);
        setTextColor(context.getResources().getColor(R.color.tabs_line));
        setGravity(Gravity.CENTER);
        setText(tabs);
    }
}
