// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech;

import com.google.android.speech.audio.AudioRecorder;
import com.google.android.speech.listeners.RecognitionEventListener;
import daz;

// Referenced classes of package com.google.android.speech:
//            RecognizerImpl

class tionEventListener
    implements .AudioCallback
{

    final RecognizerImpl this$0;
    final RecognitionEventListener val$listener;

    public void recordingStarted(long l)
    {
        if (RecognizerImpl.access$000(RecognizerImpl.this).isRecording())
        {
            RecognizerImpl.access$000(RecognizerImpl.this).setRecordingStartTime(l);
        }
    }

    public void shutdownAudio()
    {
        if (RecognizerImpl.access$100(RecognizerImpl.this).c(ate.IDLE))
        {
            RecognizerImpl.access$300(RecognizerImpl.this, val$listener);
        }
    }

    public void stopAudio()
    {
        if (RecognizerImpl.access$100(RecognizerImpl.this).b(ate.LISTENING))
        {
            RecognizerImpl.access$200(RecognizerImpl.this, val$listener);
        }
    }

    tionEventListener()
    {
        this$0 = final_recognizerimpl;
        val$listener = RecognitionEventListener.this;
        super();
    }
}
