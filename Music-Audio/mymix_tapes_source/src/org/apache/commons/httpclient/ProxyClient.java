// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.io.IOException;
import java.net.Socket;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.params.HttpParams;
import org.apache.commons.httpclient.protocol.Protocol;

// Referenced classes of package org.apache.commons.httpclient:
//            HttpState, HostConfiguration, HttpException, ConnectMethod, 
//            HttpMethodDirector, HttpConnection, HttpConnectionManager

public class ProxyClient
{
    public static class ConnectResponse
    {

        private ConnectMethod connectMethod;
        private Socket socket;

        private void setConnectMethod(ConnectMethod connectmethod)
        {
            connectMethod = connectmethod;
        }

        private void setSocket(Socket socket1)
        {
            socket = socket1;
        }

        public ConnectMethod getConnectMethod()
        {
            return connectMethod;
        }

        public Socket getSocket()
        {
            return socket;
        }



        private ConnectResponse()
        {
        }

    }

    static class DummyConnectionManager
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

        DummyConnectionManager()
        {
        }
    }


    private HostConfiguration hostConfiguration;
    private HttpClientParams params;
    private HttpState state;

    public ProxyClient()
    {
        this(new HttpClientParams());
    }

    public ProxyClient(HttpClientParams httpclientparams)
    {
        state = new HttpState();
        params = null;
        hostConfiguration = new HostConfiguration();
        if (httpclientparams == null)
        {
            throw new IllegalArgumentException("Params may not be null");
        } else
        {
            params = httpclientparams;
            return;
        }
    }

    public ConnectResponse connect()
        throws IOException, HttpException
    {
        Object obj = getHostConfiguration();
        if (((HostConfiguration) (obj)).getProxyHost() == null)
        {
            throw new IllegalStateException("proxy host must be configured");
        }
        if (((HostConfiguration) (obj)).getHost() == null)
        {
            throw new IllegalStateException("destination host must be configured");
        }
        if (((HostConfiguration) (obj)).getProtocol().isSecure())
        {
            throw new IllegalStateException("secure protocol socket factory may not be used");
        }
        ConnectMethod connectmethod = new ConnectMethod(getHostConfiguration());
        connectmethod.getParams().setDefaults(getParams());
        DummyConnectionManager dummyconnectionmanager = new DummyConnectionManager();
        dummyconnectionmanager.setConnectionParams(getParams());
        (new HttpMethodDirector(dummyconnectionmanager, ((HostConfiguration) (obj)), getParams(), getState())).executeMethod(connectmethod);
        obj = new ConnectResponse();
        ((ConnectResponse) (obj)).setConnectMethod(connectmethod);
        if (connectmethod.getStatusCode() == 200)
        {
            ((ConnectResponse) (obj)).setSocket(dummyconnectionmanager.getConnection().getSocket());
            return ((ConnectResponse) (obj));
        } else
        {
            dummyconnectionmanager.getConnection().close();
            return ((ConnectResponse) (obj));
        }
    }

    public HostConfiguration getHostConfiguration()
    {
        this;
        JVM INSTR monitorenter ;
        HostConfiguration hostconfiguration = hostConfiguration;
        this;
        JVM INSTR monitorexit ;
        return hostconfiguration;
        Exception exception;
        exception;
        throw exception;
    }

    public HttpClientParams getParams()
    {
        this;
        JVM INSTR monitorenter ;
        HttpClientParams httpclientparams = params;
        this;
        JVM INSTR monitorexit ;
        return httpclientparams;
        Exception exception;
        exception;
        throw exception;
    }

    public HttpState getState()
    {
        this;
        JVM INSTR monitorenter ;
        HttpState httpstate = state;
        this;
        JVM INSTR monitorexit ;
        return httpstate;
        Exception exception;
        exception;
        throw exception;
    }

    public void setHostConfiguration(HostConfiguration hostconfiguration)
    {
        this;
        JVM INSTR monitorenter ;
        hostConfiguration = hostconfiguration;
        this;
        JVM INSTR monitorexit ;
        return;
        hostconfiguration;
        throw hostconfiguration;
    }

    public void setParams(HttpClientParams httpclientparams)
    {
        this;
        JVM INSTR monitorenter ;
        if (httpclientparams != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new IllegalArgumentException("Parameters may not be null");
        httpclientparams;
        this;
        JVM INSTR monitorexit ;
        throw httpclientparams;
        params = httpclientparams;
        this;
        JVM INSTR monitorexit ;
    }

    public void setState(HttpState httpstate)
    {
        this;
        JVM INSTR monitorenter ;
        state = httpstate;
        this;
        JVM INSTR monitorexit ;
        return;
        httpstate;
        throw httpstate;
    }
}
