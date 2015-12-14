// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.clone;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class BrushStyleView extends View
{

    private Paint a;
    private BlurMaskFilter b;
    private float c;
    private float d;
    private float e;
    private int f;

    public BrushStyleView(Context context)
    {
        super(context);
        a = new Paint();
        b = null;
        c = 75F;
        d = 20F;
        e = d;
        f = 255;
        a();
    }

    public BrushStyleView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = new Paint();
        b = null;
        c = 75F;
        d = 20F;
        e = d;
        f = 255;
        a();
    }

    public BrushStyleView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = new Paint();
        b = null;
        c = 75F;
        d = 20F;
        e = d;
        f = 255;
        a();
    }

    private void a()
    {
        a.setAntiAlias(true);
        a.setColor(-1);
        a.setAlpha(f);
        setBackgroundColor(0);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int i = getWidth();
        int j = getHeight();
        float f1 = (int)(((float)Math.min(i, j) * e) / 100F);
        float f2 = (c * f1) / 100F / 2.0F;
        a.setStrokeWidth(f1 - f2);
        if (c > 0.0F)
        {
            b = new BlurMaskFilter(f2, android.graphics.BlurMaskFilter.Blur.NORMAL);
        } else
        {
            b = null;
        }
        a.setMaskFilter(b);
        canvas.drawCircle((float)i / 2.0F, (float)j / 2.0F, (f1 - f2 * 2.0F) / 2.0F, a);
    }

    public void setBrushMinPercent(float f1)
    {
        d = f1;
    }

    public void setBrushPercentSize(float f1)
    {
        e = d + ((100F - d) * f1) / 100F;
    }

    public void setHardness(float f1)
    {
        c = f1;
    }

    public void setOpacity(int i)
    {
        f = i;
        a.setAlpha(i);
    }
}
