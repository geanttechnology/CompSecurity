// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class MaskColorView extends View
{

    private static final String TAG = "MaskColorView";
    private RectF mFrame;
    private Bitmap mMask;
    private Paint mPaint;
    private int maskColor;

    public MaskColorView(Context context)
    {
        super(context);
        mFrame = new RectF();
        init();
    }

    public MaskColorView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mFrame = new RectF();
        init();
    }

    public Bitmap getMask()
    {
        return mMask;
    }

    protected void init()
    {
        mPaint = new Paint();
        mPaint.setFilterBitmap(true);
        mPaint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_IN));
    }

    protected void onDraw(Canvas canvas)
    {
        if (mMask != null)
        {
            canvas.save();
            canvas.scale(mFrame.width() / (float)mMask.getWidth(), mFrame.height() / (float)mMask.getHeight());
            int i = canvas.saveLayer(0.0F, 0.0F, mFrame.width(), mFrame.height(), null, 31);
            canvas.drawColor(maskColor);
            mPaint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_IN));
            if (mMask != null && !mMask.isRecycled())
            {
                canvas.drawBitmap(mMask, 0.0F, 0.0F, mPaint);
            }
            mPaint.setXfermode(null);
            canvas.restoreToCount(i);
            canvas.restore();
            return;
        } else
        {
            super.onDraw(canvas);
            return;
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        mFrame.set(0.0F, 0.0F, k - i, l - j);
    }

    public void setMask(Bitmap bitmap)
    {
        if (mMask != null && !mMask.isRecycled())
        {
            mMask.recycle();
            mMask = null;
        }
        mMask = bitmap;
    }

    public void setMaskColor(int i)
    {
        maskColor = i;
    }
}
