// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics;

import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.model.Factory;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.n.m;

// Referenced classes of package com.shazam.android.analytics:
//            TaggedBeaconTaggingStatus, TaggingStatus

public class TaggedBeaconTaggingStatusFactory
    implements Factory
{

    private final EventAnalytics analytics;
    private final BeaconEventKey beaconEventKey;
    private final Factory timeIntervalFactory;
    private final m timeProvider;

    public TaggedBeaconTaggingStatusFactory(Factory factory, m m, EventAnalytics eventanalytics, BeaconEventKey beaconeventkey)
    {
        timeIntervalFactory = factory;
        timeProvider = m;
        analytics = eventanalytics;
        beaconEventKey = beaconeventkey;
    }

    public TaggingStatus create(Void void1)
    {
        return new TaggedBeaconTaggingStatus(timeIntervalFactory, timeProvider, analytics, beaconEventKey);
    }

    public volatile Object create(Object obj)
    {
        return create((Void)obj);
    }
}
