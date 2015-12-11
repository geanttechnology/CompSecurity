// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.feed;

import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.android.analytics.event.factory.NewsFeedEventFactory;
import com.shazam.android.widget.feed.j;
import com.shazam.model.news.FeedCard;
import com.shazam.n.h;
import com.shazam.n.i;

// Referenced classes of package com.shazam.android.analytics.feed:
//            FeedCardImpression

public class BeaconingFeedCardImpression
    implements FeedCardImpression
{

    private final EventAnalyticsFromView eventAnalytics;
    private h stopWatch;
    private final i stopWatchFactory;

    public BeaconingFeedCardImpression(EventAnalyticsFromView eventanalyticsfromview, i j)
    {
        eventAnalytics = eventanalyticsfromview;
        stopWatchFactory = j;
    }

    public void cancel()
    {
        stopWatch = null;
    }

    public void onImpressionFinished(j j, FeedCard feedcard, int k, int l)
    {
        if (stopWatch != null && stopWatch.b)
        {
            stopWatch.b();
            eventAnalytics.logEvent(j, NewsFeedEventFactory.createNewsCardImpression(feedcard, k, l, stopWatch.a));
        }
    }

    public void onImpressionStarted()
    {
        stopWatch = stopWatchFactory.a();
        stopWatch.a();
    }
}
