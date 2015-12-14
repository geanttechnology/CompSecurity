// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.audio;

import android.media.AudioTrack;
import com.google.android.exoplayer.util.Util;

// Referenced classes of package com.google.android.exoplayer.audio:
//            AudioTrack

private static class <init>
{

    protected AudioTrack audioTrack;
    private boolean isPassthrough;
    private long lastRawPlaybackHeadPosition;
    private long passthroughWorkaroundPauseOffset;
    private long rawPlaybackHeadWrapCount;
    private int sampleRate;

    public long getPlaybackHeadPosition()
    {
        long l;
        long l1;
        l1 = 0xffffffffL & (long)audioTrack.getPlaybackHeadPosition();
        l = l1;
        if (Util.SDK_INT > 22) goto _L2; else goto _L1
_L1:
        l = l1;
        if (!isPassthrough) goto _L2; else goto _L3
_L3:
        if (audioTrack.getPlayState() != 1) goto _L5; else goto _L4
_L4:
        lastRawPlaybackHeadPosition = l1;
_L7:
        l = l1 + passthroughWorkaroundPauseOffset;
_L2:
        if (lastRawPlaybackHeadPosition > l)
        {
            rawPlaybackHeadWrapCount = rawPlaybackHeadWrapCount + 1L;
        }
        lastRawPlaybackHeadPosition = l;
        return (rawPlaybackHeadWrapCount << 32) + l;
_L5:
        if (audioTrack.getPlayState() == 2 && l1 == 0L)
        {
            passthroughWorkaroundPauseOffset = lastRawPlaybackHeadPosition;
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public long getPlaybackHeadPositionUs()
    {
        return (getPlaybackHeadPosition() * 0xf4240L) / (long)sampleRate;
    }

    public long getTimestampFramePosition()
    {
        throw new UnsupportedOperationException();
    }

    public long getTimestampNanoTime()
    {
        throw new UnsupportedOperationException();
    }

    public boolean overrideHasPendingData()
    {
        return Util.SDK_INT <= 22 && isPassthrough && audioTrack.getPlayState() == 2 && audioTrack.getPlaybackHeadPosition() == 0;
    }

    public void reconfigure(AudioTrack audiotrack, boolean flag)
    {
        audioTrack = audiotrack;
        isPassthrough = flag;
        lastRawPlaybackHeadPosition = 0L;
        rawPlaybackHeadWrapCount = 0L;
        passthroughWorkaroundPauseOffset = 0L;
        if (audiotrack != null)
        {
            sampleRate = audiotrack.getSampleRate();
        }
    }

    public boolean updateTimestamp()
    {
        return false;
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
