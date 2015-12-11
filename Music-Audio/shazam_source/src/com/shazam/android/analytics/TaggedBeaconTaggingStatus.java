// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics;

import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.factory.TaggingEndedEventFactory;
import com.shazam.android.analytics.event.factory.TaggingStartedEventFactory;
import com.shazam.b.e.a;
import com.shazam.h.o;
import com.shazam.model.Factory;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.n.m;
import java.net.URL;

// Referenced classes of package com.shazam.android.analytics:
//            TaggingStatus, TaggedBeacon, TaggingOutcome, TaggedBeaconData

public class TaggedBeaconTaggingStatus
    implements TaggingStatus
{

    private final EventAnalytics analytics;
    private final BeaconEventKey beaconEventKey;
    private boolean hasJustDoneRecognition;
    private TaggedBeacon taggedBeacon;
    private final Factory timeIntervalFactory;
    private final m timeProvider;

    public TaggedBeaconTaggingStatus(Factory factory, m m1, EventAnalytics eventanalytics, BeaconEventKey beaconeventkey)
    {
        timeIntervalFactory = factory;
        timeProvider = m1;
        analytics = eventanalytics;
        beaconEventKey = beaconeventkey;
    }

    private void sendInnerBeacon(TaggedBeacon taggedbeacon)
    {
        if (taggedbeacon.innerTaggedBeacon != null && taggedbeacon.isFinishedInnerTaggedBeacon())
        {
            com.shazam.android.analytics.event.Event event = com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(beaconEventKey).withParameters(taggedbeacon.getInnerEventParameters()).build();
            analytics.logEvent(event);
            taggedbeacon.clearInnerTaggedBeacon();
        }
    }

    public void clearEndOfRecognition()
    {
        hasJustDoneRecognition = false;
    }

    public boolean getJustDoneRecognition()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = hasJustDoneRecognition;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public TaggedBeacon getTaggedBeacon()
    {
        this;
        JVM INSTR monitorenter ;
        TaggedBeacon taggedbeacon = taggedBeacon;
        this;
        JVM INSTR monitorexit ;
        return taggedbeacon;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isTagSessionActive()
    {
        this;
        JVM INSTR monitorenter ;
        TaggedBeacon taggedbeacon = taggedBeacon;
        boolean flag;
        if (taggedbeacon != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public void markEndOfRecognition()
    {
        hasJustDoneRecognition = true;
    }

    public void onConnecting(URL url)
    {
        if (isTagSessionActive())
        {
            taggedBeacon.startLatencyInterval();
            taggedBeacon.startRequestInterval();
        }
    }

    public void onRequestSent(URL url, byte abyte0[])
    {
        if (isTagSessionActive())
        {
            int i;
            if (abyte0 == null)
            {
                i = 0;
            } else
            {
                i = abyte0.length;
            }
            taggedBeacon.endRequestInterval(i);
            taggedBeacon.startResponseInterval();
        }
    }

    public void onResponseReceived(URL url, o o1)
    {
        if (isTagSessionActive())
        {
            boolean flag = false;
            url = o1.a("content-length");
            int i = ((flag) ? 1 : 0);
            if (a.c(url))
            {
                i = ((flag) ? 1 : 0);
                if (!"-1".equals(url))
                {
                    i = Integer.valueOf(url).intValue();
                }
            }
            taggedBeacon.endResponseInterval(i);
            taggedBeacon.endLatencyInterval();
        }
    }

    public void overallTaggingStart(TaggedBeaconData taggedbeacondata)
    {
        this;
        JVM INSTR monitorenter ;
        hasJustDoneRecognition = false;
        taggedBeacon = TaggedBeacon.newInstance(timeIntervalFactory, taggedbeacondata, timeProvider.b());
        taggedBeacon.startUiTime();
        (new StringBuilder("Overall Tagging Start - create taggedBeacon = new...")).append(taggedBeacon);
        analytics.logEvent(TaggingStartedEventFactory.taggingStartedEventFrom(taggedbeacondata));
        this;
        JVM INSTR monitorexit ;
        return;
        taggedbeacondata;
        throw taggedbeacondata;
    }

    public void sendBeaconIfAvailable()
    {
        sendBeaconIfAvailable(taggedBeacon);
    }

    public void sendBeaconIfAvailable(TaggedBeacon taggedbeacon)
    {
        (new StringBuilder("sendBeacon - taggedBeacon = ")).append(taggedbeacon);
        if (taggedbeacon != null)
        {
            taggedbeacon.stopUiTime();
            taggedbeacon.setEndTime(timeProvider.b());
            sendInnerBeacon(taggedbeacon);
            if (hasJustDoneRecognition)
            {
                taggedBeacon = null;
                hasJustDoneRecognition = false;
                com.shazam.android.analytics.event.Event event = com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(beaconEventKey).withParameters(taggedbeacon.getEventParameters()).build();
                TaggingOutcome taggingoutcome = taggedbeacon.getOutcome();
                if (TaggingOutcome.MATCH.equals(taggingoutcome) || TaggingOutcome.NO_MATCH.equals(taggingoutcome))
                {
                    analytics.logEvent(event);
                }
                analytics.logEvent(TaggingEndedEventFactory.taggingEndedEventFrom(taggedbeacon));
            }
        }
        (new StringBuilder("sendBeacon - just about to null taggedBeacon = ")).append(taggedbeacon);
    }

    public void setOutcome(TaggingOutcome taggingoutcome)
    {
        taggedBeacon.setOutcome(taggingoutcome);
    }

    public void startRecordingTime()
    {
        if (isTagSessionActive())
        {
            taggedBeacon.startRecordingTime();
        }
    }
}
