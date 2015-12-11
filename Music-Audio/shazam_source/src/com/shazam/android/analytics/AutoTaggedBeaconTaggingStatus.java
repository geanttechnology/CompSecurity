// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics;

import com.shazam.h.o;
import com.shazam.model.Factory;
import java.net.URL;

// Referenced classes of package com.shazam.android.analytics:
//            TaggingStatus, TaggedBeacon, TaggedBeaconData, TaggingOutcome

public class AutoTaggedBeaconTaggingStatus
    implements TaggingStatus
{

    private TaggingStatus building;
    private TaggingStatus forUi;
    private final Factory taggingStatusFactory;

    public AutoTaggedBeaconTaggingStatus(Factory factory)
    {
        taggingStatusFactory = factory;
        building = (TaggingStatus)factory.create(null);
    }

    public void clearEndOfRecognition()
    {
        building.clearEndOfRecognition();
    }

    public boolean getJustDoneRecognition()
    {
        return building.getJustDoneRecognition();
    }

    public TaggedBeacon getTaggedBeacon()
    {
        return building.getTaggedBeacon();
    }

    public boolean isTagSessionActive()
    {
        return building.isTagSessionActive();
    }

    public void markEndOfRecognition()
    {
        building.markEndOfRecognition();
    }

    public void onConnecting(URL url)
    {
        building.onConnecting(url);
    }

    public void onRequestSent(URL url, byte abyte0[])
    {
        building.onRequestSent(url, abyte0);
    }

    public void onResponseReceived(URL url, o o)
    {
        building.onResponseReceived(url, o);
    }

    public void overallTaggingStart(TaggedBeaconData taggedbeacondata)
    {
        building.overallTaggingStart(taggedbeacondata);
    }

    public void readyForUi()
    {
        forUi = building;
        building = (TaggingStatus)taggingStatusFactory.create(null);
    }

    public void sendBeaconIfAvailable()
    {
        if (forUi != null)
        {
            forUi.sendBeaconIfAvailable();
        }
    }

    public void sendBeaconIfAvailable(TaggedBeacon taggedbeacon)
    {
        building.sendBeaconIfAvailable(taggedbeacon);
    }

    public void setOutcome(TaggingOutcome taggingoutcome)
    {
        building.setOutcome(taggingoutcome);
    }

    public void startRecordingTime()
    {
        building.startRecordingTime();
    }
}
