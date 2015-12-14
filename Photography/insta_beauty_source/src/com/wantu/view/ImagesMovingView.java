// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import bpn;
import com.instabeauty.application.InstaBeautyApplication;
import java.util.List;

public class ImagesMovingView extends View
{

    private String TAG;
    private Rect currentRect;
    private Bitmap mBitmap;
    private BitmapDrawable mBitmapDrawable;
    private bpn mDelegate;
    private Paint mPaint;
    private List mRectsArray;
    private Rect startRect;
    private Rect targetRect;

    public ImagesMovingView(Context context)
    {
        super(context);
        TAG = "ImagesMovingView";
        init();
    }

    public ImagesMovingView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        TAG = "ImagesMovingView";
        init();
    }

    private void drawCurrentRect(Canvas canvas)
    {
        Path path = new Path();
        path.moveTo(currentRect.left, currentRect.top);
        path.lineTo(currentRect.right, currentRect.top);
        path.lineTo(currentRect.right, currentRect.bottom);
        path.lineTo(currentRect.left, currentRect.bottom);
        path.close();
        canvas.drawPath(path, mPaint);
    }

    private void drawMoveBitmap(Canvas canvas)
    {
        mBitmapDrawable.setBounds(currentRect);
        mBitmapDrawable.setAlpha(127);
        mBitmapDrawable.draw(canvas);
    }

    private void drawTargetRect(Canvas canvas)
    {
        Path path = new Path();
        path.moveTo(targetRect.left, targetRect.top);
        path.lineTo(targetRect.right, targetRect.top);
        path.lineTo(targetRect.right, targetRect.bottom);
        path.lineTo(targetRect.left, targetRect.bottom);
        path.close();
        canvas.drawPath(path, mPaint);
    }

    private Rect getTargetRectByPoint(int i, int j)
    {
        Rect rect = null;
        for (int k = 0; k < mRectsArray.size(); k++)
        {
            Rect rect1 = (Rect)mRectsArray.get(k);
            if (rect1.contains(i, j))
            {
                rect = rect1;
                if (!rectIsEqual(rect1, startRect));
            }
        }

        return rect;
    }

    private void init()
    {
        setFocusable(true);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        float f1 = InstaBeautyApplication.a().b().getResources().getDisplayMetrics().density;
        float f = 4F;
        if (f1 > 2.0F)
        {
            f = 8F;
        }
        mPaint.setStrokeWidth(f);
        mPaint.setStyle(android.graphics.Paint.Style.STROKE);
        mPaint.setColor(-256);
    }

    private boolean rectIsEqual(Rect rect, Rect rect1)
    {
        while (rect == null || rect1 == null || rect.left != rect1.left || rect.top != rect1.top || rect.bottom != rect1.bottom || rect.right != rect1.right) 
        {
            return false;
        }
        return true;
    }

    public Rect getStartRect()
    {
        return startRect;
    }

    public Rect getTargetRect()
    {
        return targetRect;
    }

    public void movePosition(int i, int j, int k, int l)
    {
        if (currentRect != null && targetRect != null)
        {
            currentRect.left = startRect.left + i;
            currentRect.right = startRect.right + i;
            currentRect.top = startRect.top + j;
            currentRect.bottom = startRect.bottom + j;
            Rect rect = getTargetRectByPoint(k, l);
            if (rect != null)
            {
                targetRect.left = rect.left;
                targetRect.right = rect.right;
                targetRect.top = rect.top;
                targetRect.bottom = rect.bottom;
            }
            invalidate();
        }
    }

    protected void onDraw(Canvas canvas)
    {
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" onDraw: ").toString());
        if (mBitmapDrawable != null)
        {
            drawMoveBitmap(canvas);
        }
        if (currentRect != null)
        {
            drawCurrentRect(canvas);
        }
        if (targetRect != null)
        {
            drawTargetRect(canvas);
        }
    }

    public void setDelegate(bpn bpn)
    {
        mDelegate = bpn;
    }

    public void setStartRectAndBitmap(Rect rect, Bitmap bitmap)
    {
        if (rect != null)
        {
            startRect = new Rect(rect);
            currentRect = new Rect(rect);
            float f = InstaBeautyApplication.a().b().getResources().getDisplayMetrics().density;
            currentRect.left = currentRect.left;
            currentRect.top = currentRect.top;
            targetRect = new Rect(rect);
        }
        mBitmap = bitmap;
        if (mBitmap != null && currentRect != null)
        {
            mBitmapDrawable = new BitmapDrawable(mBitmap);
            mBitmapDrawable.setBounds(currentRect);
        }
        invalidate();
    }

    public void setTargetRects(List list)
    {
        mRectsArray = list;
    }
}
