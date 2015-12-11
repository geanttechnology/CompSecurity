// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.a;

import com.offerup.android.e.c;

// Referenced classes of package com.offerup.android.g.a:
//            h

final class i
{

    private h a;

    i(h h1)
    {
        a = h1;
        super();
    }

    public final void itemReceived(c c1)
    {
        c1 = c1.a();
        if (a.a == null)
        {
            a.a = c1;
        }
        if (a.a != null && c1 != null)
        {
            a.a = c1;
            h.a(a, false);
            if (h.a(a))
            {
                a.a(a.a);
                h.a(a, true);
            }
        }
    }
}
