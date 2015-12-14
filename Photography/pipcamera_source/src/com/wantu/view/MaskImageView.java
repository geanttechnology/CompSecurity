// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;

public class MaskImageView extends ImageView
{

    private static final String TAG = "MaskImageView";
    private Canvas bitmapCanvas;
    private Rect mFrame;
    private Bitmap mMask;
    private Paint mPaint;
    private Bitmap offscreenBitmap;

    public MaskImageView(Context context)
    {
        super(context);
        mFrame = new Rect();
        init();
    }

    public MaskImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mFrame = new Rect();
        init();
    }

    private Canvas createOffscreenCanvas(int i, int j)
    {
        if (i == 0 || j == 0)
        {
            return null;
        } else
        {
            offscreenBitmap = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(offscreenBitmap);
            canvas.drawARGB(0, 0, 0, 0);
            return canvas;
        }
    }

    public Bitmap getDispalyImage(int i, int j)
    {
        int k = getWidth();
        float f = (float)i / (float)k;
        Bitmap bitmap = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Matrix matrix = getImageMatrix();
        matrix.postScale(f, f);
        setDrawingCacheEnabled(true);
        buildDrawingCache(true);
        Bitmap bitmap1 = getDrawingCache(true);
        setDrawingCacheEnabled(false);
        if (bitmap1 != null && !bitmap1.isRecycled())
        {
            canvas.drawBitmap(bitmap1, matrix, null);
        }
        return bitmap;
    }

    public Bitmap getMask()
    {
        return mMask;
    }

    public void init()
    {
        mPaint = new Paint();
        mPaint.setFilterBitmap(true);
        mPaint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_IN));
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
    }

    protected void onMeasure(int i, int j)
    {
        if (bitmapCanvas == null || i != mFrame.width() || j != mFrame.height())
        {
            bitmapCanvas = createOffscreenCanvas(i, i);
        }
        mFrame.set(0, 0, i, i);
        super.onMeasure(i, j);
    }

    public void setMask(Bitmap bitmap)
    {
        mMask = bitmap;
    }
}
