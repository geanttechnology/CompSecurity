// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.audio;

import android.media.AudioRecord;
import android.media.MediaSyncEvent;
import android.media.audiofx.NoiseSuppressor;

// Referenced classes of package com.google.android.speech.audio:
//            MicrophoneInputStream

public class FullMicrophoneInputStream extends MicrophoneInputStream
{

    private static final boolean DEBUG = false;
    private static final String TAG = "FullMicrophoneInputStream";
    private NoiseSuppressor mNoiseSuppressor;

    public FullMicrophoneInputStream(int i, int j, boolean flag, MicrophoneInputStream.Callbacks callbacks, boolean flag1)
    {
        super(i, j, flag, callbacks, flag1);
    }

    protected void createNoiseSuppressor()
    {
        if (!mNoiseSuppressionEnabled)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        mNoiseSuppressor = NoiseSuppressor.create(mAudioRecord.getAudioSessionId());
        if (mNoiseSuppressor.setEnabled(true) != 0)
        {
            mNoiseSuppressor = null;
            return;
        }
        try
        {
            mCallbacks.onEvent(7);
            return;
        }
        catch (Exception exception)
        {
            mNoiseSuppressor = null;
        }
    }

    protected void releaseNoiseSuppressor()
    {
        if (mNoiseSuppressor != null)
        {
            mNoiseSuppressor.release();
            mNoiseSuppressor = null;
        }
    }

    protected void startRecording()
    {
        MediaSyncEvent mediasyncevent = null;
        int i = mCallbacks.playSpeakNowSound();
        if (i > 0)
        {
            mediasyncevent = MediaSyncEvent.createEvent(1);
            mediasyncevent.setAudioSessionId(i);
        }
        if (mediasyncevent != null)
        {
            mAudioRecord.startRecording(mediasyncevent);
            mCallbacks.onEvent(6);
            return;
        } else
        {
            mAudioRecord.startRecording();
            mCallbacks.onEvent(5);
            return;
        }
    }
}
