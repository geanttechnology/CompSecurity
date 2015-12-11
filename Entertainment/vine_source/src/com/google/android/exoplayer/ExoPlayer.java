// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;


// Referenced classes of package com.google.android.exoplayer:
//            MediaCodecVideoTrackRenderer, MediaCodecAudioTrackRenderer, ExoPlaybackException

public class ExoPlayer
{
    public static class Factory
    {

        public static ExoPlayer newInstance(int i, int j, int k)
        {
            return null;
        }

        public Factory()
        {
        }
    }

    public static interface Listener
    {

        public abstract void onPlayWhenReadyCommitted();

        public abstract void onPlayerError(ExoPlaybackException exoplaybackexception);

        public abstract void onPlayerStateChanged(boolean flag, int i);
    }


    public static final int STATE_BUFFERING = 3;
    public static final int STATE_ENDED = 4;
    public static final int STATE_IDLE = 1;
    public static final int STATE_PREPARING = 2;
    public static final int STATE_READY = 5;

    public ExoPlayer()
    {
    }

    public void addListener(Listener listener)
    {
    }

    public void blockingSendMessage(Object obj, Object obj1, Object obj2)
    {
    }

    public int getCurrentPosition()
    {
        return 0;
    }

    public int getDuration()
    {
        return 0;
    }

    public boolean getPlayWhenReady()
    {
        return false;
    }

    public void prepare(MediaCodecVideoTrackRenderer mediacodecvideotrackrenderer, MediaCodecAudioTrackRenderer mediacodecaudiotrackrenderer)
    {
    }

    public void release()
    {
    }

    public void seekTo(int i)
    {
    }

    public void sendMessage(Object obj, Object obj1, Object obj2)
    {
    }

    public void setPlayWhenReady(boolean flag)
    {
    }

    public void stop()
    {
    }
}
