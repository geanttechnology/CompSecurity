// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.d;


// Referenced classes of package com.mopub.d:
//            e, l, n

private final class d
    implements Runnable
{

    final e a;
    private final l b;
    private final n c;
    private final Runnable d;

    public final void run()
    {
        if (!b.h) goto _L2; else goto _L1
_L1:
        b.b("canceled-at-delivery");
_L5:
        return;
_L2:
        boolean flag;
        if (c.c == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L4; else goto _L3
_L3:
        b.a(c.a);
_L6:
        l l1;
        s s;
        if (c.d)
        {
            b.a("intermediate-response");
        } else
        {
            b.b("done");
        }
        if (d != null)
        {
            d.run();
            return;
        }
        if (true) goto _L5; else goto _L4
_L4:
        l1 = b;
        s = c.c;
        if (l1.d != null)
        {
            l1.d.a(s);
        }
          goto _L6
    }

    public le(e e1, l l1, n n1, Runnable runnable)
    {
        a = e1;
        super();
        b = l1;
        c = n1;
        d = runnable;
    }
}
