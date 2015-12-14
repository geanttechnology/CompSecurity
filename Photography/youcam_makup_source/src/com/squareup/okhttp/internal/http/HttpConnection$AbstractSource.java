// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Util;
import java.net.Socket;
import okio.d;
import okio.q;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            CacheRequest, HttpConnection

class cacheRequest
{

    protected final q cacheBody;
    private final CacheRequest cacheRequest;
    protected boolean closed;
    final HttpConnection this$0;

    protected final void cacheWrite(d d1, long l)
    {
        if (cacheBody != null)
        {
            d1 = d1.r();
            d1.g(d1.a() - l);
            cacheBody.write(d1, l);
        }
    }

    protected final void endOfInput(boolean flag)
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
            Internal.instance.recycle(HttpConnection.access$700(HttpConnection.this), HttpConnection.access$800(HttpConnection.this));
        } else
        if (HttpConnection.access$600(HttpConnection.this) == 2)
        {
            HttpConnection.access$302(HttpConnection.this, 6);
            HttpConnection.access$800(HttpConnection.this).getSocket().close();
            return;
        }
    }

    protected final void unexpectedEndOfInput()
    {
        if (cacheRequest != null)
        {
            cacheRequest.abort();
        }
        Util.closeQuietly(HttpConnection.access$800(HttpConnection.this).getSocket());
        HttpConnection.access$302(HttpConnection.this, 6);
    }

    (CacheRequest cacherequest)
    {
        this$0 = HttpConnection.this;
        super();
        if (cacherequest != null)
        {
            httpconnection = cacherequest.body();
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
