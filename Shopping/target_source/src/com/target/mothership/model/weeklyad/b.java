// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.weeklyad;

import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.common.weeklyad.ProductSlug;
import com.target.mothership.common.weeklyad.PromotionRequest;
import com.target.mothership.common.weeklyad.StoreSlug;
import com.target.mothership.model.e;
import com.target.mothership.model.h;
import com.target.mothership.model.weeklyad.handler.c;
import com.target.mothership.model.weeklyad.handler.d;
import com.target.mothership.services.apigee.n.c.a;

// Referenced classes of package com.target.mothership.model.weeklyad:
//            a

class b extends com.target.mothership.model.weeklyad.a
{

    public static final String TAG = com/target/mothership/model/weeklyad/b.getSimpleName();
    private a mServices;

    public b()
    {
        mServices = new a();
    }

    public void a(StoreIdentifier storeidentifier, com.target.mothership.model.d d1)
    {
        d1 = new e(new d(d1));
        mServices.a(storeidentifier, d1);
    }

    public void a(ProductSlug productslug, PromotionRequest promotionrequest, h h)
    {
        h = new e(new com.target.mothership.model.weeklyad.handler.b(h));
        mServices.a(productslug, promotionrequest, h);
    }

    public void a(StoreSlug storeslug, PromotionRequest promotionrequest, com.target.mothership.model.d d1)
    {
        d1 = new e(new c(d1));
        mServices.b(storeslug, promotionrequest, d1);
    }

    public void a(StoreSlug storeslug, PromotionRequest promotionrequest, h h)
    {
        h = new e(new com.target.mothership.model.weeklyad.handler.a(h));
        mServices.a(storeslug, promotionrequest, h);
    }

}
