// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.SeekBar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MidRollSeekBar extends SeekBar
{

    private static final int CIRCLE_DIAMETER = 7;
    private List mMidrollKeys;
    private Paint mPaint;
    private RectF mRect;

    public MidRollSeekBar(Context context)
    {
        super(context);
        mRect = new RectF(0.0F, 0.0F, 7F, 7F);
        mPaint = new Paint();
        mMidrollKeys = new ArrayList();
        init();
    }

    public MidRollSeekBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mRect = new RectF(0.0F, 0.0F, 7F, 7F);
        mPaint = new Paint();
        mMidrollKeys = new ArrayList();
        init();
    }

    public MidRollSeekBar(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mRect = new RectF(0.0F, 0.0F, 7F, 7F);
        mPaint = new Paint();
        mMidrollKeys = new ArrayList();
        init();
    }

    private void init()
    {
        mPaint.setARGB(255, 255, 255, 255);
        mPaint.setAntiAlias(true);
    }

    protected void onDraw(Canvas canvas)
    {
        this;
        JVM INSTR monitorenter ;
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(getPaddingLeft(), (getHeight() - 7) / 2);
        for (Iterator iterator = mMidrollKeys.iterator(); iterator.hasNext(); canvas.restore())
        {
            Integer integer = (Integer)iterator.next();
            int i = getWidth();
            int j = getPaddingLeft();
            int k = getPaddingRight();
            canvas.save();
            canvas.translate((int)Math.round((((double)integer.intValue() * 1000D) / (double)getMax()) * (double)(i - j - k)), 0.0F);
            canvas.drawOval(mRect, mPaint);
        }

        break MISSING_BLOCK_LABEL_142;
        canvas;
        throw canvas;
        canvas.restore();
        this;
        JVM INSTR monitorexit ;
    }

    public void setMidRollKeys(List list, int i)
    {
        mMidrollKeys = list;
        setMax(i * 1000);
    }
}
