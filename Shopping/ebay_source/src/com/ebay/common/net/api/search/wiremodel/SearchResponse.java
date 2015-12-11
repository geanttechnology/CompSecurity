// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search.wiremodel;

import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import java.util.ArrayList;
import java.util.List;

public class SearchResponse
{

    public EbayAspectHistogram aspectHistogram;
    public EbayCategoryHistogram categoryHistogram;
    public final ArrayList itemIds = new ArrayList();
    public ArrayList items;
    public int matchCount;
    public int matchCountWithDupes;
    public List rewrites;
    public ArrayList searchExpansions;
    public long searchedCategoryId;
    public com.ebay.common.net.api.search.SearchServiceResponse.SellerOfferDetail sellerOfferDetail;
    public String trackingCorrelationId;
    public String trackingResponseHeader;

    public SearchResponse()
    {
        items = null;
        categoryHistogram = null;
        aspectHistogram = null;
        trackingResponseHeader = null;
        searchExpansions = null;
        sellerOfferDetail = null;
        searchedCategoryId = 0L;
        trackingCorrelationId = null;
    }
}
