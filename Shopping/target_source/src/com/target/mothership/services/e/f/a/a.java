// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.f.a;

import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.services.f.a.c;
import com.target.mothership.services.f.a.e;
import com.target.mothership.util.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a extends e
{

    private static final com.target.mothership.services.f.a.b.a GENERIC_TERMS = new com.target.mothership.services.f.a.b.a("genericTerms");
    private static final c HAS_PROMOTION;
    private static final c PROMOTION_DETAIL;
    private static final com.target.mothership.services.f.a.b.a SEARCH_TERM = new com.target.mothership.services.f.a.b.a("searchTerm");
    private static final com.target.mothership.services.f.a.b.a STORE_ID = new com.target.mothership.services.f.a.b.a("store-id");
    private static final com.target.mothership.services.f.a.b.a TCINS = new com.target.mothership.services.f.a.b.a("tcins");

    public a(com.target.mothership.services.f.b.a a1)
    {
        super(a1);
    }

    private String a(List list)
    {
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add(((Tcin)list.next()).b())) { }
        return o.a(arraylist, ",");
    }

    public com.target.mothership.services.f.a.b.b a(StoreIdentifier storeidentifier, Tcin tcin)
    {
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(STORE_ID.b(), storeidentifier.a());
        storeidentifier = new android.support.v4.f.a();
        storeidentifier.put(TCINS.a(), tcin.b());
        return a(PROMOTION_DETAIL, null, ((Map) (a1)), ((Map) (storeidentifier)), null);
    }

    public com.target.mothership.services.f.a.b.b a(StoreIdentifier storeidentifier, String s)
    {
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(STORE_ID.b(), storeidentifier.a());
        storeidentifier = new android.support.v4.f.a();
        storeidentifier.put(SEARCH_TERM.a(), s);
        return a(PROMOTION_DETAIL, null, ((Map) (a1)), ((Map) (storeidentifier)), null);
    }

    public com.target.mothership.services.f.a.b.b a(StoreIdentifier storeidentifier, List list, List list1)
    {
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(STORE_ID.b(), storeidentifier.a());
        storeidentifier = new android.support.v4.f.a();
        if (list != null && !list.isEmpty())
        {
            storeidentifier.put(TCINS.a(), a(list));
        }
        if (list1 != null && !list1.isEmpty())
        {
            storeidentifier.put(GENERIC_TERMS.a(), o.a(list1, ","));
        }
        return a(HAS_PROMOTION, null, ((Map) (a1)), ((Map) (storeidentifier)), null);
    }

    static 
    {
        HAS_PROMOTION = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.TGTAppData, "/v1/gen2spec/promotions/{store-id}");
        PROMOTION_DETAIL = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.TGTAppData, "/v1/promotions/search/{store-id}");
    }
}
