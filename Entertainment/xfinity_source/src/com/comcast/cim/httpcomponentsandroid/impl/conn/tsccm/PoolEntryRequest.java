// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.conn.tsccm;

import com.comcast.cim.httpcomponentsandroid.conn.ConnectionPoolTimeoutException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.conn.tsccm:
//            BasicPoolEntry

public interface PoolEntryRequest
{

    public abstract BasicPoolEntry getPoolEntry(long l, TimeUnit timeunit)
        throws InterruptedException, ConnectionPoolTimeoutException;
}
