package com.baidu.waimai.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.baidu.waimai.R;
import com.baidu.waimai.Utils.Utils;
import com.baidu.waimai.entity.HomeCategoryItem;

import java.util.ArrayList;

/**
 * User: KdMobiB
 * Date: 2016/6/1
 * Time: 17:58
 */
public class HomeGridView extends GridView {
    private Context context;
    private ArrayList<HomeCategoryItem> homeCategoryItems            = new ArrayList<>();
    private int                         width, height, space, numCol = 4;

    public HomeGridView(Context context, ArrayList<HomeCategoryItem> homeCategoryItems) {
        super(context);
        this.context = context;
        this.homeCategoryItems = homeCategoryItems;
        initView();
    }

    private void initView() {
        width = Utils.getScreenWidth();
        height = width / 2;
        space = (int) context.getResources().getDimension(R.dimen.space_small);
        setPadding(0,Utils.dip2px(4),0,0);
        setLayoutParams(new AbsListView.LayoutParams(width, height));
        setNumColumns(numCol);
        setVerticalSpacing(space);
        setHorizontalSpacing(space);
        setBackgroundResource(R.color.item_background);
        setAdapter(new GvAdapter());
    }

    private class GvAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return homeCategoryItems.size();
        }

        @Override
        public HomeCategoryItem getItem(int position) {
            return homeCategoryItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            ViewHolder holder;
            if (view == null) {
                view = View.inflate(context, R.layout.item_home_category, null);
                holder = new ViewHolder(view);
                view.setTag(holder);
            }
            holder = (ViewHolder) view.getTag();
            HomeCategoryItem item = getItem(position);
            holder.tv_name.setText(item.getName());
            holder.img_category.setBackgroundResource(item.getImgId());
            return view;
        }
    }

    private class ViewHolder {
        private TextView  tv_name;
        private ImageView img_category;

        private ViewHolder(View view) {
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            img_category = (ImageView) view.findViewById(R.id.img_category);
        }
    }
}
