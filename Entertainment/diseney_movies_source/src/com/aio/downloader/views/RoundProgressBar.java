// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class RoundProgressBar extends View
{

    public static final int FILL = 1;
    public static final int STROKE = 0;
    Context context;
    private Paint mCirclePaint;
    private int max;
    private Paint paint;
    private int progress;
    private int roundColor;
    private int roundProgressColor;
    private float roundWidth;
    private int style;
    private int textColor;
    private boolean textIsDisplayable;
    private float textSize;

    public RoundProgressBar(Context context1)
    {
        this(context1, null);
    }

    public RoundProgressBar(Context context1, AttributeSet attributeset)
    {
        this(context1, attributeset, 0);
    }

    public RoundProgressBar(Context context1, AttributeSet attributeset, int i)
    {
        super(context1, attributeset, i);
        paint = new Paint();
        context1 = context1.obtainStyledAttributes(attributeset, com.aio.downloader.R.styleable.RoundProgressBar);
        roundColor = context1.getColor(0, 0xffff0000);
        roundProgressColor = context1.getColor(1, 0xff00ff00);
        textColor = context1.getColor(3, 0xff00ff00);
        textSize = context1.getDimension(4, 15F);
        roundWidth = context1.getDimension(2, 8F);
        max = context1.getInteger(5, 100);
        textIsDisplayable = context1.getBoolean(6, true);
        style = context1.getInt(7, 0);
        context1.recycle();
    }

    public int getCricleColor()
    {
        return roundColor;
    }

    public int getCricleProgressColor()
    {
        return roundProgressColor;
    }

    public int getMax()
    {
        this;
        JVM INSTR monitorenter ;
        int i = max;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public int getProgress()
    {
        this;
        JVM INSTR monitorenter ;
        int i = progress;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public float getRoundWidth()
    {
        return roundWidth;
    }

    public int getTextColor()
    {
        return textColor;
    }

    public float getTextSize()
    {
        return textSize;
    }

    protected void onDraw(Canvas canvas)
    {
        RectF rectf;
        super.onDraw(canvas);
        int i = getWidth() / 2;
        int j = (int)((float)i - roundWidth / 2.0F);
        paint.setColor(roundColor);
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setStrokeWidth(roundWidth);
        paint.setAntiAlias(true);
        canvas.drawCircle(i, i, j, paint);
        Log.e("log", (new StringBuilder(String.valueOf(i))).toString());
        paint.setStrokeWidth(0.0F);
        paint.setColor(textColor);
        paint.setTextSize(textSize);
        int k = (int)(((float)progress / (float)max) * 100F);
        float f = paint.measureText((new StringBuilder(String.valueOf(k))).append("%").toString());
        if (textIsDisplayable && k != 0 && style == 0)
        {
            canvas.drawText((new StringBuilder(String.valueOf(k))).append("%").toString(), (float)i - f / 2.0F, (float)i + textSize / 2.0F, paint);
        }
        paint.setStrokeWidth(roundWidth);
        paint.setColor(roundProgressColor);
        rectf = new RectF(i - j, i - j, i + j, i + j);
        style;
        JVM INSTR tableswitch 0 1: default 324
    //                   0 325
    //                   1 361;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        canvas.drawArc(rectf, 0.0F, (progress * 360) / max, false, paint);
        return;
_L3:
        paint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        if (progress != 0)
        {
            canvas.drawArc(rectf, 0.0F, (progress * 360) / max, true, paint);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void setCricleColor(int i)
    {
        roundColor = i;
    }

    public void setCricleProgressColor(int i)
    {
        roundProgressColor = i;
    }

    public void setMax(int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (i >= 0)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new IllegalArgumentException("max not less than 0");
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        max = i;
        this;
        JVM INSTR monitorexit ;
    }

    public void setProgress(int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (i >= 0)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new IllegalArgumentException("progress not less than 0");
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        int j = i;
        if (i > max)
        {
            j = max;
        }
        if (j <= max)
        {
            progress = j;
            postInvalidate();
        }
        this;
        JVM INSTR monitorexit ;
    }

    public void setRoundWidth(float f)
    {
        roundWidth = f;
    }

    public void setTextColor(int i)
    {
        textColor = i;
    }

    public void setTextSize(float f)
    {
        textSize = f;
    }
}
