// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.ResponseHandler;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.concurrent.FutureCallback;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package cz.msebera.android.httpclient.impl.client:
//            FutureRequestExecutionMetrics

class HttpRequestTaskCallable
    implements Callable
{

    private final FutureCallback callback;
    private final AtomicBoolean cancelled = new AtomicBoolean(false);
    private final HttpContext context;
    private long ended;
    private final HttpClient httpclient;
    private final FutureRequestExecutionMetrics metrics;
    private final HttpUriRequest request;
    private final ResponseHandler responseHandler;
    private final long scheduled = System.currentTimeMillis();
    private long started;

    HttpRequestTaskCallable(HttpClient httpclient1, HttpUriRequest httpurirequest, HttpContext httpcontext, ResponseHandler responsehandler, FutureCallback futurecallback, FutureRequestExecutionMetrics futurerequestexecutionmetrics)
    {
        started = -1L;
        ended = -1L;
        httpclient = httpclient1;
        responseHandler = responsehandler;
        request = httpurirequest;
        context = httpcontext;
        callback = futurecallback;
        metrics = futurerequestexecutionmetrics;
    }

    public Object call()
        throws Exception
    {
        if (cancelled.get())
        {
            break MISSING_BLOCK_LABEL_223;
        }
        metrics.getActiveConnections().incrementAndGet();
        started = System.currentTimeMillis();
        Object obj;
        metrics.getScheduledConnections().decrementAndGet();
        obj = httpclient.execute(request, responseHandler, context);
        ended = System.currentTimeMillis();
        metrics.getSuccessfulConnections().increment(started);
        if (callback != null)
        {
            callback.completed(obj);
        }
        metrics.getRequests().increment(started);
        metrics.getTasks().increment(started);
        metrics.getActiveConnections().decrementAndGet();
        return obj;
        Object obj1;
        obj1;
        metrics.getFailedConnections().increment(started);
        ended = System.currentTimeMillis();
        if (callback != null)
        {
            callback.failed(((Exception) (obj1)));
        }
        throw obj1;
        obj1;
        metrics.getRequests().increment(started);
        metrics.getTasks().increment(started);
        metrics.getActiveConnections().decrementAndGet();
        throw obj1;
        throw new IllegalStateException((new StringBuilder()).append("call has been cancelled for request ").append(request.getURI()).toString());
    }

    public void cancel()
    {
        cancelled.set(true);
        if (callback != null)
        {
            callback.cancelled();
        }
    }

    public long getEnded()
    {
        return ended;
    }

    public long getScheduled()
    {
        return scheduled;
    }

    public long getStarted()
    {
        return started;
    }
}
