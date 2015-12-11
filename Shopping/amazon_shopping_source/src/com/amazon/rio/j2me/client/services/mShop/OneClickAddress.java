// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            Address

public class OneClickAddress
{

    private Address address;
    private List paymentMethod;

    public OneClickAddress()
    {
    }

    public Address getAddress()
    {
        return address;
    }

    public List getPaymentMethod()
    {
        return paymentMethod;
    }

    public void setAddress(Address address1)
    {
        address = address1;
    }

    public void setPaymentMethod(List list)
    {
        paymentMethod = list;
    }
}
