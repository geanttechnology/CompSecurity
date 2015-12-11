// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import java.util.concurrent.FutureTask;

// Referenced classes of package cz.msebera.android.httpclient.impl.client:
//            HttpRequestTaskCallable

public class HttpRequestFutureTask extends FutureTask
{

    private final HttpRequestTaskCallable callable;
    private final HttpUriRequest request;

    public HttpRequestFutureTask(HttpUriRequest httpurirequest, HttpRequestTaskCallable httprequesttaskcallable)
    {
        super(httprequesttaskcallable);
        request = httpurirequest;
        callable = httprequesttaskcallable;
    }

    public boolean cancel(boolean flag)
    {
        callable.cancel();
        if (flag)
        {
            request.abort();
        }
        return super.cancel(flag);
    }

    public long endedTime()
    {
        if (isDone())
        {
            return callable.getEnded();
        } else
        {
            throw new IllegalStateException("Task is not done yet");
        }
    }

    public long requestDuration()
    {
        if (isDone())
        {
            return endedTime() - startedTime();
        } else
        {
            throw new IllegalStateException("Task is not done yet");
        }
    }

    public long scheduledTime()
    {
        return callable.getScheduled();
    }

    public long startedTime()
    {
        return callable.getStarted();
    }

    public long taskDuration()
    {
        if (isDone())
        {
            return endedTime() - scheduledTime();
        } else
        {
            throw new IllegalStateException("Task is not done yet");
        }
    }

    public String toString()
    {
        return request.getRequestLine().getUri();
    }
}
