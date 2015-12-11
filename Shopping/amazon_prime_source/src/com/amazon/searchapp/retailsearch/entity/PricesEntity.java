// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.EditionsMetadata;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.PriceInfo;
import com.amazon.searchapp.retailsearch.model.Prices;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class PricesEntity extends RetailSearchEntity
    implements Prices
{

    private PriceInfo buy;
    private PriceInfo collectible;
    private PriceInfo digital;
    private List editions;
    private EditionsMetadata editionsMetadata;
    private String editionsType;
    private PriceInfo kindle;
    private PriceInfo newOffers;
    private PriceInfo override;
    private PriceInfo refurbished;
    private PriceInfo rental;
    private PriceInfo sponsored;
    private PriceInfo subscribeAndSave;
    private PriceInfo tradeIn;
    private PriceInfo usedAndNewOffers;
    private PriceInfo usedOffers;
    private Link watchInstantly;

    public PricesEntity()
    {
    }

    public PriceInfo getBuy()
    {
        return buy;
    }

    public PriceInfo getCollectible()
    {
        return collectible;
    }

    public PriceInfo getDigital()
    {
        return digital;
    }

    public List getEditions()
    {
        return editions;
    }

    public EditionsMetadata getEditionsMetadata()
    {
        return editionsMetadata;
    }

    public String getEditionsType()
    {
        return editionsType;
    }

    public PriceInfo getKindle()
    {
        return kindle;
    }

    public PriceInfo getNewOffers()
    {
        return newOffers;
    }

    public PriceInfo getOverride()
    {
        return override;
    }

    public PriceInfo getRefurbished()
    {
        return refurbished;
    }

    public PriceInfo getRental()
    {
        return rental;
    }

    public PriceInfo getSponsored()
    {
        return sponsored;
    }

    public PriceInfo getSubscribeAndSave()
    {
        return subscribeAndSave;
    }

    public PriceInfo getTradeIn()
    {
        return tradeIn;
    }

    public PriceInfo getUsedAndNewOffers()
    {
        return usedAndNewOffers;
    }

    public PriceInfo getUsedOffers()
    {
        return usedOffers;
    }

    public Link getWatchInstantly()
    {
        return watchInstantly;
    }

    public void setBuy(PriceInfo priceinfo)
    {
        buy = priceinfo;
    }

    public void setCollectible(PriceInfo priceinfo)
    {
        collectible = priceinfo;
    }

    public void setDigital(PriceInfo priceinfo)
    {
        digital = priceinfo;
    }

    public void setEditions(List list)
    {
        editions = list;
    }

    public void setEditionsMetadata(EditionsMetadata editionsmetadata)
    {
        editionsMetadata = editionsmetadata;
    }

    public void setEditionsType(String s)
    {
        editionsType = s;
    }

    public void setKindle(PriceInfo priceinfo)
    {
        kindle = priceinfo;
    }

    public void setNewOffers(PriceInfo priceinfo)
    {
        newOffers = priceinfo;
    }

    public void setOverride(PriceInfo priceinfo)
    {
        override = priceinfo;
    }

    public void setRefurbished(PriceInfo priceinfo)
    {
        refurbished = priceinfo;
    }

    public void setRental(PriceInfo priceinfo)
    {
        rental = priceinfo;
    }

    public void setSponsored(PriceInfo priceinfo)
    {
        sponsored = priceinfo;
    }

    public void setSubscribeAndSave(PriceInfo priceinfo)
    {
        subscribeAndSave = priceinfo;
    }

    public void setTradeIn(PriceInfo priceinfo)
    {
        tradeIn = priceinfo;
    }

    public void setUsedAndNewOffers(PriceInfo priceinfo)
    {
        usedAndNewOffers = priceinfo;
    }

    public void setUsedOffers(PriceInfo priceinfo)
    {
        usedOffers = priceinfo;
    }

    public void setWatchInstantly(Link link)
    {
        watchInstantly = link;
    }
}
