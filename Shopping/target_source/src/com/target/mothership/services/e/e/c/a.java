// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.e.c;

import com.target.mothership.common.params.ProductRecommendationsParam;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.services.b;
import com.target.mothership.services.e.e.b.d;
import com.target.mothership.services.e.i.c;
import com.target.mothership.services.w;

public class a extends b
{

    private com.target.mothership.services.e.e.a.b mRequestFactory;

    public a()
    {
        mRequestFactory = new com.target.mothership.services.e.e.a.b(com.target.mothership.b.a().b());
    }

    public void a(ProductRecommendationsParam productrecommendationsparam, w w)
    {
        a(mRequestFactory.a(productrecommendationsparam), com/target/mothership/services/e/e/b/d, w);
    }

    public void a(ProductSummaryParam productsummaryparam, w w)
    {
        a(mRequestFactory.a(productsummaryparam), ((com.target.mothership.services.aa) (new c())), w);
    }

    public void a(com.target.mothership.services.e.e.a.a a1, w w)
    {
        a(mRequestFactory.a(a1), ((com.target.mothership.services.aa) (new com.target.mothership.services.e.i.a())), w);
    }

    public void a(String s, w w)
    {
        a(mRequestFactory.a(s), com/target/mothership/services/e/e/b/a, w);
    }

    public void b(ProductSummaryParam productsummaryparam, w w)
    {
        a(mRequestFactory.b(productsummaryparam), new c(), w);
    }

    public void b(com.target.mothership.services.e.e.a.a a1, w w)
    {
        a(mRequestFactory.b(a1), new c(), w);
    }
}
