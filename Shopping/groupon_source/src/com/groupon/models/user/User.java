// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.user;

import com.groupon.models.GenericAmount;
import com.groupon.models.gift.GiftCode;
import java.util.ArrayList;
import java.util.List;

public class User
{

    public List billingRecords;
    public GenericAmount creditsAvailable;
    public GiftCode gift_code;
    public List incentiveTickets;
    public List shippingAddresses;

    public User()
    {
        shippingAddresses = new ArrayList();
    }
}
