// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.listeners;

import dap;
import eee;
import etg;
import ewk;
import ewv;

// Referenced classes of package com.google.android.speech.listeners:
//            OnReadyForSpeechListener

public interface RecognitionEventListener
    extends OnReadyForSpeechListener
{

    public abstract void onBeginningOfSpeech(long l);

    public abstract void onDone();

    public abstract void onEndOfSpeech();

    public abstract void onError(dap dap);

    public abstract void onMajelResult(etg etg);

    public abstract void onMediaDataResult(byte abyte0[]);

    public abstract void onMusicDetected();

    public abstract void onNoSpeechDetected();

    public abstract void onPinholeResult(ewv ewv);

    public abstract void onRecognitionCancelled();

    public abstract void onRecognitionResult(ewk ewk);

    public abstract void onSoundSearchResult(eee eee);
}
