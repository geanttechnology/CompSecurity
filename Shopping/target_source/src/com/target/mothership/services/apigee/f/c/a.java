// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.f.c;

import com.target.mothership.services.apigee.f.a.f;
import com.target.mothership.services.apigee.f.a.i;
import com.target.mothership.services.apigee.f.a.j;
import com.target.mothership.services.apigee.f.b.c;
import com.target.mothership.services.apigee.f.b.d;
import com.target.mothership.services.apigee.f.b.e;
import com.target.mothership.services.apigee.f.b.g;
import com.target.mothership.services.apigee.f.b.h;
import com.target.mothership.services.apigee.f.b.o;
import com.target.mothership.services.apigee.f.b.p;
import com.target.mothership.services.b;
import com.target.mothership.services.w;

public class a extends b
{

    private final f mRequestFactory = new f(com.target.mothership.b.a().b());

    public a()
    {
    }

    public void a(com.target.mothership.services.apigee.f.a.c c1, w w)
    {
        a(mRequestFactory.a(c1), com/target/mothership/services/apigee/f/b/e, w);
    }

    public void a(com.target.mothership.services.apigee.f.a.e e1, w w)
    {
        a(mRequestFactory.a(e1), com/target/mothership/services/apigee/f/b/b, w);
    }

    public void a(com.target.mothership.services.apigee.f.a.g g1, w w)
    {
        a(mRequestFactory.a(g1), com/target/mothership/services/apigee/f/b/b, w);
    }

    public void a(i i, w w)
    {
        a(mRequestFactory.a(i), com/target/mothership/services/apigee/f/b/o, w);
    }

    public void a(w w)
    {
        a(mRequestFactory.a(), com/target/mothership/services/apigee/f/b/d, w);
    }

    public void a(String s, com.target.mothership.services.apigee.f.a.g g1, w w)
    {
        a(mRequestFactory.a(s, g1), com/target/mothership/services/apigee/f/b/b, w);
    }

    public void a(String s, j j, w w)
    {
        a(mRequestFactory.a(s, j), com/target/mothership/services/apigee/f/b/g, w);
    }

    public void a(String s, w w)
    {
        a(mRequestFactory.a(s), com/target/mothership/services/apigee/f/b/d, w);
    }

    public void a(String s, String s1, j j, w w)
    {
        a(mRequestFactory.a(s, s1, j), com/target/mothership/services/apigee/f/b/p, w);
    }

    public void a(String s, String s1, w w)
    {
        a(mRequestFactory.a(s, s1), com/target/mothership/services/apigee/f/b/h, w);
    }

    public void b(String s, w w)
    {
        a(mRequestFactory.b(s), w);
    }

    public void c(String s, w w)
    {
        a(mRequestFactory.e(s), com/target/mothership/services/apigee/f/b/c, w);
    }
}
