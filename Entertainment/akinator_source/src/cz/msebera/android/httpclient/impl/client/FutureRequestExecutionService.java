// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.ResponseHandler;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.concurrent.FutureCallback;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package cz.msebera.android.httpclient.impl.client:
//            FutureRequestExecutionMetrics, HttpRequestFutureTask, HttpRequestTaskCallable

public class FutureRequestExecutionService
    implements Closeable
{

    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final ExecutorService executorService;
    private final HttpClient httpclient;
    private final FutureRequestExecutionMetrics metrics = new FutureRequestExecutionMetrics();

    public FutureRequestExecutionService(HttpClient httpclient1, ExecutorService executorservice)
    {
        httpclient = httpclient1;
        executorService = executorservice;
    }

    public void close()
        throws IOException
    {
        closed.set(true);
        executorService.shutdownNow();
        if (httpclient instanceof Closeable)
        {
            ((Closeable)httpclient).close();
        }
    }

    public HttpRequestFutureTask execute(HttpUriRequest httpurirequest, HttpContext httpcontext, ResponseHandler responsehandler)
    {
        return execute(httpurirequest, httpcontext, responsehandler, null);
    }

    public HttpRequestFutureTask execute(HttpUriRequest httpurirequest, HttpContext httpcontext, ResponseHandler responsehandler, FutureCallback futurecallback)
    {
        if (closed.get())
        {
            throw new IllegalStateException("Close has been called on this httpclient instance.");
        } else
        {
            metrics.getScheduledConnections().incrementAndGet();
            httpurirequest = new HttpRequestFutureTask(httpurirequest, new HttpRequestTaskCallable(httpclient, httpurirequest, httpcontext, responsehandler, futurecallback, metrics));
            executorService.execute(httpurirequest);
            return httpurirequest;
        }
    }

    public FutureRequestExecutionMetrics metrics()
    {
        return metrics;
    }
}
