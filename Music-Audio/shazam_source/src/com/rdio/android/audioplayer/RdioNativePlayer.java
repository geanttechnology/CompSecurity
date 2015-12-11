// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer;

import android.content.Context;
import android.util.Log;
import com.rdio.android.audioplayer.util.DeviceHelper;
import java.nio.ByteBuffer;

// Referenced classes of package com.rdio.android.audioplayer:
//            RdioAudioPlayer, NativeAudio

public class RdioNativePlayer extends RdioAudioPlayer
{

    private static final int DEFAULT_NATIVE_BUFFER_FRAMES = 512;
    private static final int DEFAULT_NATIVE_SAMPLING_RATE = 44100;
    private static final String TAG = "RdioNativePlayer";
    private static int audioSessionId = 0;
    private static NativeAudio nativeAudio = new NativeAudio();
    private ByteBuffer writeDirectBuffer;

    public RdioNativePlayer(Context context)
    {
        initialize(false, DeviceHelper.getNativeBufferSizeFrames(context));
        nativeAudio.registerCallback();
        nativeAudio.setEventsListener(new NativeAudio.Events() {

            final RdioNativePlayer this$0;

            public void onEndMarker()
            {
                onNativeAudioEvent(0);
            }

            
            {
                this$0 = RdioNativePlayer.this;
                super();
            }
        });
    }

    public static int calculateNumBufferFrames(int i)
    {
        if (i <= 0)
        {
            i = 512;
        }
        return DeviceHelper.getPlaybackNumFramesFactor() * i;
    }

    public static void initialize(boolean flag, int i)
    {
        initialize(flag, i, 44100);
    }

    public static void initialize(boolean flag, int i, int j)
    {
        i = calculateNumBufferFrames(i);
        i = nativeAudio.createPcmAudioPlayer(j, i, flag);
        if (i == 0)
        {
            Log.e("RdioNativePlayer", "Fatal error creating PCM audio player");
            return;
        }
        if (!nativeAudio.setActiveAudioPlayer(i))
        {
            Log.e("RdioNativePlayer", (new StringBuilder("Failed to set active audio player to ID: ")).append(i).toString());
            return;
        } else
        {
            audioSessionId = i;
            return;
        }
    }

    private void onNativeAudioEvent(int i)
    {
        onCompletion();
    }

    public static void shutdown()
    {
        nativeAudio.releasePcmAudioPlayer();
    }

    protected void flushAudio()
    {
        flushAudio(false);
    }

    protected void flushAudio(boolean flag)
    {
        nativeAudio.flushPcmBuffer();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        Thread.sleep(100L);
        return;
        InterruptedException interruptedexception;
        interruptedexception;
        interruptedexception.printStackTrace();
        return;
    }

    public int getCurrentPosition()
    {
        return (lastSeekOffsetMsec + (int)nativeAudio.getAudioPosition()) - currTrackOffsetMsec;
    }

    public int getSessionId()
    {
        return audioSessionId;
    }

    protected void internalPauseAudio()
    {
        nativeAudio.pauseAudio();
    }

    protected void internalPlayAudio()
    {
        nativeAudio.playAudio();
    }

    protected void internalStopAudio()
    {
        nativeAudio.stopAudio();
    }

    protected void prepareAudio()
    {
    }

    protected void releaseAudio()
    {
    }

    protected com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioStatusCode setPlaybackRate(int i)
    {
        return com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioStatusCode.Success;
    }

    protected void setTrackEndMarker(int i)
    {
        nativeAudio.setEndMarker(i);
    }

    public void setVolume(float f, float f1)
    {
        nativeAudio.setAudioVolume((f + f1) / 2.0F);
    }

    protected int write(byte abyte0[], int i, int j)
    {
        if (writeDirectBuffer == null || writeDirectBuffer.limit() < abyte0.length)
        {
            writeDirectBuffer = ByteBuffer.allocateDirect(j);
        }
        writeDirectBuffer.put(abyte0);
        writeDirectBuffer.clear();
        return (int)nativeAudio.writePcmBuffer(writeDirectBuffer, i, j);
    }

    protected void writeEOT()
    {
    }


}
