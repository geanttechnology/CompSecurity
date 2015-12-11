// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            PriceInfo, EditionsMetadata, KindleUnlimited, Link

public interface Prices
{

    public abstract PriceInfo getBuy();

    public abstract PriceInfo getCollectible();

    public abstract PriceInfo getDigital();

    public abstract List getEditions();

    public abstract EditionsMetadata getEditionsMetadata();

    public abstract String getEditionsType();

    public abstract KindleUnlimited getKindleUnlimited();

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
}
