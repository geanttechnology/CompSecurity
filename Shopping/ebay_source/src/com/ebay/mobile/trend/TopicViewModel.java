// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.trend;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.nautilus.domain.data.Trend;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.trend:
//            TrendUrlParser, TopicListingViewModel

public class TopicViewModel extends ViewModel
{

    private static TrendUrlParser trendUrlParser = new TrendUrlParser();
    public final String collectionId;
    public final List listings = new ArrayList();
    public final long noOfClicks;
    public final long noOfSearches;
    public final SearchParameters searchParameters;
    public final String topicDescription;
    public final String topicImageUrl;
    public final String topicPosition;
    public final String topicTitle;
    public final String topicTrendDelta;
    public final String trendDeltaType;

    public TopicViewModel(int i, Trend trend, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener1, Context context)
    {
        super(i, onclicklistener1);
        if (trend == null)
        {
            topicTrendDelta = null;
            topicImageUrl = null;
            topicDescription = null;
            topicPosition = null;
            topicTitle = null;
            noOfClicks = -1L;
            noOfSearches = -1L;
            trendDeltaType = null;
            collectionId = null;
            searchParameters = null;
            return;
        }
        topicImageUrl = trend.bannerImage.url;
        long l;
        if (trend.rankDelta != null && trend.rankDelta.delta.textSpans.size() > 0)
        {
            onclicklistener1 = ((com.ebay.nautilus.domain.data.Trend.TextSpan)trend.rankDelta.delta.textSpans.get(0)).text;
        } else
        {
            onclicklistener1 = null;
        }
        topicTrendDelta = onclicklistener1;
        topicTitle = trend.title;
        topicPosition = trend.label;
        if (trend.searchStats != null && trend.searchStats.total != null)
        {
            l = ((Long)trend.searchStats.total.value).longValue();
        } else
        {
            l = -1L;
        }
        noOfSearches = l;
        if (trend.searchStats != null && trend.searchStats.totalClicks != null)
        {
            l = ((Long)trend.searchStats.totalClicks.value).longValue();
        } else
        {
            l = -1L;
        }
        noOfClicks = l;
        topicDescription = trend.description;
        trendDeltaType = trend.rankDelta.change;
        com.ebay.nautilus.domain.data.Trend.TrendingListingSummary trendinglistingsummary;
        for (onclicklistener1 = trend.trendingListingSummaries.iterator(); onclicklistener1.hasNext(); listings.add(new TopicListingViewModel(3, trendinglistingsummary, onclicklistener)))
        {
            trendinglistingsummary = (com.ebay.nautilus.domain.data.Trend.TrendingListingSummary)onclicklistener1.next();
        }

        if (trend.collectionIds != null && trend.collectionIds.size() > 0)
        {
            onclicklistener = (String)trend.collectionIds.get(0);
        } else
        {
            onclicklistener = null;
        }
        collectionId = onclicklistener;
        if (collectionId == null && !TextUtils.isEmpty(trend.url))
        {
            trend = Uri.parse(trend.url);
            searchParameters = trendUrlParser.parse(context, trend);
            return;
        } else
        {
            searchParameters = null;
            return;
        }
    }

}
