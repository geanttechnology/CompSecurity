// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.model;

import org.json.JSONObject;

public class setCurrency extends JSONObject
{

    private static final String KEY_CATEGORY = "category";
    private static final String KEY_CURRENCY = "currency";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PRICE = "price";
    private static final String KEY_QUANTITY = "quantity";

    public setCurrency setCategory(String s)
    {
        put("category", s);
        return this;
    }

    public put setCurrency(String s)
    {
        put("currency", s);
        return this;
    }

    public put setId(Object obj)
    {
        put("id", obj);
        return this;
    }

    public put setName(Object obj)
    {
        put("name", obj);
        return this;
    }

    public put setPrice(Number number)
    {
        put("price", number);
        return this;
    }

    public put setQuantity(Number number)
    {
        put("quantity", number);
        return this;
    }

    public ()
    {
    }

    public (Object obj, Object obj1, String s, Number number, Number number1, String s1)
    {
        if (obj != null)
        {
            setId(obj);
        }
        if (obj1 != null)
        {
            setName(obj1);
        }
        if (s != null)
        {
            setCategory(s);
        }
        if (number != null)
        {
            setPrice(number);
        }
        if (number1 != null)
        {
            setQuantity(number1);
        }
        if (s1 != null)
        {
            setCurrency(s1);
        }
    }

    public setCurrency(String s)
    {
        super(s);
    }
}
