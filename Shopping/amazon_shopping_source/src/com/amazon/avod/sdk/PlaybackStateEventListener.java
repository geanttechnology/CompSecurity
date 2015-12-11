// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk;

import com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventContext;

public interface PlaybackStateEventListener
{

    public abstract void onPause(PlaybackSdkEventContext playbacksdkeventcontext);

    public abstract void onResume(PlaybackSdkEventContext playbacksdkeventcontext);

    public abstract void onSeekEnd(PlaybackSdkEventContext playbacksdkeventcontext);

    public abstract void onSeekStart(long l, PlaybackSdkEventContext playbacksdkeventcontext);

    public abstract void onStart(PlaybackSdkEventContext playbacksdkeventcontext);

    public abstract void onStop(PlaybackSdkEventContext playbacksdkeventcontext);
}
