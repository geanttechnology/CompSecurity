// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.f.c;

import com.target.mothership.services.apigee.f.a.a;
import com.target.mothership.services.apigee.f.a.f;
import com.target.mothership.services.apigee.f.a.l;
import com.target.mothership.services.apigee.f.b.j;
import com.target.mothership.services.apigee.f.b.k;
import com.target.mothership.services.apigee.f.b.n;
import com.target.mothership.services.w;

public class b extends com.target.mothership.services.b
{

    private final f mRequestFactory = new f(com.target.mothership.b.a().b());

    public b()
    {
    }

    public void a(String s, a a1, w w)
    {
        a(mRequestFactory.a(s, a1), com/target/mothership/services/apigee/f/b/n, w);
    }

    public void a(String s, com.target.mothership.services.apigee.f.a.b b1, w w)
    {
        a(mRequestFactory.a(s, b1), com/target/mothership/services/apigee/f/b/n, w);
    }

    public void a(String s, w w)
    {
        a(mRequestFactory.c(s), com/target/mothership/services/apigee/f/b/j, w);
    }

    public void a(String s, String s1, l l, w w)
    {
        a(mRequestFactory.a(s, s1, l), com/target/mothership/services/apigee/f/b/n, w);
    }

    public void a(String s, String s1, String s2, w w)
    {
        a(mRequestFactory.a(s, s1, s2), w);
    }

    public void b(String s, w w)
    {
        a(mRequestFactory.d(s), com/target/mothership/services/apigee/f/b/k, w);
    }
}
