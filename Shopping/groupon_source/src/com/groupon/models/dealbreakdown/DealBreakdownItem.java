// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.dealbreakdown;

import com.groupon.models.BookingDetails;
import com.groupon.models.GenericAmount;
import java.util.List;

public class DealBreakdownItem
{

    public List adjustments;
    public String dealOption;
    public String delivery;
    public String destinationAddress;
    public String name;
    public String optionId;
    public int quantity;
    public GenericAmount tax;
    public GenericAmount total;
    public BookingDetails travelBookingDetails;
    public GenericAmount unitPrice;

    public DealBreakdownItem()
    {
    }
}
