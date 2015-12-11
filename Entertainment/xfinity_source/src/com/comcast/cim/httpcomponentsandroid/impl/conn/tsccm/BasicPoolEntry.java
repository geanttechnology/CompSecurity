// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.conn.tsccm;

import com.comcast.cim.httpcomponentsandroid.conn.ClientConnectionOperator;
import com.comcast.cim.httpcomponentsandroid.conn.OperatedClientConnection;
import com.comcast.cim.httpcomponentsandroid.conn.routing.HttpRoute;
import com.comcast.cim.httpcomponentsandroid.impl.conn.AbstractPoolEntry;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.conn.tsccm:
//            BasicPoolEntryRef

public class BasicPoolEntry extends AbstractPoolEntry
{

    private final long created = System.currentTimeMillis();
    private long expiry;
    private long updated;
    private long validUntil;

    public BasicPoolEntry(ClientConnectionOperator clientconnectionoperator, HttpRoute httproute, long l, TimeUnit timeunit)
    {
        super(clientconnectionoperator, httproute);
        if (httproute == null)
        {
            throw new IllegalArgumentException("HTTP route may not be null");
        }
        if (l > 0L)
        {
            validUntil = created + timeunit.toMillis(l);
        } else
        {
            validUntil = 0x7fffffffffffffffL;
        }
        expiry = validUntil;
    }

    protected final OperatedClientConnection getConnection()
    {
        return super.connection;
    }

    public long getCreated()
    {
        return created;
    }

    public long getExpiry()
    {
        return expiry;
    }

    protected final HttpRoute getPlannedRoute()
    {
        return super.route;
    }

    public long getUpdated()
    {
        return updated;
    }

    public long getValidUntil()
    {
        return validUntil;
    }

    protected final BasicPoolEntryRef getWeakRef()
    {
        return null;
    }

    public boolean isExpired(long l)
    {
        return l >= expiry;
    }

    protected void shutdownEntry()
    {
        super.shutdownEntry();
    }

    public void updateExpiry(long l, TimeUnit timeunit)
    {
        updated = System.currentTimeMillis();
        if (l > 0L)
        {
            l = updated + timeunit.toMillis(l);
        } else
        {
            l = 0x7fffffffffffffffL;
        }
        expiry = Math.min(validUntil, l);
    }
}
