// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;


// Referenced classes of package com.a.a.a.a:
//            c, x, b

final class y
    implements c
{

    final x a;

    y(x x1)
    {
        a = x1;
        super();
    }

    public final void a(String s, String s1)
    {
        if ("no-cache".equalsIgnoreCase(s))
        {
            a.b = true;
        } else
        {
            if ("max-age".equalsIgnoreCase(s))
            {
                a.c = b.a(s1);
                return;
            }
            if ("max-stale".equalsIgnoreCase(s))
            {
                a.d = b.a(s1);
                return;
            }
            if ("min-fresh".equalsIgnoreCase(s))
            {
                a.e = b.a(s1);
                return;
            }
            if ("only-if-cached".equalsIgnoreCase(s))
            {
                a.f = true;
                return;
            }
        }
    }
}
