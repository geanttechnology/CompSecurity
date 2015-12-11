// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

public class FpoView extends TextView
{

    private Paint mPaint;

    public FpoView(Context context)
    {
        super(context);
        a();
    }

    public FpoView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public FpoView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private void a()
    {
        mPaint = new Paint();
        mPaint.setStyle(android.graphics.Paint.Style.STROKE);
        mPaint.setColor(0xffcccccc);
        mPaint.setStrokeWidth(2.0F);
        mPaint.setAntiAlias(true);
        setBackgroundColor(0xffeeeeee);
        setTextColor(0xff444444);
        setGravity(17);
    }

    protected void onDraw(Canvas canvas)
    {
        canvas.drawLine(0.0F, 0.0F, getWidth(), getHeight(), mPaint);
        canvas.drawLine(0.0F, getHeight(), getWidth(), 0.0F, mPaint);
        super.onDraw(canvas);
    }

    protected void onMeasure(int i, int j)
    {
        setText("");
        super.onMeasure(i, j);
        setText("FPO");
        setTextSize(Math.min((float)getMeasuredHeight() / 4F, (float)getMeasuredWidth() / 10F));
    }
}
