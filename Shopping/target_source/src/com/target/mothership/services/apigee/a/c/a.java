// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.a.c;

import com.target.mothership.common.product.Dpci;
import com.target.mothership.services.b;
import com.target.mothership.services.w;
import java.util.List;

public class a extends b
{

    private final com.target.mothership.services.apigee.a.a.a mRequestFactory = new com.target.mothership.services.apigee.a.a.a(com.target.mothership.b.a().b());

    public a()
    {
    }

    public void a(Dpci dpci, int i, String s, int j, w w)
    {
        a(mRequestFactory.a(dpci.b(), i, s, j), com/target/mothership/services/apigee/a/b/a, w);
    }

    public void a(Dpci dpci, int i, List list, w w)
    {
        a(mRequestFactory.a(dpci.b(), i, list), com/target/mothership/services/apigee/a/b/a, w);
    }
}
