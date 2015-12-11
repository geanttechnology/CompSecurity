// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics;

import com.shazam.model.analytics.TaggedBeaconSender;

// Referenced classes of package com.shazam.android.analytics:
//            TaggedBeacon, TaggingStatus

public class LegacyTaggedBeaconSender
    implements TaggedBeaconSender
{

    private final TaggedBeacon taggedBeacon;
    private final TaggingStatus taggingStatus;

    public LegacyTaggedBeaconSender(TaggingStatus taggingstatus, TaggedBeacon taggedbeacon)
    {
        taggedBeacon = taggedbeacon;
        taggingStatus = taggingstatus;
    }

    public void sendTagInfo(String s)
    {
        sendTagInfo(s, false);
    }

    public void sendTagInfo(String s, boolean flag)
    {
        if (flag)
        {
            taggedBeacon.stopInnerUiTime();
        }
        taggedBeacon.setTagResultVersion(s);
        taggingStatus.sendBeaconIfAvailable(taggedBeacon);
    }
}
