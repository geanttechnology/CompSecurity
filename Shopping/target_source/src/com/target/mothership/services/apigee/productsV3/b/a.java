// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.productsV3.b;

import com.target.mothership.common.product.Dpci;
import com.target.mothership.common.product.o;
import com.target.mothership.services.b;
import com.target.mothership.services.w;
import java.util.List;

public class a extends b
{

    private static final int DEFAULT_RADIUS = 250;
    private final com.target.mothership.services.apigee.productsV3.a.b mRequestFactory = new com.target.mothership.services.apigee.productsV3.a.b(com.target.mothership.b.a().b());

    public a()
    {
    }

    public void a(Dpci dpci, String s, o o, w w)
    {
        a(mRequestFactory.a(new com.target.mothership.services.apigee.productsV3.a.a(dpci, 1, s, o, Integer.valueOf(250))), com/target/mothership/services/apigee/productsV3/response/a, w);
    }

    public void a(Dpci dpci, List list, o o, w w)
    {
        a(mRequestFactory.a(new com.target.mothership.services.apigee.productsV3.a.a(dpci, 1, list, o)), com/target/mothership/services/apigee/productsV3/response/a, w);
    }
}
