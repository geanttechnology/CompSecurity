// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            PriceInfo, EditionsMetadata, Link

public interface Prices
{

    public abstract PriceInfo getBuy();

    public abstract PriceInfo getCollectible();

    public abstract PriceInfo getDigital();

    public abstract List getEditions();

    public abstract EditionsMetadata getEditionsMetadata();

    public abstract String getEditionsType();

    public abstract PriceInfo getKindle();

    public abstract PriceInfo getNewOffers();

    public abstract PriceInfo getOverride();

    public abstract PriceInfo getRefurbished();

    public abstract PriceInfo getRental();

    public abstract PriceInfo getSponsored();

    public abstract PriceInfo getSubscribeAndSave();

    public abstract PriceInfo getTradeIn();

    public abstract PriceInfo getUsedAndNewOffers();

    public abstract PriceInfo getUsedOffers();

    public abstract Link getWatchInstantly();

    public abstract void setBuy(PriceInfo priceinfo);

    public abstract void setCollectible(PriceInfo priceinfo);

    public abstract void setDigital(PriceInfo priceinfo);

    public abstract void setEditions(List list);

    public abstract void setEditionsMetadata(EditionsMetadata editionsmetadata);

    public abstract void setEditionsType(String s);

    public abstract void setKindle(PriceInfo priceinfo);

    public abstract void setNewOffers(PriceInfo priceinfo);

    public abstract void setOverride(PriceInfo priceinfo);

    public abstract void setRefurbished(PriceInfo priceinfo);

    public abstract void setRental(PriceInfo priceinfo);

    public abstract void setSponsored(PriceInfo priceinfo);

    public abstract void setSubscribeAndSave(PriceInfo priceinfo);

    public abstract void setTradeIn(PriceInfo priceinfo);

    public abstract void setUsedAndNewOffers(PriceInfo priceinfo);

    public abstract void setUsedOffers(PriceInfo priceinfo);

    public abstract void setWatchInstantly(Link link);
}
