// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.weeklyad;

import com.target.mothership.b;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.common.weeklyad.ProductSlug;
import com.target.mothership.common.weeklyad.PromotionRequest;
import com.target.mothership.common.weeklyad.StoreSlug;
import com.target.mothership.model.a;
import com.target.mothership.model.d;
import com.target.mothership.model.h;

// Referenced classes of package com.target.mothership.model.weeklyad:
//            d, b, a

public class c extends a
{

    private com.target.mothership.model.weeklyad.a mDataSource;

    public c()
    {
        if (b.a().m())
        {
            mDataSource = new com.target.mothership.model.weeklyad.d();
            return;
        } else
        {
            mDataSource = new com.target.mothership.model.weeklyad.b();
            return;
        }
    }

    public void a(StoreIdentifier storeidentifier, d d1)
    {
        mDataSource.a(storeidentifier, d1);
    }

    public void a(ProductSlug productslug, PromotionRequest promotionrequest, h h)
    {
        mDataSource.a(productslug, promotionrequest, h);
    }

    public void a(StoreSlug storeslug, PromotionRequest promotionrequest, d d1)
    {
        mDataSource.a(storeslug, promotionrequest, d1);
    }

    public void a(StoreSlug storeslug, PromotionRequest promotionrequest, h h)
    {
        mDataSource.a(storeslug, promotionrequest, h);
    }

    public void a(StoreSlug storeslug, h h)
    {
        mDataSource.a(storeslug, null, h);
    }
}
