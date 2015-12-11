// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android;


// Referenced classes of package com.amazon.blueshift.bluefront.android:
//            SpeechClient, SpeechRequestListener, SpeechClientException

private class <init>
    implements <init>
{

    final SpeechClient this$0;

    public void onBeginningOfSpeech()
    {
        SpeechClient.access$200(SpeechClient.this).onBeginningOfSpeech();
    }

    public void onBluefrontResult(Object obj)
    {
        SpeechClient.access$200(SpeechClient.this).onBluefrontResults(obj);
    }

    public void onBufferReceived(byte abyte0[])
    {
        SpeechClient.access$200(SpeechClient.this).onBufferReceived(abyte0);
    }

    public void onError(SpeechClientException speechclientexception)
    {
        SpeechClient.access$300(SpeechClient.this);
        SpeechClient.access$200(SpeechClient.this).onError(speechclientexception);
    }

    public void onMaxSpeechTimeout()
    {
        SpeechClient.access$300(SpeechClient.this);
        SpeechClient.access$200(SpeechClient.this).onMaxSpeechTimeout();
    }

    public void onNoSpeechTimeout()
    {
        SpeechClient.access$200(SpeechClient.this).onNoSpeechTimeout();
    }

    public void onReadyForSpeech()
    {
        SpeechClient.access$200(SpeechClient.this).onReadyForSpeech(null);
    }

    public void onRmsChanged(float f)
    {
        SpeechClient.access$200(SpeechClient.this).onRmsChanged(f);
    }

    public void onSilenceDetected()
    {
        SpeechClient.access$300(SpeechClient.this);
        SpeechClient.access$200(SpeechClient.this).onSilenceDetected();
    }

    private ()
    {
        this$0 = SpeechClient.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
