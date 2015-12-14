// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;


// Referenced classes of package com.google.android.exoplayer:
//            TrackRenderer

public final class DummyTrackRenderer extends TrackRenderer
{

    public DummyTrackRenderer()
    {
    }

    protected int doPrepare(long l)
    {
        return -1;
    }

    protected void doSomeWork(long l, long l1)
    {
        throw new IllegalStateException();
    }

    protected long getBufferedPositionUs()
    {
        throw new IllegalStateException();
    }

    protected long getDurationUs()
    {
        throw new IllegalStateException();
    }

    protected boolean isEnded()
    {
        throw new IllegalStateException();
    }

    protected boolean isReady()
    {
        throw new IllegalStateException();
    }

    protected void maybeThrowError()
    {
        throw new IllegalStateException();
    }

    protected void seekTo(long l)
    {
        throw new IllegalStateException();
    }
}
