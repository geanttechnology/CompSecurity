// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android;


// Referenced classes of package com.amazon.blueshift.bluefront.android:
//            SpeechRequestTask, SpeechClientException

public static interface 
{

    public abstract void onBeginningOfSpeech();

    public abstract void onBluefrontResult(Object obj);

    public abstract void onBufferReceived(byte abyte0[]);

    public abstract void onError(SpeechClientException speechclientexception);

    public abstract void onMaxSpeechTimeout();

    public abstract void onNoSpeechTimeout();

    public abstract void onReadyForSpeech();

    public abstract void onRmsChanged(float f);

    public abstract void onSilenceDetected();
}
