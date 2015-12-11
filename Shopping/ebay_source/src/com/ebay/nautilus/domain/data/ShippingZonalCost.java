// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import java.io.Serializable;

public class ShippingZonalCost
    implements Serializable, Comparable
{

    public double cost;
    public long zone;

    public ShippingZonalCost()
    {
        cost = 0.0D;
        zone = 0L;
    }

    public int compareTo(ShippingZonalCost shippingzonalcost)
    {
        if (cost == shippingzonalcost.cost)
        {
            return 0;
        }
        return cost <= shippingzonalcost.cost ? -1 : 1;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((ShippingZonalCost)obj);
    }

    public String toString()
    {
        return (new StringBuilder()).append("Zone: ").append(zone).append(" - Cost: ").append(cost).toString();
    }
}
