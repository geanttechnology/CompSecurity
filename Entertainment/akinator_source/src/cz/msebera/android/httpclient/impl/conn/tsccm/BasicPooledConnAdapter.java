// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.impl.conn.AbstractPoolEntry;
import cz.msebera.android.httpclient.impl.conn.AbstractPooledConnAdapter;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn.tsccm:
//            ThreadSafeClientConnManager

public class BasicPooledConnAdapter extends AbstractPooledConnAdapter
{

    protected BasicPooledConnAdapter(ThreadSafeClientConnManager threadsafeclientconnmanager, AbstractPoolEntry abstractpoolentry)
    {
        super(threadsafeclientconnmanager, abstractpoolentry);
        markReusable();
    }

    protected void detach()
    {
        super.detach();
    }

    protected ClientConnectionManager getManager()
    {
        return super.getManager();
    }

    protected AbstractPoolEntry getPoolEntry()
    {
        return super.getPoolEntry();
    }
}
