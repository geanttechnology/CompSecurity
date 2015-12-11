// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.reporting;

import com.rdio.android.core.events.playback.ReportPlaybackEventType;

// Referenced classes of package com.rdio.android.core.reporting:
//            PlaybackEventReporter

static class tType
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
