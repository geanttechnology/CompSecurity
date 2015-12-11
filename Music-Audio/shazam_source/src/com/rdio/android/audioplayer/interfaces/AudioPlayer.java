// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.interfaces;

import com.rdio.android.audioplayer.sources.MediaSource;

// Referenced classes of package com.rdio.android.audioplayer.interfaces:
//            AudioPlayerListener

public interface AudioPlayer
{
    public static final class AudioPlaybackMode extends Enum
    {

        private static final AudioPlaybackMode $VALUES[];
        public static final AudioPlaybackMode Gapless;
        public static final AudioPlaybackMode Normal;

        public static AudioPlaybackMode valueOf(String s)
        {
            return (AudioPlaybackMode)Enum.valueOf(com/rdio/android/audioplayer/interfaces/AudioPlayer$AudioPlaybackMode, s);
        }

        public static AudioPlaybackMode[] values()
        {
            return (AudioPlaybackMode[])$VALUES.clone();
        }

        static 
        {
            Normal = new AudioPlaybackMode("Normal", 0);
            Gapless = new AudioPlaybackMode("Gapless", 1);
            $VALUES = (new AudioPlaybackMode[] {
                Normal, Gapless
            });
        }

        private AudioPlaybackMode(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class AudioPlayerState extends Enum
    {

        private static final AudioPlayerState $VALUES[];
        public static final AudioPlayerState Completed;
        public static final AudioPlayerState Error;
        public static final AudioPlayerState Prepared;
        public static final AudioPlayerState Preparing;
        public static final AudioPlayerState Ready;
        public static final AudioPlayerState Reset;
        public static final AudioPlayerState Resetting;
        public static final AudioPlayerState Uninitialized;
        public static final AudioPlayerState Uninitializing;

        public static AudioPlayerState valueOf(String s)
        {
            return (AudioPlayerState)Enum.valueOf(com/rdio/android/audioplayer/interfaces/AudioPlayer$AudioPlayerState, s);
        }

        public static AudioPlayerState[] values()
        {
            return (AudioPlayerState[])$VALUES.clone();
        }

        static 
        {
            Resetting = new AudioPlayerState("Resetting", 0);
            Reset = new AudioPlayerState("Reset", 1);
            Ready = new AudioPlayerState("Ready", 2);
            Preparing = new AudioPlayerState("Preparing", 3);
            Prepared = new AudioPlayerState("Prepared", 4);
            Completed = new AudioPlayerState("Completed", 5);
            Error = new AudioPlayerState("Error", 6);
            Uninitializing = new AudioPlayerState("Uninitializing", 7);
            Uninitialized = new AudioPlayerState("Uninitialized", 8);
            $VALUES = (new AudioPlayerState[] {
                Resetting, Reset, Ready, Preparing, Prepared, Completed, Error, Uninitializing, Uninitialized
            });
        }

        private AudioPlayerState(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class AudioStatusCode extends Enum
    {

        private static final AudioStatusCode $VALUES[];
        public static final AudioStatusCode Error;
        public static final AudioStatusCode ErrorBadValue;
        public static final AudioStatusCode ErrorInvalidOperation;
        public static final AudioStatusCode Success;
        public static final AudioStatusCode Unknown;
        private int value;

        public static AudioStatusCode valueOf(String s)
        {
            return (AudioStatusCode)Enum.valueOf(com/rdio/android/audioplayer/interfaces/AudioPlayer$AudioStatusCode, s);
        }

        public static AudioStatusCode[] values()
        {
            return (AudioStatusCode[])$VALUES.clone();
        }

        public final int getValue()
        {
            return value;
        }

        static 
        {
            Success = new AudioStatusCode("Success", 0, 0);
            Error = new AudioStatusCode("Error", 1, -1);
            ErrorBadValue = new AudioStatusCode("ErrorBadValue", 2, -2);
            ErrorInvalidOperation = new AudioStatusCode("ErrorInvalidOperation", 3, -3);
            Unknown = new AudioStatusCode("Unknown", 4, -4);
            $VALUES = (new AudioStatusCode[] {
                Success, Error, ErrorBadValue, ErrorInvalidOperation, Unknown
            });
        }

        private AudioStatusCode(String s, int i, int j)
        {
            super(s, i);
            value = j;
        }
    }


    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getLastReportedBufferedPercent();

    public abstract AudioPlaybackMode getPlaybackMode();

    public abstract int getSessionId();

    public abstract AudioPlayerState getState();

    public abstract String getStreamQuality();

    public abstract boolean isCompleted();

    public abstract boolean isPlaying();

    public abstract boolean isPrepared();

    public abstract boolean isPreparing();

    public abstract boolean isReset();

    public abstract boolean isResetting();

    public abstract void pause();

    public abstract boolean prepare();

    public abstract void prepareAsync();

    public abstract void release();

    public abstract void reset();

    public abstract void seekTo(int i);

    public abstract void setAudioPlayerListener(AudioPlayerListener audioplayerlistener);

    public abstract void setDataSource(MediaSource mediasource, com.rdio.android.audioplayer.extractors.MediaTypeUtil.MediaType mediatype, int i);

    public abstract void setNextDataSource(MediaSource mediasource);

    public abstract void setVolume(float f, float f1);

    public abstract void start();

    public abstract void stop();

    public abstract boolean supportsGaplessPlayback();
}
