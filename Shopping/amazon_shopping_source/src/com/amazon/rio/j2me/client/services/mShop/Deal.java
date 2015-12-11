// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            CustomerDealPurchaseStatus, Savings

public class Deal
{

    private String asin;
    private Integer averageOverallRating;
    private CustomerDealPurchaseStatus customerPurchaseStatus;
    private Integer customerReviewsCount;
    private String dealId;
    private List dealVariationChildren;
    private List dealVariationDimensions;
    private String desc;
    private Boolean eligibleForPrimeShipping;
    private Integer endTime;
    private byte image[];
    private String imageName;
    private Boolean isRedeemedToCustomer;
    private Boolean isSoldOut;
    private Integer msToCacheExpires;
    private Integer msToEnd;
    private Integer msToStart;
    private String offerId;
    private Integer percentageSold;
    private Boolean priceViolatesMap;
    private Savings savings;
    private Integer startTime;
    private String title;
    private String totalAvailable;
    private String url;
    private List visualBuckets;

    public Deal()
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

    public byte[] getImage()
    {
        return image;
    }

    public Integer getMsToEnd()
    {
        return msToEnd;
    }

    public Integer getMsToStart()
    {
        return msToStart;
    }

    public String getOfferId()
    {
        return offerId;
    }

    public Savings getSavings()
    {
        return savings;
    }

    public String getTitle()
    {
        return title;
    }

    public void setAsin(String s)
    {
        asin = s;
    }

    public void setAverageOverallRating(Integer integer)
    {
        averageOverallRating = integer;
    }

    public void setCustomerPurchaseStatus(CustomerDealPurchaseStatus customerdealpurchasestatus)
    {
        customerPurchaseStatus = customerdealpurchasestatus;
    }

    public void setCustomerReviewsCount(Integer integer)
    {
        customerReviewsCount = integer;
    }

    public void setDealId(String s)
    {
        dealId = s;
    }

    public void setDealVariationChildren(List list)
    {
        dealVariationChildren = list;
    }

    public void setDealVariationDimensions(List list)
    {
        dealVariationDimensions = list;
    }

    public void setDesc(String s)
    {
        desc = s;
    }

    public void setEligibleForPrimeShipping(Boolean boolean1)
    {
        eligibleForPrimeShipping = boolean1;
    }

    public void setEndTime(Integer integer)
    {
        endTime = integer;
    }

    public void setImage(byte abyte0[])
    {
        image = abyte0;
    }

    public void setImageName(String s)
    {
        imageName = s;
    }

    public void setIsRedeemedToCustomer(Boolean boolean1)
    {
        isRedeemedToCustomer = boolean1;
    }

    public void setIsSoldOut(Boolean boolean1)
    {
        isSoldOut = boolean1;
    }

    public void setMsToCacheExpires(Integer integer)
    {
        msToCacheExpires = integer;
    }

    public void setMsToEnd(Integer integer)
    {
        msToEnd = integer;
    }

    public void setMsToStart(Integer integer)
    {
        msToStart = integer;
    }

    public void setOfferId(String s)
    {
        offerId = s;
    }

    public void setPercentageSold(Integer integer)
    {
        percentageSold = integer;
    }

    public void setPriceViolatesMap(Boolean boolean1)
    {
        priceViolatesMap = boolean1;
    }

    public void setSavings(Savings savings1)
    {
        savings = savings1;
    }

    public void setStartTime(Integer integer)
    {
        startTime = integer;
    }

    public void setTitle(String s)
    {
        title = s;
    }

    public void setTotalAvailable(String s)
    {
        totalAvailable = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }

    public void setVisualBuckets(List list)
    {
        visualBuckets = list;
    }
}
