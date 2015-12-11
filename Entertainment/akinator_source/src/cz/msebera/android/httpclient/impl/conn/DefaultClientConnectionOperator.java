// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.ConnectTimeoutException;
import cz.msebera.android.httpclient.conn.DnsResolver;
import cz.msebera.android.httpclient.conn.HttpInetSocketAddress;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.scheme.Scheme;
import cz.msebera.android.httpclient.conn.scheme.SchemeLayeredSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.conn.scheme.SchemeSocketFactory;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.params.HttpConnectionParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn:
//            SystemDefaultDnsResolver, DefaultClientConnection

public class DefaultClientConnectionOperator
    implements ClientConnectionOperator
{

    protected final DnsResolver dnsResolver;
    public HttpClientAndroidLog log;
    protected final SchemeRegistry schemeRegistry;

    public DefaultClientConnectionOperator(SchemeRegistry schemeregistry)
    {
        log = new HttpClientAndroidLog(getClass());
        Args.notNull(schemeregistry, "Scheme registry");
        schemeRegistry = schemeregistry;
        dnsResolver = new SystemDefaultDnsResolver();
    }

    public DefaultClientConnectionOperator(SchemeRegistry schemeregistry, DnsResolver dnsresolver)
    {
        log = new HttpClientAndroidLog(getClass());
        Args.notNull(schemeregistry, "Scheme registry");
        Args.notNull(dnsresolver, "DNS resolver");
        schemeRegistry = schemeregistry;
        dnsResolver = dnsresolver;
    }

    private SchemeRegistry getSchemeRegistry(HttpContext httpcontext)
    {
        SchemeRegistry schemeregistry = (SchemeRegistry)httpcontext.getAttribute("http.scheme-registry");
        httpcontext = schemeregistry;
        if (schemeregistry == null)
        {
            httpcontext = schemeRegistry;
        }
        return httpcontext;
    }

    public OperatedClientConnection createConnection()
    {
        return new DefaultClientConnection();
    }

    public void openConnection(OperatedClientConnection operatedclientconnection, HttpHost httphost, InetAddress inetaddress, HttpContext httpcontext, HttpParams httpparams)
        throws IOException
    {
        HttpInetSocketAddress httpinetsocketaddress;
        int i;
        boolean flag;
        Args.notNull(operatedclientconnection, "Connection");
        Args.notNull(httphost, "Target host");
        Args.notNull(httpparams, "HTTP parameters");
        Object obj;
        Socket socket;
        Socket socket1;
        SchemeSocketFactory schemesocketfactory;
        InetAddress ainetaddress[];
        int j;
        boolean flag1;
        if (!operatedclientconnection.isOpen())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Asserts.check(flag1, "Connection must not be open");
        obj = getSchemeRegistry(httpcontext).getScheme(httphost.getSchemeName());
        schemesocketfactory = ((Scheme) (obj)).getSchemeSocketFactory();
        ainetaddress = resolveHostname(httphost.getHostName());
        j = ((Scheme) (obj)).resolvePort(httphost.getPort());
        i = 0;
_L2:
        if (i >= ainetaddress.length)
        {
            break MISSING_BLOCK_LABEL_272;
        }
        obj = ainetaddress[i];
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
            break MISSING_BLOCK_LABEL_245;
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
            throw obj1;
        }
        break MISSING_BLOCK_LABEL_305;
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
        return dnsResolver.resolve(s);
    }

    public void updateSecureConnection(OperatedClientConnection operatedclientconnection, HttpHost httphost, HttpContext httpcontext, HttpParams httpparams)
        throws IOException
    {
        Args.notNull(operatedclientconnection, "Connection");
        Args.notNull(httphost, "Target host");
        Args.notNull(httpparams, "Parameters");
        Asserts.check(operatedclientconnection.isOpen(), "Connection must be open");
        Object obj = getSchemeRegistry(httpcontext).getScheme(httphost.getSchemeName());
        Asserts.check(((Scheme) (obj)).getSchemeSocketFactory() instanceof SchemeLayeredSocketFactory, "Socket factory must implement SchemeLayeredSocketFactory");
        SchemeLayeredSocketFactory schemelayeredsocketfactory = (SchemeLayeredSocketFactory)((Scheme) (obj)).getSchemeSocketFactory();
        obj = schemelayeredsocketfactory.createLayeredSocket(operatedclientconnection.getSocket(), httphost.getHostName(), ((Scheme) (obj)).resolvePort(httphost.getPort()), httpparams);
        prepareSocket(((Socket) (obj)), httpcontext, httpparams);
        operatedclientconnection.update(((Socket) (obj)), httphost, schemelayeredsocketfactory.isSecure(((Socket) (obj))), httpparams);
    }
}
