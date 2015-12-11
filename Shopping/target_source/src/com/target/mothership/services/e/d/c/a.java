// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.d.c;

import com.target.mothership.common.params.PageItemParams;
import com.target.mothership.services.b;
import com.target.mothership.services.w;

public class a extends b
{

    private final com.target.mothership.services.e.d.a.a mRequestFactory = new com.target.mothership.services.e.d.a.a(com.target.mothership.b.a().b());

    public a()
    {
    }

    public void a(PageItemParams pageitemparams, w w)
    {
        a(mRequestFactory.a(pageitemparams), com/target/mothership/services/e/d/b/a, w);
    }

    public void a(String s, PageItemParams pageitemparams, w w)
    {
        a(mRequestFactory.a(s, pageitemparams), com/target/mothership/services/e/d/b/a, w);
    }

    public void b(PageItemParams pageitemparams, w w)
    {
        a(mRequestFactory.b(pageitemparams), com/target/mothership/services/e/d/b/a, w);
    }

    public void c(PageItemParams pageitemparams, w w)
    {
        a(mRequestFactory.c(pageitemparams), com/target/mothership/services/e/d/b/a, w);
    }
}
