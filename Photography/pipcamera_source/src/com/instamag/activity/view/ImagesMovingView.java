// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import com.pipcamera.application.PIPCameraApplication;
import java.util.ArrayList;
import java.util.List;
import re;

public class ImagesMovingView extends View
{

    private String TAG;
    private Rect currentRect;
    private Bitmap mBitmap;
    private BitmapDrawable mBitmapDrawable;
    private re mDelegate;
    private Paint mPaint;
    private List mPathsArray;
    private List mRectsArray;
    private Rect startRect;
    private Rect targetRect;

    public ImagesMovingView(Context context)
    {
        super(context);
        TAG = "ImagesMovingView";
        mRectsArray = new ArrayList();
        mPathsArray = new ArrayList();
        init();
    }

    public ImagesMovingView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        TAG = "ImagesMovingView";
        mRectsArray = new ArrayList();
        mPathsArray = new ArrayList();
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
        for (int k = 0; k < mPathsArray.size(); k++)
        {
            Path path = (Path)mPathsArray.get(k);
            RectF rectf = new RectF();
            path.computeBounds(rectf, true);
            Region region = new Region();
            region.setPath(path, new Region((int)rectf.left, (int)rectf.top, (int)rectf.right, (int)rectf.bottom));
            if (region.contains(i, j))
            {
                Rect rect1 = (Rect)mRectsArray.get(k);
                rect = rect1;
                if (!rectIsEqual(rect1, startRect));
            }
        }

        return rect;
    }

    private Rect getTargetRectByPointInRects(int i, int j)
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
        float f1 = PIPCameraApplication.b().getResources().getDisplayMetrics().density;
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

    public void movePosition(int i, int j)
    {
        if (currentRect != null && targetRect != null)
        {
            currentRect.left = startRect.left + i;
            currentRect.right = startRect.right + i;
            currentRect.top = startRect.top + j;
            currentRect.bottom = startRect.bottom + j;
            Rect rect = getTargetRectByPoint(currentRect.centerX(), currentRect.centerY());
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

    public void movePosition(int i, int j, int k, int l)
    {
        if (currentRect != null && targetRect != null)
        {
            currentRect.left = startRect.left + i;
            currentRect.right = startRect.right + i;
            currentRect.top = startRect.top + j;
            currentRect.bottom = startRect.bottom + j;
            Rect rect = getTargetRectByPointInRects(k, l);
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
        if (mBitmapDrawable == null) goto _L2; else goto _L1
_L1:
        drawMoveBitmap(canvas);
_L4:
        if (targetRect != null)
        {
            drawTargetRect(canvas);
        }
        return;
_L2:
        if (currentRect != null)
        {
            drawCurrentRect(canvas);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setDelegate(re re)
    {
        mDelegate = re;
    }

    public void setStartRectAndBitmap(Rect rect, Bitmap bitmap)
    {
        if (rect != null)
        {
            startRect = new Rect(rect);
            currentRect = new Rect(rect);
            float f = PIPCameraApplication.b().getResources().getDisplayMetrics().density * 8F;
            if (bitmap == null)
            {
                f = 0.0F;
            }
            currentRect.left = (int)((float)currentRect.left + f);
            currentRect.top = (int)(f + (float)currentRect.top);
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

    public void setTargetPaths(List list)
    {
        mPathsArray = list;
    }

    public void setTargetRects(List list)
    {
        mRectsArray = list;
    }
}
