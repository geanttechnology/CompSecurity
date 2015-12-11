// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.conn.params;

import com.comcast.cim.httpcomponentsandroid.conn.routing.HttpRoute;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.conn.params:
//            ConnPerRoute

public final class ConnPerRouteBean
    implements ConnPerRoute
{

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
        if (httproute == null)
        {
            throw new IllegalArgumentException("HTTP route may not be null.");
        }
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
        if (i < 1)
        {
            throw new IllegalArgumentException("The maximum must be greater than 0.");
        } else
        {
            defaultMax = i;
            return;
        }
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
