// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a;

import com.facebook.ads.a.f.s;
import com.facebook.ads.b;

// Referenced classes of package com.facebook.ads.a:
//            a

public final class c
{

    final a a;
    private final String b;

    public c(a a1, String s1)
    {
        String s2 = s1;
        if (s.a(s1))
        {
            s2 = a1.p;
        }
        a = a1;
        b = s2;
    }

    public final b a()
    {
        if (a.q)
        {
            return new b(a.o, b);
        } else
        {
            return new b(a.a.o, a.a.p);
        }
    }
}
