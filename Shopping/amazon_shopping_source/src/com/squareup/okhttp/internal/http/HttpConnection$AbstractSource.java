// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.okio.OkBuffer;
import com.squareup.okhttp.internal.okio.Okio;
import java.io.IOException;
import java.io.OutputStream;
import java.net.CacheRequest;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HttpConnection

private class cacheRequest
{

    protected final OutputStream cacheBody;
    private final CacheRequest cacheRequest;
    protected boolean closed;
    final HttpConnection this$0;

    protected final void cacheWrite(OkBuffer okbuffer, long l)
        throws IOException
    {
        if (cacheBody != null)
        {
            Okio.copy(okbuffer, okbuffer.size() - l, l, cacheBody);
        }
    }

    protected final void endOfInput(boolean flag)
        throws IOException
    {
        if (HttpConnection.access$300(HttpConnection.this) != 5)
        {
            throw new IllegalStateException((new StringBuilder()).append("state: ").append(HttpConnection.access$300(HttpConnection.this)).toString());
        }
        if (cacheRequest != null)
        {
            cacheBody.close();
        }
        HttpConnection.access$302(HttpConnection.this, 0);
        if (flag && HttpConnection.access$600(HttpConnection.this) == 1)
        {
            HttpConnection.access$602(HttpConnection.this, 0);
            HttpConnection.access$800(HttpConnection.this).recycle(HttpConnection.access$700(HttpConnection.this));
        } else
        if (HttpConnection.access$600(HttpConnection.this) == 2)
        {
            HttpConnection.access$302(HttpConnection.this, 6);
            HttpConnection.access$700(HttpConnection.this).close();
            return;
        }
    }

    protected final void unexpectedEndOfInput()
    {
        if (cacheRequest != null)
        {
            cacheRequest.abort();
        }
        Util.closeQuietly(HttpConnection.access$700(HttpConnection.this));
        HttpConnection.access$302(HttpConnection.this, 6);
    }

    (CacheRequest cacherequest)
        throws IOException
    {
        this$0 = HttpConnection.this;
        super();
        if (cacherequest != null)
        {
            httpconnection = cacherequest.getBody();
        } else
        {
            httpconnection = null;
        }
        if (HttpConnection.this == null)
        {
            cacherequest = null;
        }
        cacheBody = HttpConnection.this;
        cacheRequest = cacherequest;
    }
}
