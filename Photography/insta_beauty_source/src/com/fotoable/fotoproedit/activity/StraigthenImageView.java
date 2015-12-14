// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class StraigthenImageView extends View
{

    private int bmpHeight;
    private int bmpWidth;
    private Paint mPaint;
    private Bitmap mSource;
    private Matrix matrix;
    private int viewHeight;
    private int viewWidth;

    public StraigthenImageView(Bitmap bitmap, Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mSource = bitmap;
        bmpWidth = bitmap.getWidth();
        bmpHeight = bitmap.getHeight();
        matrix = new Matrix();
        mPaint = new Paint();
        mPaint.setARGB(0, 0, 0, 255);
        mPaint.setAntiAlias(true);
    }

    private float getRatio(int i, int j, int k, int l)
    {
        float f = (float)i / (float)k;
        float f1 = (float)j / (float)l;
        if (f > f1)
        {
            return f;
        } else
        {
            return f1;
        }
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (mSource == null || mSource.isRecycled())
        {
            break MISSING_BLOCK_LABEL_38;
        }
        canvas.drawBitmap(mSource, matrix, mPaint);
        return;
        canvas;
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        viewWidth = android.view.View.MeasureSpec.getSize(i);
        viewHeight = android.view.View.MeasureSpec.getSize(j);
        float f = getRatio(viewWidth, viewHeight, bmpWidth, bmpHeight);
        matrix.setScale(f, f, viewWidth / 2, viewHeight / 2);
    }

    public void setRotate(float f)
    {
        matrix.setRotate(f, viewWidth / 2, viewHeight / 2);
    }
}
