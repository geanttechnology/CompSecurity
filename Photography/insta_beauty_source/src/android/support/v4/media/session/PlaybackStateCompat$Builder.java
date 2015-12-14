// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media.session;

import android.os.SystemClock;

// Referenced classes of package android.support.v4.media.session:
//            PlaybackStateCompat

public final class _cls00
{

    private long mActions;
    private long mBufferedPosition;
    private CharSequence mErrorMessage;
    private long mPosition;
    private float mRate;
    private int mState;
    private long mUpdateTime;

    public PlaybackStateCompat build()
    {
        return new PlaybackStateCompat(mState, mPosition, mBufferedPosition, mRate, mActions, mErrorMessage, mUpdateTime, null);
    }

    public mUpdateTime setActions(long l)
    {
        mActions = l;
        return this;
    }

    public mActions setBufferedPosition(long l)
    {
        mBufferedPosition = l;
        return this;
    }

    public mBufferedPosition setErrorMessage(CharSequence charsequence)
    {
        mErrorMessage = charsequence;
        return this;
    }

    public mErrorMessage setState(int i, long l, float f)
    {
        return setState(i, l, f, SystemClock.elapsedRealtime());
    }

    public setState setState(int i, long l, float f, long l1)
    {
        mState = i;
        mPosition = l;
        mUpdateTime = l1;
        mRate = f;
        return this;
    }

    public ()
    {
    }

    public (PlaybackStateCompat playbackstatecompat)
    {
        mState = PlaybackStateCompat.access$300(playbackstatecompat);
        mPosition = PlaybackStateCompat.access$400(playbackstatecompat);
        mRate = PlaybackStateCompat.access$500(playbackstatecompat);
        mUpdateTime = PlaybackStateCompat.access$600(playbackstatecompat);
        mBufferedPosition = PlaybackStateCompat.access$700(playbackstatecompat);
        mActions = PlaybackStateCompat.access$800(playbackstatecompat);
        mErrorMessage = PlaybackStateCompat.access$900(playbackstatecompat);
    }
}
