// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

class Solid extends View
{

    private Paint aboveWavePaint;
    private Paint blowWavePaint;

    public Solid(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public Solid(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        context = new android.widget.LinearLayout.LayoutParams(-1, -2);
        context.weight = 1.0F;
        setLayoutParams(context);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawRect(getLeft(), 0.0F, getRight(), getBottom(), blowWavePaint);
        canvas.drawRect(getLeft(), 0.0F, getRight(), getBottom(), aboveWavePaint);
    }

    public void setAboveWavePaint(Paint paint)
    {
        aboveWavePaint = paint;
    }

    public void setBlowWavePaint(Paint paint)
    {
        blowWavePaint = paint;
    }
}
