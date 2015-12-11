// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.audio;

import android.text.TextUtils;

// Referenced classes of package com.google.android.speech.audio:
//            AudioStore

public class SingleRecordingAudioStore
    implements AudioStore
{

    private static final boolean DBG = false;
    private static final String TAG = "SingleRecordingAudioStore";
    private AudioStore.AudioRecording mLastAudioRecording;
    private String mLastRequestId;

    public SingleRecordingAudioStore()
    {
    }

    public AudioStore.AudioRecording getAudio(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (!TextUtils.equals(s, mLastRequestId)) goto _L2; else goto _L1
_L1:
        s = mLastAudioRecording;
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = null;
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public AudioStore.AudioRecording getLastAudio()
    {
        this;
        JVM INSTR monitorenter ;
        AudioStore.AudioRecording audiorecording = mLastAudioRecording;
        this;
        JVM INSTR monitorexit ;
        return audiorecording;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean hasAudio(String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = TextUtils.equals(s, mLastRequestId);
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
    }

    public void put(String s, AudioStore.AudioRecording audiorecording)
    {
        this;
        JVM INSTR monitorenter ;
        mLastRequestId = s;
        mLastAudioRecording = audiorecording;
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }
}
