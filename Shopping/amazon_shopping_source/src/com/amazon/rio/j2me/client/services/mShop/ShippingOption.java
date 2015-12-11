// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class ShippingOption
{

    private Integer selected;
    private String shipSplitPreferenceKey;
    private String shipSplitPreferenceText;

    public ShippingOption()
    {
    }

    public void setSelected(Integer integer)
    {
        selected = integer;
    }

    public void setShipSplitPreferenceKey(String s)
    {
        shipSplitPreferenceKey = s;
    }

    public void setShipSplitPreferenceText(String s)
    {
        shipSplitPreferenceText = s;
    }
}
