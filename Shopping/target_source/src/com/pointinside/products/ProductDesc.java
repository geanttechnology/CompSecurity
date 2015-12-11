// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import org.json.JSONException;
import org.json.JSONObject;

public class ProductDesc
{

    private static final String KEY_TYPE_METAPRODUCT = "metaproductId";
    private static final String KEY_TYPE_PRODUCT = "productId";
    private static final String KEY_TYPE_TERM = "term";
    private String mLookupKeyType;
    private String mLookupValue;

    private ProductDesc(String s, String s1)
    {
        mLookupValue = s;
        mLookupKeyType = s1;
    }

    public static ProductDesc createWithMetaproductId(String s)
    {
        return new ProductDesc(s, "metaproductId");
    }

    public static ProductDesc createWithProductId(String s)
    {
        return new ProductDesc(s, "productId");
    }

    public static ProductDesc createWithTerm(String s)
    {
        return new ProductDesc(s, "term");
    }

    public JSONObject getAsJsonObject()
        throws JSONException
    {
        return (new JSONObject()).put(mLookupKeyType, mLookupValue);
    }
}
