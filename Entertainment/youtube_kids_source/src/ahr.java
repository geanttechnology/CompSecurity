// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.google.android.speech.S3ResponseProcessor;
import com.google.android.speech.listeners.RecognitionEventListener;
import java.io.ByteArrayOutputStream;

public class ahr
    implements S3ResponseProcessor
{

    private static final String a = ahr.getSimpleName();
    private final ByteArrayOutputStream b = new ByteArrayOutputStream();

    public ahr()
    {
    }

    public void process(exf exf1, RecognitionEventListener recognitioneventlistener)
    {
        exf1.a;
        JVM INSTR tableswitch 0 3: default 36
    //                   0 37
    //                   1 139
    //                   2 146
    //                   3 156;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        if (exf1.d)
        {
            exu exu1 = exf1.e;
            if (exu1.b && b.size() > 0)
            {
                recognitioneventlistener.onMediaDataResult(b.toByteArray());
            } else
            {
                byte abyte0[] = exu1.a.b();
                b.write(abyte0, 0, abyte0.length);
            }
        }
        if (exf1.b)
        {
            recognitioneventlistener.onRecognitionResult(exf1.c.b);
        }
        if (exf1.f)
        {
            recognitioneventlistener.onPinholeResult(exf1.g);
            return;
        }
          goto _L1
_L3:
        recognitioneventlistener.onDone();
        return;
_L4:
        throw new IllegalStateException("Error S3Response received via onResult");
_L5:
        Log.w(a, "NOT_STARTED received");
        recognitioneventlistener.onError(new daq(0));
        return;
    }

}
