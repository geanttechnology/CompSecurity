// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.client.cache;

import com.comcast.cim.httpcomponentsandroid.HttpHost;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.ProtocolException;
import com.comcast.cim.httpcomponentsandroid.client.cache.HttpCacheEntry;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import java.io.IOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.client.cache:
//            CachingHttpClient, AsynchronousValidator

class AsynchronousValidationRequest
    implements Runnable
{

    private final HttpCacheEntry cacheEntry;
    private final CachingHttpClient cachingClient;
    private final HttpContext context;
    private final String identifier;
    private final Log log = LogFactory.getLog(getClass());
    private final AsynchronousValidator parent;
    private final HttpRequest request;
    private final HttpHost target;

    AsynchronousValidationRequest(AsynchronousValidator asynchronousvalidator, CachingHttpClient cachinghttpclient, HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext, HttpCacheEntry httpcacheentry, String s)
    {
        parent = asynchronousvalidator;
        cachingClient = cachinghttpclient;
        target = httphost;
        request = httprequest;
        context = httpcontext;
        cacheEntry = httpcacheentry;
        identifier = s;
    }

    public void run()
    {
        cachingClient.revalidateCacheEntry(target, request, context, cacheEntry);
        parent.markComplete(identifier);
        return;
        Object obj;
        obj;
        log.debug((new StringBuilder()).append("Asynchronous revalidation failed due to exception: ").append(obj).toString());
        parent.markComplete(identifier);
        return;
        obj;
        log.error((new StringBuilder()).append("ProtocolException thrown during asynchronous revalidation: ").append(obj).toString());
        parent.markComplete(identifier);
        return;
        obj;
        parent.markComplete(identifier);
        throw obj;
    }
}
