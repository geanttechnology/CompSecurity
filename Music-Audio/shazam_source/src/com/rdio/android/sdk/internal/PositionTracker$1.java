// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal;

import com.google.a.d.e;
import com.rdio.android.core.events.playback.ReportPlaybackEvent;
import com.rdio.android.core.events.playback.ReportPlaybackEventInfo;
import com.rdio.android.core.events.playback.ReportPlaybackEventType;
import com.rdio.android.sdk.model.Track;
import java.util.TimerTask;

// Referenced classes of package com.rdio.android.sdk.internal:
//            PositionTracker, PlayerManagerInternal

class this._cls0 extends TimerTask
{

    final PositionTracker this$0;

    public void run()
    {
        ReportPlaybackEventInfo reportplaybackeventinfo = new ReportPlaybackEventInfo();
        reportplaybackeventinfo.position = PositionTracker.access$000(PositionTracker.this).getCurrentPosition();
        if (PositionTracker.access$000(PositionTracker.this).getCurrentTrack() != null)
        {
            reportplaybackeventinfo.trackKey = PositionTracker.access$000(PositionTracker.this).getCurrentTrack().key;
        }
        if (reportplaybackeventinfo.position > 0)
        {
            lastValidTimeSeen = reportplaybackeventinfo.position;
        }
        PositionTracker.access$100(PositionTracker.this).post(new ReportPlaybackEvent(ReportPlaybackEventType.TrackPositionChanged, reportplaybackeventinfo));
        PositionTracker.access$000(PositionTracker.this).updateListenersPosition(reportplaybackeventinfo.position);
    }

    backEventType()
    {
        this$0 = PositionTracker.this;
        super();
    }
}
