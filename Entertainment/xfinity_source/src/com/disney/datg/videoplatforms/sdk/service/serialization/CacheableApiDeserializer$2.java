// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.service.serialization;

import com.disney.datg.videoplatforms.sdk.service.HttpRequestHandler;
import com.disney.datg.videoplatforms.sdk.service.Request;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.springframework.http.ResponseEntity;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.service.serialization:
//            CacheableApiDeserializer

class val.dataResponse
    implements Future
{

    final CacheableApiDeserializer this$0;
    final HttpRequestHandler val$asyncHandler;
    final ResponseEntity val$dataResponse;
    final Request val$request;

    public boolean cancel(boolean flag)
    {
        return false;
    }

    public volatile Object get()
        throws InterruptedException, ExecutionException
    {
        return get();
    }

    public volatile Object get(long l, TimeUnit timeunit)
        throws InterruptedException, ExecutionException, TimeoutException
    {
        return get(l, timeunit);
    }

    public ResponseEntity get()
        throws InterruptedException, ExecutionException, RejectedExecutionException
    {
        if (val$asyncHandler != null)
        {
            val$asyncHandler.onResponse(val$request, val$dataResponse);
        }
        return val$dataResponse;
    }

    public ResponseEntity get(long l, TimeUnit timeunit)
        throws InterruptedException, ExecutionException, RejectedExecutionException, TimeoutException
    {
        if (val$asyncHandler != null)
        {
            val$asyncHandler.onResponse(val$request, val$dataResponse);
        }
        return val$dataResponse;
    }

    public boolean isCancelled()
    {
        return false;
    }

    public boolean isDone()
    {
        return false;
    }

    Y()
    {
        this$0 = final_cacheableapideserializer;
        val$asyncHandler = httprequesthandler;
        val$request = request1;
        val$dataResponse = ResponseEntity.this;
        super();
    }
}
