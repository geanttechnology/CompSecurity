// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class ProductRequest
{

    private String asin;
    private String clickStreamOrigin;
    private Boolean excludeImage;
    private int maxImageDimension;
    private Integer maxSwatchDimension;
    private Boolean noPrefetchChildren;
    private String offerId;
    private int offerListingsCount;
    private int reviewsCount;
    private Integer simsCount;
    private boolean variationChild;
    private Integer variationsModelOverride;

    public ProductRequest()
    {
    }

    public String getAsin()
    {
        return asin;
    }

    public String getClickStreamOrigin()
    {
        return clickStreamOrigin;
    }

    public Boolean getExcludeImage()
    {
        return excludeImage;
    }

    public int getMaxImageDimension()
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

    public String getOfferId()
    {
        return offerId;
    }

    public int getOfferListingsCount()
    {
        return offerListingsCount;
    }

    public int getReviewsCount()
    {
        return reviewsCount;
    }

    public Integer getSimsCount()
    {
        return simsCount;
    }

    public boolean getVariationChild()
    {
        return variationChild;
    }

    public Integer getVariationsModelOverride()
    {
        return variationsModelOverride;
    }

    public void setAsin(String s)
    {
        asin = s;
    }

    public void setClickStreamOrigin(String s)
    {
        clickStreamOrigin = s;
    }

    public void setExcludeImage(Boolean boolean1)
    {
        excludeImage = boolean1;
    }

    public void setMaxImageDimension(int i)
    {
        maxImageDimension = i;
    }

    public void setMaxSwatchDimension(Integer integer)
    {
        maxSwatchDimension = integer;
    }

    public void setNoPrefetchChildren(Boolean boolean1)
    {
        noPrefetchChildren = boolean1;
    }

    public void setOfferId(String s)
    {
        offerId = s;
    }

    public void setSimsCount(Integer integer)
    {
        simsCount = integer;
    }

    public void setVariationChild(boolean flag)
    {
        variationChild = flag;
    }

    public void setVariationsModelOverride(Integer integer)
    {
        variationsModelOverride = integer;
    }
}
