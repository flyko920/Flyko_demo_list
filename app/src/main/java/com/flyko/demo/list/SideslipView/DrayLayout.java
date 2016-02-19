package com.flyko.demo.list.SideslipView;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by flykozhang on 16-2-19.
 */
public class DrayLayout extends FrameLayout {

    private ViewDragHelper mViewDragHelper;
    public DrayLayout(Context context) {
        this(context,null);
    }

    public DrayLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DrayLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //初始化
        mViewDragHelper = ViewDragHelper.create(this,1.0f,mCallback);
    }

    private ViewDragHelper.Callback mCallback = new ViewDragHelper.Callback() {

        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return true;
        }

        // 当View被捕获时, 被调用
        @Override
        public void onViewCaptured(View capturedChild, int activePointerId) {
            super.onViewCaptured(capturedChild, activePointerId);
        }

        @Override
        public int getViewHorizontalDragRange(View child) {
            return super.getViewHorizontalDragRange(child);
        }

        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return super.clampViewPositionHorizontal(child, left, dx);
        }
    };

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
            return mViewDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        try {
            mViewDragHelper.processTouchEvent(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
