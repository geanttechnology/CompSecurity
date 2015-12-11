// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.conn.ConnectionPoolTimeoutException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn.tsccm:
//            BasicPoolEntry

public interface PoolEntryRequest
{

    public abstract void abortRequest();

    public abstract BasicPoolEntry getPoolEntry(long l, TimeUnit timeunit)
        throws InterruptedException, ConnectionPoolTimeoutException;
}
