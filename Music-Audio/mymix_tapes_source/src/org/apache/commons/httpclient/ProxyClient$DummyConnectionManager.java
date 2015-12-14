// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.params.HttpParams;

// Referenced classes of package org.apache.commons.httpclient:
//            HttpConnectionManager, ProxyClient, HttpException, HttpConnection, 
//            HostConfiguration

static class 
    implements HttpConnectionManager
{

    private HttpParams connectionParams;
    private HttpConnection httpConnection;

    public void closeIdleConnections(long l)
    {
    }

    public HttpConnection getConnection()
    {
        return httpConnection;
    }

    public HttpConnection getConnection(HostConfiguration hostconfiguration)
    {
        return getConnectionWithTimeout(hostconfiguration, -1L);
    }

    public HttpConnection getConnection(HostConfiguration hostconfiguration, long l)
        throws HttpException
    {
        return getConnectionWithTimeout(hostconfiguration, l);
    }

    public HttpConnection getConnectionWithTimeout(HostConfiguration hostconfiguration, long l)
    {
        httpConnection = new HttpConnection(hostconfiguration);
        httpConnection.setHttpConnectionManager(this);
        httpConnection.getParams().setDefaults(connectionParams);
        return httpConnection;
    }

    public HttpConnectionManagerParams getParams()
    {
        return null;
    }

    public void releaseConnection(HttpConnection httpconnection)
    {
    }

    public void setConnectionParams(HttpParams httpparams)
    {
        connectionParams = httpparams;
    }

    public void setParams(HttpConnectionManagerParams httpconnectionmanagerparams)
    {
    }

    ()
    {
    }
}
