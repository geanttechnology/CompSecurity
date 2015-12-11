// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.google.android.speech.callback.Callback;
import java.io.Closeable;
import java.io.IOException;
import java.net.HttpURLConnection;

public final class czz extends Thread
    implements Closeable
{

    private final dad a;
    private final HttpURLConnection b;
    private final Callback c;
    private exf d;
    private volatile boolean e;

    public czz(dad dad1, HttpURLConnection httpurlconnection, Callback callback, exf exf1)
    {
        super("PairHttpReaderUp");
        a = dad1;
        b = httpurlconnection;
        c = callback;
        d = exf1;
        e = true;
    }

    public final void close()
    {
        e = false;
        interrupt();
    }

    public final void run()
    {
_L2:
        Object obj;
        if (!e)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        if (d == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = d;
        d = null;
_L3:
        if (((exf) (obj)).a == 2 || ((exf) (obj)).a == 1)
        {
            e = false;
        }
        c.onResult(obj);
        if (true) goto _L2; else goto _L1
        obj;
        if (e)
        {
            Log.w("PairHttpConnection", (new StringBuilder("[Upload] exception - exit")).append(((IOException) (obj)).getMessage()).toString());
            c.onError(new dam("Error while reading", ((Throwable) (obj))));
        }
        emp.a(a);
        b.disconnect();
        return;
_L1:
        obj = a.a();
          goto _L3
        emp.a(a);
        b.disconnect();
        return;
        Exception exception;
        exception;
        emp.a(a);
        b.disconnect();
        throw exception;
    }
}
