// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import com.google.android.exoplayer.util.Assertions;

// Referenced classes of package com.google.android.exoplayer:
//            ExoPlaybackException, MediaClock

public abstract class TrackRenderer
    implements ExoPlayer.ExoPlayerComponent
{

    public static final long END_OF_TRACK_US = -3L;
    public static final long MATCH_LONGEST_US = -2L;
    protected static final int STATE_ENABLED = 2;
    protected static final int STATE_IGNORE = -1;
    protected static final int STATE_PREPARED = 1;
    protected static final int STATE_RELEASED = -2;
    protected static final int STATE_STARTED = 3;
    protected static final int STATE_UNPREPARED = 0;
    public static final long UNKNOWN_TIME_US = -1L;
    private int state;

    public TrackRenderer()
    {
    }

    final void disable()
        throws ExoPlaybackException
    {
        boolean flag;
        if (state == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        state = 1;
        onDisabled();
    }

    protected abstract int doPrepare(long l)
        throws ExoPlaybackException;

    protected abstract void doSomeWork(long l, long l1)
        throws ExoPlaybackException;

    final void enable(long l, boolean flag)
        throws ExoPlaybackException
    {
        boolean flag1 = true;
        if (state != 1)
        {
            flag1 = false;
        }
        Assertions.checkState(flag1);
        state = 2;
        onEnabled(l, flag);
    }

    protected abstract long getBufferedPositionUs();

    protected abstract long getDurationUs();

    protected MediaClock getMediaClock()
    {
        return null;
    }

    protected final int getState()
    {
        return state;
    }

    public void handleMessage(int i, Object obj)
        throws ExoPlaybackException
    {
    }

    protected abstract boolean isEnded();

    protected abstract boolean isReady();

    protected abstract void maybeThrowError()
        throws ExoPlaybackException;

    protected void onDisabled()
        throws ExoPlaybackException
    {
    }

    protected void onEnabled(long l, boolean flag)
        throws ExoPlaybackException
    {
    }

    protected void onReleased()
        throws ExoPlaybackException
    {
    }

    protected void onStarted()
        throws ExoPlaybackException
    {
    }

    protected void onStopped()
        throws ExoPlaybackException
    {
    }

    final int prepare(long l)
        throws ExoPlaybackException
    {
label0:
        {
            boolean flag1 = false;
            boolean flag;
            if (state == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Assertions.checkState(flag);
            state = doPrepare(l);
            if (state != 0 && state != 1)
            {
                flag = flag1;
                if (state != -1)
                {
                    break label0;
                }
            }
            flag = true;
        }
        Assertions.checkState(flag);
        return state;
    }

    final void release()
        throws ExoPlaybackException
    {
        boolean flag;
        if (state != 2 && state != 3 && state != -2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        state = -2;
        onReleased();
    }

    protected abstract void seekTo(long l)
        throws ExoPlaybackException;

    final void start()
        throws ExoPlaybackException
    {
        boolean flag;
        if (state == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        state = 3;
        onStarted();
    }

    final void stop()
        throws ExoPlaybackException
    {
        boolean flag;
        if (state == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        state = 2;
        onStopped();
    }
}
