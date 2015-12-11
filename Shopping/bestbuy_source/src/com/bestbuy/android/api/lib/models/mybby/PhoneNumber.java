// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.mybby;

import org.json.JSONObject;

class PhoneNumber
{

    private String areaCode;
    private String countryCode;
    private boolean isPrimary;
    private String number;
    private String typeCode;

    PhoneNumber()
    {
    }

    public static PhoneNumber loadData(JSONObject jsonobject)
    {
        PhoneNumber phonenumber = new PhoneNumber();
        phonenumber.areaCode = jsonobject.optString("areaCode");
        phonenumber.countryCode = jsonobject.optString("countryCode");
        phonenumber.number = jsonobject.optString("number");
        phonenumber.typeCode = jsonobject.optString("typeCode");
        phonenumber.isPrimary = jsonobject.optBoolean("primary");
        return phonenumber;
    }

    public String getAreaCode()
    {
        return areaCode;
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    public String getNumber()
    {
        return number;
    }

    public String getTypeCode()
    {
        return typeCode;
    }

    public boolean isPrimary()
    {
        return isPrimary;
    }
}
