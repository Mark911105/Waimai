package com.baidu.waimai.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.baidu.waimai.R;
import com.baidu.waimai.entity.HomeCategoryItem;
import com.baidu.waimai.entity.HomeItem;
import com.baidu.waimai.widget.HomeGridView;
import com.baidu.waimai.widget.HomeLabelView;
import com.baidu.waimai.widget.HomeTabView;

import java.util.ArrayList;

/**
 * User: Administrator
 * Date: 2016/6/1
 * Time: 1:31
 */
public class HomeFragment extends BaseFragment {
    private       ListView     lv;
    public static HomeFragment contentFragment;
    private ArrayList<HomeItem> items = new ArrayList<>();

    public static HomeFragment newInstance() {
//        if (contentFragment == null) {
//            contentFragment = new HomeFragment();
//        }
//        return contentFragment;
        return new HomeFragment();
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_home;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        lv = (ListView) view.findViewById(R.id.lv);
        lv.addHeaderView(addCategoryView());
        lv.addHeaderView(addListLabelView());

        getHomeItemData();
        lv.setAdapter(new lvAdapter());
    }

    private int[]    itemImgIds = {R.drawable.home_shopone, R.drawable.home_shoptwo, R.drawable.home_shopthree};
    private String[] itemStrIds = {"券", "票", "付", "赔"};

    private HomeItem getHomeItem(int position) {
        ArrayList<String> tabs = new ArrayList<>();
        for (int i = 0; i < position % 4; i++) {
            tabs.add(itemStrIds[i]);
        }
        HomeItem item = new HomeItem();
        item.setAddress(85);
        item.setImgId(itemImgIds[position % 3]);
        item.setRate((float) (position % 9) / 2);
        item.setSendprize(position);
        item.setStartprize(2 * position);
        item.setSendtime(3 * position);
        item.setTabs(tabs);
        item.setTitle("Title" + position);
        item.setSalenum(4 * position);
        return item;
    }

    private void getHomeItemData() {
        items.clear();
        for (int i = 0; i < 20; i++) {
            items.add(getHomeItem(i));
        }
    }

    private View addCategoryView() {
        ArrayList<HomeCategoryItem> homeCategoryItems = new ArrayList<>();
        homeCategoryItems.add(new HomeCategoryItem(R.drawable.home_category_buy, "购物"));
        homeCategoryItems.add(new HomeCategoryItem(R.drawable.home_category_deliver, "交通"));
        homeCategoryItems.add(new HomeCategoryItem(R.drawable.home_category_eat, "吃饭"));
        homeCategoryItems.add(new HomeCategoryItem(R.drawable.home_category_fruit, "水果"));
        homeCategoryItems.add(new HomeCategoryItem(R.drawable.home_category_medicine, "药品"));
        homeCategoryItems.add(new HomeCategoryItem(R.drawable.home_category_newdian, "新店"));
        homeCategoryItems.add(new HomeCategoryItem(R.drawable.home_category_tea, "喝茶"));
        homeCategoryItems.add(new HomeCategoryItem(R.drawable.home_category_tuhao, "土豪"));
        HomeGridView homeGridView = new HomeGridView(context, homeCategoryItems);
        return homeGridView;
    }

    private View addListLabelView() {
        HomeLabelView labelView = new HomeLabelView(context);
        labelView.setText("全部商家");
        return labelView;
    }

    private class lvAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public HomeItem getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View v, ViewGroup parent) {
            ViewHolder holder;
            if (v == null) {
                v = View.inflate(context, R.layout.item_home, null);
                holder = new ViewHolder(v);
                v.setTag(holder);
            }

            HomeItem item = getItem(position);
            holder = (ViewHolder) v.getTag();
            holder.tvTitle.setText(item.getTitle());
            holder.img.setImageResource(item.getImgId());
            holder.tvAddress.setText(item.getAddress() + "m");
            holder.rating.setRating(item.getRate());
            holder.tvSaleNum.setText(String.format("已售%d份", item.getSalenum()));
            holder.tvStartPrize.setText(String.format("起送¥%d", (int) item.getStartprize()));
            holder.tvSendPrize.setText(String.format("配送¥%d", (int) item.getSendprize()));
            holder.tvSendTime.setText(String.format("平均%d分钟", (int) item.getSendtime()));

            holder.linTabs.removeAllViews();
            for (String tab : item.getTabs()) {
                holder.linTabs.addView(new HomeTabView(context, tab));
            }
            return v;
        }
    }

    private class ViewHolder {
        private TextView     tvTitle;
        private ImageView    img;
        private RatingBar    rating;
        private LinearLayout linTabs;
        private TextView     tvSaleNum;
        private TextView     tvAddress;
        private TextView     tvStartPrize, tvSendPrize, tvSendTime;

        private ViewHolder(View itemView) {
            tvTitle = (TextView) itemView.findViewById(R.id.item_home_tv_title);
            tvSaleNum = (TextView) itemView.findViewById(R.id.item_home_tv_salenum);
            tvAddress = (TextView) itemView.findViewById(R.id.item_home_tv_address);
            tvStartPrize = (TextView) itemView.findViewById(R.id.item_home_tv_startprize);
            tvSendPrize = (TextView) itemView.findViewById(R.id.item_home_tv_sendprize);
            tvSendTime = (TextView) itemView.findViewById(R.id.item_home_tv_sendtime);
            linTabs = (LinearLayout) itemView.findViewById(R.id.lin_tabs);
            rating = (RatingBar) itemView.findViewById(R.id.item_home_ratingbar);
            img = (ImageView) itemView.findViewById(R.id.item_home_img);
        }
    }
}
