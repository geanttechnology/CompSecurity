// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.pool;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.config.ConnectionConfig;
import cz.msebera.android.httpclient.config.SocketConfig;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.pool.AbstractConnPool;
import cz.msebera.android.httpclient.pool.ConnFactory;
import cz.msebera.android.httpclient.pool.PoolEntry;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package cz.msebera.android.httpclient.impl.pool:
//            BasicConnFactory, BasicPoolEntry

public class BasicConnPool extends AbstractConnPool
{

    private static final AtomicLong COUNTER = new AtomicLong();

    public BasicConnPool()
    {
        super(new BasicConnFactory(SocketConfig.DEFAULT, ConnectionConfig.DEFAULT), 2, 20);
    }

    public BasicConnPool(SocketConfig socketconfig, ConnectionConfig connectionconfig)
    {
        super(new BasicConnFactory(socketconfig, connectionconfig), 2, 20);
    }

    public BasicConnPool(HttpParams httpparams)
    {
        super(new BasicConnFactory(httpparams), 2, 20);
    }

    public BasicConnPool(ConnFactory connfactory)
    {
        super(connfactory, 2, 20);
    }

    protected BasicPoolEntry createEntry(HttpHost httphost, HttpClientConnection httpclientconnection)
    {
        return new BasicPoolEntry(Long.toString(COUNTER.getAndIncrement()), httphost, httpclientconnection);
    }

    protected volatile PoolEntry createEntry(Object obj, Object obj1)
    {
        return createEntry((HttpHost)obj, (HttpClientConnection)obj1);
    }

}
