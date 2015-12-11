// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.huc;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.http.CacheRequest;
import com.squareup.okhttp.internal.http.CacheStrategy;
import java.io.IOException;
import java.net.CacheResponse;
import java.net.ResponseCache;
import okio.Okio;
import okio.Sink;

// Referenced classes of package com.squareup.okhttp.internal.huc:
//            JavaApiConverter

public final class CacheAdapter
    implements InternalCache
{

    private final ResponseCache _flddelegate;

    public CacheAdapter(ResponseCache responsecache)
    {
        _flddelegate = responsecache;
    }

    private CacheResponse getJavaCachedResponse(Request request)
        throws IOException
    {
        java.util.Map map = JavaApiConverter.extractJavaHeaders(request);
        return _flddelegate.get(request.uri(), request.method(), map);
    }

    public Response get(Request request)
        throws IOException
    {
        CacheResponse cacheresponse = getJavaCachedResponse(request);
        if (cacheresponse == null)
        {
            return null;
        } else
        {
            return JavaApiConverter.createOkResponse(request, cacheresponse);
        }
    }

    public ResponseCache getDelegate()
    {
        return _flddelegate;
    }

    public CacheRequest put(final Response request)
        throws IOException
    {
        java.net.URI uri = request.request().uri();
        request = JavaApiConverter.createJavaUrlConnection(request);
        request = _flddelegate.put(uri, request);
        if (request == null)
        {
            return null;
        } else
        {
            return new CacheRequest() {

                final CacheAdapter this$0;
                final java.net.CacheRequest val$request;

                public void abort()
                {
                    request.abort();
                }

                public Sink body()
                    throws IOException
                {
                    java.io.OutputStream outputstream = request.getBody();
                    if (outputstream != null)
                    {
                        return Okio.sink(outputstream);
                    } else
                    {
                        return null;
                    }
                }

            
            {
                this$0 = CacheAdapter.this;
                request = cacherequest;
                super();
            }
            };
        }
    }

    public void remove(Request request)
        throws IOException
    {
    }

    public void trackConditionalCacheHit()
    {
    }

    public void trackResponse(CacheStrategy cachestrategy)
    {
    }

    public void update(Response response, Response response1)
        throws IOException
    {
    }
}
