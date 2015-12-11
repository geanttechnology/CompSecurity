// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.speech.callback.RecognitionEngineCallback;
import com.google.android.speech.dispatcher.RecognitionDispatcher;

public class agv
    implements com.google.android.speech.dispatcher.RecognitionDispatcher.ResultsMerger
{

    private static final String a = agv.getSimpleName();
    private final RecognitionDispatcher b;
    private final RecognitionEngineCallback c;
    private boolean d;
    private final dat e = new dat();

    public agv(RecognitionDispatcher recognitiondispatcher, RecognitionEngineCallback recognitionenginecallback)
    {
        d = false;
        b = recognitiondispatcher;
        c = recognitionenginecallback;
    }

    public void invalidate()
    {
        dat dat1 = e;
        d = true;
    }

    public void onError(Object obj)
    {
        obj = (dap)obj;
        dat dat1 = e;
        if (!d)
        {
            b.cancel();
            c.onError(obj);
        }
    }

    public void onProgressUpdate(int i, long l)
    {
        if (d)
        {
            return;
        } else
        {
            c.onProgressUpdate(i, l);
            return;
        }
    }

    public void onResult(Object obj)
    {
        obj = (daj)obj;
        dat dat1 = e;
        if (d)
        {
            obj = a;
        } else
        {
            int i = ((daj) (obj)).a;
            i = ((daj) (obj)).b;
            if (i == 1)
            {
                c.onResult(obj);
                return;
            }
            if (i == 3)
            {
                c.onResult(obj);
                return;
            }
            if (i == 2)
            {
                c.onResult(obj);
                return;
            }
        }
    }

}
