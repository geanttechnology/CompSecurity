// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data;

import com.amazon.searchapp.retailsearch.entity.PriceInfoEntity;
import com.amazon.searchapp.retailsearch.model.EditionsPriceInfo;
import com.amazon.searchapp.retailsearch.model.PriceInfo;

public class EditionsPriceInfoUtil
{

    public EditionsPriceInfoUtil()
    {
    }

    public static PriceInfo toPriceInfo(EditionsPriceInfo editionspriceinfo)
    {
        PriceInfoEntity priceinfoentity = new PriceInfoEntity();
        priceinfoentity.setAudienceRating(editionspriceinfo.getAudienceRating());
        priceinfoentity.setAvailability(editionspriceinfo.getAvailability());
        priceinfoentity.setIssuePrice(editionspriceinfo.getIssuePrice());
        priceinfoentity.setLink(editionspriceinfo.getLink());
        priceinfoentity.setListPrice(editionspriceinfo.getListPrice());
        priceinfoentity.setMap(editionspriceinfo.getMap());
        priceinfoentity.setMarketplaceLabel(editionspriceinfo.getMarketplaceLabel());
        priceinfoentity.setOfferCount(editionspriceinfo.getOfferCount());
        priceinfoentity.setPostLinkText(editionspriceinfo.getPostLinkText());
        priceinfoentity.setPreLinkText(editionspriceinfo.getPreLinkText());
        priceinfoentity.setPrice(editionspriceinfo.getPrice());
        priceinfoentity.setRatings(editionspriceinfo.getRatings());
        priceinfoentity.setShipping(editionspriceinfo.getShipping());
        priceinfoentity.setUnitPrice(editionspriceinfo.getUnitPrice());
        return priceinfoentity;
    }
}
