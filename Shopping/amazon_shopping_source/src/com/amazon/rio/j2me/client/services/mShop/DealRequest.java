// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class DealRequest
{

    private String asin;
    private String dealId;
    private Integer maxImageDimension;
    private Integer maxSwatchDimension;
    private Boolean noPrefetchChildren;
    private Boolean showVariations;

    public DealRequest()
    {
    }

    public String getAsin()
    {
        return asin;
    }

    public String getDealId()
    {
        return dealId;
    }

    public Integer getMaxImageDimension()
    {
        return maxImageDimension;
    }

    public Integer getMaxSwatchDimension()
    {
        return maxSwatchDimension;
    }

    public Boolean getNoPrefetchChildren()
    {
        return noPrefetchChildren;
    }

    public Boolean getShowVariations()
    {
        return showVariations;
    }

    public void setAsin(String s)
    {
        asin = s;
    }

    public void setDealId(String s)
    {
        dealId = s;
    }

    public void setShowVariations(Boolean boolean1)
    {
        showVariations = boolean1;
    }
}
