// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.weeklyad;

import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.common.weeklyad.ProductSlug;
import com.target.mothership.common.weeklyad.PromotionRequest;
import com.target.mothership.common.weeklyad.StoreSlug;
import com.target.mothership.util.h;

// Referenced classes of package com.target.mothership.model.weeklyad:
//            a, b

public class d extends a
{

    private b mLiveDataSource;

    public d()
    {
        mLiveDataSource = new b();
    }

    public void a(StoreIdentifier storeidentifier, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_get_weekly_ad_store_slugs.json");
            return;
        } else
        {
            a("get_weekly_ad_store_slugs.json");
            mLiveDataSource.a(storeidentifier, d1);
            return;
        }
    }

    public void a(ProductSlug productslug, PromotionRequest promotionrequest, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            a("get_weekly_ad_listing_collection.json");
            mLiveDataSource.a(productslug, promotionrequest, h1);
            return;
        }
    }

    public void a(StoreSlug storeslug, PromotionRequest promotionrequest, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_get_weekly_ad_pages.json");
            return;
        } else
        {
            a("get_weekly_ad_pages.json");
            mLiveDataSource.a(storeslug, promotionrequest, d1);
            return;
        }
    }

    public void a(StoreSlug storeslug, PromotionRequest promotionrequest, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            a("get_weekly_ad_homepage.json");
            mLiveDataSource.a(storeslug, promotionrequest, h1);
            return;
        }
    }
}
