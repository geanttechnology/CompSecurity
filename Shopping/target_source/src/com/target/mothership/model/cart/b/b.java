// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.b;

import java.util.List;

public class b
{

    private String mAddressId;
    private List mOrderShippingParams;

    public b(String s, List list)
    {
        mAddressId = s;
        mOrderShippingParams = list;
    }

    public String a()
    {
        return mAddressId;
    }

    public List b()
    {
        return mOrderShippingParams;
    }
}
