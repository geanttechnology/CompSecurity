// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.d.a;

import com.target.mothership.common.page_item.d;
import com.target.mothership.common.params.PageItemParams;
import com.target.mothership.common.product.EndecaId;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.services.f.a.c;
import com.target.mothership.services.f.a.e;
import com.target.mothership.util.o;
import java.util.Map;

public class a extends e
{

    private static final com.target.mothership.services.f.a.b.a ENDECA = new com.target.mothership.services.f.a.b.a("endecaId");
    private static final c GET_CATEGORY_PAGE_ITEMS;
    private static final c GET_CUSTOM_PAGE_ITEMS;
    private static final c GET_DEALS_PAGE_ITEMS;
    private static final c GET_FEATURED_PAGE_ITEMS;
    private static final com.target.mothership.services.f.a.b.a PAGE_ID = new com.target.mothership.services.f.a.b.a("pageId");
    private static final com.target.mothership.services.f.a.b.a STORE_ID = new com.target.mothership.services.f.a.b.a("storeId");
    private static final com.target.mothership.services.f.a.b.a WHERE = new com.target.mothership.services.f.a.b.a("where");

    public a(com.target.mothership.services.f.b.a a1)
    {
        super(a1);
    }

    private Map d(PageItemParams pageitemparams)
    {
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        Object obj = (StoreIdentifier)pageitemparams.c().d();
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = ((StoreIdentifier) (obj)).a();
        }
        if (o.g(((String) (obj))))
        {
            a1.put(STORE_ID.a(), obj);
        }
        obj = (d)pageitemparams.b().d();
        if (obj != null && o.g(((d) (obj)).toString()))
        {
            a1.put(WHERE.a(), ((d) (obj)).toString());
        }
        obj = (EndecaId)pageitemparams.d().d();
        if (obj != null && o.g(((EndecaId) (obj)).a()))
        {
            a1.put(ENDECA.a(), ((EndecaId) (obj)).a());
        }
        a1.putAll(pageitemparams.a());
        return a1;
    }

    public com.target.mothership.services.f.a.b.b a(PageItemParams pageitemparams)
    {
        return a(GET_CATEGORY_PAGE_ITEMS, null, null, d(pageitemparams), null);
    }

    public com.target.mothership.services.f.a.b.b a(String s, PageItemParams pageitemparams)
    {
        c c1 = GET_CUSTOM_PAGE_ITEMS;
        pageitemparams = d(pageitemparams);
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        if (o.g(s))
        {
            a1.put(PAGE_ID.b(), s);
        }
        return a(c1, null, ((Map) (a1)), ((Map) (pageitemparams)), null);
    }

    public com.target.mothership.services.f.a.b.b b(PageItemParams pageitemparams)
    {
        return a(GET_DEALS_PAGE_ITEMS, null, null, d(pageitemparams), null);
    }

    public com.target.mothership.services.f.a.b.b c(PageItemParams pageitemparams)
    {
        return a(GET_FEATURED_PAGE_ITEMS, null, null, d(pageitemparams), null);
    }

    static 
    {
        GET_CATEGORY_PAGE_ITEMS = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.TGTAppData, "/v1/pages/find-phone");
        GET_DEALS_PAGE_ITEMS = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.TGTAppData, "/v1/pages/deals-phone");
        GET_CUSTOM_PAGE_ITEMS = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.TGTAppData, "/v1/pages/{pageId}");
        GET_FEATURED_PAGE_ITEMS = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.TGTAppData, "/v1/pages/featured-phone");
    }
}
