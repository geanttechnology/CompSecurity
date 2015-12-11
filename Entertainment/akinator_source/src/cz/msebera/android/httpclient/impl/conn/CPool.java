// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.pool.AbstractConnPool;
import cz.msebera.android.httpclient.pool.ConnFactory;
import cz.msebera.android.httpclient.pool.PoolEntry;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn:
//            CPoolEntry

class CPool extends AbstractConnPool
{

    private static final AtomicLong COUNTER = new AtomicLong();
    public HttpClientAndroidLog log;
    private final long timeToLive;
    private final TimeUnit tunit;

    public CPool(ConnFactory connfactory, int i, int j, long l, TimeUnit timeunit)
    {
        super(connfactory, i, j);
        log = new HttpClientAndroidLog(cz/msebera/android/httpclient/impl/conn/CPool);
        timeToLive = l;
        tunit = timeunit;
    }

    protected CPoolEntry createEntry(HttpRoute httproute, ManagedHttpClientConnection managedhttpclientconnection)
    {
        String s = Long.toString(COUNTER.getAndIncrement());
        return new CPoolEntry(log, s, httproute, managedhttpclientconnection, timeToLive, tunit);
    }

    protected volatile PoolEntry createEntry(Object obj, Object obj1)
    {
        return createEntry((HttpRoute)obj, (ManagedHttpClientConnection)obj1);
    }

}
