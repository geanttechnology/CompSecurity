// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            BadgeInfo, MerchantInfo, PricePerUnit, ShippingOffer, 
//            SpecialOffer

public class BasicOfferListing
{

    private int availabilityCondition;
    private List availabilityMessages;
    private BadgeInfo badgeInfo;
    private String condition;
    private String conditionType;
    private boolean deprecatedEligibleForPrimeShipping;
    private boolean eligibleForSuperSaverShipping;
    private String fulfilledBy;
    private boolean giftWrapAvailable;
    private MerchantInfo merchantInfo;
    private String offerId;
    private Integer percentSavings;
    private String points;
    private String price;
    private String priceMessage;
    private PricePerUnit pricePerUnit;
    private String priceSavings;
    private boolean priceViolatesMap;
    private ShippingOffer shippingOffer;
    private SpecialOffer specialOffer;

    public BasicOfferListing()
    {
    }

    public int getAvailabilityCondition()
    {
        return availabilityCondition;
    }

    public List getAvailabilityMessages()
    {
        return availabilityMessages;
    }

    public BadgeInfo getBadgeInfo()
    {
        return badgeInfo;
    }

    public String getCondition()
    {
        return condition;
    }

    public boolean getEligibleForSuperSaverShipping()
    {
        return eligibleForSuperSaverShipping;
    }

    public MerchantInfo getMerchantInfo()
    {
        return merchantInfo;
    }

    public String getOfferId()
    {
        return offerId;
    }

    public String getPoints()
    {
        return points;
    }

    public String getPrice()
    {
        return price;
    }

    public String getPriceMessage()
    {
        return priceMessage;
    }

    public PricePerUnit getPricePerUnit()
    {
        return pricePerUnit;
    }

    public boolean getPriceViolatesMap()
    {
        return priceViolatesMap;
    }

    public ShippingOffer getShippingOffer()
    {
        return shippingOffer;
    }

    public void setAvailabilityCondition(int i)
    {
        availabilityCondition = i;
    }

    public void setAvailabilityMessages(List list)
    {
        availabilityMessages = list;
    }

    public void setBadgeInfo(BadgeInfo badgeinfo)
    {
        badgeInfo = badgeinfo;
    }

    public void setCondition(String s)
    {
        condition = s;
    }

    public void setConditionType(String s)
    {
        conditionType = s;
    }

    public void setDeprecatedEligibleForPrimeShipping(boolean flag)
    {
        deprecatedEligibleForPrimeShipping = flag;
    }

    public void setEligibleForSuperSaverShipping(boolean flag)
    {
        eligibleForSuperSaverShipping = flag;
    }

    public void setFulfilledBy(String s)
    {
        fulfilledBy = s;
    }

    public void setGiftWrapAvailable(boolean flag)
    {
        giftWrapAvailable = flag;
    }

    public void setMerchantInfo(MerchantInfo merchantinfo)
    {
        merchantInfo = merchantinfo;
    }

    public void setOfferId(String s)
    {
        offerId = s;
    }

    public void setPercentSavings(Integer integer)
    {
        percentSavings = integer;
    }

    public void setPoints(String s)
    {
        points = s;
    }

    public void setPrice(String s)
    {
        price = s;
    }

    public void setPriceMessage(String s)
    {
        priceMessage = s;
    }

    public void setPricePerUnit(PricePerUnit priceperunit)
    {
        pricePerUnit = priceperunit;
    }

    public void setPriceSavings(String s)
    {
        priceSavings = s;
    }

    public void setPriceViolatesMap(boolean flag)
    {
        priceViolatesMap = flag;
    }

    public void setShippingOffer(ShippingOffer shippingoffer)
    {
        shippingOffer = shippingoffer;
    }

    public void setSpecialOffer(SpecialOffer specialoffer)
    {
        specialOffer = specialoffer;
    }
}
