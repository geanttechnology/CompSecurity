// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import com.google.android.gms.d.ii;

// Referenced classes of package com.google.android.gms.e:
//            bh, aj

final class ai
    implements bh
{

    private final long a = 0xdbba0L;
    private final long b = 5000L;
    private final int c = 30;
    private double d;
    private long e;
    private final Object f = new Object();
    private final String g;
    private final ii h;

    public ai(String s, ii ii1)
    {
        d = c;
        g = s;
        h = ii1;
    }

    public final boolean a()
    {
        long l;
label0:
        {
            synchronized (f)
            {
                l = h.a();
                if (l - e >= b)
                {
                    break label0;
                }
                (new StringBuilder("Excessive ")).append(g).append(" detected; call ignored.");
                aj.a();
            }
            return false;
        }
        double d1;
        if (d >= (double)c)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        d1 = (double)(l - e) / (double)a;
        if (d1 <= 0.0D)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        d = Math.min(c, d1 + d);
        e = l;
        if (d < 1.0D)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        d = d - 1.0D;
        obj;
        JVM INSTR monitorexit ;
        return true;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        (new StringBuilder("Excessive ")).append(g).append(" detected; call ignored.");
        aj.a();
        obj;
        JVM INSTR monitorexit ;
        return false;
    }
}
