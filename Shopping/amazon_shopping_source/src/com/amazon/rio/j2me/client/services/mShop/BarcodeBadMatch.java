// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

public class BarcodeBadMatch
{

    private List asins;
    private String barcode;
    private String barcodeType;

    public BarcodeBadMatch()
    {
    }

    public List getAsins()
    {
        return asins;
    }

    public String getBarcode()
    {
        return barcode;
    }

    public String getBarcodeType()
    {
        return barcodeType;
    }

    public void setAsins(List list)
    {
        asins = list;
    }

    public void setBarcode(String s)
    {
        barcode = s;
    }

    public void setBarcodeType(String s)
    {
        barcodeType = s;
    }
}
