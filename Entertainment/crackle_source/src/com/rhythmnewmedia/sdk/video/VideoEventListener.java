// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk.video;


// Referenced classes of package com.rhythmnewmedia.sdk.video:
//            RhythmVideoView

public interface VideoEventListener
{

    public abstract void onCompletion(RhythmVideoView rhythmvideoview, int i, int j, int k);

    public abstract void onError(RhythmVideoView rhythmvideoview, int i, int j, int k, int l);

    public abstract void onPrepared(RhythmVideoView rhythmvideoview, int i, int j);

    public abstract void playbackStarted(RhythmVideoView rhythmvideoview, boolean flag, int i, int j);

    public abstract void playbackStopped(RhythmVideoView rhythmvideoview, boolean flag, int i, int j);
}
