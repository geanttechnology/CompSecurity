// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.a.a;

import com.google.api.a.d.h;
import com.google.api.a.d.l;
import com.google.api.a.d.r;
import com.google.api.a.d.v;
import com.google.api.a.f.a.a.a.a.c;
import com.google.api.a.g.b.d;
import com.google.api.a.g.g;
import com.google.api.a.g.w;
import java.util.ArrayList;
import java.util.Collection;

// Referenced classes of package com.google.api.a.a.a:
//            a, k, j

public static class b
{

    a.c.a a;
    v b;
    com.google.api.a.e.c c;
    h d;
    l e;
    String f;
    String g;
    k h;
    d i;
    r j;
    Collection k;
    g l;
    a.c.a m;
    Collection n;

    public b a(b b1)
    {
        m = b1;
        return this;
    }

    public m a(m m1)
    {
        a = (a)com.google.api.a.f.a.a.a.a.c.a(m1);
        return this;
    }

    public a.c.a a(j j1)
    {
        n.add(com.google.api.a.f.a.a.a.a.c.a(j1));
        return this;
    }

    public a.c.a a(h h1)
    {
        d = (h)com.google.api.a.f.a.a.a.a.c.a(h1);
        return this;
    }

    public a.c.a a(l l1)
    {
        e = l1;
        return this;
    }

    public e a(v v1)
    {
        b = (v)com.google.api.a.f.a.a.a.a.c.a(v1);
        return this;
    }

    public a.c.a a(com.google.api.a.e.c c1)
    {
        c = (com.google.api.a.e.c)com.google.api.a.f.a.a.a.a.c.a(c1);
        return this;
    }

    public a.c.a a(d d1)
    {
        boolean flag;
        if (h == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w.a(flag);
        i = d1;
        return this;
    }

    public i a(String s)
    {
        f = (String)com.google.api.a.f.a.a.a.a.c.a(s);
        return this;
    }

    public a.c.a a(Collection collection)
    {
        k = (Collection)com.google.api.a.f.a.a.a.a.c.a(collection);
        return this;
    }

    public a a()
    {
        return new a(this);
    }

    public nit> b(String s)
    {
        g = (String)com.google.api.a.f.a.a.a.a.c.a(s);
        return this;
    }

    public a.c(a.c c1, v v1, com.google.api.a.e.c c2, h h1, l l1, String s, String s1)
    {
        k = new ArrayList();
        l = g.a;
        n = new ArrayList();
        a(c1);
        a(v1);
        a(c2);
        a(h1);
        a(l1);
        a(s);
        b(s1);
    }
}
