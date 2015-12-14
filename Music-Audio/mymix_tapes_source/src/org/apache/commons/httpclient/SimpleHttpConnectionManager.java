// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient:
//            HttpConnectionManager, HttpConnection, HostConfiguration

public class SimpleHttpConnectionManager
    implements HttpConnectionManager
{

    private static final Log LOG;
    private static final String MISUSE_MESSAGE = "SimpleHttpConnectionManager being used incorrectly.  Be sure that HttpMethod.releaseConnection() is always called and that only one thread and/or method is using this connection manager at a time.";
    static Class class$org$apache$commons$httpclient$SimpleHttpConnectionManager;
    private boolean alwaysClose;
    protected HttpConnection httpConnection;
    private long idleStartTime;
    private volatile boolean inUse;
    private HttpConnectionManagerParams params;

    public SimpleHttpConnectionManager()
    {
        params = new HttpConnectionManagerParams();
        idleStartTime = 0x7fffffffffffffffL;
        inUse = false;
        alwaysClose = false;
    }

    public SimpleHttpConnectionManager(boolean flag)
    {
        params = new HttpConnectionManagerParams();
        idleStartTime = 0x7fffffffffffffffL;
        inUse = false;
        alwaysClose = false;
        alwaysClose = flag;
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

    static void finishLastResponse(HttpConnection httpconnection)
    {
        InputStream inputstream;
        inputstream = httpconnection.getLastResponseInputStream();
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_18;
        }
        httpconnection.setLastResponseInputStream(null);
        inputstream.close();
        return;
        IOException ioexception;
        ioexception;
        httpconnection.close();
        return;
    }

    public void closeIdleConnections(long l)
    {
        long l1 = System.currentTimeMillis();
        if (idleStartTime <= l1 - l)
        {
            httpConnection.close();
        }
    }

    public HttpConnection getConnection(HostConfiguration hostconfiguration)
    {
        return getConnection(hostconfiguration, 0L);
    }

    public HttpConnection getConnection(HostConfiguration hostconfiguration, long l)
    {
        return getConnectionWithTimeout(hostconfiguration, l);
    }

    public HttpConnection getConnectionWithTimeout(HostConfiguration hostconfiguration, long l)
    {
        if (httpConnection == null)
        {
            httpConnection = new HttpConnection(hostconfiguration);
            httpConnection.setHttpConnectionManager(this);
            httpConnection.getParams().setDefaults(params);
        } else
        if (!hostconfiguration.hostEquals(httpConnection) || !hostconfiguration.proxyEquals(httpConnection))
        {
            if (httpConnection.isOpen())
            {
                httpConnection.close();
            }
            httpConnection.setHost(hostconfiguration.getHost());
            httpConnection.setPort(hostconfiguration.getPort());
            httpConnection.setProtocol(hostconfiguration.getProtocol());
            httpConnection.setLocalAddress(hostconfiguration.getLocalAddress());
            httpConnection.setProxyHost(hostconfiguration.getProxyHost());
            httpConnection.setProxyPort(hostconfiguration.getProxyPort());
        } else
        {
            finishLastResponse(httpConnection);
        }
        idleStartTime = 0x7fffffffffffffffL;
        if (inUse)
        {
            LOG.warn("SimpleHttpConnectionManager being used incorrectly.  Be sure that HttpMethod.releaseConnection() is always called and that only one thread and/or method is using this connection manager at a time.");
        }
        inUse = true;
        return httpConnection;
    }

    public HttpConnectionManagerParams getParams()
    {
        return params;
    }

    public boolean isConnectionStaleCheckingEnabled()
    {
        return params.isStaleCheckingEnabled();
    }

    public void releaseConnection(HttpConnection httpconnection)
    {
        if (httpconnection != httpConnection)
        {
            throw new IllegalStateException("Unexpected release of an unknown connection.");
        }
        if (alwaysClose)
        {
            httpConnection.close();
        } else
        {
            finishLastResponse(httpConnection);
        }
        inUse = false;
        idleStartTime = System.currentTimeMillis();
    }

    public void setConnectionStaleCheckingEnabled(boolean flag)
    {
        params.setStaleCheckingEnabled(flag);
    }

    public void setParams(HttpConnectionManagerParams httpconnectionmanagerparams)
    {
        if (httpconnectionmanagerparams == null)
        {
            throw new IllegalArgumentException("Parameters may not be null");
        } else
        {
            params = httpconnectionmanagerparams;
            return;
        }
    }

    public void shutdown()
    {
        httpConnection.close();
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$SimpleHttpConnectionManager == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.SimpleHttpConnectionManager");
            class$org$apache$commons$httpclient$SimpleHttpConnectionManager = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$SimpleHttpConnectionManager;
        }
        LOG = LogFactory.getLog(class1);
    }
}
