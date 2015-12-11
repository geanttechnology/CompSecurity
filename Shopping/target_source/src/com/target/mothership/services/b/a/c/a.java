// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.b.a.c;

import com.target.mothership.services.b;
import com.target.mothership.services.b.a.d.c;
import com.target.mothership.services.b.a.d.d;
import com.target.mothership.services.b.a.d.e;
import com.target.mothership.services.b.a.d.f;
import com.target.mothership.services.b.a.d.g;
import com.target.mothership.services.w;

public class a extends b
{

    private final com.target.mothership.services.b.a.a.a mRequestFactory = new com.target.mothership.services.b.a.a.a(com.target.mothership.b.a().b());

    public a()
    {
    }

    public void a(com.target.mothership.services.b.a.a.b b1, w w)
    {
        a(mRequestFactory.a(b1), ((com.target.mothership.services.aa) (new f())), w);
    }

    public void a(String s, w w)
    {
        a(mRequestFactory.a(s), ((com.target.mothership.services.aa) (new d())), w);
    }

    public void a(String s, String s1, w w)
    {
        a(mRequestFactory.a(s, s1), ((com.target.mothership.services.aa) (new g())), w);
    }

    public void b(String s, w w)
    {
        a(mRequestFactory.b(s), new e(), w);
    }

    public void b(String s, String s1, w w)
    {
        a(mRequestFactory.b(s, s1), new com.target.mothership.services.b.a.d.a(), w);
    }

    public void c(String s, w w)
    {
        a(mRequestFactory.c(s), new com.target.mothership.services.b.a.d.b(), w);
    }

    public void d(String s, w w)
    {
        a(mRequestFactory.d(s), new c(), w);
    }
}
