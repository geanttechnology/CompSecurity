// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.h.c;

import com.target.mothership.services.b;
import com.target.mothership.services.e.h.b.f;
import com.target.mothership.services.e.h.b.i;
import com.target.mothership.services.e.i.h;
import com.target.mothership.services.w;
import java.util.List;

public class a extends b
{

    private com.target.mothership.services.e.h.a.a mRequestFactory;

    public a()
    {
        mRequestFactory = new com.target.mothership.services.e.h.a.a(com.target.mothership.b.a().b());
    }

    public void a(int j, w w)
    {
        a(mRequestFactory.a(j), com/target/mothership/services/e/h/b/i, w);
    }

    public void a(String s, int j, int k, w w)
    {
        a(mRequestFactory.a(s, j, k), com/target/mothership/services/e/h/b/f, w);
    }

    public void a(List list, w w)
    {
        a(mRequestFactory.a(list), ((com.target.mothership.services.aa) (new h())), w);
    }
}
