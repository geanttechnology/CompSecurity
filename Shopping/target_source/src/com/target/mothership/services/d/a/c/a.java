// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.d.a.c;

import com.target.mothership.services.b;
import com.target.mothership.services.w;

public class a extends b
{

    private final com.target.mothership.services.d.a.a.a mRequestFactory = new com.target.mothership.services.d.a.a.a(com.target.mothership.b.a().b());

    public a()
    {
    }

    public void a(String s, w w)
    {
        a(mRequestFactory.a(s), ((com.target.mothership.services.aa) (new com.target.mothership.services.d.a.d.a())), w);
    }

    public void b(String s, w w)
    {
        a(mRequestFactory.b(s), w);
    }
}
