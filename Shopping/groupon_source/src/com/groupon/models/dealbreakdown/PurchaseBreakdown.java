// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.dealbreakdown;

import com.groupon.models.BookingDetails;
import java.util.List;

public interface PurchaseBreakdown
{

    public abstract List getAdjustments();

    public abstract List getPaymentMethods();

    public abstract List getTenderItemsOfType(String s);

    public abstract BookingDetails getTravelBookingDetails();
}
