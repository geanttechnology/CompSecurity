// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.a.a;

import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.services.f.a.c;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a extends com.target.mothership.services.f.a.a
{

    private static final com.target.mothership.services.f.a.b.a LOCATION_IDS = new com.target.mothership.services.f.a.b.a("location_ids");
    private static final com.target.mothership.services.f.a.b.a NEAR_BY = new com.target.mothership.services.f.a.b.a("nearby");
    private static final com.target.mothership.services.f.a.b.a PRODUCT_ID = new com.target.mothership.services.f.a.b.a("product_id");
    private static final c PRODUCT_STORE_AVAILABILITY_SEARCH;
    private static final com.target.mothership.services.f.a.b.a REQUESTED_QUANTITY = new com.target.mothership.services.f.a.b.a("requested_quantity");
    private static final com.target.mothership.services.f.a.b.a STORE_SEARCH_LIMIT = new com.target.mothership.services.f.a.b.a("stores_limit");

    public a(com.target.mothership.services.f.b.a a1)
    {
        super(a1);
    }

    private static String a(List list)
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = list.iterator();
        for (int i = 1; iterator.hasNext(); i++)
        {
            stringbuilder.append(((StoreIdentifier)iterator.next()).a());
            if (i < list.size())
            {
                stringbuilder.append(',');
            }
        }

        return stringbuilder.toString();
    }

    public com.target.mothership.services.f.a.b.b a(String s, int i, String s1, int j)
    {
        c c1 = PRODUCT_STORE_AVAILABILITY_SEARCH;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(PRODUCT_ID.b(), s);
        a1.put(REQUESTED_QUANTITY.b(), String.valueOf(i));
        s = new android.support.v4.f.a();
        s.put(NEAR_BY.a(), s1);
        s.put(STORE_SEARCH_LIMIT.a(), String.valueOf(j));
        return a(c1, null, ((Map) (a1)), ((Map) (s)), null);
    }

    public com.target.mothership.services.f.a.b.b a(String s, int i, List list)
    {
        c c1 = PRODUCT_STORE_AVAILABILITY_SEARCH;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(PRODUCT_ID.b(), s);
        a1.put(REQUESTED_QUANTITY.b(), String.valueOf(i));
        s = new android.support.v4.f.a();
        s.put(LOCATION_IDS.a(), a(list));
        return a(c1, null, ((Map) (a1)), ((Map) (s)), null);
    }

    static 
    {
        PRODUCT_STORE_AVAILABILITY_SEARCH = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.ApigeeSecure, "/available_to_promise/v2/{product_id}/search?multichannel_option=none&inventory_type=stores&channel_id=ESTORE&field_groups=location_summary&requested_quantity={requested_quantity}");
    }
}
