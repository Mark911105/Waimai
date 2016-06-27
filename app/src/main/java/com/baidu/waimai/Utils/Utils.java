package com.baidu.waimai.Utils;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.waimai.App;

/**
 * User: KdMobiB
 * Date: 2016/6/1
 * Time: 15:30
 */
public class Utils {
    public static int getScreenWidth() {
        int width;
        WindowManager wm = (WindowManager) App.app.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            Point size = new Point();
            display.getSize(size);
            width = size.x;
        } else {
            width = display.getWidth();
        }
        return width;
    }

    public static int getScreenHeight() {
        int height;
        WindowManager wm = (WindowManager) App.app.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            Point size = new Point();
            display.getSize(size);
            height = size.y;
        } else {
            height = display.getHeight();
        }
        return height;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(float dpValue) {
        final float scale = App.app.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
