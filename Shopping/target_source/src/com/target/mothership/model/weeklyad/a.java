// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.weeklyad;

import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.common.weeklyad.ProductSlug;
import com.target.mothership.common.weeklyad.PromotionRequest;
import com.target.mothership.common.weeklyad.StoreSlug;
import com.target.mothership.model.c;
import com.target.mothership.model.d;
import com.target.mothership.model.h;

public abstract class a extends c
{

    public a()
    {
    }

    public abstract void a(StoreIdentifier storeidentifier, d d);

    public abstract void a(ProductSlug productslug, PromotionRequest promotionrequest, h h);

    public abstract void a(StoreSlug storeslug, PromotionRequest promotionrequest, d d);

    public abstract void a(StoreSlug storeslug, PromotionRequest promotionrequest, h h);
}
