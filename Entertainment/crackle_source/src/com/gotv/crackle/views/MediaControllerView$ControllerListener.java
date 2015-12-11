// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;


// Referenced classes of package com.gotv.crackle.views:
//            MediaControllerView

public static interface 
{

    public abstract void doToggleFullscreen();

    public abstract void onAboutToSeekTo(int i);

    public abstract void onBuffer();

    public abstract void onBufferTooLong();

    public abstract void onPrepared();

    public abstract void onSeekDragging();

    public abstract boolean onSeekTo(int i);

    public abstract void onStopBuffering();

    public abstract void onStopDragging();

    public abstract void onVideoPlaybackPaused();

    public abstract void onVideoPlaybackStarted();

    public abstract void onVideoPlaybackStopped();

    public abstract void onVisibilityChanged(boolean flag);
}
