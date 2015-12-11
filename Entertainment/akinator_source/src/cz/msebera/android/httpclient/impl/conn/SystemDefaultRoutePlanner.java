// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.conn.SchemePortResolver;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn:
//            DefaultRoutePlanner

public class SystemDefaultRoutePlanner extends DefaultRoutePlanner
{

    private final ProxySelector proxySelector;

    public SystemDefaultRoutePlanner(SchemePortResolver schemeportresolver, ProxySelector proxyselector)
    {
        super(schemeportresolver);
        if (proxyselector == null)
        {
            proxyselector = ProxySelector.getDefault();
        }
        proxySelector = proxyselector;
    }

    public SystemDefaultRoutePlanner(ProxySelector proxyselector)
    {
        this(null, proxyselector);
    }

    private Proxy chooseProxy(List list)
    {
        Proxy proxy;
        int i;
        proxy = null;
        i = 0;
_L6:
        if (proxy != null || i >= list.size()) goto _L2; else goto _L1
_L1:
        Proxy proxy1 = (Proxy)list.get(i);
        static class _cls1
        {

            static final int $SwitchMap$java$net$Proxy$Type[];

            static 
            {
                $SwitchMap$java$net$Proxy$Type = new int[java.net.Proxy.Type.values().length];
                try
                {
                    $SwitchMap$java$net$Proxy$Type[java.net.Proxy.Type.DIRECT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$java$net$Proxy$Type[java.net.Proxy.Type.HTTP.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$java$net$Proxy$Type[java.net.Proxy.Type.SOCKS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.java.net.Proxy.Type[proxy1.type().ordinal()];
        JVM INSTR tableswitch 1 2: default 64
    //                   1 73
    //                   2 73;
           goto _L3 _L4 _L4
_L3:
        i++;
        continue; /* Loop/switch isn't completed */
_L4:
        proxy = proxy1;
        if (true) goto _L3; else goto _L2
_L2:
        list = proxy;
        if (proxy == null)
        {
            list = Proxy.NO_PROXY;
        }
        return list;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private String getHost(InetSocketAddress inetsocketaddress)
    {
        if (inetsocketaddress.isUnresolved())
        {
            return inetsocketaddress.getHostName();
        } else
        {
            return inetsocketaddress.getAddress().getHostAddress();
        }
    }

    protected HttpHost determineProxy(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException
    {
        try
        {
            httprequest = new URI(httphost.toURI());
        }
        // Misplaced declaration of an exception variable
        catch (HttpRequest httprequest)
        {
            throw new HttpException((new StringBuilder()).append("Cannot convert host to URI: ").append(httphost).toString(), httprequest);
        }
        httprequest = chooseProxy(proxySelector.select(httprequest));
        httphost = null;
        if (httprequest.type() == java.net.Proxy.Type.HTTP)
        {
            if (!(httprequest.address() instanceof InetSocketAddress))
            {
                throw new HttpException((new StringBuilder()).append("Unable to handle non-Inet proxy address: ").append(httprequest.address()).toString());
            }
            httphost = (InetSocketAddress)httprequest.address();
            httphost = new HttpHost(getHost(httphost), httphost.getPort());
        }
        return httphost;
    }
}
