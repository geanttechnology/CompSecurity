// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn.params;

import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.util.Args;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package cz.msebera.android.httpclient.conn.params:
//            ConnPerRoute

public final class ConnPerRouteBean
    implements ConnPerRoute
{

    public static final int DEFAULT_MAX_CONNECTIONS_PER_ROUTE = 2;
    private volatile int defaultMax;
    private final ConcurrentHashMap maxPerHostMap;

    public ConnPerRouteBean()
    {
        this(2);
    }

    public ConnPerRouteBean(int i)
    {
        maxPerHostMap = new ConcurrentHashMap();
        setDefaultMaxPerRoute(i);
    }

    public int getDefaultMax()
    {
        return defaultMax;
    }

    public int getDefaultMaxPerRoute()
    {
        return defaultMax;
    }

    public int getMaxForRoute(HttpRoute httproute)
    {
        Args.notNull(httproute, "HTTP route");
        httproute = (Integer)maxPerHostMap.get(httproute);
        if (httproute != null)
        {
            return httproute.intValue();
        } else
        {
            return defaultMax;
        }
    }

    public void setDefaultMaxPerRoute(int i)
    {
        Args.positive(i, "Defautl max per route");
        defaultMax = i;
    }

    public void setMaxForRoute(HttpRoute httproute, int i)
    {
        Args.notNull(httproute, "HTTP route");
        Args.positive(i, "Max per route");
        maxPerHostMap.put(httproute, Integer.valueOf(i));
    }

    public void setMaxForRoutes(Map map)
    {
        if (map == null)
        {
            return;
        } else
        {
            maxPerHostMap.clear();
            maxPerHostMap.putAll(map);
            return;
        }
    }

    public String toString()
    {
        return maxPerHostMap.toString();
    }
}
