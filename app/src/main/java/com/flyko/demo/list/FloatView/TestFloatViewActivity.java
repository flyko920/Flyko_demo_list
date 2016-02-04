package com.flyko.demo.list.FloatView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.*;
import android.widget.ImageView;
import android.widget.Toast;
import com.flyko.demo.list.R;

/**
 * Created by flykozhang on 16-2-2.
 */
public class TestFloatViewActivity extends Activity implements View.OnClickListener {
    private WindowManager windowManager = null;
    private WindowManager.LayoutParams windowManagerParams = null;
    private MyFloatView floatView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);// 取消标题栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);// 全屏
        setContentView(R.layout.activity_main);
        createView();
    }

    private void createView() {
        floatView = new MyFloatView(getApplicationContext());
        floatView.setOnClickListener(this);
        ImageView view = new ImageView(this);
        view.setImageResource(R.mipmap.ic_launcher);
        floatView.addView(view); // 这里简单的用自带的icon来做演示

        windowManager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
// 设置LayoutParams(全局变量）相关参数
        windowManagerParams = new WindowManager.LayoutParams();

        windowManagerParams.type = 2003; // 设置window type
// windowManagerParams.format = PixelFormat.RGBA_8888; // 设置图片格式，效果为背景透明
// 设置Window flag
        windowManagerParams.flags = 40;
        windowManagerParams.format = 1;
// 调整悬浮窗口至左上角，便于调整坐标
        windowManagerParams.gravity = Gravity.LEFT | Gravity.TOP;
// 以屏幕左上角为原点，设置x、y初始值
        windowManagerParams.x = 150;
        windowManagerParams.y = 150;
// 设置悬浮窗口长宽数据
        windowManagerParams.width = 400;
        windowManagerParams.height = 400;
// 显示myFloatView图像
        windowManager.addView(floatView, windowManagerParams);
    }

    public void onClick(View v) {
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
//        openCLD("com.jovian.android.pqgl", getApplicationContext());
    }

}
