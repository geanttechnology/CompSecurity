// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.pool.AbstractConnPool;
import cz.msebera.android.httpclient.pool.ConnFactory;
import cz.msebera.android.httpclient.pool.PoolEntry;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn:
//            HttpPoolEntry

class HttpConnPool extends AbstractConnPool
{
    static class InternalConnFactory
        implements ConnFactory
    {

        private final ClientConnectionOperator connOperator;

        public OperatedClientConnection create(HttpRoute httproute)
            throws IOException
        {
            return connOperator.createConnection();
        }

        public volatile Object create(Object obj)
            throws IOException
        {
            return create((HttpRoute)obj);
        }

        InternalConnFactory(ClientConnectionOperator clientconnectionoperator)
        {
            connOperator = clientconnectionoperator;
        }
    }


    private static final AtomicLong COUNTER = new AtomicLong();
    public HttpClientAndroidLog log;
    private final long timeToLive;
    private final TimeUnit tunit;

    public HttpConnPool(HttpClientAndroidLog httpclientandroidlog, ClientConnectionOperator clientconnectionoperator, int i, int j, long l, TimeUnit timeunit)
    {
        super(new InternalConnFactory(clientconnectionoperator), i, j);
        log = httpclientandroidlog;
        timeToLive = l;
        tunit = timeunit;
    }

    protected HttpPoolEntry createEntry(HttpRoute httproute, OperatedClientConnection operatedclientconnection)
    {
        String s = Long.toString(COUNTER.getAndIncrement());
        return new HttpPoolEntry(log, s, httproute, operatedclientconnection, timeToLive, tunit);
    }

    protected volatile PoolEntry createEntry(Object obj, Object obj1)
    {
        return createEntry((HttpRoute)obj, (OperatedClientConnection)obj1);
    }

}
