// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.conn;

import com.comcast.cim.httpcomponentsandroid.HttpHost;
import com.comcast.cim.httpcomponentsandroid.conn.ClientConnectionOperator;
import com.comcast.cim.httpcomponentsandroid.conn.ConnectTimeoutException;
import com.comcast.cim.httpcomponentsandroid.conn.HttpHostConnectException;
import com.comcast.cim.httpcomponentsandroid.conn.OperatedClientConnection;
import com.comcast.cim.httpcomponentsandroid.conn.scheme.LayeredSchemeSocketFactory;
import com.comcast.cim.httpcomponentsandroid.conn.scheme.Scheme;
import com.comcast.cim.httpcomponentsandroid.conn.scheme.SchemeRegistry;
import com.comcast.cim.httpcomponentsandroid.conn.scheme.SchemeSocketFactory;
import com.comcast.cim.httpcomponentsandroid.params.HttpConnectionParams;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.conn:
//            DefaultClientConnection, HttpInetSocketAddress

public class DefaultClientConnectionOperator
    implements ClientConnectionOperator
{

    private final Log log = LogFactory.getLog(getClass());
    protected final SchemeRegistry schemeRegistry;

    public DefaultClientConnectionOperator(SchemeRegistry schemeregistry)
    {
        if (schemeregistry == null)
        {
            throw new IllegalArgumentException("Scheme registry amy not be null");
        } else
        {
            schemeRegistry = schemeregistry;
            return;
        }
    }

    public OperatedClientConnection createConnection()
    {
        return new DefaultClientConnection();
    }

    public void openConnection(OperatedClientConnection operatedclientconnection, HttpHost httphost, InetAddress inetaddress, HttpContext httpcontext, HttpParams httpparams)
        throws IOException
    {
        SchemeSocketFactory schemesocketfactory;
        InetAddress ainetaddress[];
        int i;
        int j;
        if (operatedclientconnection == null)
        {
            throw new IllegalArgumentException("Connection may not be null");
        }
        if (httphost == null)
        {
            throw new IllegalArgumentException("Target host may not be null");
        }
        if (httpparams == null)
        {
            throw new IllegalArgumentException("Parameters may not be null");
        }
        if (operatedclientconnection.isOpen())
        {
            throw new IllegalStateException("Connection must not be open");
        }
        Scheme scheme = schemeRegistry.getScheme(httphost.getSchemeName());
        schemesocketfactory = scheme.getSchemeSocketFactory();
        ainetaddress = resolveHostname(httphost.getHostName());
        j = scheme.resolvePort(httphost.getPort());
        i = 0;
_L2:
        HttpInetSocketAddress httpinetsocketaddress;
        boolean flag;
        if (i >= ainetaddress.length)
        {
            break MISSING_BLOCK_LABEL_295;
        }
        Object obj = ainetaddress[i];
        Socket socket;
        Socket socket1;
        if (i == ainetaddress.length - 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        socket = schemesocketfactory.createSocket(httpparams);
        operatedclientconnection.opening(socket, httphost);
        httpinetsocketaddress = new HttpInetSocketAddress(httphost, ((InetAddress) (obj)), j);
        obj = null;
        if (inetaddress != null)
        {
            obj = new InetSocketAddress(inetaddress, 0);
        }
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Connecting to ").append(httpinetsocketaddress).toString());
        }
        socket1 = schemesocketfactory.connectSocket(socket, httpinetsocketaddress, ((InetSocketAddress) (obj)), httpparams);
        obj = socket;
        if (socket == socket1)
        {
            break MISSING_BLOCK_LABEL_268;
        }
        obj = socket1;
        operatedclientconnection.opening(((Socket) (obj)), httphost);
        prepareSocket(((Socket) (obj)), httpcontext, httpparams);
        operatedclientconnection.openCompleted(schemesocketfactory.isSecure(((Socket) (obj))), httpparams);
        return;
        Object obj1;
        obj1;
        if (flag)
        {
            throw new HttpHostConnectException(httphost, ((ConnectException) (obj1)));
        }
        break MISSING_BLOCK_LABEL_330;
        obj1;
        if (flag)
        {
            throw obj1;
        }
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Connect to ").append(httpinetsocketaddress).append(" timed out. ").append("Connection will be retried using another IP address").toString());
        }
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void prepareSocket(Socket socket, HttpContext httpcontext, HttpParams httpparams)
        throws IOException
    {
        socket.setTcpNoDelay(HttpConnectionParams.getTcpNoDelay(httpparams));
        socket.setSoTimeout(HttpConnectionParams.getSoTimeout(httpparams));
        int i = HttpConnectionParams.getLinger(httpparams);
        if (i >= 0)
        {
            boolean flag;
            if (i > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            socket.setSoLinger(flag, i);
        }
    }

    protected InetAddress[] resolveHostname(String s)
        throws UnknownHostException
    {
        return InetAddress.getAllByName(s);
    }

    public void updateSecureConnection(OperatedClientConnection operatedclientconnection, HttpHost httphost, HttpContext httpcontext, HttpParams httpparams)
        throws IOException
    {
        if (operatedclientconnection == null)
        {
            throw new IllegalArgumentException("Connection may not be null");
        }
        if (httphost == null)
        {
            throw new IllegalArgumentException("Target host may not be null");
        }
        if (httpparams == null)
        {
            throw new IllegalArgumentException("Parameters may not be null");
        }
        if (!operatedclientconnection.isOpen())
        {
            throw new IllegalStateException("Connection must be open");
        }
        Object obj = schemeRegistry.getScheme(httphost.getSchemeName());
        if (!(((Scheme) (obj)).getSchemeSocketFactory() instanceof LayeredSchemeSocketFactory))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Target scheme (").append(((Scheme) (obj)).getName()).append(") must have layered socket factory.").toString());
        }
        LayeredSchemeSocketFactory layeredschemesocketfactory = (LayeredSchemeSocketFactory)((Scheme) (obj)).getSchemeSocketFactory();
        try
        {
            obj = layeredschemesocketfactory.createLayeredSocket(operatedclientconnection.getSocket(), httphost.getHostName(), ((Scheme) (obj)).resolvePort(httphost.getPort()), true);
        }
        // Misplaced declaration of an exception variable
        catch (OperatedClientConnection operatedclientconnection)
        {
            throw new HttpHostConnectException(httphost, operatedclientconnection);
        }
        prepareSocket(((Socket) (obj)), httpcontext, httpparams);
        operatedclientconnection.update(((Socket) (obj)), httphost, layeredschemesocketfactory.isSecure(((Socket) (obj))), httpparams);
    }
}
