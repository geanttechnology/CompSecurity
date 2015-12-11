// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;

import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data.UnifiedStream:
//            Contents

public static final class TrendingListingSummary
{
    public static final class RankDelta
    {

        public String change;
        public TextSpanValueProperty delta;

        public RankDelta()
        {
        }
    }

    public static final class SearchStats
    {

        public TextSpanValueProperty total;
        public TextSpanValueProperty totalClicks;

        public SearchStats()
        {
        }
    }

    public static class TextSpanValueProperty
    {

        public Object value;

        public TextSpanValueProperty()
        {
        }
    }

    public static final class TrendingListingSummary
    {

        public ListingSummary listingSummary;

        public TrendingListingSummary()
        {
        }
    }

    public static final class TrendingListingSummary.ListingSummary
    {

        public Contents.ContentGroup.ContentRecord.Image image;
        public String listingId;

        public TrendingListingSummary.ListingSummary()
        {
        }
    }


    public TrendingListingSummary.ListingSummary bannerImage;
    public String categoryId;
    public List collectionIds;
    public String description;
    public String label;
    public RankDelta rankDelta;
    public SearchStats searchStats;
    public SearchStats squareImage;
    public String title;
    public int topicId;
    public List trendingListingSummaries;

    public TrendingListingSummary()
    {
    }
}
