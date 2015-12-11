// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import cz.msebera.android.httpclient.conn.ConnectionPoolTimeoutException;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn:
//            PoolingClientConnectionManager

class val.future
    implements ClientConnectionRequest
{

    final PoolingClientConnectionManager this$0;
    final Future val$future;

    public void abortRequest()
    {
        val$future.cancel(true);
    }

    public ManagedClientConnection getConnection(long l, TimeUnit timeunit)
        throws InterruptedException, ConnectionPoolTimeoutException
    {
        return leaseConnection(val$future, l, timeunit);
    }

    ()
    {
        this$0 = final_poolingclientconnectionmanager;
        val$future = Future.this;
        super();
    }
}
