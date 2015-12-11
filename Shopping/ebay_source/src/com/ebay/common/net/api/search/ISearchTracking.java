// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import java.util.List;

public interface ISearchTracking
{

    public abstract boolean areExpansionsSurfaced();

    public abstract EbayAspectHistogram getAspects();

    public abstract Integer getAuctionItemCount();

    public abstract EbayCategoryHistogram getCategories();

    public abstract Integer getFixedPriceItemCount();

    public abstract List getItemIds();

    public abstract List getPage();

    public abstract String getRequestCorrelationId();

    public abstract int getTotalCount();

    public abstract String getTrackingResponseHeader();
}
