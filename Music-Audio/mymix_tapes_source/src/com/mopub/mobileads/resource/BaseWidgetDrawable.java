// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads.resource;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public abstract class BaseWidgetDrawable extends Drawable
{

    public BaseWidgetDrawable()
    {
    }

    protected void drawTextWithinBounds(Canvas canvas, Paint paint, Rect rect, String s)
    {
        paint.getTextBounds(s, 0, s.length(), rect);
        float f = (paint.descent() - paint.ascent()) / 2.0F;
        float f1 = paint.descent();
        canvas.drawText(s, getBounds().centerX(), (float)getBounds().centerY() + (f - f1), paint);
    }

    public int getOpacity()
    {
        return 0;
    }

    public void setAlpha(int i)
    {
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
    }
}
