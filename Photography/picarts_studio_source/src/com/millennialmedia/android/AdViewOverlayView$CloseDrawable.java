// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

class a extends Drawable
{

    protected final Paint a = new Paint();
    private boolean b;

    public void draw(Canvas canvas)
    {
        Rect rect = copyBounds();
        int i = rect.right - rect.left;
        int j = rect.bottom - rect.top;
        float f = (float)i / 6F;
        a.setStrokeWidth(f);
        char c;
        if (b)
        {
            c = '\377';
        } else
        {
            c = 'P';
        }
        a.setARGB(255, c, c, c);
        canvas.drawLine(f / 2.0F, f / 2.0F, (float)i - f / 2.0F, (float)j - f / 2.0F, a);
        canvas.drawLine((float)i - f / 2.0F, f / 2.0F, f / 2.0F, (float)j - f / 2.0F, a);
    }

    public int getOpacity()
    {
        return -3;
    }

    public void setAlpha(int i)
    {
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
    }

    A(boolean flag)
    {
        b = true;
        b = true;
        a.setAntiAlias(true);
        a.setStyle(android.graphics.seDrawable.a);
    }
}
