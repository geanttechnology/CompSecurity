// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.n.a;

import com.google.a.a.e;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.common.weeklyad.ProductSlug;
import com.target.mothership.common.weeklyad.PromotionRequest;
import com.target.mothership.common.weeklyad.PromotionSlug;
import com.target.mothership.common.weeklyad.StoreSlug;
import com.target.mothership.services.f.a.b;
import com.target.mothership.services.f.a.c;
import com.target.mothership.util.o;
import java.util.Map;

public class a extends b
{

    private static final com.target.mothership.services.f.a.b.a CODE = new com.target.mothership.services.f.a.b.a("code");
    private static c HOMEPAGE;
    private static c LISTING;
    private static c PAGES;
    private static final com.target.mothership.services.f.a.b.a PREVIEW = new com.target.mothership.services.f.a.b.a("preview");
    private static final com.target.mothership.services.f.a.b.a PRODUCT_SLUG = new com.target.mothership.services.f.a.b.a("productSlug");
    private static final com.target.mothership.services.f.a.b.a STORE_REF = new com.target.mothership.services.f.a.b.a("storeRef");
    private static final com.target.mothership.services.f.a.b.a STORE_SLUG = new com.target.mothership.services.f.a.b.a("storeSlug");
    private static c STORE_SLUGS;
    private static final android.support.v4.f.a WEEKLY_AD_HEADERS = new android.support.v4.f.a() {

            
            {
                put("Accept-Encoding", "");
            }
    };

    public a(com.target.mothership.services.f.b.a a1)
    {
        super(a1);
    }

    public com.target.mothership.services.f.a.b.b a(StoreIdentifier storeidentifier)
    {
        c c1 = STORE_SLUGS;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(STORE_REF.b(), o.a(storeidentifier.a(), 4));
        return a(c1, null, ((Map) (a1)), null, ((Map) (WEEKLY_AD_HEADERS)));
    }

    public com.target.mothership.services.f.a.b.b a(ProductSlug productslug, PromotionRequest promotionrequest)
    {
        c c1 = LISTING;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        android.support.v4.f.a a2 = new android.support.v4.f.a();
        a1.put(PRODUCT_SLUG.b(), productslug.a());
        if (promotionrequest != null)
        {
            if (promotionrequest.a().b())
            {
                a2.put(CODE.a(), ((PromotionSlug)promotionrequest.a().c()).a());
            }
            if (promotionrequest.b().b())
            {
                a2.put(PREVIEW.a(), promotionrequest.b().c());
            }
        }
        return a(c1, null, ((Map) (a1)), ((Map) (a2)), ((Map) (WEEKLY_AD_HEADERS)), true);
    }

    public com.target.mothership.services.f.a.b.b a(StoreSlug storeslug, PromotionRequest promotionrequest)
    {
        c c1 = HOMEPAGE;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(STORE_SLUG.b(), storeslug.a());
        storeslug = new android.support.v4.f.a();
        if (promotionrequest != null)
        {
            if (promotionrequest.a().b())
            {
                storeslug.put(CODE.a(), ((PromotionSlug)promotionrequest.a().c()).a());
            }
            if (promotionrequest.b().b())
            {
                storeslug.put(PREVIEW.a(), promotionrequest.b().c());
            }
        }
        return a(c1, null, ((Map) (a1)), ((Map) (storeslug)), ((Map) (WEEKLY_AD_HEADERS)), true);
    }

    public com.target.mothership.services.f.a.b.b b(StoreSlug storeslug, PromotionRequest promotionrequest)
    {
        c c1 = PAGES;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        android.support.v4.f.a a2 = new android.support.v4.f.a();
        a1.put(STORE_SLUG.b(), storeslug.a());
        if (promotionrequest != null)
        {
            if (promotionrequest.a().b())
            {
                a2.put(CODE.a(), ((PromotionSlug)promotionrequest.a().c()).a());
            }
            if (promotionrequest.b().b())
            {
                a2.put(PREVIEW.a(), promotionrequest.b().c());
            }
        }
        return a(c1, null, a1, a2, WEEKLY_AD_HEADERS, true);
    }

    static 
    {
        STORE_SLUGS = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.Apigee, "/v1/promotions/weeklyad/storeslugs?storeref={storeRef}");
        HOMEPAGE = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.Apigee, "/v1/promotions/weeklyad/{storeSlug}/homepage");
        PAGES = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.Apigee, "/v1/promotions/weeklyad/{storeSlug}/pages");
        LISTING = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.Apigee, "/v1/promotions/weeklyad/listings/{productSlug}");
    }
}
