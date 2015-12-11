// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics;

import com.shazam.h.x;

// Referenced classes of package com.shazam.android.analytics:
//            TaggedBeacon, TaggedBeaconData, TaggingOutcome

public interface TaggingStatus
    extends x
{

    public abstract void clearEndOfRecognition();

    public abstract boolean getJustDoneRecognition();

    public abstract TaggedBeacon getTaggedBeacon();

    public abstract boolean isTagSessionActive();

    public abstract void markEndOfRecognition();

    public abstract void overallTaggingStart(TaggedBeaconData taggedbeacondata);

    public abstract void sendBeaconIfAvailable();

    public abstract void sendBeaconIfAvailable(TaggedBeacon taggedbeacon);

    public abstract void setOutcome(TaggingOutcome taggingoutcome);

    public abstract void startRecordingTime();
}
