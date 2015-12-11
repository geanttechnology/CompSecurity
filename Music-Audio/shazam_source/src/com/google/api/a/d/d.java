// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d;

import com.google.api.a.f.a.a.a.a.c;
import com.google.api.a.f.b.a.a.a.a.a;
import com.google.api.a.g.z;

// Referenced classes of package com.google.api.a.d:
//            l, r, p, m

public final class d
    implements l, r
{

    private final String a;
    private final String b;

    public d(String s, String s1)
    {
        a = (String)c.a(s);
        b = (String)c.a(s1);
    }

    public final void a(p p1)
    {
        p1.a = this;
    }

    public final void b(p p1)
    {
        m m1 = p1.b;
        String s = a;
        p1 = b;
        s = String.valueOf(String.valueOf((String)c.a(s)));
        p1 = String.valueOf(String.valueOf((String)c.a(p1)));
        p1 = String.valueOf(com.google.api.a.f.b.a.a.a.a.a.a(z.a((new StringBuilder(s.length() + 1 + p1.length())).append(s).append(":").append(p1).toString())));
        if (p1.length() != 0)
        {
            p1 = "Basic ".concat(p1);
        } else
        {
            p1 = new String("Basic ");
        }
        m1.a(p1);
    }
}
