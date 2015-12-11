// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.a.a.a:
//            h, f

class e
    implements Runnable
{

    private final AbstractHttpClient a;
    private final HttpContext b;
    private final HttpUriRequest c;
    private final f d;
    private boolean e;
    private int f;

    public e(AbstractHttpClient abstracthttpclient, HttpContext httpcontext, HttpUriRequest httpurirequest, f f1)
    {
        a = abstracthttpclient;
        b = httpcontext;
        c = httpurirequest;
        d = f1;
        if (f1 instanceof h)
        {
            e = true;
        }
    }

    private void a()
    {
        if (!Thread.currentThread().isInterrupted())
        {
            org.apache.http.HttpResponse httpresponse = a.execute(c, b);
            if (!Thread.currentThread().isInterrupted() && d != null)
            {
                d.a(httpresponse);
            }
        }
    }

    private void b()
    {
        Object obj;
        Object obj2;
        boolean flag;
        flag = true;
        obj = null;
        obj2 = a.getHttpRequestRetryHandler();
_L5:
        if (!flag)
        {
            obj2 = new ConnectException();
            ((ConnectException) (obj2)).initCause(((Throwable) (obj)));
            throw obj2;
        }
        a();
_L2:
        return;
        Object obj1;
        obj1;
        if (d == null) goto _L2; else goto _L1
_L1:
        d.b(((Throwable) (obj1)), "can't resolve host");
        return;
        obj1;
        if (d == null) goto _L2; else goto _L3
_L3:
        d.b(((Throwable) (obj1)), "can't resolve host");
        return;
        obj1;
        if (d != null)
        {
            d.b(((Throwable) (obj1)), "socket time out");
            return;
        }
          goto _L2
        obj1;
        int i = f + 1;
        f = i;
        flag = ((HttpRequestRetryHandler) (obj2)).retryRequest(((IOException) (obj1)), i, b);
        continue; /* Loop/switch isn't completed */
        obj1;
        obj1 = new IOException((new StringBuilder("NPE in HttpClient")).append(((NullPointerException) (obj1)).getMessage()).toString());
        int j = f + 1;
        f = j;
        flag = ((HttpRequestRetryHandler) (obj2)).retryRequest(((IOException) (obj1)), j, b);
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void run()
    {
        if (d != null)
        {
            d.c();
        }
        b();
        if (d != null)
        {
            d.d();
        }
_L1:
        return;
        IOException ioexception;
        ioexception;
        if (d != null)
        {
            d.d();
            if (e)
            {
                d.a(ioexception, null);
                return;
            } else
            {
                d.b(ioexception, null);
                return;
            }
        }
          goto _L1
    }
}
