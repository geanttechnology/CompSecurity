// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android;

import com.amazon.blueshift.bluefront.android.audio.AudioSourceListener;

// Referenced classes of package com.amazon.blueshift.bluefront.android:
//            SpeechRequestTask

private class <init>
    implements AudioSourceListener
{

    final SpeechRequestTask this$0;

    public void onBeginningOfSpeech()
    {
        SpeechRequestTask.access$500(SpeechRequestTask.this, new this._cls0[] {
            new (gOfSpeech)
        });
    }

    public void onBufferReceived(byte abyte0[])
    {
        SpeechRequestTask.access$200(SpeechRequestTask.this, new this._cls0[] {
            new (eceived, abyte0)
        });
    }

    public void onMaxSpeechTimeout()
    {
        SpeechRequestTask.access$700(SpeechRequestTask.this, new this._cls0[] {
            new (chTimeout)
        });
    }

    public void onNoSpeechTimeout()
    {
        SpeechRequestTask.access$600(SpeechRequestTask.this, new this._cls0[] {
            new (hTimeout)
        });
    }

    public void onReadyForSpeech()
    {
        SpeechRequestTask.access$400(SpeechRequestTask.this, new this._cls0[] {
            new (rSpeech)
        });
    }

    public void onRmsChanged(float f)
    {
        SpeechRequestTask.access$100(SpeechRequestTask.this, new this._cls0[] {
            new (ged, Float.valueOf(f))
        });
    }

    public void onSilenceDetected()
    {
        SpeechRequestTask.access$300(SpeechRequestTask.this, new this._cls0[] {
            new (Detected)
        });
    }

    private ()
    {
        this$0 = SpeechRequestTask.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
