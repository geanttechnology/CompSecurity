// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.impl.conn.AbstractPoolEntry;
import cz.msebera.android.httpclient.util.Args;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn.tsccm:
//            BasicPoolEntryRef

public class BasicPoolEntry extends AbstractPoolEntry
{

    private final long created;
    private long expiry;
    private long updated;
    private final long validUntil;

    public BasicPoolEntry(ClientConnectionOperator clientconnectionoperator, HttpRoute httproute)
    {
        this(clientconnectionoperator, httproute, -1L, TimeUnit.MILLISECONDS);
    }

    public BasicPoolEntry(ClientConnectionOperator clientconnectionoperator, HttpRoute httproute, long l, TimeUnit timeunit)
    {
        super(clientconnectionoperator, httproute);
        Args.notNull(httproute, "HTTP route");
        created = System.currentTimeMillis();
        if (l > 0L)
        {
            validUntil = created + timeunit.toMillis(l);
        } else
        {
            validUntil = 0x7fffffffffffffffL;
        }
        expiry = validUntil;
    }

    public BasicPoolEntry(ClientConnectionOperator clientconnectionoperator, HttpRoute httproute, ReferenceQueue referencequeue)
    {
        super(clientconnectionoperator, httproute);
        Args.notNull(httproute, "HTTP route");
        created = System.currentTimeMillis();
        validUntil = 0x7fffffffffffffffL;
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
