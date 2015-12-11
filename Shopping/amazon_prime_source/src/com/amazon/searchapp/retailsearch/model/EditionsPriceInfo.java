// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            AudienceRating, Availability, Link, Ratings, 
//            Savings, Shipping

public interface EditionsPriceInfo
{

    public abstract String getAsin();

    public abstract AudienceRating getAudienceRating();

    public abstract Availability getAvailability();

    public abstract String getGroup();

    public abstract String getIssuePrice();

    public abstract Link getLink();

    public abstract String getListPrice();

    public abstract Link getMap();

    public abstract Link getMarketplaceAnyPriceLink();

    public abstract Link getMarketplaceCollectiblePriceLink();

    public abstract List getMarketplaceLabel();

    public abstract Link getMarketplaceNewPriceLink();

    public abstract Link getMarketplaceRefurbishedPriceLink();

    public abstract Link getMarketplaceUsedPriceLink();

    public abstract String getMerchantId();

    public abstract String getMerchantName();

    public abstract String getMerchantSku();

    public abstract long getOfferCount();

    public abstract String getOfferId();

    public abstract String getPostLinkText();

    public abstract String getPreLinkText();

    public abstract String getPrice();

    public abstract Ratings getRatings();

    public abstract Savings getSavings();

    public abstract Shipping getShipping();

    public abstract List getStyledPrice();

    public abstract List getStyledRentalPrice();

    public abstract String getUnitPrice();

    public abstract void setAsin(String s);

    public abstract void setAudienceRating(AudienceRating audiencerating);

    public abstract void setAvailability(Availability availability);

    public abstract void setGroup(String s);

    public abstract void setIssuePrice(String s);

    public abstract void setLink(Link link);

    public abstract void setListPrice(String s);

    public abstract void setMap(Link link);

    public abstract void setMarketplaceAnyPriceLink(Link link);

    public abstract void setMarketplaceCollectiblePriceLink(Link link);

    public abstract void setMarketplaceLabel(List list);

    public abstract void setMarketplaceNewPriceLink(Link link);

    public abstract void setMarketplaceRefurbishedPriceLink(Link link);

    public abstract void setMarketplaceUsedPriceLink(Link link);

    public abstract void setMerchantId(String s);

    public abstract void setMerchantName(String s);

    public abstract void setMerchantSku(String s);

    public abstract void setOfferCount(long l);

    public abstract void setOfferId(String s);

    public abstract void setPostLinkText(String s);

    public abstract void setPreLinkText(String s);

    public abstract void setPrice(String s);

    public abstract void setRatings(Ratings ratings);

    public abstract void setSavings(Savings savings);

    public abstract void setShipping(Shipping shipping);

    public abstract void setStyledPrice(List list);

    public abstract void setStyledRentalPrice(List list);

    public abstract void setUnitPrice(String s);
}
