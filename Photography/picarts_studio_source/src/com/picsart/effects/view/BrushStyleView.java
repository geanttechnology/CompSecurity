// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.socialin.android.util.c;

public class BrushStyleView extends ImageView
{

    private Bitmap a;
    private Canvas b;
    private Paint c;
    private BlurMaskFilter d;
    private float e;
    private String f;

    public BrushStyleView(Context context, int i, int j)
    {
        super(context);
        a = null;
        b = new Canvas();
        c = new Paint(1);
        d = null;
        e = 50F;
        setParams(i, j);
    }

    public BrushStyleView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = null;
        b = new Canvas();
        c = new Paint(1);
        d = null;
        e = 50F;
        setParams(255, 100);
    }

    public void setBmpTag(String s)
    {
        f = s;
    }

    public void setParams(int i, int j)
    {
        float f1 = (e * (float)j) / 100F;
        int k = Math.round((e + f1) * 2.0F);
        if (a != null)
        {
            com.socialin.android.util.c.a(a, f);
            a = null;
        }
        if (a == null)
        {
            a = com.socialin.android.util.c.a(k, k, android.graphics.Bitmap.Config.ARGB_8888, f);
            b.setBitmap(a);
        }
        b.drawARGB(0, 0, 0, 0);
        if (j > 0)
        {
            d = new BlurMaskFilter(f1, android.graphics.BlurMaskFilter.Blur.NORMAL);
        } else
        {
            d = null;
        }
        c.setColor(-1);
        c.setAlpha(i);
        c.setMaskFilter(d);
        b.drawCircle((float)k / 2.0F, (float)k / 2.0F, e, c);
        setImageBitmap(a);
        invalidate();
    }
}
