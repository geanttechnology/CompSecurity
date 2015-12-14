// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;

public final class a
{

    public boolean a;
    public int b;
    public float c;
    public float d;
    private int e;
    private float f;
    private Bitmap g;
    private RectF h;
    private float i;
    private float j;
    private Rect k;

    public a(Context context, int l, int i1)
    {
        f = 0.0F;
        new Rect();
        a = false;
        c = 0.0F;
        d = 0.0F;
        i = 0.0F;
        j = 0.0F;
        k = new Rect();
        e = l;
        if (l == 0)
        {
            e = 35;
        }
        f = Utils.a(e, context);
        if (g == null && i1 >= 0)
        {
            g = com.socialin.android.util.c.a(context.getResources(), i1);
        }
        float f1 = g.getWidth();
        float f2 = g.getHeight();
        float f3 = Math.min(f / f1, f / f2);
        h = new RectF(0.0F, 0.0F, Math.round(f1 * f3), Math.round(f2 * f3));
        k.set(0, 0, g.getWidth(), g.getHeight());
    }

    private void b()
    {
        if (h != null)
        {
            h.set(c - h.width() / 2.0F, d - h.height() / 2.0F, c + h.width() / 2.0F, d + h.height() / 2.0F);
        }
    }

    public final void a()
    {
        if (g != null && !g.isRecycled())
        {
            g.recycle();
        }
        g = null;
    }

    public final void a(float f1, float f2)
    {
        i = c - f1;
        j = d - f2;
    }

    public final void a(float f1, float f2, float f3)
    {
        c = i * f3 + f1;
        d = j * f3 + f2;
        b();
    }

    public final void a(Canvas canvas, Paint paint)
    {
        if (a && g != null && !g.isRecycled())
        {
            canvas.save();
            canvas.rotate(b, c, d);
            canvas.drawBitmap(g, k, h, paint);
            canvas.restore();
        }
    }

    public final void b(float f1, float f2)
    {
        c = f1;
        d = f2;
        b();
    }

    public final boolean c(float f1, float f2)
    {
        if (h != null)
        {
            return h.contains(f1, f2);
        } else
        {
            return false;
        }
    }
}
