// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

public class PrimeOneClickShippingOffers
{

    private String note;
    private List shippingOffers;

    public PrimeOneClickShippingOffers()
    {
    }

    public String getNote()
    {
        return note;
    }

    public List getShippingOffers()
    {
        return shippingOffers;
    }

    public void setNote(String s)
    {
        note = s;
    }

    public void setShippingOffers(List list)
    {
        shippingOffers = list;
    }
}
