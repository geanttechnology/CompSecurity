// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.audio;

import android.util.Log;
import com.google.android.speech.logger.SpeechLibLogger;
import dbh;
import java.io.InputStream;
import java.lang.reflect.Constructor;

// Referenced classes of package com.google.android.speech.audio:
//            AudioInputStreamFactory, DefaultMicrophoneInputStreamCallbacks, SpeakNowSoundPlayer

public class MicrophoneInputStreamFactory
    implements AudioInputStreamFactory
{

    private static final int AUDIO_RECORD_BUFFER_SIZE_SECONDS = 8;
    private static final String TAG = "MicrophoneInputStreamFactory";
    private final MicrophoneInputStream.Callbacks mCallbacks;
    private final boolean mNoiseSuppression;
    private final boolean mPreemptible;
    private final int mSampleRateHz;

    public MicrophoneInputStreamFactory(int i, boolean flag, SpeakNowSoundPlayer speaknowsoundplayer, dbh dbh, SpeechLibLogger speechliblogger, boolean flag1)
    {
        mSampleRateHz = i;
        mNoiseSuppression = flag;
        mCallbacks = new DefaultMicrophoneInputStreamCallbacks(dbh, speaknowsoundplayer, speechliblogger);
        mPreemptible = flag1;
    }

    private int getAudioRecordBufferSizeBytes()
    {
        return mSampleRateHz << 1 << 3;
    }

    public static int getBytesPerMsec(int i)
    {
        return (i * 2) / 1000;
    }

    public static int getMicrophoneReadSize(int i)
    {
        return getBytesPerMsec(i) * 20;
    }

    public InputStream createInputStream()
    {
        Object obj;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            obj = "com.google.android.speech.audio.FullMicrophoneInputStream";
        } else
        {
            obj = "com.google.android.speech.audio.MicrophoneInputStream";
        }
        try
        {
            obj = (InputStream)Class.forName(((String) (obj))).getConstructor(new Class[] {
                Integer.TYPE, Integer.TYPE, Boolean.TYPE, com/google/android/speech/audio/MicrophoneInputStream$Callbacks, Boolean.TYPE
            }).newInstance(new Object[] {
                Integer.valueOf(mSampleRateHz), Integer.valueOf(getAudioRecordBufferSizeBytes()), Boolean.valueOf(mNoiseSuppression), mCallbacks, Boolean.valueOf(mPreemptible)
            });
        }
        catch (Exception exception)
        {
            Log.e("MicrophoneInputStreamFactory", "Unable to create MicrophoneInputStream", exception);
            throw new RuntimeException("Unable to create MicrophoneInputStream", exception);
        }
        return ((InputStream) (obj));
    }
}
