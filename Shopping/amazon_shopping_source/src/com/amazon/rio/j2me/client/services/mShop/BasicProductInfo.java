// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            OffersSummary

public class BasicProductInfo
{

    private String asin;
    private int availabilityCondition;
    private Integer averageOverallRating;
    private String bindingSymbol;
    private Boolean blackCurtain;
    private String byLine;
    private int customerReviewsCount;
    private Boolean defaultParent;
    private String imageUrl;
    private int imagesCount;
    private String listPrice;
    private OffersSummary newSummary;
    private String productGroupId;
    private String shortDescription;
    private String title;
    private String tradeInPrice;
    private OffersSummary usedAndNewSummary;
    private String variationParentAsin;
    private String variationPriceRange;

    public BasicProductInfo()
    {
    }

    public String getAsin()
    {
        return asin;
    }

    public int getAvailabilityCondition()
    {
        return availabilityCondition;
    }

    public Integer getAverageOverallRating()
    {
        return averageOverallRating;
    }

    public String getBindingSymbol()
    {
        return bindingSymbol;
    }

    public Boolean getBlackCurtain()
    {
        return blackCurtain;
    }

    public String getByLine()
    {
        return byLine;
    }

    public int getCustomerReviewsCount()
    {
        return customerReviewsCount;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public String getListPrice()
    {
        return listPrice;
    }

    public String getProductGroupId()
    {
        return productGroupId;
    }

    public String getShortDescription()
    {
        return shortDescription;
    }

    public String getTitle()
    {
        return title;
    }

    public OffersSummary getUsedAndNewSummary()
    {
        return usedAndNewSummary;
    }

    public String getVariationParentAsin()
    {
        return variationParentAsin;
    }

    public String getVariationPriceRange()
    {
        return variationPriceRange;
    }

    public void setAsin(String s)
    {
        asin = s;
    }

    public void setAvailabilityCondition(int i)
    {
        availabilityCondition = i;
    }

    public void setAverageOverallRating(Integer integer)
    {
        averageOverallRating = integer;
    }

    public void setBindingSymbol(String s)
    {
        bindingSymbol = s;
    }

    public void setBlackCurtain(Boolean boolean1)
    {
        blackCurtain = boolean1;
    }

    public void setByLine(String s)
    {
        byLine = s;
    }

    public void setCustomerReviewsCount(int i)
    {
        customerReviewsCount = i;
    }

    public void setDefaultParent(Boolean boolean1)
    {
        defaultParent = boolean1;
    }

    public void setImageUrl(String s)
    {
        imageUrl = s;
    }

    public void setImagesCount(int i)
    {
        imagesCount = i;
    }

    public void setListPrice(String s)
    {
        listPrice = s;
    }

    public void setNewSummary(OffersSummary offerssummary)
    {
        newSummary = offerssummary;
    }

    public void setProductGroupId(String s)
    {
        productGroupId = s;
    }

    public void setShortDescription(String s)
    {
        shortDescription = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }

    public void setTradeInPrice(String s)
    {
        tradeInPrice = s;
    }

    public void setUsedAndNewSummary(OffersSummary offerssummary)
    {
        usedAndNewSummary = offerssummary;
    }

    public void setVariationParentAsin(String s)
    {
        variationParentAsin = s;
    }

    public void setVariationPriceRange(String s)
    {
        variationPriceRange = s;
    }
}
