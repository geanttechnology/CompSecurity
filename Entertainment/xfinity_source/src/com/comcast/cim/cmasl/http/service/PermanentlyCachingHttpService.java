// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.http.service;

import com.comcast.cim.cmasl.http.exceptions.CimIOException;
import com.comcast.cim.cmasl.http.request.CacheableRequestProvider;
import com.comcast.cim.cmasl.http.request.RequestProvider;
import com.comcast.cim.cmasl.http.response.DetailedRequestStatus;
import com.comcast.cim.cmasl.http.response.ResponseHandler;
import com.comcast.cim.cmasl.utils.StorageCache;
import com.comcast.cim.cmasl.utils.provider.Provider;
import java.io.InputStream;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.cmasl.http.service:
//            HttpService

public class PermanentlyCachingHttpService
    implements HttpService
{
    private class StreamStoringResponseHandler
        implements ResponseHandler
    {

        private final String cacheKey;
        private final ResponseHandler _flddelegate;
        private final StorageCache storageCache;
        final PermanentlyCachingHttpService this$0;

        private ResponseHandler getDelegate()
        {
            return _flddelegate;
        }

        public void handleResponseBody(InputStream inputstream)
        {
            StorageCache storagecache = storageCache;
            storagecache;
            JVM INSTR monitorenter ;
            LOG.debug("Storing stream to permanent cache");
            storageCache.store(inputstream, (new StringBuilder()).append(cacheKey).append("-temp").toString());
            feedCachedContentToResponseHandler(_flddelegate, storageCache.retrieve((new StringBuilder()).append(cacheKey).append("-temp").toString()));
            storageCache.store(storageCache.retrieve((new StringBuilder()).append(cacheKey).append("-temp").toString()), cacheKey);
            storageCache.remove((new StringBuilder()).append(cacheKey).append("-temp").toString());
            storagecache;
            JVM INSTR monitorexit ;
            return;
            inputstream;
            storageCache.remove((new StringBuilder()).append(cacheKey).append("-temp").toString());
            throw inputstream;
            inputstream;
            storagecache;
            JVM INSTR monitorexit ;
            throw inputstream;
        }

        public void handleResponseHeaders(String s, DetailedRequestStatus detailedrequeststatus, Map map)
        {
            _flddelegate.handleResponseHeaders(s, detailedrequeststatus, map);
        }


        private StreamStoringResponseHandler(StorageCache storagecache, String s, ResponseHandler responsehandler)
        {
            this$0 = PermanentlyCachingHttpService.this;
            super();
            _flddelegate = responsehandler;
            cacheKey = s;
            storageCache = storagecache;
        }

    }


    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private final HttpService _flddelegate;
    private final StorageCache storageCache;

    public PermanentlyCachingHttpService(HttpService httpservice, StorageCache storagecache)
    {
        _flddelegate = httpservice;
        storageCache = storagecache;
    }

    private void feedCachedContentToResponseHandler(ResponseHandler responsehandler, InputStream inputstream)
    {
        LOG.debug("Reading stream from permanent cache");
        responsehandler.handleResponseBody(inputstream);
        IOUtils.closeQuietly(inputstream);
        return;
        responsehandler;
        IOUtils.closeQuietly(inputstream);
        throw responsehandler;
    }

    public ResponseHandler executeRequest(final CacheableRequestProvider requestProvider, final Provider responseHandlerProvider)
    {
        Object obj = ((StreamStoringResponseHandler)_flddelegate.executeRequest(requestProvider, new Provider() {

            final PermanentlyCachingHttpService this$0;
            final CacheableRequestProvider val$requestProvider;
            final Provider val$responseHandlerProvider;

            public StreamStoringResponseHandler get()
            {
                return new StreamStoringResponseHandler(storageCache, requestProvider.getCacheKey(), (ResponseHandler)responseHandlerProvider.get());
            }

            public volatile Object get()
            {
                return get();
            }

            
            {
                this$0 = PermanentlyCachingHttpService.this;
                requestProvider = cacheablerequestprovider;
                responseHandlerProvider = provider;
                super();
            }
        })).getDelegate();
        return ((ResponseHandler) (obj));
        CimIOException cimioexception;
        cimioexception;
        LOG.warn("Caught IO error, we may be offline, attempt to fall back to permanent cache", cimioexception);
        obj = storageCache;
        obj;
        JVM INSTR monitorenter ;
        requestProvider = storageCache.retrieve(requestProvider.getCacheKey());
        if (requestProvider != null)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        LOG.warn("Cached stream not available, rethrowing");
        throw cimioexception;
        requestProvider;
        obj;
        JVM INSTR monitorexit ;
        throw requestProvider;
        responseHandlerProvider = (ResponseHandler)responseHandlerProvider.get();
        feedCachedContentToResponseHandler(responseHandlerProvider, requestProvider);
        obj;
        JVM INSTR monitorexit ;
        return responseHandlerProvider;
    }

    public volatile ResponseHandler executeRequest(RequestProvider requestprovider, Provider provider)
    {
        return executeRequest((CacheableRequestProvider)requestprovider, provider);
    }



}
