// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.conn.tsccm;

import com.comcast.cim.httpcomponentsandroid.conn.ClientConnectionManager;
import com.comcast.cim.httpcomponentsandroid.impl.conn.AbstractPoolEntry;
import com.comcast.cim.httpcomponentsandroid.impl.conn.AbstractPooledConnAdapter;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.conn.tsccm:
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
