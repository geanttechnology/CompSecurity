// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.a.a;

import com.google.api.a.d.ac;
import com.google.api.a.d.l;
import com.google.api.a.d.p;
import com.google.api.a.d.r;
import com.google.api.a.f.a.a.a.a.c;
import java.util.HashMap;
import java.util.Map;

public final class h
    implements l, r
{

    private final String a;
    private final String b;

    public h(String s, String s1)
    {
        a = (String)c.a(s);
        b = s1;
    }

    public final void a(p p1)
    {
        p1.a = this;
    }

    public final void b(p p1)
    {
        com.google.api.a.d.i i = p1.f;
        if (i != null)
        {
            p1 = (ac)i;
        } else
        {
            ac ac1 = new ac(new HashMap());
            p1.f = ac1;
            p1 = ac1;
        }
        p1 = com.google.api.a.g.h.b(((ac) (p1)).b);
        p1.put("client_id", a);
        if (b != null)
        {
            p1.put("client_secret", b);
        }
    }
}
