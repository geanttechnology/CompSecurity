// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.huc;

import com.squareup.okhttp.internal.http.CacheRequest;
import java.io.IOException;
import okio.Okio;
import okio.Sink;

// Referenced classes of package com.squareup.okhttp.internal.huc:
//            CacheAdapter

class val.request
    implements CacheRequest
{

    final CacheAdapter this$0;
    final java.net.CacheRequest val$request;

    public void abort()
    {
        val$request.abort();
    }

    public Sink body()
        throws IOException
    {
        java.io.OutputStream outputstream = val$request.getBody();
        if (outputstream != null)
        {
            return Okio.sink(outputstream);
        } else
        {
            return null;
        }
    }

    ()
    {
        this$0 = final_cacheadapter;
        val$request = java.net.CacheRequest.this;
        super();
    }
}
