// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.trend;

import com.ebay.mobile.common.view.ViewModel;
import java.util.List;

public class TopicListingViewModel extends ViewModel
{

    public final String listingId;
    public final String trendItemImage;
    public final String trendItemPrice;
    public final String trendItemTitle;

    public TopicListingViewModel(int i, com.ebay.nautilus.domain.data.Trend.TrendingListingSummary trendinglistingsummary, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        Object obj = null;
        super(i, onclicklistener);
        if (trendinglistingsummary == null || trendinglistingsummary.listingSummary == null)
        {
            trendItemPrice = null;
            trendItemTitle = null;
            trendItemImage = null;
            listingId = null;
            return;
        }
        listingId = trendinglistingsummary.listingSummary.listingId;
        trendItemImage = trendinglistingsummary.listingSummary.image.url;
        trendItemTitle = trendinglistingsummary.listingSummary.title;
        onclicklistener = obj;
        if (trendinglistingsummary.listingSummary.displayPrice.textSpans.size() > 0)
        {
            onclicklistener = ((com.ebay.nautilus.domain.data.Trend.TextSpan)trendinglistingsummary.listingSummary.displayPrice.textSpans.get(0)).text;
        }
        trendItemPrice = onclicklistener;
    }
}
