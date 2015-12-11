// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.model;

import org.json.JSONArray;

// Referenced classes of package com.apptentive.android.sdk.model:
//            ExtendedData

public class CommerceExtendedData extends ExtendedData
{

    private static final String KEY_AFFILIATION = "affiliation";
    private static final String KEY_CURRENCY = "currency";
    private static final String KEY_ID = "id";
    private static final String KEY_ITEMS = "items";
    private static final String KEY_REVENUE = "revenue";
    private static final String KEY_SHIPPING = "shipping";
    private static final String KEY_TAX = "tax";
    private static final int VERSION = 1;

    public CommerceExtendedData()
    {
    }

    public CommerceExtendedData(Object obj, Object obj1, Number number, Number number1, Number number2, String s)
    {
        setId(obj);
        setAffiliation(obj1);
        setRevenue(number);
        setShipping(number1);
        setTax(number2);
        setCurrency(s);
    }

    public CommerceExtendedData(String s)
    {
        super(s);
    }

    public CommerceExtendedData addItem(Item item)
    {
        JSONArray jsonarray;
        if (isNull("items"))
        {
            jsonarray = new JSONArray();
            put("items", jsonarray);
        } else
        {
            jsonarray = getJSONArray("items");
        }
        jsonarray.put(item);
        return this;
    }

    protected void init()
    {
        setType(ExtendedData.Type.commerce);
        setVersion(1);
    }

    public CommerceExtendedData setAffiliation(Object obj)
    {
        put("affiliation", obj);
        return this;
    }

    public CommerceExtendedData setCurrency(String s)
    {
        put("currency", s);
        return this;
    }

    public CommerceExtendedData setId(Object obj)
    {
        put("id", obj);
        return this;
    }

    public CommerceExtendedData setRevenue(Number number)
    {
        put("revenue", number);
        return this;
    }

    public CommerceExtendedData setShipping(Number number)
    {
        put("shipping", number);
        return this;
    }

    public CommerceExtendedData setTax(Number number)
    {
        put("tax", number);
        return this;
    }
}
