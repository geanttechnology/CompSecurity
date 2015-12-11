// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.http.service;

import com.comcast.cim.cmasl.http.response.DetailedRequestStatus;
import com.comcast.cim.cmasl.http.response.ResponseHandler;
import com.comcast.cim.cmasl.utils.StorageCache;
import java.io.InputStream;
import java.util.Map;
import org.slf4j.Logger;

// Referenced classes of package com.comcast.cim.cmasl.http.service:
//            PermanentlyCachingHttpService

private class <init>
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
        PermanentlyCachingHttpService.access$300(PermanentlyCachingHttpService.this).debug("Storing stream to permanent cache");
        storageCache.store(inputstream, (new StringBuilder()).append(cacheKey).append("-temp").toString());
        PermanentlyCachingHttpService.access$400(PermanentlyCachingHttpService.this, _flddelegate, storageCache.retrieve((new StringBuilder()).append(cacheKey).append("-temp").toString()));
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


    private (StorageCache storagecache, String s, ResponseHandler responsehandler)
    {
        this$0 = PermanentlyCachingHttpService.this;
        super();
        _flddelegate = responsehandler;
        cacheKey = s;
        storageCache = storagecache;
    }

    storageCache(StorageCache storagecache, String s, ResponseHandler responsehandler, storageCache storagecache1)
    {
        this(storagecache, s, responsehandler);
    }
}
