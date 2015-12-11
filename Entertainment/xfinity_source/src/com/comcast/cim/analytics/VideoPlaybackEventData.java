// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.analytics;


// Referenced classes of package com.comcast.cim.analytics:
//            XfinityEventData

public class VideoPlaybackEventData extends XfinityEventData
{

    public VideoPlaybackEventData()
    {
        super("videoPlayback");
    }

    public VideoPlaybackEventData(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7)
    {
        super("videoPlayback");
        addData("appName", s);
        addData("appVersion", s1);
        addData("omnitureTrackingKey", s2);
        addData("eventType", s3);
        addData("trackingEntityType", s4);
        addData("networkName", s5);
        addData("mediaId", s6);
        addData("trackingDuration", s7);
    }
}
