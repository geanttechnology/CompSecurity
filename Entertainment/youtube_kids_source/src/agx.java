// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.speech.ResponseProcessor;
import com.google.android.speech.S3ResponseProcessor;
import com.google.android.speech.listeners.RecognitionEventListener;
import com.google.android.speech.logger.SpeechLibLogger;

final class agx extends ResponseProcessor
{

    private final dat a = new dat();
    private boolean b;

    agx(agw agw, com.google.android.speech.ResponseProcessor.AudioCallback audiocallback, RecognitionEventListener recognitioneventlistener, boolean flag, eyi eyi, S3ResponseProcessor s3responseprocessor, SpeechLibLogger speechliblogger)
    {
        super(audiocallback, recognitioneventlistener, flag, eyi, s3responseprocessor, speechliblogger);
        b = false;
    }

    public final void invalidate()
    {
        b = true;
        super.invalidate();
    }

    public final void onProgressUpdate(int i, long l)
    {
        if (!b);
    }

    public final void onResult(daj daj1)
    {
        dat dat1 = a;
        if (b)
        {
            return;
        } else
        {
            super.onResult(daj1);
            return;
        }
    }

    public final volatile void onResult(Object obj)
    {
        onResult((daj)obj);
    }
}
