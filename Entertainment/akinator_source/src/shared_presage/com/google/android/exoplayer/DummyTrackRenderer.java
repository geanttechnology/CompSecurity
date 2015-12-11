// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer;


// Referenced classes of package shared_presage.com.google.android.exoplayer:
//            TrackRenderer

public final class DummyTrackRenderer extends TrackRenderer
{

    public DummyTrackRenderer()
    {
    }

    protected final int doPrepare(long l)
    {
        return -1;
    }

    protected final void doSomeWork(long l, long l1)
    {
        throw new IllegalStateException();
    }

    protected final long getBufferedPositionUs()
    {
        throw new IllegalStateException();
    }

    protected final long getDurationUs()
    {
        throw new IllegalStateException();
    }

    protected final boolean isEnded()
    {
        throw new IllegalStateException();
    }

    protected final boolean isReady()
    {
        throw new IllegalStateException();
    }

    protected final void maybeThrowError()
    {
        throw new IllegalStateException();
    }

    protected final void seekTo(long l)
    {
        throw new IllegalStateException();
    }
}
