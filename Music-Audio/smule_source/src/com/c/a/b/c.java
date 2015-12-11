// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.b;

import android.graphics.Bitmap;
import com.c.a.b.a.d;
import com.c.a.b.a.g;
import com.c.a.b.e.a;

// Referenced classes of package com.c.a.b:
//            j, d, i

final class c
    implements Runnable
{

    private final Bitmap a;
    private final String b;
    private final a c;
    private final String d;
    private final com.c.a.b.c.a e;
    private final d f;
    private final i g;
    private final g h;
    private boolean i;

    public c(Bitmap bitmap, j j1, i k, g g1)
    {
        a = bitmap;
        b = j1.a;
        c = j1.c;
        d = j1.b;
        e = j1.e.q();
        f = j1.f;
        g = k;
        h = g1;
    }

    private boolean a()
    {
        String s = g.a(c);
        return !d.equals(s);
    }

    void a(boolean flag)
    {
        i = flag;
    }

    public void run()
    {
        if (c.e())
        {
            if (i)
            {
                com.c.a.c.c.a("ImageAware was collected by GC. Task is cancelled. [%s]", new Object[] {
                    d
                });
            }
            f.b(b, c.d());
            return;
        }
        if (a())
        {
            if (i)
            {
                com.c.a.c.c.a("ImageAware is reused for another image. Task is cancelled. [%s]", new Object[] {
                    d
                });
            }
            f.b(b, c.d());
            return;
        }
        if (i)
        {
            com.c.a.c.c.a("Display image in ImageAware (loaded from %1$s) [%2$s]", new Object[] {
                h, d
            });
        }
        Bitmap bitmap = e.a(a, c, h);
        f.a(b, c.d(), bitmap);
        g.b(c);
    }
}
