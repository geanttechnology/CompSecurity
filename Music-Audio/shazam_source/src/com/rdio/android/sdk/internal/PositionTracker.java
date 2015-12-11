// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal;

import com.google.a.d.e;
import com.rdio.android.core.events.playback.ReportPlaybackEvent;
import com.rdio.android.core.events.playback.ReportPlaybackEventInfo;
import com.rdio.android.core.events.playback.ReportPlaybackEventType;
import com.rdio.android.sdk.model.Track;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.rdio.android.sdk.internal:
//            PlaybackStateChangedEvent, PlayerManagerInternal

public class PositionTracker
{

    private e eventBus;
    int lastValidTimeSeen;
    private PlayerManagerInternal playerManager;
    TimerTask task;
    private Timer timer;

    public PositionTracker(e e1, PlayerManagerInternal playermanagerinternal)
    {
        eventBus = e1;
        playerManager = playermanagerinternal;
        lastValidTimeSeen = 0;
    }

    public void onPlaybackStateChanged(PlaybackStateChangedEvent playbackstatechangedevent)
    {
        if (playbackstatechangedevent.getState() == PlaybackStateChangedEvent.State.Loading)
        {
            lastValidTimeSeen = 0;
        }
        if (playbackstatechangedevent.getState() != PlaybackStateChangedEvent.State.Playing) goto _L2; else goto _L1
_L1:
        timer = new Timer();
        if (task != null)
        {
            task.cancel();
        }
        task = new TimerTask() {

            final PositionTracker this$0;

            public void run()
            {
                ReportPlaybackEventInfo reportplaybackeventinfo = new ReportPlaybackEventInfo();
                reportplaybackeventinfo.position = playerManager.getCurrentPosition();
                if (playerManager.getCurrentTrack() != null)
                {
                    reportplaybackeventinfo.trackKey = playerManager.getCurrentTrack().key;
                }
                if (reportplaybackeventinfo.position > 0)
                {
                    lastValidTimeSeen = reportplaybackeventinfo.position;
                }
                eventBus.post(new ReportPlaybackEvent(ReportPlaybackEventType.TrackPositionChanged, reportplaybackeventinfo));
                playerManager.updateListenersPosition(reportplaybackeventinfo.position);
            }

            
            {
                this$0 = PositionTracker.this;
                super();
            }
        };
        timer.scheduleAtFixedRate(task, 0L, 1000L);
_L6:
        if (playbackstatechangedevent.getState() == PlaybackStateChangedEvent.State.Error)
        {
            playbackstatechangedevent = new ReportPlaybackEventInfo();
            playbackstatechangedevent.trackKey = playerManager.getCurrentTrack().key;
            playbackstatechangedevent.position = lastValidTimeSeen;
            eventBus.post(new ReportPlaybackEvent(ReportPlaybackEventType.TrackSkipped, playbackstatechangedevent));
        }
_L4:
        return;
_L2:
        if (timer == null) goto _L4; else goto _L3
_L3:
        timer.cancel();
        if (true) goto _L6; else goto _L5
_L5:
    }


}
