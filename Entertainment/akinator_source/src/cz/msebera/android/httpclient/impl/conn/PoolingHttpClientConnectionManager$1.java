// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.conn.ConnectionPoolTimeoutException;
import cz.msebera.android.httpclient.conn.ConnectionRequest;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn:
//            PoolingHttpClientConnectionManager

class val.future
    implements ConnectionRequest
{

    final PoolingHttpClientConnectionManager this$0;
    final Future val$future;

    public boolean cancel()
    {
        return val$future.cancel(true);
    }

    public HttpClientConnection get(long l, TimeUnit timeunit)
        throws InterruptedException, ExecutionException, ConnectionPoolTimeoutException
    {
        return leaseConnection(val$future, l, timeunit);
    }

    ()
    {
        this$0 = final_poolinghttpclientconnectionmanager;
        val$future = Future.this;
        super();
    }
}
