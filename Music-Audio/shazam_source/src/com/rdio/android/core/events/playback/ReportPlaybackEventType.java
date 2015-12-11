// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events.playback;


public final class ReportPlaybackEventType extends Enum
{

    private static final ReportPlaybackEventType $VALUES[];
    public static final ReportPlaybackEventType LoadingParent;
    public static final ReportPlaybackEventType TrackEnded;
    public static final ReportPlaybackEventType TrackError;
    public static final ReportPlaybackEventType TrackLoading;
    public static final ReportPlaybackEventType TrackPaused;
    public static final ReportPlaybackEventType TrackPositionChanged;
    public static final ReportPlaybackEventType TrackReady;
    public static final ReportPlaybackEventType TrackResumed;
    public static final ReportPlaybackEventType TrackSeek;
    public static final ReportPlaybackEventType TrackSkipped;
    public static final ReportPlaybackEventType TrackStarted;

    private ReportPlaybackEventType(String s, int i)
    {
        super(s, i);
    }

    public static ReportPlaybackEventType valueOf(String s)
    {
        return (ReportPlaybackEventType)Enum.valueOf(com/rdio/android/core/events/playback/ReportPlaybackEventType, s);
    }

    public static ReportPlaybackEventType[] values()
    {
        return (ReportPlaybackEventType[])$VALUES.clone();
    }

    static 
    {
        LoadingParent = new ReportPlaybackEventType("LoadingParent", 0);
        TrackLoading = new ReportPlaybackEventType("TrackLoading", 1);
        TrackReady = new ReportPlaybackEventType("TrackReady", 2);
        TrackStarted = new ReportPlaybackEventType("TrackStarted", 3);
        TrackEnded = new ReportPlaybackEventType("TrackEnded", 4);
        TrackSkipped = new ReportPlaybackEventType("TrackSkipped", 5);
        TrackPaused = new ReportPlaybackEventType("TrackPaused", 6);
        TrackResumed = new ReportPlaybackEventType("TrackResumed", 7);
        TrackSeek = new ReportPlaybackEventType("TrackSeek", 8);
        TrackError = new ReportPlaybackEventType("TrackError", 9);
        TrackPositionChanged = new ReportPlaybackEventType("TrackPositionChanged", 10);
        $VALUES = (new ReportPlaybackEventType[] {
            LoadingParent, TrackLoading, TrackReady, TrackStarted, TrackEnded, TrackSkipped, TrackPaused, TrackResumed, TrackSeek, TrackError, 
            TrackPositionChanged
        });
    }
}
