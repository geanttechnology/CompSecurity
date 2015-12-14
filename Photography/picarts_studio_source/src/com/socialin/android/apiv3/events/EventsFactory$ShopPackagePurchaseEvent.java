// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.constants.EventParam;

public class addParam extends addParam
{

    public addParam setBrand(String s)
    {
        addParam(EventParam.BRAND, s);
        return this;
    }

    public addParam setPrice(int i)
    {
        addParam(EventParam.PRICE, Integer.valueOf(i));
        return this;
    }

    public addParam setStatus(String s)
    {
        addParam(EventParam.STATUS, s);
        return this;
    }

    public addParam setType(String s)
    {
        addParam(EventParam.TYPE, s);
        return this;
    }

    public (String s)
    {
        super("shop_package_purchase");
        addParam(EventParam.ID, s);
    }
}
