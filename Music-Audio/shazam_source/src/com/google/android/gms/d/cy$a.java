// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;


// Referenced classes of package com.google.android.gms.d:
//            cy, hx, is

private final class d
    implements Runnable
{

    final cy a;
    private final hx b;
    private final is c;
    private final Runnable d;

    public final void run()
    {
        if (!b.j) goto _L2; else goto _L1
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
        hx hx1;
        kq kq;
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
        hx1 = b;
        kq = c.c;
        if (hx1.f != null)
        {
            hx1.f.a(kq);
        }
          goto _L6
    }

    public (cy cy1, hx hx1, is is1, Runnable runnable)
    {
        a = cy1;
        super();
        b = hx1;
        c = is1;
        d = runnable;
    }
}
