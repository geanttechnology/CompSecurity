// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk;

import com.rdio.android.audioplayer.interfaces.AudioError;

public interface PlayerListener
{
    public static final class PlayState extends Enum
    {

        private static final PlayState $VALUES[];
        public static final PlayState Error;
        public static final PlayState Loading;
        public static final PlayState None;
        public static final PlayState Paused;
        public static final PlayState Playing;
        public static final PlayState Stopped;

        public static PlayState valueOf(String s)
        {
            return (PlayState)Enum.valueOf(com/rdio/android/sdk/PlayerListener$PlayState, s);
        }

        public static PlayState[] values()
        {
            return (PlayState[])$VALUES.clone();
        }

        static 
        {
            Loading = new PlayState("Loading", 0);
            Playing = new PlayState("Playing", 1);
            Paused = new PlayState("Paused", 2);
            Stopped = new PlayState("Stopped", 3);
            Error = new PlayState("Error", 4);
            None = new PlayState("None", 5);
            $VALUES = (new PlayState[] {
                Loading, Playing, Paused, Stopped, Error, None
            });
        }

        private PlayState(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract void onBufferingEnded();

    public abstract void onBufferingStarted();

    public abstract void onComplete();

    public abstract void onError(AudioError audioerror);

    public abstract void onPlayStateChanged(PlayState playstate);

    public abstract void onPositionUpdate(int i);

    public abstract void onPrepared();

    public abstract void onSeekCompleted();

    public abstract void onSeekStarted();
}
