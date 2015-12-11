// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.conversiontracking;

import java.util.List;

// Referenced classes of package com.google.ads.conversiontracking:
//            h, j, i

private class <init>
    implements Runnable
{

    final h a;

    public void run()
    {
label0:
        {
            synchronized (h.a(a))
            {
                if (h.b(a) && j.d(h.c(a)) && !h.d(a))
                {
                    break label0;
                }
            }
            return;
        }
        h.f(a).addAll(h.e(a).a(100L));
        j.c(h.c(a));
        h.a(a, true);
        h.a(a).notify();
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private (h h1)
    {
        a = h1;
        super();
    }

    a(h h1, a a1)
    {
        this(h1);
    }
}
