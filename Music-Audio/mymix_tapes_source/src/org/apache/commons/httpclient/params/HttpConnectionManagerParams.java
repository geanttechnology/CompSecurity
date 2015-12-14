// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.params;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.httpclient.HostConfiguration;

// Referenced classes of package org.apache.commons.httpclient.params:
//            HttpConnectionParams

public class HttpConnectionManagerParams extends HttpConnectionParams
{

    public static final String MAX_HOST_CONNECTIONS = "http.connection-manager.max-per-host";
    public static final String MAX_TOTAL_CONNECTIONS = "http.connection-manager.max-total";

    public HttpConnectionManagerParams()
    {
    }

    public int getDefaultMaxConnectionsPerHost()
    {
        return getMaxConnectionsPerHost(HostConfiguration.ANY_HOST_CONFIGURATION);
    }

    public int getMaxConnectionsPerHost(HostConfiguration hostconfiguration)
    {
        Object obj = (Map)getParameter("http.connection-manager.max-per-host");
        if (obj != null)
        {
            obj = (Integer)((Map) (obj)).get(hostconfiguration);
            if (obj == null && hostconfiguration != HostConfiguration.ANY_HOST_CONFIGURATION)
            {
                return getMaxConnectionsPerHost(HostConfiguration.ANY_HOST_CONFIGURATION);
            }
            if (obj != null)
            {
                return ((Integer) (obj)).intValue();
            }
        }
        return 2;
    }

    public int getMaxTotalConnections()
    {
        return getIntParameter("http.connection-manager.max-total", 20);
    }

    public void setDefaultMaxConnectionsPerHost(int i)
    {
        setMaxConnectionsPerHost(HostConfiguration.ANY_HOST_CONFIGURATION, i);
    }

    public void setMaxConnectionsPerHost(HostConfiguration hostconfiguration, int i)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException("maxHostConnections must be greater than 0");
        }
        Object obj = (Map)getParameter("http.connection-manager.max-per-host");
        if (obj == null)
        {
            obj = new HashMap();
        } else
        {
            obj = new HashMap(((Map) (obj)));
        }
        ((Map) (obj)).put(hostconfiguration, new Integer(i));
        setParameter("http.connection-manager.max-per-host", obj);
    }

    public void setMaxTotalConnections(int i)
    {
        setIntParameter("http.connection-manager.max-total", i);
    }
}
