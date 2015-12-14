// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.metrics;


public final class VideoEvent extends Enum
{

    private static final VideoEvent $VALUES[];
    public static final VideoEvent AttemptToPlayVideoLongerThan20Mins;
    public static final VideoEvent EndVideo;
    public static final VideoEvent MEDIA_ERROR_IO;
    public static final VideoEvent MEDIA_ERROR_MALFORMED;
    public static final VideoEvent MEDIA_ERROR_SERVER_DIED;
    public static final VideoEvent MEDIA_ERROR_TIMED_OUT;
    public static final VideoEvent MEDIA_ERROR_UNKNOWN;
    public static final VideoEvent MEDIA_ERROR_UNSUPPORTED;
    public static final VideoEvent PreloadVideo;
    public static final VideoEvent RebufferVideo;
    public static final VideoEvent StartPlayingVideo;
    public static final VideoEvent StartVideo;
    public static final VideoEvent UNEXPECTED_ERROR;

    private VideoEvent(String s, int i)
    {
        super(s, i);
    }

    public static VideoEvent valueOf(String s)
    {
        return (VideoEvent)Enum.valueOf(com/amazon/gallery/framework/gallery/metrics/VideoEvent, s);
    }

    public static VideoEvent[] values()
    {
        return (VideoEvent[])$VALUES.clone();
    }

    static 
    {
        StartVideo = new VideoEvent("StartVideo", 0);
        EndVideo = new VideoEvent("EndVideo", 1);
        StartPlayingVideo = new VideoEvent("StartPlayingVideo", 2);
        PreloadVideo = new VideoEvent("PreloadVideo", 3);
        RebufferVideo = new VideoEvent("RebufferVideo", 4);
        MEDIA_ERROR_UNKNOWN = new VideoEvent("MEDIA_ERROR_UNKNOWN", 5);
        MEDIA_ERROR_SERVER_DIED = new VideoEvent("MEDIA_ERROR_SERVER_DIED", 6);
        MEDIA_ERROR_TIMED_OUT = new VideoEvent("MEDIA_ERROR_TIMED_OUT", 7);
        MEDIA_ERROR_IO = new VideoEvent("MEDIA_ERROR_IO", 8);
        MEDIA_ERROR_MALFORMED = new VideoEvent("MEDIA_ERROR_MALFORMED", 9);
        MEDIA_ERROR_UNSUPPORTED = new VideoEvent("MEDIA_ERROR_UNSUPPORTED", 10);
        UNEXPECTED_ERROR = new VideoEvent("UNEXPECTED_ERROR", 11);
        AttemptToPlayVideoLongerThan20Mins = new VideoEvent("AttemptToPlayVideoLongerThan20Mins", 12);
        $VALUES = (new VideoEvent[] {
            StartVideo, EndVideo, StartPlayingVideo, PreloadVideo, RebufferVideo, MEDIA_ERROR_UNKNOWN, MEDIA_ERROR_SERVER_DIED, MEDIA_ERROR_TIMED_OUT, MEDIA_ERROR_IO, MEDIA_ERROR_MALFORMED, 
            MEDIA_ERROR_UNSUPPORTED, UNEXPECTED_ERROR, AttemptToPlayVideoLongerThan20Mins
        });
    }
}
