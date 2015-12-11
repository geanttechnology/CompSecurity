// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.reporting;

import com.google.a.d.e;
import com.rdio.android.core.events.playback.ReportPlaybackEvent;
import com.rdio.android.core.events.playback.ReportPlaybackEventInfo;
import com.rdio.android.core.events.playback.ReportPlaybackEventType;
import com.rdio.android.core.util.Logging;

// Referenced classes of package com.rdio.android.core.reporting:
//            TrackPlayEvent, BaseEventUploader, PlayEvent, PlayEventType

public class PlaybackEventReporter
{

    private static final String TAG = "PlaybackEventReporter";
    private static final int TIME_INITIAL_PLAY_EVENT = 2000;
    private static final int TIME_SECONDARY_PLAY_EVENT = 30000;
    private TrackPlayEvent currentTrackPlayEvent;
    private int deviceType;
    private e eventBus;
    private long eventStartTime;
    private BaseEventUploader eventUploader;
    private Logging logging;

    public PlaybackEventReporter(int i, BaseEventUploader baseeventuploader, e e1, Logging logging1)
    {
        eventBus = e1;
        eventUploader = baseeventuploader;
        logging = logging1;
        deviceType = i;
        e1.register(this);
    }

    private void finishCurrentEvent()
    {
        if (currentTrackPlayEvent == null)
        {
            return;
        }
        if (currentTrackPlayEvent.shouldSendToServer)
        {
            logging.log(3, "PlaybackEventReporter", (new StringBuilder("Submitting event for ")).append(currentTrackPlayEvent.getTrackKey()).toString());
            if (!persistEvent(currentTrackPlayEvent))
            {
                eventUploader.addItemToProcess(currentTrackPlayEvent.toJson());
            }
        } else
        {
            logging.log(3, "PlaybackEventReporter", (new StringBuilder("Dropping play event for ")).append(currentTrackPlayEvent.getTrackKey()).append(". Event has not passed initial play time").toString());
        }
        currentTrackPlayEvent = null;
    }

    private int getElapsedTimeAndReset()
    {
        if (eventStartTime == 0L)
        {
            return 0;
        } else
        {
            int i = (int)(System.currentTimeMillis() - eventStartTime);
            eventStartTime = 0L;
            return i;
        }
    }

    private void handleTrackEnded(ReportPlaybackEvent reportplaybackevent)
    {
        if (isEventValid(reportplaybackevent))
        {
            logging.log(3, "PlaybackEventReporter", (new StringBuilder("Sending finish event for ")).append(currentTrackPlayEvent.getTrackKey()).toString());
            currentTrackPlayEvent.addSubEvent(new PlayEvent(PlayEventType.Finish));
        }
        finishCurrentEvent();
    }

    private void handleTrackError(ReportPlaybackEvent reportplaybackevent)
    {
        if (!isEventValid(reportplaybackevent))
        {
            return;
        } else
        {
            PlayEvent playevent = new PlayEvent(PlayEventType.Error);
            playevent.put("errorType", reportplaybackevent.getInfo().errorType);
            playevent.put("errorMessage", reportplaybackevent.getInfo().errorMessage);
            currentTrackPlayEvent.addSubEvent(playevent);
            currentTrackPlayEvent.shouldSendToServer = true;
            finishCurrentEvent();
            return;
        }
    }

    private void handleTrackLoading(ReportPlaybackEvent reportplaybackevent)
    {
        finishCurrentEvent();
        reportplaybackevent = reportplaybackevent.getInfo();
        int i = getElapsedTimeAndReset();
        currentTrackPlayEvent = new TrackPlayEvent(deviceType, ((ReportPlaybackEventInfo) (reportplaybackevent)).trackKey, PlayEventType.Play);
        if (i > 0)
        {
            currentTrackPlayEvent.put("sourceLoadTimeMs", i);
            logging.log(3, "PlaybackEventReporter", (new StringBuilder("Starting event for ")).append(((ReportPlaybackEventInfo) (reportplaybackevent)).trackKey).append(". Source load time ").append(i).append(" ms").toString());
        }
        currentTrackPlayEvent.streamType = ((ReportPlaybackEventInfo) (reportplaybackevent)).streamType;
        currentTrackPlayEvent.isOfflineStream = ((ReportPlaybackEventInfo) (reportplaybackevent)).isOfflinePlay;
        currentTrackPlayEvent.parentKey = ((ReportPlaybackEventInfo) (reportplaybackevent)).parentKey;
        startTrackingElapsedTime();
    }

    private void handleTrackPaused(ReportPlaybackEvent reportplaybackevent)
    {
        if (!isEventValid(reportplaybackevent))
        {
            return;
        }
        if (currentTrackPlayEvent.recordedPause)
        {
            logging.log(5, "PlaybackEventReporter", "TrackPause event received while paused, ignoring");
            return;
        } else
        {
            currentTrackPlayEvent.recordedPause = true;
            PlayEvent playevent = new PlayEvent(PlayEventType.Pause);
            playevent.playTimeMs = reportplaybackevent.getInfo().position;
            currentTrackPlayEvent.addSubEvent(playevent);
            return;
        }
    }

    private void handleTrackPositionChanged(ReportPlaybackEvent reportplaybackevent)
    {
        if (isEventValid(reportplaybackevent))
        {
            reportplaybackevent = reportplaybackevent.getInfo();
            if (!currentTrackPlayEvent.shouldSendToServer && ((ReportPlaybackEventInfo) (reportplaybackevent)).position >= 2000)
            {
                currentTrackPlayEvent.shouldSendToServer = true;
                return;
            }
            if (!currentTrackPlayEvent.hasPlayedPastSignificantTime && ((ReportPlaybackEventInfo) (reportplaybackevent)).position >= 30000)
            {
                currentTrackPlayEvent.hasPlayedPastSignificantTime = true;
                reportplaybackevent = new PlayEvent(PlayEventType.Time);
                reportplaybackevent.playTimeMs = 30000;
                currentTrackPlayEvent.addSubEvent(reportplaybackevent);
                return;
            }
        }
    }

    private void handleTrackReady(ReportPlaybackEvent reportplaybackevent)
    {
        if (!isEventValid(reportplaybackevent))
        {
            return;
        }
        int i = getElapsedTimeAndReset();
        if (i > 0)
        {
            logging.log(3, "PlaybackEventReporter", (new StringBuilder("Track ready, connect time ")).append(i).append(" ms").toString());
            currentTrackPlayEvent.put("connectTimeMs", i);
        }
        reportplaybackevent = reportplaybackevent.getInfo();
        currentTrackPlayEvent.streamType = ((ReportPlaybackEventInfo) (reportplaybackevent)).streamType;
        if (((ReportPlaybackEventInfo) (reportplaybackevent)).streamUri != null)
        {
            currentTrackPlayEvent.put("streamURL", ((ReportPlaybackEventInfo) (reportplaybackevent)).streamUri);
        }
        currentTrackPlayEvent.isOfflineStream = ((ReportPlaybackEventInfo) (reportplaybackevent)).isOfflinePlay;
        startTrackingElapsedTime();
    }

    private void handleTrackResumed(ReportPlaybackEvent reportplaybackevent)
    {
        if (!isEventValid(reportplaybackevent))
        {
            return;
        } else
        {
            currentTrackPlayEvent.recordedPause = false;
            PlayEvent playevent = new PlayEvent(PlayEventType.Resume);
            playevent.playTimeMs = reportplaybackevent.getInfo().position;
            currentTrackPlayEvent.addSubEvent(playevent);
            return;
        }
    }

    private void handleTrackSeek(ReportPlaybackEvent reportplaybackevent)
    {
        if (!isEventValid(reportplaybackevent))
        {
            return;
        } else
        {
            PlayEvent playevent = new PlayEvent(PlayEventType.Pause);
            playevent.playTimeMs = reportplaybackevent.getInfo().position;
            currentTrackPlayEvent.addSubEvent(playevent);
            playevent = new PlayEvent(PlayEventType.Resume);
            playevent.playTimeMs = reportplaybackevent.getInfo().seekToPosition;
            currentTrackPlayEvent.addSubEvent(playevent);
            return;
        }
    }

    private void handleTrackSkipped(ReportPlaybackEvent reportplaybackevent)
    {
        if (!isEventValid(reportplaybackevent))
        {
            return;
        } else
        {
            PlayEvent playevent = new PlayEvent(PlayEventType.Skip);
            playevent.playTimeMs = reportplaybackevent.getInfo().position;
            currentTrackPlayEvent.addSubEvent(playevent);
            finishCurrentEvent();
            return;
        }
    }

    private void handleTrackStarted(ReportPlaybackEvent reportplaybackevent)
    {
        if (isEventValid(reportplaybackevent))
        {
            reportplaybackevent = reportplaybackevent.getInfo();
            int i = getElapsedTimeAndReset();
            if (i > 0)
            {
                logging.log(3, "PlaybackEventReporter", (new StringBuilder("Track ")).append(((ReportPlaybackEventInfo) (reportplaybackevent)).trackKey).append(" started, time ").append(i).append(" ms").toString());
                currentTrackPlayEvent.put("prepareTimeMs", i);
                return;
            }
        }
    }

    private boolean isEventValid(ReportPlaybackEvent reportplaybackevent)
    {
        if (currentTrackPlayEvent == null)
        {
            logging.log(6, "PlaybackEventReporter", (new StringBuilder("Current event is null when handling event type: ")).append(reportplaybackevent.getEventType()).toString());
            return false;
        }
        if (!currentTrackPlayEvent.getTrackKey().equals(reportplaybackevent.getInfo().trackKey))
        {
            logging.log(6, "PlaybackEventReporter", (new StringBuilder("Current event is for ")).append(currentTrackPlayEvent.getTrackKey()).append(" and received event for ").append(reportplaybackevent.getInfo().trackKey).toString());
            return false;
        } else
        {
            return true;
        }
    }

    private void startTrackingElapsedTime()
    {
        eventStartTime = System.currentTimeMillis();
    }

    public void onReportPlaybackEvent(ReportPlaybackEvent reportplaybackevent)
    {
        logging.log(3, "PlaybackEventReporter", (new StringBuilder("Reporting event type: ")).append(reportplaybackevent.getEventType()).toString());
        static class _cls1
        {

            static final int $SwitchMap$com$rdio$android$core$events$playback$ReportPlaybackEventType[];

            static 
            {
                $SwitchMap$com$rdio$android$core$events$playback$ReportPlaybackEventType = new int[ReportPlaybackEventType.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$events$playback$ReportPlaybackEventType[ReportPlaybackEventType.LoadingParent.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$events$playback$ReportPlaybackEventType[ReportPlaybackEventType.TrackLoading.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$events$playback$ReportPlaybackEventType[ReportPlaybackEventType.TrackReady.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$events$playback$ReportPlaybackEventType[ReportPlaybackEventType.TrackStarted.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$events$playback$ReportPlaybackEventType[ReportPlaybackEventType.TrackEnded.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$events$playback$ReportPlaybackEventType[ReportPlaybackEventType.TrackPaused.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$events$playback$ReportPlaybackEventType[ReportPlaybackEventType.TrackResumed.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$events$playback$ReportPlaybackEventType[ReportPlaybackEventType.TrackSeek.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$events$playback$ReportPlaybackEventType[ReportPlaybackEventType.TrackSkipped.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$events$playback$ReportPlaybackEventType[ReportPlaybackEventType.TrackError.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$events$playback$ReportPlaybackEventType[ReportPlaybackEventType.TrackPositionChanged.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.rdio.android.core.events.playback.ReportPlaybackEventType[reportplaybackevent.getEventType().ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            startTrackingElapsedTime();
            return;

        case 2: // '\002'
            handleTrackLoading(reportplaybackevent);
            return;

        case 3: // '\003'
            handleTrackReady(reportplaybackevent);
            return;

        case 4: // '\004'
            handleTrackStarted(reportplaybackevent);
            return;

        case 5: // '\005'
            handleTrackEnded(reportplaybackevent);
            return;

        case 6: // '\006'
            handleTrackPaused(reportplaybackevent);
            return;

        case 7: // '\007'
            handleTrackResumed(reportplaybackevent);
            return;

        case 8: // '\b'
            handleTrackSeek(reportplaybackevent);
            return;

        case 9: // '\t'
            handleTrackSkipped(reportplaybackevent);
            return;

        case 10: // '\n'
            handleTrackError(reportplaybackevent);
            return;

        case 11: // '\013'
            handleTrackPositionChanged(reportplaybackevent);
            break;
        }
    }

    protected boolean persistEvent(TrackPlayEvent trackplayevent)
    {
        return false;
    }
}
