// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            Link, AudienceRating, Availability, Ratings, 
//            Savings, Shipping

public interface PriceInfo
{

    public abstract Link getAppLink();

    public abstract AudienceRating getAudienceRating();

    public abstract Availability getAvailability();

    public abstract List getInAppPurchaseLabel();

    public abstract String getIssuePrice();

    public abstract Link getLink();

    public abstract String getListPrice();

    public abstract Link getMap();

    public abstract List getMarketplaceLabel();

    public abstract long getOfferCount();

    public abstract List getPostLinkStyleText();

    public abstract String getPostLinkText();

    public abstract List getPreLinkStyleText();

    public abstract String getPreLinkText();

    public abstract String getPrice();

    public abstract Ratings getRatings();

    public abstract Savings getSavings();

    public abstract Shipping getShipping();

    public abstract List getStyledLabel();

    public abstract String getUnitPrice();

    public abstract void setAppLink(Link link);

    public abstract void setAudienceRating(AudienceRating audiencerating);

    public abstract void setAvailability(Availability availability);

    public abstract void setInAppPurchaseLabel(List list);

    public abstract void setIssuePrice(String s);

    public abstract void setLink(Link link);

    public abstract void setListPrice(String s);

    public abstract void setMap(Link link);

    public abstract void setMarketplaceLabel(List list);

    public abstract void setOfferCount(long l);

    public abstract void setPostLinkStyleText(List list);

    public abstract void setPostLinkText(String s);

    public abstract void setPreLinkStyleText(List list);

    public abstract void setPreLinkText(String s);

    public abstract void setPrice(String s);

    public abstract void setRatings(Ratings ratings);

    public abstract void setSavings(Savings savings);

    public abstract void setShipping(Shipping shipping);

    public abstract void setStyledLabel(List list);

    public abstract void setUnitPrice(String s);
}
