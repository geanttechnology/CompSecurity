// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer;

import java.nio.ByteBuffer;

public class NativeAudio
{
    public static interface Events
    {

        public abstract void onEndMarker();
    }


    private static final String TAG = "NativeAudio";
    private Events listener;

    public NativeAudio()
    {
    }

    public native int createAudioEffect(int i);

    public native int createPcmAudioPlayer(int i, int j, boolean flag);

    public native void enableAudioEffect(int i, boolean flag);

    public native void flushPcmBuffer();

    public native short fxBassGetRoundedStrength(int i);

    public native boolean fxBassIsStrengthSupported(int i);

    public native void fxBassSetStrength(int i, short word0);

    public native short fxEqlzGetBandLevel(int i, short word0);

    public native int fxEqlzGetCenterBandFreq(int i, short word0);

    public native short fxEqlzGetCurrPreset(int i);

    public native int fxEqlzGetMaxBandFreq(int i, short word0);

    public native short fxEqlzGetMaxBandLevel(int i);

    public native int fxEqlzGetMinBandFreq(int i, short word0);

    public native short fxEqlzGetMinBandLevel(int i);

    public native short fxEqlzGetNumBands(int i);

    public native short fxEqlzGetNumPresets(int i);

    public native String fxEqlzGetPresetName(int i, short word0);

    public native boolean fxEqlzSetBandLevel(int i, short word0, short word1);

    public native boolean fxEqlzUsePreset(int i, short word0);

    public native short fxVirtGetRoundedStrength(int i);

    public native boolean fxVirtIsStrengthSupported(int i);

    public native void fxVirtSetStrength(int i, short word0);

    public native long getAudioDuration();

    public native long getAudioPosition();

    public native long getBytesEnqueued();

    public native boolean isAudioEffectEnabled(int i);

    public native void pauseAudio();

    public native void playAudio();

    public void raiseOnEndMarker()
    {
        if (listener != null)
        {
            listener.onEndMarker();
        }
    }

    public native void registerCallback();

    public native void releasePcmAudioPlayer();

    public native boolean setActiveAudioPlayer(int i);

    public native void setAudioPosition(long l);

    public native void setAudioVolume(float f);

    public native void setEndMarker(long l);

    public void setEventsListener(Events events)
    {
        listener = events;
    }

    public native void stopAudio();

    public native long writePcmBuffer(ByteBuffer bytebuffer, long l, long l1);

    static 
    {
        System.loadLibrary("NativeAudio");
    }
}
