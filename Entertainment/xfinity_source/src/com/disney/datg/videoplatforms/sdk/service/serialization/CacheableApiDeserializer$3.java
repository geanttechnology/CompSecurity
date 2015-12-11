// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.service.serialization;

import com.disney.datg.videoplatforms.sdk.cache.Cache;
import com.disney.datg.videoplatforms.sdk.service.HttpRequestHandler;
import com.disney.datg.videoplatforms.sdk.service.Request;
import org.springframework.http.ResponseEntity;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.service.serialization:
//            CacheableApiDeserializer

class val.asyncHandler
    implements HttpRequestHandler
{

    final CacheableApiDeserializer this$0;
    final HttpRequestHandler val$asyncHandler;
    final Object val$key;

    public void onError(Request request, Exception exception)
    {
        if (val$asyncHandler != null)
        {
            val$asyncHandler.onError(request, exception);
        }
    }

    public void onRequest(Request request)
    {
        if (val$asyncHandler != null)
        {
            val$asyncHandler.onRequest(request);
        }
    }

    public void onResponse(Request request, ResponseEntity responseentity)
    {
        if (cache != null)
        {
            cache.put(val$key, responseentity, timeToLive);
        }
        if (val$asyncHandler != null)
        {
            val$asyncHandler.onResponse(request, responseentity);
        }
    }

    Y()
    {
        this$0 = final_cacheableapideserializer;
        val$key = obj;
        val$asyncHandler = HttpRequestHandler.this;
        super();
    }
}
