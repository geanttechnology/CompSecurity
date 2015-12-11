// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.player;


public interface VideoViewInterface
{
    public static interface OnCompletionListener
    {

        public abstract void onCompletion(VideoViewInterface videoviewinterface);
    }

    public static interface OnErrorListener
    {

        public abstract boolean onError(VideoViewInterface videoviewinterface, int i, int j);
    }

    public static interface OnPreparedListener
    {

        public abstract void onPrepared(VideoViewInterface videoviewinterface);
    }


    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getPlayingPosition();

    public abstract Object getTag();

    public abstract boolean hasStarted();

    public abstract boolean isInPlaybackState();

    public abstract boolean isPaused();

    public abstract boolean isPlaying();

    public abstract void onPrepared();

    public abstract void pause();

    public abstract void resume();

    public abstract void seekTo(int i);

    public abstract void setAutoPlayOnPrepared(boolean flag);

    public abstract void setKeepScreenOn(boolean flag);

    public abstract void setLooping(boolean flag);

    public abstract void setOnCompletionListener(OnCompletionListener oncompletionlistener);

    public abstract void setOnErrorListener(OnErrorListener onerrorlistener);

    public abstract void setOnPreparedListener(OnPreparedListener onpreparedlistener);

    public abstract void setVideoPath(String s);

    public abstract void setVideoPathDirect(String s);

    public abstract void start();

    public abstract void stopPlayback();

    public abstract void suspend();
}
