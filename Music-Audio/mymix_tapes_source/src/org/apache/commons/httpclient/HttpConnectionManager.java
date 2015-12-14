// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import org.apache.commons.httpclient.params.HttpConnectionManagerParams;

// Referenced classes of package org.apache.commons.httpclient:
//            HttpException, ConnectionPoolTimeoutException, HostConfiguration, HttpConnection

public interface HttpConnectionManager
{

    public abstract void closeIdleConnections(long l);

    public abstract HttpConnection getConnection(HostConfiguration hostconfiguration);

    public abstract HttpConnection getConnection(HostConfiguration hostconfiguration, long l)
        throws HttpException;

    public abstract HttpConnection getConnectionWithTimeout(HostConfiguration hostconfiguration, long l)
        throws ConnectionPoolTimeoutException;

    public abstract HttpConnectionManagerParams getParams();

    public abstract void releaseConnection(HttpConnection httpconnection);

    public abstract void setParams(HttpConnectionManagerParams httpconnectionmanagerparams);
}
