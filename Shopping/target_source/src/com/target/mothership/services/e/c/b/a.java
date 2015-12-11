// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.c.b;

import com.target.mothership.services.b;
import com.target.mothership.services.w;

public class a extends b
{

    private com.target.mothership.services.e.c.a.b mRequestFactory;

    public a()
    {
        mRequestFactory = new com.target.mothership.services.e.c.a.b(com.target.mothership.b.a().b());
    }

    public void a(com.target.mothership.services.e.c.a.a a1, w w)
    {
        a(mRequestFactory.a(a1), w);
    }

    public void a(com.target.mothership.services.e.c.a.a a1, String s, w w)
    {
        a(mRequestFactory.a(a1, s), w);
    }

    public void a(String s, w w)
    {
        a(mRequestFactory.a(s), w);
    }
}
