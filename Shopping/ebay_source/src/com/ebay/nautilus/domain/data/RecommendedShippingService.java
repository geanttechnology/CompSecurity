// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import java.io.Serializable;

public class RecommendedShippingService
    implements Serializable
{

    public long maxDeliveryDays;
    public long minDeliveryDays;
    public String serviceId;
    public String shippingServiceName;

    public RecommendedShippingService()
    {
    }

    public String toString()
    {
        return (new StringBuilder()).append(shippingServiceName).append(":").append(minDeliveryDays).append(":").append(maxDeliveryDays).append(":").append(serviceId).toString();
    }
}
