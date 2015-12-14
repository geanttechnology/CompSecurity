// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.RectF;
import android.os.Handler;
import wantu.sephiroth.android.library.imagezoom.ImageViewTouchBase;

public class cgf
    implements Runnable
{

    double a;
    double b;
    final double c;
    final long d;
    final double e;
    final double f;
    final ImageViewTouchBase g;

    public cgf(ImageViewTouchBase imageviewtouchbase, double d1, long l, double d2, 
            double d3)
    {
        g = imageviewtouchbase;
        c = d1;
        d = l;
        e = d2;
        f = d3;
        super();
        a = 0.0D;
        b = 0.0D;
    }

    public void run()
    {
        long l = System.currentTimeMillis();
        double d1 = Math.min(c, l - d);
        double d2 = g.mEasing.a(d1, 0.0D, e, c);
        double d3 = g.mEasing.a(d1, 0.0D, f, c);
        g.panBy(d2 - a, d3 - b);
        a = d2;
        b = d3;
        if (d1 < c)
        {
            g.mHandler.post(this);
        } else
        {
            RectF rectf = g.getCenter(true, true);
            if (rectf.left != 0.0F || rectf.top != 0.0F)
            {
                g.scrollBy(rectf.left, rectf.top);
                return;
            }
        }
    }
}
