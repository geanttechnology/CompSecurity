// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics;

import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.factory.TaggingEndedEventFactory;
import com.shazam.android.ay.b;
import com.shazam.android.ay.c.m;
import com.shazam.android.d.c;

// Referenced classes of package com.shazam.android.analytics:
//            TaggingStatus, TaggedBeacon, TaggingOutcome

public class TaggingEndedTagErrorListener
    implements m
{

    private final EventAnalytics eventAnalytics;
    private final TaggingStatus taggingStatus;
    private final com.shazam.n.m timeProvider;

    public TaggingEndedTagErrorListener(EventAnalytics eventanalytics, TaggingStatus taggingstatus, com.shazam.n.m m1)
    {
        eventAnalytics = eventanalytics;
        taggingStatus = taggingstatus;
        timeProvider = m1;
    }

    public void onError(b b1, c c)
    {
        c = taggingStatus.getTaggedBeacon();
        taggingStatus.clearEndOfRecognition();
        if (c == null) goto _L2; else goto _L1
_L1:
        c.setEndTime(timeProvider.b());
        static class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[b.values().length];
                try
                {
                    a[b.c.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        _cls1.a[b1.ordinal()];
        JVM INSTR tableswitch 1 1: default 64
    //                   1 85;
           goto _L3 _L4
_L3:
        c.setOutcome(TaggingOutcome.ERROR);
_L6:
        eventAnalytics.logEvent(TaggingEndedEventFactory.taggingEndedEventFrom(c));
_L2:
        return;
_L4:
        c.setOutcome(TaggingOutcome.UNSUBMITTED);
        if (true) goto _L6; else goto _L5
_L5:
    }
}
