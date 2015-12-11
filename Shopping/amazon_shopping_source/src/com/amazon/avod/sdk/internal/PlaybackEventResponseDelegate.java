// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk.internal;

import com.amazon.avod.sdk.PlaybackStateEventListener;
import com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventContext;

public class PlaybackEventResponseDelegate extends com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventResponse.Stub
{

    private final PlaybackStateEventListener mEventListener;

    public PlaybackEventResponseDelegate(PlaybackStateEventListener playbackstateeventlistener)
    {
        mEventListener = playbackstateeventlistener;
    }

    public void onPause(PlaybackSdkEventContext playbacksdkeventcontext)
    {
        if (mEventListener != null)
        {
            mEventListener.onPause(playbacksdkeventcontext);
        }
    }

    public void onResume(PlaybackSdkEventContext playbacksdkeventcontext)
    {
        if (mEventListener != null)
        {
            mEventListener.onResume(playbacksdkeventcontext);
        }
    }

    public void onSeekEnd(PlaybackSdkEventContext playbacksdkeventcontext)
    {
        if (mEventListener != null)
        {
            mEventListener.onSeekEnd(playbacksdkeventcontext);
        }
    }

    public void onSeekStart(long l, PlaybackSdkEventContext playbacksdkeventcontext)
    {
        if (mEventListener != null)
        {
            mEventListener.onSeekStart(l, playbacksdkeventcontext);
        }
    }

    public void onStart(PlaybackSdkEventContext playbacksdkeventcontext)
    {
        if (mEventListener != null)
        {
            mEventListener.onStart(playbacksdkeventcontext);
        }
    }

    public void onStop(PlaybackSdkEventContext playbacksdkeventcontext)
    {
        if (mEventListener != null)
        {
            mEventListener.onStop(playbacksdkeventcontext);
        }
    }
}
