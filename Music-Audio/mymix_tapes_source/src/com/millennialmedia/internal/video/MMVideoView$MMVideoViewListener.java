// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;


// Referenced classes of package com.millennialmedia.internal.video:
//            MMVideoView

public static interface 
{

    public abstract void onBufferingUpdate(MMVideoView mmvideoview, int i);

    public abstract void onComplete(MMVideoView mmvideoview);

    public abstract void onError(MMVideoView mmvideoview);

    public abstract void onMuted(MMVideoView mmvideoview);

    public abstract void onPause(MMVideoView mmvideoview);

    public abstract void onPrepared(MMVideoView mmvideoview);

    public abstract void onProgress(MMVideoView mmvideoview, int i);

    public abstract void onReadyToStart(MMVideoView mmvideoview);

    public abstract void onSeek(MMVideoView mmvideoview);

    public abstract void onStart(MMVideoView mmvideoview);

    public abstract void onStop(MMVideoView mmvideoview);

    public abstract void onUnmuted(MMVideoView mmvideoview);
}
