// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events.playback;


// Referenced classes of package com.rdio.android.core.events.playback:
//            ReportPlaybackEventType, ReportPlaybackEventInfo

public class ReportPlaybackEvent
{

    private ReportPlaybackEventType eventType;
    private ReportPlaybackEventInfo info;

    public ReportPlaybackEvent(ReportPlaybackEventType reportplaybackeventtype, ReportPlaybackEventInfo reportplaybackeventinfo)
    {
        info = reportplaybackeventinfo;
        eventType = reportplaybackeventtype;
    }

    public ReportPlaybackEventType getEventType()
    {
        return eventType;
    }

    public ReportPlaybackEventInfo getInfo()
    {
        return info;
    }
}
