// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.conn.params;

import com.comcast.cim.httpcomponentsandroid.conn.routing.HttpRoute;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.conn.params:
//            ConnManagerPNames, ConnPerRoute

public final class ConnManagerParams
    implements ConnManagerPNames
{

    private static final ConnPerRoute DEFAULT_CONN_PER_ROUTE = new ConnPerRoute() {

        public int getMaxForRoute(HttpRoute httproute)
        {
            return 2;
        }

    };

    public ConnManagerParams()
    {
    }

    public static long getTimeout(HttpParams httpparams)
    {
        if (httpparams == null)
        {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        Long long1 = (Long)httpparams.getParameter("http.conn-manager.timeout");
        if (long1 != null)
        {
            return long1.longValue();
        } else
        {
            return (long)httpparams.getIntParameter("http.connection.timeout", 0);
        }
    }

}
