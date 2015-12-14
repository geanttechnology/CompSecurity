// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.net.InetAddress;
import org.apache.commons.httpclient.params.HostParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.util.LangUtils;

// Referenced classes of package org.apache.commons.httpclient:
//            HttpHost, ProxyHost, HttpConnection, URIException, 
//            URI

public class HostConfiguration
    implements Cloneable
{

    public static final HostConfiguration ANY_HOST_CONFIGURATION = new HostConfiguration();
    private HttpHost host;
    private InetAddress localAddress;
    private HostParams params;
    private ProxyHost proxyHost;

    public HostConfiguration()
    {
        host = null;
        proxyHost = null;
        localAddress = null;
        params = new HostParams();
    }

    public HostConfiguration(HostConfiguration hostconfiguration)
    {
        host = null;
        proxyHost = null;
        localAddress = null;
        params = new HostParams();
        init(hostconfiguration);
    }

    private void init(HostConfiguration hostconfiguration)
    {
        hostconfiguration;
        JVM INSTR monitorenter ;
        if (hostconfiguration.host == null) goto _L2; else goto _L1
_L1:
        host = (HttpHost)hostconfiguration.host.clone();
_L3:
        if (hostconfiguration.proxyHost == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        proxyHost = (ProxyHost)hostconfiguration.proxyHost.clone();
_L4:
        localAddress = hostconfiguration.getLocalAddress();
        params = (HostParams)hostconfiguration.getParams().clone();
        hostconfiguration;
        JVM INSTR monitorexit ;
        return;
_L2:
        host = null;
          goto _L3
        Object obj;
        obj;
        throw new IllegalArgumentException("Host configuration could not be cloned");
        obj;
        hostconfiguration;
        JVM INSTR monitorexit ;
        throw obj;
        proxyHost = null;
          goto _L4
    }

    public Object clone()
    {
        HostConfiguration hostconfiguration;
        try
        {
            hostconfiguration = (HostConfiguration)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            throw new IllegalArgumentException("Host configuration could not be cloned");
        }
        hostconfiguration.init(this);
        return hostconfiguration;
    }

    public boolean equals(Object obj)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        boolean flag1 = obj instanceof HostConfiguration;
        if (!flag1) goto _L2; else goto _L1
_L1:
        if (obj != this) goto _L4; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L4:
        obj = (HostConfiguration)obj;
        if (!LangUtils.equals(host, ((HostConfiguration) (obj)).host) || !LangUtils.equals(proxyHost, ((HostConfiguration) (obj)).proxyHost))
        {
            break MISSING_BLOCK_LABEL_71;
        }
        flag1 = LangUtils.equals(localAddress, ((HostConfiguration) (obj)).localAddress);
        if (flag1)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = false;
        continue; /* Loop/switch isn't completed */
_L2:
        flag = false;
        if (true) goto _L3; else goto _L5
_L5:
        obj;
        throw obj;
    }

    public String getHost()
    {
        this;
        JVM INSTR monitorenter ;
        if (host == null) goto _L2; else goto _L1
_L1:
        String s = host.getHostName();
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public String getHostURL()
    {
        this;
        JVM INSTR monitorenter ;
        if (host == null)
        {
            throw new IllegalStateException("Host must be set to create a host URL");
        }
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        String s = host.toURI();
        this;
        JVM INSTR monitorexit ;
        return s;
    }

    public InetAddress getLocalAddress()
    {
        this;
        JVM INSTR monitorenter ;
        InetAddress inetaddress = localAddress;
        this;
        JVM INSTR monitorexit ;
        return inetaddress;
        Exception exception;
        exception;
        throw exception;
    }

    public HostParams getParams()
    {
        return params;
    }

    public int getPort()
    {
        this;
        JVM INSTR monitorenter ;
        if (host == null) goto _L2; else goto _L1
_L1:
        int i = host.getPort();
_L4:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        i = -1;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public Protocol getProtocol()
    {
        this;
        JVM INSTR monitorenter ;
        if (host == null) goto _L2; else goto _L1
_L1:
        Protocol protocol = host.getProtocol();
_L4:
        this;
        JVM INSTR monitorexit ;
        return protocol;
_L2:
        protocol = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public String getProxyHost()
    {
        this;
        JVM INSTR monitorenter ;
        if (proxyHost == null) goto _L2; else goto _L1
_L1:
        String s = proxyHost.getHostName();
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public int getProxyPort()
    {
        this;
        JVM INSTR monitorenter ;
        if (proxyHost == null) goto _L2; else goto _L1
_L1:
        int i = proxyHost.getPort();
_L4:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        i = -1;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public String getVirtualHost()
    {
        this;
        JVM INSTR monitorenter ;
        String s = params.getVirtualHost();
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public int hashCode()
    {
        this;
        JVM INSTR monitorenter ;
        int i = LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, host), proxyHost), localAddress);
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean hostEquals(HttpConnection httpconnection)
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        if (httpconnection != null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        throw new IllegalArgumentException("Connection may not be null");
        httpconnection;
        this;
        JVM INSTR monitorexit ;
        throw httpconnection;
        boolean flag = flag1;
        if (host == null) goto _L2; else goto _L1
_L1:
        flag = host.getHostName().equalsIgnoreCase(httpconnection.getHost());
        if (flag) goto _L4; else goto _L3
_L3:
        flag = flag1;
_L2:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L4:
        flag = flag1;
        if (host.getPort() != httpconnection.getPort())
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!host.getProtocol().equals(httpconnection.getProtocol()))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (localAddress == null)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        flag = flag1;
        if (!localAddress.equals(httpconnection.getLocalAddress()))
        {
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_132;
        httpconnection = httpconnection.getLocalAddress();
        if (httpconnection != null)
        {
            flag = flag1;
            continue; /* Loop/switch isn't completed */
        }
        flag = true;
        if (true) goto _L2; else goto _L5
_L5:
    }

    public boolean isHostSet()
    {
        this;
        JVM INSTR monitorenter ;
        HttpHost httphost = host;
        boolean flag;
        if (httphost != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isProxySet()
    {
        this;
        JVM INSTR monitorenter ;
        ProxyHost proxyhost = proxyHost;
        boolean flag;
        if (proxyhost != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean proxyEquals(HttpConnection httpconnection)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        if (httpconnection != null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        throw new IllegalArgumentException("Connection may not be null");
        httpconnection;
        this;
        JVM INSTR monitorexit ;
        throw httpconnection;
        if (proxyHost == null) goto _L2; else goto _L1
_L1:
        if (!proxyHost.getHostName().equalsIgnoreCase(httpconnection.getProxyHost())) goto _L4; else goto _L3
_L3:
        int i;
        int j;
        i = proxyHost.getPort();
        j = httpconnection.getProxyPort();
        if (i != j) goto _L4; else goto _L5
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L4:
        flag = false;
        continue; /* Loop/switch isn't completed */
_L2:
        httpconnection = httpconnection.getProxyHost();
        if (httpconnection != null)
        {
            flag = false;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public void setHost(String s)
    {
        this;
        JVM INSTR monitorenter ;
        Protocol protocol = Protocol.getProtocol("http");
        setHost(s, protocol.getDefaultPort(), protocol);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setHost(String s, int i)
    {
        this;
        JVM INSTR monitorenter ;
        setHost(s, i, Protocol.getProtocol("http"));
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setHost(String s, int i, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        host = new HttpHost(s, i, Protocol.getProtocol(s1));
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setHost(String s, int i, Protocol protocol)
    {
        this;
        JVM INSTR monitorenter ;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new IllegalArgumentException("host must not be null");
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        if (protocol != null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        throw new IllegalArgumentException("protocol must not be null");
        host = new HttpHost(s, i, protocol);
        this;
        JVM INSTR monitorexit ;
    }

    public void setHost(String s, String s1, int i, Protocol protocol)
    {
        this;
        JVM INSTR monitorenter ;
        setHost(s, i, protocol);
        params.setVirtualHost(s1);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setHost(HttpHost httphost)
    {
        this;
        JVM INSTR monitorenter ;
        host = httphost;
        this;
        JVM INSTR monitorexit ;
        return;
        httphost;
        throw httphost;
    }

    public void setHost(URI uri)
    {
        this;
        JVM INSTR monitorenter ;
        setHost(uri.getHost(), uri.getPort(), uri.getScheme());
        this;
        JVM INSTR monitorexit ;
        return;
        uri;
        throw new IllegalArgumentException(uri.toString());
        uri;
        this;
        JVM INSTR monitorexit ;
        throw uri;
    }

    public void setLocalAddress(InetAddress inetaddress)
    {
        this;
        JVM INSTR monitorenter ;
        localAddress = inetaddress;
        this;
        JVM INSTR monitorexit ;
        return;
        inetaddress;
        throw inetaddress;
    }

    public void setParams(HostParams hostparams)
    {
        if (hostparams == null)
        {
            throw new IllegalArgumentException("Parameters may not be null");
        } else
        {
            params = hostparams;
            return;
        }
    }

    public void setProxy(String s, int i)
    {
        this;
        JVM INSTR monitorenter ;
        proxyHost = new ProxyHost(s, i);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setProxyHost(ProxyHost proxyhost)
    {
        this;
        JVM INSTR monitorenter ;
        proxyHost = proxyhost;
        this;
        JVM INSTR monitorexit ;
        return;
        proxyhost;
        throw proxyhost;
    }

    public String toString()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = false;
        Object obj;
        obj = new StringBuffer(50);
        ((StringBuffer) (obj)).append("HostConfiguration[");
        if (host == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        flag = true;
        ((StringBuffer) (obj)).append("host=").append(host);
        boolean flag1 = flag;
        if (proxyHost == null) goto _L2; else goto _L1
_L1:
        if (!flag) goto _L4; else goto _L3
_L3:
        ((StringBuffer) (obj)).append(", ");
_L9:
        ((StringBuffer) (obj)).append("proxyHost=").append(proxyHost);
        flag1 = flag;
_L2:
        if (localAddress == null) goto _L6; else goto _L5
_L5:
        if (!flag1) goto _L8; else goto _L7
_L7:
        ((StringBuffer) (obj)).append(", ");
_L10:
        ((StringBuffer) (obj)).append("localAddress=").append(localAddress);
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        ((StringBuffer) (obj)).append(", ");
        ((StringBuffer) (obj)).append("params=").append(params);
_L6:
        ((StringBuffer) (obj)).append("]");
        obj = ((StringBuffer) (obj)).toString();
        this;
        JVM INSTR monitorexit ;
        return ((String) (obj));
_L4:
        flag = true;
          goto _L9
_L8:
        flag1 = true;
          goto _L10
        Exception exception;
        exception;
        throw exception;
          goto _L9
    }

}
