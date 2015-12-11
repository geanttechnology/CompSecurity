// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.conn.tsccm;

import com.comcast.cim.httpcomponentsandroid.conn.ConnectionPoolTimeoutException;
import com.comcast.cim.httpcomponentsandroid.conn.routing.HttpRoute;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.conn.tsccm:
//            PoolEntryRequest, ConnPoolByRoute, WaitingThreadAborter, BasicPoolEntry

class val.state
    implements PoolEntryRequest
{

    final ConnPoolByRoute this$0;
    final WaitingThreadAborter val$aborter;
    final HttpRoute val$route;
    final Object val$state;

    public BasicPoolEntry getPoolEntry(long l, TimeUnit timeunit)
        throws InterruptedException, ConnectionPoolTimeoutException
    {
        return getEntryBlocking(val$route, val$state, l, timeunit, val$aborter);
    }

    er()
    {
        this$0 = final_connpoolbyroute;
        val$aborter = waitingthreadaborter;
        val$route = httproute;
        val$state = Object.this;
        super();
    }
}
