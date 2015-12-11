// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.feed;

import com.shazam.android.widget.feed.j;
import com.shazam.model.news.FeedCard;

public interface FeedCardImpression
{

    public abstract void cancel();

    public abstract void onImpressionFinished(j j, FeedCard feedcard, int i, int k);

    public abstract void onImpressionStarted();
}
