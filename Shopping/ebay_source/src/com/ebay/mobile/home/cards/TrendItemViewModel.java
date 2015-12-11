// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import com.ebay.mobile.common.view.ViewModel;
import java.util.ArrayList;
import java.util.List;

public class TrendItemViewModel extends ViewModel
{

    public final int deltaChange;
    public final String deltaType;
    public final List imageUrl = new ArrayList();
    public final String label;
    public final long noOfViews;
    public final String topicName;

    public TrendItemViewModel(int i, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Topic topic)
    {
        super(i, onclicklistener);
        label = topic.label;
        topicName = topic.title;
        deltaType = topic.rankDelta.change;
        deltaChange = ((Integer)topic.rankDelta.delta.value).intValue();
        noOfViews = ((Long)topic.searchStats.total.value).longValue();
        imageUrl.add(topic.squareImage.url);
        if (topic.trendingListingSummaries != null)
        {
            int j = Math.min(2, topic.trendingListingSummaries.size());
            for (i = 0; i < j; i++)
            {
                onclicklistener = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Topic.TrendingListingSummary)topic.trendingListingSummaries.get(i);
                if (onclicklistener != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Topic.TrendingListingSummary) (onclicklistener)).listingSummary != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Topic.TrendingListingSummary) (onclicklistener)).listingSummary.image != null)
                {
                    imageUrl.add(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Topic.TrendingListingSummary) (onclicklistener)).listingSummary.image.url);
                }
            }

        }
    }
}
