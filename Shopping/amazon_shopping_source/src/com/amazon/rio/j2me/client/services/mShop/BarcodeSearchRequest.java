// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class BarcodeSearchRequest
{

    private String barcode;
    private String barcodeType;
    private String clickStreamOrigin;
    private Boolean includeAddOnItems;
    private int maxImageDimension;
    private int size;

    public BarcodeSearchRequest()
    {
    }

    public String getBarcode()
    {
        return barcode;
    }

    public String getBarcodeType()
    {
        return barcodeType;
    }

    public String getClickStreamOrigin()
    {
        return clickStreamOrigin;
    }

    public Boolean getIncludeAddOnItems()
    {
        return includeAddOnItems;
    }

    public int getMaxImageDimension()
    {
        return maxImageDimension;
    }

    public int getSize()
    {
        return size;
    }

    public void setBarcode(String s)
    {
        barcode = s;
    }

    public void setBarcodeType(String s)
    {
        barcodeType = s;
    }

    public void setClickStreamOrigin(String s)
    {
        clickStreamOrigin = s;
    }

    public void setIncludeAddOnItems(Boolean boolean1)
    {
        includeAddOnItems = boolean1;
    }

    public void setMaxImageDimension(int i)
    {
        maxImageDimension = i;
    }

    public void setSize(int i)
    {
        size = i;
    }
}
