// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            v, u, bv

private class .x extends Drawable
{

    Bitmap a;
    Bitmap b;
    final v c;

    public void draw(Canvas canvas)
    {
        Rect rect = getBounds();
        canvas.drawBitmap(a, rect.left, rect.top, null);
        int l = (int)Math.ceil((float)(rect.width() - a.getWidth()) / (float)b.getWidth());
        int i = rect.left;
        int k = a.getWidth() + i;
        for (int j = 0; j < l; j++)
        {
            canvas.drawBitmap(b, k, rect.top, null);
            k += b.getWidth();
        }

    }

    public int getMinimumHeight()
    {
        return b.getHeight();
    }

    public int getOpacity()
    {
        return 1;
    }

    public void setAlpha(int i)
    {
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
    }

    public (v v1)
    {
        c = v1;
        super();
        a = v.a(v1).q().a(.w);
        b = v.a(v1).q().a(.x);
    }
}
