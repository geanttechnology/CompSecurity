// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.p.a;

import com.shazam.android.persistence.n.b;

// Referenced classes of package com.shazam.android.p.a:
//            b, g, i

public final class a
{

    private final i a;
    private final g b;
    private final com.shazam.android.p.a.b c;

    public a(i i, g g1, com.shazam.android.p.a.b b1)
    {
        a = i;
        b = g1;
        c = b1;
    }

    public final void a(com.shazam.android.ag.a a1, b b1)
    {
        String s1 = a1.d;
        String s = b1.h("applicationChannel");
        b1 = s;
        if (s == null)
        {
            b1 = "";
        }
        s = c.a();
        if (com.shazam.b.e.a.c(s))
        {
            a1.c(s);
        }
        s = b.a();
        if (s != null)
        {
            (new StringBuilder("Preload info: '")).append(s).append("'");
            if ("".equals(s))
            {
                b1 = null;
            } else
            {
                b1 = s;
            }
            a1.c(b1);
        } else
        if (!"AMAZON".equals(s1) && !"AMAZON".equals(b1))
        {
            if (com.shazam.b.e.a.a(s1) && com.shazam.b.e.a.c(b1))
            {
                a1.c(b1);
                return;
            }
            if (!com.shazam.b.e.a.c(s1) || !com.shazam.b.e.a.a(b1))
            {
                if (com.shazam.b.e.a.c(s1) && com.shazam.b.e.a.c(b1))
                {
                    a1.c(b1);
                    return;
                }
                if (com.shazam.b.e.a.a(s1))
                {
                    com.shazam.b.e.a.a(b1);
                    return;
                }
            }
        }
    }
}
