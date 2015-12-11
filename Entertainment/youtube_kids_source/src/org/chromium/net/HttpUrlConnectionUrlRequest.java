// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;

import android.content.Context;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;

// Referenced classes of package org.chromium.net:
//            HttpUrlRequest, HttpUrlRequestListener, UserAgent

class HttpUrlConnectionUrlRequest
    implements HttpUrlRequest
{

    private static ExecutorService p;
    private static final Object q = new Object();
    private final Context a;
    private final String b;
    private final Map c;
    private final WritableByteChannel d;
    private final HttpUrlRequestListener e;
    private IOException f;
    private HttpURLConnection g;
    private int h;
    private boolean i;
    private long j;
    private String k;
    private int l;
    private boolean m;
    private InputStream n;
    private final Object o;

    HttpUrlConnectionUrlRequest(Context context, String s, Map map, WritableByteChannel writablebytechannel, HttpUrlRequestListener httpurlrequestlistener)
    {
        if (context == null)
        {
            throw new NullPointerException("Context is required");
        }
        if (s == null)
        {
            throw new NullPointerException("URL is required");
        } else
        {
            a = context;
            b = s;
            c = map;
            d = writablebytechannel;
            e = httpurlrequestlistener;
            o = new Object();
            return;
        }
    }

    static void a(HttpUrlConnectionUrlRequest httpurlconnectionurlrequest)
    {
        boolean flag;
        boolean flag1;
        flag = false;
        flag1 = true;
        Object obj = httpurlconnectionurlrequest.o;
        obj;
        JVM INSTR monitorenter ;
        if (!httpurlconnectionurlrequest.m) goto _L2; else goto _L1
_L1:
        httpurlconnectionurlrequest.e.a(httpurlconnectionurlrequest);
_L5:
        return;
_L2:
        obj;
        JVM INSTR monitorexit ;
        int i1;
        httpurlconnectionurlrequest.g = (HttpURLConnection)(new URL(httpurlconnectionurlrequest.b)).openConnection();
        httpurlconnectionurlrequest.g.setConnectTimeout(3000);
        httpurlconnectionurlrequest.g.setReadTimeout(0x15f90);
        httpurlconnectionurlrequest.g.setInstanceFollowRedirects(true);
        if (httpurlconnectionurlrequest.c != null)
        {
            java.util.Map.Entry entry;
            for (obj = httpurlconnectionurlrequest.c.entrySet().iterator(); ((Iterator) (obj)).hasNext(); httpurlconnectionurlrequest.g.setRequestProperty((String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)((Iterator) (obj)).next();
            }

        }
          goto _L3
_L6:
        httpurlconnectionurlrequest.f = ((IOException) (obj));
        if (i1 != 0) goto _L5; else goto _L4
_L4:
        httpurlconnectionurlrequest.e.a(httpurlconnectionurlrequest);
        return;
        Object obj1;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        Exception exception;
        try
        {
            throw obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            i1 = 0;
        }
        finally
        {
            i1 = ((flag) ? 1 : 0);
        }
          goto _L6
_L12:
        if (i1 == 0)
        {
            httpurlconnectionurlrequest.e.a(httpurlconnectionurlrequest);
        }
        throw exception;
_L3:
        if (0L == 0L)
        {
            break MISSING_BLOCK_LABEL_236;
        }
        httpurlconnectionurlrequest.g.setRequestProperty("Range", (new StringBuilder("bytes=")).append(0L).append("-").toString());
        if (httpurlconnectionurlrequest.g.getRequestProperty("User-Agent") == null)
        {
            httpurlconnectionurlrequest.g.setRequestProperty("User-Agent", UserAgent.a(httpurlconnectionurlrequest.a));
        }
        exception = null;
        InputStream inputstream = httpurlconnectionurlrequest.g.getInputStream();
        exception = inputstream;
_L13:
        httpurlconnectionurlrequest.l = httpurlconnectionurlrequest.g.getResponseCode();
        httpurlconnectionurlrequest.g.getResponseMessage();
        httpurlconnectionurlrequest.k = httpurlconnectionurlrequest.g.getContentType();
        httpurlconnectionurlrequest.h = httpurlconnectionurlrequest.g.getContentLength();
        if (0L <= 0L)
        {
            break MISSING_BLOCK_LABEL_328;
        }
        i1 = httpurlconnectionurlrequest.h;
        httpurlconnectionurlrequest.e.b(httpurlconnectionurlrequest);
        if (httpurlconnectionurlrequest.l / 100 != 2)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 == 0)
        {
            break MISSING_BLOCK_LABEL_363;
        }
        exception = httpurlconnectionurlrequest.g.getErrorStream();
        httpurlconnectionurlrequest.n = exception;
        if (httpurlconnectionurlrequest.n != null && "gzip".equals(httpurlconnectionurlrequest.g.getContentEncoding()))
        {
            httpurlconnectionurlrequest.n = new GZIPInputStream(httpurlconnectionurlrequest.n);
            httpurlconnectionurlrequest.h = -1;
        }
        if (0L == 0L) goto _L8; else goto _L7
_L7:
        if (httpurlconnectionurlrequest.l != 200) goto _L10; else goto _L9
_L9:
        if (httpurlconnectionurlrequest.h != -1)
        {
            httpurlconnectionurlrequest.h = (int)(long)httpurlconnectionurlrequest.h;
        }
        httpurlconnectionurlrequest.i = true;
_L8:
        exception = httpurlconnectionurlrequest.n;
        if (exception == null)
        {
            break MISSING_BLOCK_LABEL_525;
        }
        f().execute(httpurlconnectionurlrequest. new _cls3());
        i1 = ((flag1) ? 1 : 0);
_L14:
        if (i1 != 0) goto _L5; else goto _L11
_L11:
        httpurlconnectionurlrequest.e.a(httpurlconnectionurlrequest);
        return;
_L10:
        httpurlconnectionurlrequest.j = 0L;
          goto _L8
        exception;
        i1 = 1;
          goto _L12
        exception;
          goto _L12
        exception;
        i1 = 1;
          goto _L6
        inputstream;
          goto _L13
        i1 = 0;
          goto _L14
    }

    static void b(HttpUrlConnectionUrlRequest httpurlconnectionurlrequest)
    {
        if (httpurlconnectionurlrequest.n == null) goto _L2; else goto _L1
_L1:
        byte abyte0[] = new byte[8192];
_L8:
        if (httpurlconnectionurlrequest.g()) goto _L2; else goto _L3
_L3:
        int j1 = httpurlconnectionurlrequest.n.read(abyte0);
        if (j1 == -1) goto _L2; else goto _L4
_L4:
        httpurlconnectionurlrequest.j = httpurlconnectionurlrequest.j + (long)j1;
        if (!httpurlconnectionurlrequest.i) goto _L6; else goto _L5
_L5:
        if (httpurlconnectionurlrequest.j <= 0L) goto _L8; else goto _L7
_L7:
        int i1;
        httpurlconnectionurlrequest.i = false;
        i1 = (int)(0L - (httpurlconnectionurlrequest.j - (long)j1));
        j1 -= i1;
_L13:
        if (0L == 0L) goto _L10; else goto _L9
_L9:
        if (httpurlconnectionurlrequest.j <= 0L) goto _L10; else goto _L11
_L11:
        j1 -= (int)httpurlconnectionurlrequest.j;
        if (j1 <= 0)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        httpurlconnectionurlrequest.d.write(ByteBuffer.wrap(abyte0, i1, j1));
        httpurlconnectionurlrequest.d();
_L2:
        Object obj;
        Object obj1;
        try
        {
            httpurlconnectionurlrequest.g.disconnect();
        }
        catch (ArrayIndexOutOfBoundsException arrayindexoutofboundsexception) { }
        try
        {
            httpurlconnectionurlrequest.d.close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (httpurlconnectionurlrequest.f == null)
            {
                httpurlconnectionurlrequest.f = ((IOException) (obj));
            }
        }
        httpurlconnectionurlrequest.e.a(httpurlconnectionurlrequest);
        return;
_L10:
        httpurlconnectionurlrequest.d.write(ByteBuffer.wrap(abyte0, i1, j1));
          goto _L8
        obj;
        httpurlconnectionurlrequest.f = ((IOException) (obj));
        try
        {
            httpurlconnectionurlrequest.g.disconnect();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        try
        {
            httpurlconnectionurlrequest.d.close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (httpurlconnectionurlrequest.f == null)
            {
                httpurlconnectionurlrequest.f = ((IOException) (obj));
            }
        }
        break MISSING_BLOCK_LABEL_154;
        obj;
        try
        {
            httpurlconnectionurlrequest.g.disconnect();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
        httpurlconnectionurlrequest.d.close();
_L12:
        throw obj;
        obj1;
        if (httpurlconnectionurlrequest.f == null)
        {
            httpurlconnectionurlrequest.f = ((IOException) (obj1));
        }
        if (true) goto _L12; else goto _L6
_L6:
        i1 = 0;
          goto _L13
    }

    private static ExecutorService f()
    {
        ExecutorService executorservice;
        synchronized (q)
        {
            if (p == null)
            {
                p = Executors.newCachedThreadPool(new _cls1());
            }
            executorservice = p;
        }
        return executorservice;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private boolean g()
    {
        boolean flag;
        synchronized (o)
        {
            flag = m;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final long a()
    {
        return (long)h;
    }

    public final int b()
    {
        int j1 = l;
        int i1 = j1;
        if (j1 == 206)
        {
            i1 = 200;
        }
        return i1;
    }

    public final void c()
    {
        f().execute(new _cls2());
    }

    public final void d()
    {
label0:
        {
            synchronized (o)
            {
                if (!m)
                {
                    break label0;
                }
            }
            return;
        }
        m = true;
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final String e()
    {
        return k;
    }


    private class _cls3
        implements Runnable
    {

        private HttpUrlConnectionUrlRequest a;

        public void run()
        {
            HttpUrlConnectionUrlRequest.b(a);
        }

        _cls3()
        {
            a = HttpUrlConnectionUrlRequest.this;
            super();
        }
    }


    private class _cls1
        implements ThreadFactory
    {

        private final AtomicInteger a = new AtomicInteger(1);

        public final Thread newThread(Runnable runnable)
        {
            runnable = new Thread(runnable, (new StringBuilder("HttpUrlConnection #")).append(a.getAndIncrement()).toString());
            runnable.setPriority(5);
            return runnable;
        }

        _cls1()
        {
        }
    }


    private class _cls2
        implements Runnable
    {

        private HttpUrlConnectionUrlRequest a;

        public void run()
        {
            HttpUrlConnectionUrlRequest.a(a);
        }

        _cls2()
        {
            a = HttpUrlConnectionUrlRequest.this;
            super();
        }
    }

}
