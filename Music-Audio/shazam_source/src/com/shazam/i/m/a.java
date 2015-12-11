// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.m;

import com.g.c.d;
import com.g.c.n;
import com.shazam.i.b.c;

public final class a
{

    private static d a;

    public static d a()
    {
        com/shazam/i/m/a;
        JVM INSTR monitorenter ;
        d d1 = a;
        if (d1 != null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        a = new n(c.a());
_L1:
        d1 = a;
        com/shazam/i/m/a;
        JVM INSTR monitorexit ;
        return d1;
        Object obj;
        obj;
        a = d.a;
          goto _L1
        obj;
        throw obj;
    }
}
