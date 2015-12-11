// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics;

import com.shazam.model.analytics.TaggedBeaconSender;

// Referenced classes of package com.shazam.android.analytics:
//            TaggingStatus, TaggedBeacon

public class JustDoneRecognitionTaggedBeaconSender
    implements TaggedBeaconSender
{

    private final TaggingStatus taggingStatus;

    public JustDoneRecognitionTaggedBeaconSender(TaggingStatus taggingstatus)
    {
        taggingStatus = taggingstatus;
    }

    public void sendTagInfo(String s)
    {
        sendTagInfo(s, false);
    }

    public void sendTagInfo(String s, boolean flag)
    {
        TaggedBeacon taggedbeacon = taggingStatus.getTaggedBeacon();
        if (taggedbeacon != null)
        {
            if (flag)
            {
                taggedbeacon.stopInnerUiTime();
            }
            taggedbeacon.setTagResultVersion(s);
        }
        taggingStatus.sendBeaconIfAvailable();
    }
}
