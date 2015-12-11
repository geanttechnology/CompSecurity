// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.b;

import java.util.List;

public class al
{

    private static final String YES = "Y";
    private List mAddressList;
    private String mCustomerOrderNumber;
    private String mIsMultipleShipment;
    private String mOrderId;
    private List mOrderItems;

    public al()
    {
    }

    public String a()
    {
        return mOrderId;
    }

    public String b()
    {
        return mCustomerOrderNumber;
    }

    public List c()
    {
        return mOrderItems;
    }

    public List d()
    {
        return mAddressList;
    }

    public boolean e()
    {
        if (mIsMultipleShipment != null)
        {
            return mIsMultipleShipment.equals("Y");
        } else
        {
            return false;
        }
    }
}
