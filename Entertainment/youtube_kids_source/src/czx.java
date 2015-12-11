// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.google.android.speech.callback.Callback;
import com.google.android.speech.utils.IoUtils;
import java.io.Closeable;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class czx extends Thread
    implements Closeable
{

    private final czv a;
    private final URL b;
    private final CountDownLatch c = new CountDownLatch(1);
    private final eyr d;
    private final czp e;
    private final Callback f;
    private volatile boolean g;

    czx(czv czv1, URL url, eyr eyr1, czp czp1, Callback callback)
    {
        super("PairHttpReaderDown");
        a = czv1;
        b = url;
        g = true;
        d = eyr1;
        e = czp1;
        f = callback;
    }

    private boolean a(HttpURLConnection httpurlconnection)
    {
        int i;
        try
        {
            i = httpurlconnection.getResponseCode();
        }
        // Misplaced declaration of an exception variable
        catch (HttpURLConnection httpurlconnection)
        {
            Log.w("PairHttpConnection", (new StringBuilder("[Download] Error opening connection: ")).append(httpurlconnection.getMessage()).toString());
            return false;
        }
        if (i != 200)
        {
            Log.w("PairHttpConnection", (new StringBuilder("[Download] response code ")).append(i).toString());
            return false;
        }
        if (!b.getHost().equals(httpurlconnection.getURL().getHost()))
        {
            Log.w("PairHttpConnection", (new StringBuilder("[Download] redirect to ")).append(httpurlconnection.getURL()).toString());
            return false;
        } else
        {
            return true;
        }
    }

    public final boolean a()
    {
        boolean flag;
        if (getState() != Thread.State.NEW)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.b(flag);
        try
        {
            if (!c.await(10L, TimeUnit.SECONDS))
            {
                g = false;
            }
        }
        catch (InterruptedException interruptedexception)
        {
            g = false;
        }
        return g;
    }

    public final void close()
    {
        g = false;
        interrupt();
    }

    public final void run()
    {
        Object obj = e.a(d.a, b);
        IoUtils.addHttpHeaders(((HttpURLConnection) (obj)), d.a);
        czv czv1 = a;
        czv.a(((HttpURLConnection) (obj)), d.a);
        ((HttpURLConnection) (obj)).setDoInput(true);
        ((HttpURLConnection) (obj)).setUseCaches(false);
        a.a(((HttpURLConnection) (obj)));
        HttpURLConnection httpurlconnection;
        c.countDown();
        httpurlconnection = (HttpURLConnection)f.b(obj);
        if (!a(httpurlconnection))
        {
            if (!a.a(4))
            {
                f.onError(new dam("[Download] Bad response or url"));
            }
            httpurlconnection.disconnect();
            return;
        }
          goto _L1
        obj;
        obj = null;
_L9:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        ((HttpURLConnection) (obj)).disconnect();
        a.a(4);
        g = false;
        c.countDown();
        return;
        Exception exception;
        exception;
        c.countDown();
        throw exception;
_L1:
        Object obj1 = new dad(httpurlconnection.getInputStream());
_L3:
        exception = ((Exception) (obj1));
        if (!g)
        {
            break MISSING_BLOCK_LABEL_225;
        }
        exception = ((Exception) (obj1));
        exf exf1 = ((dad) (obj1)).a();
        exception = ((Exception) (obj1));
        if (a.a(3))
        {
            break MISSING_BLOCK_LABEL_235;
        }
        exception = ((Exception) (obj1));
        f.onError(new dam("State error while reading."));
        emp.a(((Closeable) (obj1)));
        httpurlconnection.disconnect();
        return;
        exception = ((Exception) (obj1));
        if (exf1.a == 2)
        {
            break MISSING_BLOCK_LABEL_255;
        }
        exception = ((Exception) (obj1));
        if (exf1.a != 1)
        {
            break MISSING_BLOCK_LABEL_262;
        }
        exception = ((Exception) (obj1));
        g = false;
        exception = ((Exception) (obj1));
        f.onResult(exf1);
        if (true) goto _L3; else goto _L2
_L2:
        Object obj2;
        obj2;
_L7:
        exception = ((Exception) (obj1));
        if (!g)
        {
            break MISSING_BLOCK_LABEL_348;
        }
        exception = ((Exception) (obj1));
        Log.w("PairHttpConnection", (new StringBuilder("[Download] exception - exit")).append(((IOException) (obj2)).getMessage()).toString());
        exception = ((Exception) (obj1));
        if (a.a(4))
        {
            break MISSING_BLOCK_LABEL_348;
        }
        exception = ((Exception) (obj1));
        f.onError(new dam("Error while reading", ((Throwable) (obj2))));
        emp.a(((Closeable) (obj1)));
        httpurlconnection.disconnect();
        return;
        exception;
        obj2 = null;
        obj1 = exception;
_L5:
        emp.a(((Closeable) (obj2)));
        httpurlconnection.disconnect();
        throw obj1;
        obj1;
        obj2 = exception;
        if (true) goto _L5; else goto _L4
_L4:
        obj2;
        obj1 = null;
        if (true) goto _L7; else goto _L6
_L6:
        IOException ioexception;
        ioexception;
        if (true) goto _L9; else goto _L8
_L8:
    }
}
