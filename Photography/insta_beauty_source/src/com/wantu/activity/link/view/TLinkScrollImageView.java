// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.link.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import biu;
import bpn;
import wantu.sephiroth.android.library.imagezoom.MaskScrollImageViewTouch;

public class TLinkScrollImageView extends FrameLayout
{

    private String TAG;
    private Bitmap centerSrcBmp;
    private MaskScrollImageViewTouch centerView;

    public TLinkScrollImageView(Context context, Bitmap bitmap)
    {
        super(context);
        TAG = "TCollageScrollImageView";
        centerSrcBmp = bitmap;
        createSubViews(context, bitmap);
    }

    private void createSubViews(Context context, Bitmap bitmap)
    {
        centerView = new MaskScrollImageViewTouch(context);
        centerView.setOnClickListener(new biu(this));
        centerView.setImageBitmap(bitmap);
        context = new android.widget.FrameLayout.LayoutParams(-1, -1);
        context.gravity = 51;
        addView(centerView, context);
    }

    public Bitmap getCenterBitmap()
    {
        return centerSrcBmp;
    }

    public MaskScrollImageViewTouch getCenterView()
    {
        return centerView;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        return false;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
    }

    public void renderInCanvas(Canvas canvas)
    {
        if (centerView != null)
        {
            canvas.save();
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)centerView.getLayoutParams();
            canvas.translate(layoutparams.leftMargin, layoutparams.topMargin);
            canvas.clipRect(0, 0, centerView.getWidth(), centerView.getHeight());
            centerView.renderInCanvas(canvas);
            canvas.restore();
        }
    }

    public void setImageMovingDelegate(bpn bpn)
    {
        if (centerView != null)
        {
            centerView.setMovingListener(bpn);
        }
    }

    public void setImageTouchViewScrollEnabled(boolean flag)
    {
        if (centerView != null)
        {
            centerView.setScrollEnabled(flag);
        }
    }

    public void setLongClickDelegate(android.view.View.OnLongClickListener onlongclicklistener)
    {
        if (centerView != null)
        {
            centerView.setOnLongClickListener(onlongclicklistener);
        }
    }

    public void updateCenterViewImage(Bitmap bitmap)
    {
        centerSrcBmp = bitmap;
        if (centerView != null)
        {
            centerView.setImageBitmap(bitmap);
        }
    }

    public void updateCenterViewImageWithSameScale(Bitmap bitmap)
    {
        centerSrcBmp = bitmap;
        if (centerView != null)
        {
            centerView.setImageBitmap(bitmap, false);
        }
    }
}
