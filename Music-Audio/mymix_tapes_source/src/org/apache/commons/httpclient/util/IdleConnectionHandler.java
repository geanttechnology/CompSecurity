// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.httpclient.HttpConnection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IdleConnectionHandler
{

    private static final Log LOG;
    static Class class$org$apache$commons$httpclient$util$IdleConnectionHandler;
    private Map connectionToAdded;

    public IdleConnectionHandler()
    {
        connectionToAdded = new HashMap();
    }

    static Class _mthclass$(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NoClassDefFoundError(s.getMessage());
        }
        return s;
    }

    public void add(HttpConnection httpconnection)
    {
        Long long1 = new Long(System.currentTimeMillis());
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Adding connection at: " + long1);
        }
        connectionToAdded.put(httpconnection, long1);
    }

    public void closeIdleConnections(long l)
    {
        l = System.currentTimeMillis() - l;
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Checking for connections, idleTimeout: " + l);
        }
        Iterator iterator = connectionToAdded.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            HttpConnection httpconnection = (HttpConnection)iterator.next();
            Long long1 = (Long)connectionToAdded.get(httpconnection);
            if (long1.longValue() <= l)
            {
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("Closing connection, connection time: " + long1);
                }
                iterator.remove();
                httpconnection.close();
            }
        } while (true);
    }

    public void remove(HttpConnection httpconnection)
    {
        connectionToAdded.remove(httpconnection);
    }

    public void removeAll()
    {
        connectionToAdded.clear();
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$util$IdleConnectionHandler == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.util.IdleConnectionHandler");
            class$org$apache$commons$httpclient$util$IdleConnectionHandler = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$util$IdleConnectionHandler;
        }
        LOG = LogFactory.getLog(class1);
    }
}
