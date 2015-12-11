// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.b;

import android.graphics.Bitmap;
import android.os.Handler;
import com.c.a.b.a.g;
import com.c.a.b.f.a;
import com.c.a.c.c;

// Referenced classes of package com.c.a.b:
//            i, g, j, c, 
//            d

class l
    implements Runnable
{

    private final i a;
    private final Bitmap b;
    private final j c;
    private final Handler d;

    public l(i k, Bitmap bitmap, j j1, Handler handler)
    {
        a = k;
        b = bitmap;
        c = j1;
        d = handler;
    }

    public void run()
    {
        if (a.a.u)
        {
            com.c.a.c.c.a("PostProcess image before displaying [%s]", new Object[] {
                c.b
            });
        }
        com.c.a.b.c c1 = new com.c.a.b.c(c.e.p().a(b), c, a, g.c);
        c1.a(a.a.u);
        if (c.e.s())
        {
            c1.run();
            return;
        } else
        {
            d.post(c1);
            return;
        }
    }
}
