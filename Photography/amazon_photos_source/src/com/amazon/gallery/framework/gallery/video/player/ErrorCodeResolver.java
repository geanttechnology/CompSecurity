// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.video.player;

import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.framework.gallery.metrics.VideoEvent;

public class ErrorCodeResolver
{

    private static ComponentProfiler metrics;

    public static int resolve(int i, int j)
    {
        if (j == 0)
        {
            j = i;
        }
        switch (j)
        {
        default:
            trackEvent(VideoEvent.UNEXPECTED_ERROR);
            return 0x7f0e022d;

        case 1: // '\001'
            trackEvent(VideoEvent.MEDIA_ERROR_UNKNOWN);
            return 0x7f0e022d;

        case 100: // 'd'
            trackEvent(VideoEvent.MEDIA_ERROR_SERVER_DIED);
            return 0x7f0e022b;

        case -110: 
            trackEvent(VideoEvent.MEDIA_ERROR_TIMED_OUT);
            return 0x7f0e022c;

        case -1004: 
            trackEvent(VideoEvent.MEDIA_ERROR_IO);
            return 0x7f0e0229;

        case -1007: 
            trackEvent(VideoEvent.MEDIA_ERROR_MALFORMED);
            return 0x7f0e022a;

        case -1010: 
            trackEvent(VideoEvent.MEDIA_ERROR_UNSUPPORTED);
            return 0x7f0e022e;

        case 1010: 
            trackEvent(VideoEvent.AttemptToPlayVideoLongerThan20Mins);
            break;
        }
        return 0x7f0e0228;
    }

    public static void setComponentProfiler(ComponentProfiler componentprofiler)
    {
        metrics = componentprofiler;
    }

    private static void trackEvent(VideoEvent videoevent)
    {
        if (metrics != null)
        {
            metrics.trackEvent(videoevent);
        }
    }
}
