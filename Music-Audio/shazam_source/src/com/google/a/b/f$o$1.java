// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;

import com.google.a.g.a.j;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.google.a.b:
//            f

final class t>
    implements Runnable
{

    final Object a;
    final int b;
    final c c;
    final j d;
    final c e;

    public final void run()
    {
        try
        {
            e.e(a, b, c, d);
            return;
        }
        catch (Throwable throwable)
        {
            f.a.log(Level.WARNING, "Exception thrown during refresh", throwable);
            c.c(throwable);
            return;
        }
    }

    ger(ger ger, Object obj, int i, ger ger1, j j)
    {
        e = ger;
        a = obj;
        b = i;
        c = ger1;
        d = j;
        super();
    }
}
