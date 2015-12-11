// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.g;

import e.c.a;
import e.h;

class g
    implements a
{

    private final a a;
    private final h b;
    private final long c;

    public g(a a1, h h1, long l)
    {
        a = a1;
        b = h1;
        c = l;
    }

    public void a()
    {
        if (!b.c()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (c <= System.currentTimeMillis())
        {
            continue; /* Loop/switch isn't completed */
        }
        long l = c - System.currentTimeMillis();
        if (l <= 0L)
        {
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            Thread.sleep(l);
        }
        catch (InterruptedException interruptedexception)
        {
            Thread.currentThread().interrupt();
            throw new RuntimeException(interruptedexception);
        }
        if (b.c()) goto _L1; else goto _L3
_L3:
        a.a();
        return;
    }
}
