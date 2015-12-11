// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import cz.msebera.android.httpclient.conn.ConnectionPoolTimeoutException;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.util.Args;
import java.util.concurrent.TimeUnit;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn.tsccm:
//            ThreadSafeClientConnManager, PoolEntryRequest, BasicPooledConnAdapter

class val.route
    implements ClientConnectionRequest
{

    final ThreadSafeClientConnManager this$0;
    final PoolEntryRequest val$poolRequest;
    final HttpRoute val$route;

    public void abortRequest()
    {
        val$poolRequest.abortRequest();
    }

    public ManagedClientConnection getConnection(long l, TimeUnit timeunit)
        throws InterruptedException, ConnectionPoolTimeoutException
    {
        Args.notNull(val$route, "Route");
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Get connection: ").append(val$route).append(", timeout = ").append(l).toString());
        }
        timeunit = val$poolRequest.getPoolEntry(l, timeunit);
        return new BasicPooledConnAdapter(ThreadSafeClientConnManager.this, timeunit);
    }

    Q()
    {
        this$0 = final_threadsafeclientconnmanager;
        val$poolRequest = poolentryrequest;
        val$route = HttpRoute.this;
        super();
    }
}
