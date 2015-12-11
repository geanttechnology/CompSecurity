// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer;

import android.view.Choreographer;

public final class SmoothFrameReleaseTimeHelper
    implements android.view.Choreographer.FrameCallback, MediaCodecVideoTrackRenderer.FrameReleaseTimeHelper
{

    private static final long CHOREOGRAPHER_SAMPLE_DELAY_MILLIS = 500L;
    private static final long MAX_ALLOWED_DRIFT_NS = 0x1312d00L;
    private static final int MIN_FRAMES_FOR_ADJUSTMENT = 6;
    private static final long VSYNC_OFFSET_PERCENTAGE = 80L;
    private long adjustedLastFrameTimeNs;
    private Choreographer choreographer;
    private int frameCount;
    private boolean haveSync;
    private long lastUnadjustedFrameTimeUs;
    private long pendingAdjustedFrameTimeNs;
    private long sampledVsyncTimeNs;
    private long syncFrameTimeNs;
    private long syncReleaseTimeNs;
    private final boolean usePrimaryDisplayVsync;
    private final long vsyncDurationNs;
    private final long vsyncOffsetNs;

    public SmoothFrameReleaseTimeHelper(float f, boolean flag)
    {
        usePrimaryDisplayVsync = flag;
        if (flag)
        {
            vsyncDurationNs = (long)(1000000000D / (double)f);
            vsyncOffsetNs = (vsyncDurationNs * 80L) / 100L;
            return;
        } else
        {
            vsyncDurationNs = -1L;
            vsyncOffsetNs = -1L;
            return;
        }
    }

    private static long closestVsync(long l, long l1, long l2)
    {
        l1 = ((l - l1) / l2) * l2 + l1;
        long l3;
        if (l <= l1)
        {
            l3 = l1 - l2;
        } else
        {
            l3 = l1;
            l1 += l2;
        }
        if (l1 - l < l - l3)
        {
            return l1;
        } else
        {
            return l3;
        }
    }

    private boolean isDriftTooLarge(long l, long l1)
    {
        long l2 = syncFrameTimeNs;
        return Math.abs(l1 - syncReleaseTimeNs - (l - l2)) > 0x1312d00L;
    }

    public final long adjustReleaseTime(long l, long l1)
    {
        long l4;
        l4 = l * 1000L;
        if (!haveSync)
        {
            break MISSING_BLOCK_LABEL_179;
        }
        if (l != lastUnadjustedFrameTimeUs)
        {
            frameCount = frameCount + 1;
            adjustedLastFrameTimeNs = pendingAdjustedFrameTimeNs;
        }
        if (frameCount < 6) goto _L2; else goto _L1
_L1:
        long l2;
        long l3;
        l2 = (l4 - syncFrameTimeNs) / (long)frameCount;
        l3 = adjustedLastFrameTimeNs + l2;
        if (isDriftTooLarge(l3, l1))
        {
            haveSync = false;
            l2 = l1;
            l3 = l4;
        } else
        {
            l2 = (syncReleaseTimeNs + l3) - syncFrameTimeNs;
        }
_L3:
        if (!haveSync)
        {
            syncFrameTimeNs = l4;
            syncReleaseTimeNs = l1;
            frameCount = 0;
            haveSync = true;
        }
        lastUnadjustedFrameTimeUs = l;
        pendingAdjustedFrameTimeNs = l3;
        if (sampledVsyncTimeNs == 0L)
        {
            return l2;
        } else
        {
            return closestVsync(l2, sampledVsyncTimeNs, vsyncDurationNs) - vsyncOffsetNs;
        }
_L2:
        if (isDriftTooLarge(l4, l1))
        {
            haveSync = false;
        }
        l2 = l1;
        l3 = l4;
          goto _L3
    }

    public final void disable()
    {
        if (usePrimaryDisplayVsync)
        {
            choreographer.removeFrameCallback(this);
            choreographer = null;
        }
    }

    public final void doFrame(long l)
    {
        sampledVsyncTimeNs = l;
        choreographer.postFrameCallbackDelayed(this, 500L);
    }

    public final void enable()
    {
        haveSync = false;
        if (usePrimaryDisplayVsync)
        {
            sampledVsyncTimeNs = 0L;
            choreographer = Choreographer.getInstance();
            choreographer.postFrameCallback(this);
        }
    }

    protected final void onSynced()
    {
    }
}
