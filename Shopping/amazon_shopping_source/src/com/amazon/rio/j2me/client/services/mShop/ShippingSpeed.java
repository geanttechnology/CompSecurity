// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

public class ShippingSpeed
{

    private Boolean deliveryInstructionRemarkSupported;
    private List deliveryTimePreference;
    private Integer earliestDate;
    private Integer latestDate;
    private Integer selected;
    private String shipSpeedKey;
    private String shipSpeedText;

    public ShippingSpeed()
    {
    }

    public void setDeliveryInstructionRemarkSupported(Boolean boolean1)
    {
        deliveryInstructionRemarkSupported = boolean1;
    }

    public void setDeliveryTimePreference(List list)
    {
        deliveryTimePreference = list;
    }

    public void setEarliestDate(Integer integer)
    {
        earliestDate = integer;
    }

    public void setLatestDate(Integer integer)
    {
        latestDate = integer;
    }

    public void setSelected(Integer integer)
    {
        selected = integer;
    }

    public void setShipSpeedKey(String s)
    {
        shipSpeedKey = s;
    }

    public void setShipSpeedText(String s)
    {
        shipSpeedText = s;
    }
}
