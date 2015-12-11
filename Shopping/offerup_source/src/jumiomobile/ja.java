// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.graphics.Rect;

// Referenced classes of package jumiomobile:
//            iz, ix, l, n, 
//            mr

class ja
    implements Runnable
{

    final int a;
    final int b;
    final iz c;

    ja(iz iz1, int i, int j)
    {
        c = iz1;
        a = i;
        b = j;
        super();
    }

    public void run()
    {
        double d = (double)c.a.b.a.a / (double)c.a.b.c.a;
        double d1 = (double)c.a.b.a.b / (double)c.a.b.c.b;
        c.a.g.a(d, d1);
        c.a.g.setROIXOffset(ix.c(c.a));
        c.a.g.setROIYOffset(ix.d(c.a));
        c.a.g.setROIRect(new Rect(ix.c(c.a), ix.d(c.a), ix.c(c.a) + a, ix.d(c.a) + b));
    }
}
