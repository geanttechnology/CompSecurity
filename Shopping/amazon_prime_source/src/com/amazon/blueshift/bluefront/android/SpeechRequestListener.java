// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android;

import android.speech.RecognitionListener;

// Referenced classes of package com.amazon.blueshift.bluefront.android:
//            SpeechClientException

public interface SpeechRequestListener
    extends RecognitionListener
{

    public abstract void onBluefrontResults(Object obj);

    public abstract void onEndOfSpeech();

    public abstract void onError(SpeechClientException speechclientexception);

    public abstract void onMaxSpeechTimeout();

    public abstract void onNoSpeechTimeout();

    public abstract void onSilenceDetected();
}
