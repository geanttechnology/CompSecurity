// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.n.c;

import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.common.weeklyad.ProductSlug;
import com.target.mothership.common.weeklyad.PromotionRequest;
import com.target.mothership.common.weeklyad.StoreSlug;
import com.target.mothership.services.apigee.n.b.c;
import com.target.mothership.services.apigee.n.b.d;
import com.target.mothership.services.b;
import com.target.mothership.services.w;

public class a extends b
{

    private final com.target.mothership.services.apigee.n.a.a mRequestFactory = new com.target.mothership.services.apigee.n.a.a(com.target.mothership.b.a().b());

    public a()
    {
    }

    public void a(StoreIdentifier storeidentifier, w w)
    {
        a(mRequestFactory.a(storeidentifier), com/target/mothership/services/apigee/n/b/d, w);
    }

    public void a(ProductSlug productslug, PromotionRequest promotionrequest, w w)
    {
        a(mRequestFactory.a(productslug, promotionrequest), com/target/mothership/services/apigee/n/b/b, w);
    }

    public void a(StoreSlug storeslug, PromotionRequest promotionrequest, w w)
    {
        a(mRequestFactory.a(storeslug, promotionrequest), com/target/mothership/services/apigee/n/b/a, w);
    }

    public void b(StoreSlug storeslug, PromotionRequest promotionrequest, w w)
    {
        a(mRequestFactory.b(storeslug, promotionrequest), com/target/mothership/services/apigee/n/b/c, w);
    }
}
