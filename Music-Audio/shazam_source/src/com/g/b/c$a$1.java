// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b;

import c.h;
import c.r;

// Referenced classes of package com.g.b:
//            c

final class b extends h
{

    final c a;
    final com.g.b.a.ion b;
    final a c;

    public final void close()
    {
label0:
        {
            synchronized (c.c)
            {
                if (!c.c)
                {
                    break label0;
                }
            }
            return;
        }
        c.c = true;
        c c2 = c.c;
        c2.c = c2.c + 1;
        c1;
        JVM INSTR monitorexit ;
        super.close();
        b.ion();
        return;
        exception;
        c1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ( , r r, c c1, com.g.b.a. 1)
    {
        c = ;
        a = c1;
        b = 1;
        super(r);
    }
}
