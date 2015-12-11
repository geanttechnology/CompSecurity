// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;

// Referenced classes of package android.support.v7:
//            ain, aij, aim, ajk, 
//            ajt, ajn, ajf, aiv

final class aii
    implements Runnable
{

    private final Bitmap a;
    private final String b;
    private final ajk c;
    private final String d;
    private final ajf e;
    private final ajn f;
    private final aim g;
    private final aiv h;

    public aii(Bitmap bitmap, ain ain1, aim aim1, aiv aiv)
    {
        a = bitmap;
        b = ain1.a;
        c = ain1.c;
        d = ain1.b;
        e = ain1.e.q();
        f = ain1.f;
        g = aim1;
        h = aiv;
    }

    private boolean a()
    {
        String s = g.a(c);
        return !d.equals(s);
    }

    public void run()
    {
        if (c.e())
        {
            ajt.a("ImageAware was collected by GC. Task is cancelled. [%s]", new Object[] {
                d
            });
            f.b(b, c.d());
            return;
        }
        if (a())
        {
            ajt.a("ImageAware is reused for another image. Task is cancelled. [%s]", new Object[] {
                d
            });
            f.b(b, c.d());
            return;
        } else
        {
            ajt.a("Display image in ImageAware (loaded from %1$s) [%2$s]", new Object[] {
                h, d
            });
            e.a(a, c, h);
            g.b(c);
            f.a(b, c.d(), a);
            return;
        }
    }
}
