// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.d;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.facebook.ads.a.d:
//            c

public final class b
    implements Runnable
{

    private final AbstractHttpClient a;
    private final HttpContext b;
    private final HttpUriRequest c;
    private final c d;
    private int e;

    public b(AbstractHttpClient abstracthttpclient, HttpContext httpcontext, HttpUriRequest httpurirequest, c c1)
    {
        a = abstracthttpclient;
        b = httpcontext;
        c = httpurirequest;
        d = c1;
    }

    public final void run()
    {
        HttpRequestRetryHandler httprequestretryhandler;
        if (d != null)
        {
            c c1 = d;
            c1.b(c1.a(2, null));
        }
        httprequestretryhandler = a.getHttpRequestRetryHandler();
        Object obj;
        boolean flag;
        flag = true;
        obj = null;
_L5:
        if (!flag) goto _L2; else goto _L1
_L1:
        if (!Thread.currentThread().isInterrupted())
        {
            obj = a.execute(c, b);
            if (!Thread.currentThread().isInterrupted() && d != null)
            {
                d.a(((org.apache.http.HttpResponse) (obj)));
            }
        }
_L4:
        try
        {
            if (d != null)
            {
                d.a();
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (d != null)
            {
                d.a();
                d.b(((Throwable) (obj)), null);
                return;
            }
        }
        break; /* Loop/switch isn't completed */
        obj;
        if (d != null)
        {
            d.b(((Throwable) (obj)), "can't resolve host");
        }
        continue; /* Loop/switch isn't completed */
        obj;
        if (d != null)
        {
            d.b(((Throwable) (obj)), "can't resolve host");
        }
        continue; /* Loop/switch isn't completed */
        obj;
        if (d != null)
        {
            d.b(((Throwable) (obj)), "socket time out");
        }
        if (true) goto _L4; else goto _L3
        obj;
        int i = e + 1;
        e = i;
        flag = httprequestretryhandler.retryRequest(((IOException) (obj)), i, b);
          goto _L5
        obj;
        obj = new IOException((new StringBuilder("NPE in HttpClient")).append(((NullPointerException) (obj)).getMessage()).toString());
        int j = e + 1;
        e = j;
        flag = httprequestretryhandler.retryRequest(((IOException) (obj)), j, b);
          goto _L5
_L2:
        ConnectException connectexception = new ConnectException();
        connectexception.initCause(((Throwable) (obj)));
        throw connectexception;
_L3:
    }
}
