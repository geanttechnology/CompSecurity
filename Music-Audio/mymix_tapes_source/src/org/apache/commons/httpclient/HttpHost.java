// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.util.LangUtils;

// Referenced classes of package org.apache.commons.httpclient:
//            URIException, URI

public class HttpHost
    implements Cloneable
{

    private String hostname;
    private int port;
    private Protocol protocol;

    public HttpHost(String s)
    {
        this(s, -1, Protocol.getProtocol("http"));
    }

    public HttpHost(String s, int i)
    {
        this(s, i, Protocol.getProtocol("http"));
    }

    public HttpHost(String s, int i, Protocol protocol1)
    {
        hostname = null;
        port = -1;
        protocol = null;
        if (s == null)
        {
            throw new IllegalArgumentException("Host name may not be null");
        }
        if (protocol1 == null)
        {
            throw new IllegalArgumentException("Protocol may not be null");
        }
        hostname = s;
        protocol = protocol1;
        if (i >= 0)
        {
            port = i;
            return;
        } else
        {
            port = protocol.getDefaultPort();
            return;
        }
    }

    public HttpHost(HttpHost httphost)
    {
        hostname = null;
        port = -1;
        protocol = null;
        init(httphost);
    }

    public HttpHost(URI uri)
        throws URIException
    {
        this(uri.getHost(), uri.getPort(), Protocol.getProtocol(uri.getScheme()));
    }

    private void init(HttpHost httphost)
    {
        hostname = httphost.hostname;
        port = httphost.port;
        protocol = httphost.protocol;
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        HttpHost httphost = (HttpHost)super.clone();
        httphost.init(this);
        return httphost;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof HttpHost))
        {
            break MISSING_BLOCK_LABEL_64;
        }
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        obj = (HttpHost)obj;
        if (!hostname.equalsIgnoreCase(((HttpHost) (obj)).hostname))
        {
            return false;
        }
        if (port != ((HttpHost) (obj)).port)
        {
            return false;
        }
        if (protocol.equals(((HttpHost) (obj)).protocol)) goto _L1; else goto _L3
_L3:
        return false;
        return false;
    }

    public String getHostName()
    {
        return hostname;
    }

    public int getPort()
    {
        return port;
    }

    public Protocol getProtocol()
    {
        return protocol;
    }

    public int hashCode()
    {
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, hostname), port), protocol);
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer(50);
        stringbuffer.append(toURI());
        return stringbuffer.toString();
    }

    public String toURI()
    {
        StringBuffer stringbuffer = new StringBuffer(50);
        stringbuffer.append(protocol.getScheme());
        stringbuffer.append("://");
        stringbuffer.append(hostname);
        if (port != protocol.getDefaultPort())
        {
            stringbuffer.append(':');
            stringbuffer.append(port);
        }
        return stringbuffer.toString();
    }
}
