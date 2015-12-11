// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk;

import com.rdio.android.sdk.model.Track;

// Referenced classes of package com.rdio.android.sdk:
//            PlayerListener, PlayRequest

public interface PlayerManager
{

    public abstract void addPlayerListener(PlayerListener playerlistener);

    public abstract int getCurrentDuration();

    public abstract int getCurrentPosition();

    public abstract Track getCurrentTrack();

    public abstract PlayerListener.PlayState getState();

    public abstract boolean isPlaying();

    public abstract void pause();

    public abstract void play();

    public abstract void play(PlayRequest playrequest);

    public abstract void seekTo(int i);

    public abstract void skipNext();

    public abstract void skipPrev();

    public abstract void stop();
}
