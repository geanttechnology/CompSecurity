// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.interfaces;


// Referenced classes of package com.rdio.android.audioplayer.interfaces:
//            AudioError, AudioInfo

public interface AudioPlayerListener
{

    public abstract void onComplete();

    public abstract void onError(AudioError audioerror);

    public abstract void onInfo(AudioInfo audioinfo);

    public abstract void onPrepared();

    public abstract void onResetComplete();

    public abstract void onSeekCompleted();

    public abstract void onSeekStarted();
}
