// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

// Referenced classes of package com.millennialmedia.android:
//            e

private static class OKE extends Drawable
{

    protected boolean a;
    protected final Paint b = new Paint();

    public void draw(Canvas canvas)
    {
        Rect rect = copyBounds();
        int i = rect.right - rect.left;
        int j = rect.bottom - rect.top;
        float f = (float)i / 6F;
        b.setStrokeWidth(f);
        char c1;
        if (a)
        {
            c1 = '\377';
        } else
        {
            c1 = 'P';
        }
        b.setARGB(255, c1, c1, c1);
        canvas.drawLine(f / 2.0F, f / 2.0F, (float)i - f / 2.0F, (float)j - f / 2.0F, b);
        canvas.drawLine((float)i - f / 2.0F, f / 2.0F, f / 2.0F, (float)j - f / 2.0F, b);
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

    le()
    {
        a = true;
        a = true;
        b.setAntiAlias(true);
        b.setStyle(android.graphics.t.Style.STROKE);
    }
}
