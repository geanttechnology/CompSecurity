// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.j;

import android.support.v4.f.a;
import java.util.Map;
import org.json.JSONObject;

class d
{

    static final String HAS_ADDED_PRODUCT_TO_LIST = "hasAddedProductToList";
    static final String HAS_ADDED_TO_CART = "hasAddedToCart";
    static final String HAS_ENTERED_GEOFENCE = "hasEnteredGeofence";
    static final String HAS_EXPRESSED_PURCHASED = "hasExpressedPurchased";
    static final String HAS_PURCHASED = "hasPurchased";
    static final String HAS_USED_DEEP_LINK_URI = "hasUsedDeepLinkURI";
    static final String HAS_VIEWED_PRODUCT = "hasViewedProduct";
    static final String HAS_VIEWED_SEARCH_RESULTS = "hasViewedSearchResults";
    static final String MOST_RELEVANT_STORE_ID = "mostRelevantStoreID";
    private final Map mAttrs = new a();

    d()
    {
    }

    static d a(String s, Object obj)
    {
        d d1 = new d();
        d1.b(s, obj);
        return d1;
    }

    JSONObject a()
    {
        return new JSONObject(mAttrs);
    }

    d b(String s, Object obj)
    {
        mAttrs.put(s, obj);
        return this;
    }
}
