// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Request;
import okio.q;
import okio.r;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HttpEngine, CacheRequest, RetryableSink

public interface Transport
{

    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    public abstract boolean canReuseConnection();

    public abstract q createRequestBody(Request request, long l);

    public abstract void disconnect(HttpEngine httpengine);

    public abstract void emptyTransferStream();

    public abstract void flushRequest();

    public abstract r getTransferStream(CacheRequest cacherequest);

    public abstract com.squareup.okhttp.Response.Builder readResponseHeaders();

    public abstract void releaseConnectionOnIdle();

    public abstract void writeRequestBody(RetryableSink retryablesink);

    public abstract void writeRequestHeaders(Request request);
}
