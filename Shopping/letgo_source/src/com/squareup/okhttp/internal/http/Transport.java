// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import android.support.v7.aqj;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HttpEngine, RetryableSink

public interface Transport
{

    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    public abstract boolean canReuseConnection();

    public abstract aqj createRequestBody(Request request, long l)
        throws IOException;

    public abstract void disconnect(HttpEngine httpengine)
        throws IOException;

    public abstract void finishRequest()
        throws IOException;

    public abstract ResponseBody openResponseBody(Response response)
        throws IOException;

    public abstract com.squareup.okhttp.Response.Builder readResponseHeaders()
        throws IOException;

    public abstract void releaseConnectionOnIdle()
        throws IOException;

    public abstract void writeRequestBody(RetryableSink retryablesink)
        throws IOException;

    public abstract void writeRequestHeaders(Request request)
        throws IOException;
}
