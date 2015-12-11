// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.conn;

import com.comcast.cim.httpcomponentsandroid.conn.routing.HttpRoute;
import com.comcast.cim.httpcomponentsandroid.conn.scheme.SchemeRegistry;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.conn:
//            ManagedClientConnection, ClientConnectionRequest

public interface ClientConnectionManager
{

    public abstract SchemeRegistry getSchemeRegistry();

    public abstract void releaseConnection(ManagedClientConnection managedclientconnection, long l, TimeUnit timeunit);

    public abstract ClientConnectionRequest requestConnection(HttpRoute httproute, Object obj);
}
