// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.pool;

import cz.msebera.android.httpclient.concurrent.FutureCallback;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;

// Referenced classes of package cz.msebera.android.httpclient.pool:
//            PoolEntryFuture, AbstractConnPool, PoolEntry

class k extends PoolEntryFuture
{

    final AbstractConnPool this$0;
    final Object val$route;
    final Object val$state;

    public PoolEntry getPoolEntry(long l, TimeUnit timeunit)
        throws InterruptedException, TimeoutException, IOException
    {
        timeunit = AbstractConnPool.access$000(AbstractConnPool.this, val$route, val$state, l, timeunit, this);
        onLease(timeunit);
        return timeunit;
    }

    public volatile Object getPoolEntry(long l, TimeUnit timeunit)
        throws IOException, InterruptedException, TimeoutException
    {
        return getPoolEntry(l, timeunit);
    }

    k(Object obj, Object obj1)
    {
        this$0 = final_abstractconnpool;
        val$route = obj;
        val$state = obj1;
        super(final_lock, FutureCallback.this);
    }
}
