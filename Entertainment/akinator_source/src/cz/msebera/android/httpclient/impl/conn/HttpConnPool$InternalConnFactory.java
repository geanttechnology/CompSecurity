// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.pool.ConnFactory;
import java.io.IOException;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn:
//            HttpConnPool

static class connOperator
    implements ConnFactory
{

    private final ClientConnectionOperator connOperator;

    public OperatedClientConnection create(HttpRoute httproute)
        throws IOException
    {
        return connOperator.createConnection();
    }

    public volatile Object create(Object obj)
        throws IOException
    {
        return create((HttpRoute)obj);
    }

    (ClientConnectionOperator clientconnectionoperator)
    {
        connOperator = clientconnectionoperator;
    }
}
