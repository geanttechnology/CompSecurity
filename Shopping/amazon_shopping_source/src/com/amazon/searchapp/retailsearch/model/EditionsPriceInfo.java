// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            AudienceRating, Availability, KindleUnlimited, Link, 
//            Ratings, Shipping

public interface EditionsPriceInfo
{

    public abstract String getAsin();

    public abstract AudienceRating getAudienceRating();

    public abstract Availability getAvailability();

    public abstract String getIssuePrice();

    public abstract KindleUnlimited getKindleUnlimited();

    public abstract Link getLink();

    public abstract String getListPrice();

    public abstract Link getMap();

    public abstract Link getMarketplaceAnyPriceLink();

    public abstract Link getMarketplaceCollectiblePriceLink();

    public abstract List getMarketplaceLabel();

    public abstract Link getMarketplaceNewPriceLink();

    public abstract Link getMarketplaceRefurbishedPriceLink();

    public abstract Link getMarketplaceUsedPriceLink();

    public abstract long getOfferCount();

    public abstract String getPostLinkText();

    public abstract String getPreLinkText();

    public abstract String getPrice();

    public abstract Ratings getRatings();

    public abstract Shipping getShipping();

    public abstract String getUnitPrice();
}
