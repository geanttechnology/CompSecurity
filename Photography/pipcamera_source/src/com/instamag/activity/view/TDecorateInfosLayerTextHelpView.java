// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import java.util.List;

public class TDecorateInfosLayerTextHelpView extends View
{

    private String TAG;
    private Paint mPaint;
    private List mRectsArray;

    public TDecorateInfosLayerTextHelpView(Context context)
    {
        super(context);
        TAG = "TDecorateInfosLayerTextHelpView";
        init();
    }

    public TDecorateInfosLayerTextHelpView(Context context, List list)
    {
        super(context);
        TAG = "TDecorateInfosLayerTextHelpView";
        init();
        mRectsArray = list;
    }

    private void drawDashRect(Canvas canvas, Rect rect)
    {
        if (rect == null)
        {
            return;
        } else
        {
            Path path = new Path();
            path.moveTo(rect.left, rect.top);
            path.lineTo(rect.right, rect.top);
            path.lineTo(rect.right, rect.bottom);
            path.lineTo(rect.left, rect.bottom);
            path.close();
            rect = new DashPathEffect(new float[] {
                5F, 5F, 5F, 5F
            }, 1.0F);
            mPaint.setPathEffect(rect);
            canvas.drawPath(path, mPaint);
            return;
        }
    }

    private void init()
    {
        float f = 2.0F;
        mPaint = new Paint();
        mPaint.setStyle(android.graphics.Paint.Style.STROKE);
        getContext().getResources().getColor(0x7f0b0053);
        mPaint.setColor(0xffff0000);
        if (getContext().getResources().getDisplayMetrics().density <= 2.0F)
        {
            f = 1.0F;
        }
        mPaint.setStrokeWidth(f);
    }

    protected void onDraw(Canvas canvas)
    {
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" onDraw: ").toString());
        if (mRectsArray != null && mRectsArray.size() > 0)
        {
            for (int i = 0; i < mRectsArray.size(); i++)
            {
                drawDashRect(canvas, (Rect)mRectsArray.get(i));
            }

        }
    }

    public void setTargetRects(List list)
    {
        mRectsArray = list;
        invalidate();
    }
}
