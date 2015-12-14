// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import java.io.IOException;
import java.net.ConnectException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            o, am

class n
    implements Runnable
{

    private final AbstractHttpClient a;
    private final HttpContext b;
    private final HttpUriRequest c;
    private final o d;
    private int e;

    public n(AbstractHttpClient abstracthttpclient, HttpContext httpcontext, HttpUriRequest httpurirequest, o o1)
    {
        a = abstracthttpclient;
        b = httpcontext;
        c = httpurirequest;
        d = o1;
    }

    private void a()
    {
        if (!Thread.currentThread().isInterrupted())
        {
            b();
            org.apache.http.HttpResponse httpresponse = a.execute(c, b);
            if (!Thread.currentThread().isInterrupted() && d != null)
            {
                d.a(httpresponse);
            }
            return;
        } else
        {
            d.c(new InterruptedException("request interupted!"), null);
            return;
        }
    }

    private void b()
    {
        am.a(null, a);
    }

    private void c()
    {
        boolean flag = true;
        Object obj = null;
        Object obj1 = a.getHttpRequestRetryHandler();
        while (flag) 
        {
            try
            {
                a();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                int i = e + 1;
                e = i;
                flag = ((HttpRequestRetryHandler) (obj1)).retryRequest(((IOException) (obj)), i, b);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                obj = new IOException((new StringBuilder()).append("NPE in HttpClient").append(((NullPointerException) (obj)).getMessage()).toString());
                int j = e + 1;
                e = j;
                flag = ((HttpRequestRetryHandler) (obj1)).retryRequest(((IOException) (obj)), j, b);
            }
        }
        obj1 = new ConnectException();
        ((ConnectException) (obj1)).initCause(((Throwable) (obj)));
        throw obj1;
    }

    public void run()
    {
        if (d != null)
        {
            d.f();
        }
        c();
_L2:
        if (d != null)
        {
            d.g();
        }
        return;
        IOException ioexception;
        ioexception;
        if (d != null)
        {
            d.c(ioexception, ioexception.toString());
        }
        if (true) goto _L2; else goto _L1
_L1:
    }
}
