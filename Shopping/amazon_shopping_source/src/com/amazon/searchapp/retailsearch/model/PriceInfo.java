// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            Link, AudienceRating, Availability, Ratings, 
//            Shipping

public interface PriceInfo
{

    public abstract Link getAppLink();

    public abstract AudienceRating getAudienceRating();

    public abstract Availability getAvailability();

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

    public abstract Shipping getShipping();

    public abstract List getStyledLabel();

    public abstract String getUnitPrice();
}
