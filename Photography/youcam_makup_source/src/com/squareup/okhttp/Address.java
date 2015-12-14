// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.net.Proxy;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package com.squareup.okhttp:
//            Authenticator, CertificatePinner

public final class Address
{

    final Authenticator authenticator;
    final CertificatePinner certificatePinner;
    final List connectionSpecs;
    final HostnameVerifier hostnameVerifier;
    final List protocols;
    final Proxy proxy;
    final SocketFactory socketFactory;
    final SSLSocketFactory sslSocketFactory;
    final String uriHost;
    final int uriPort;

    public Address(String s, int i, SocketFactory socketfactory, SSLSocketFactory sslsocketfactory, HostnameVerifier hostnameverifier, CertificatePinner certificatepinner, Authenticator authenticator1, 
            Proxy proxy1, List list, List list1)
    {
        if (s == null)
        {
            throw new NullPointerException("uriHost == null");
        }
        if (i <= 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("uriPort <= 0: ").append(i).toString());
        }
        if (authenticator1 == null)
        {
            throw new IllegalArgumentException("authenticator == null");
        }
        if (list == null)
        {
            throw new IllegalArgumentException("protocols == null");
        } else
        {
            proxy = proxy1;
            uriHost = s;
            uriPort = i;
            socketFactory = socketfactory;
            sslSocketFactory = sslsocketfactory;
            hostnameVerifier = hostnameverifier;
            certificatePinner = certificatepinner;
            authenticator = authenticator1;
            protocols = Util.immutableList(list);
            connectionSpecs = Util.immutableList(list1);
            return;
        }
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof Address)
        {
            obj = (Address)obj;
            flag = flag1;
            if (Util.equal(proxy, ((Address) (obj)).proxy))
            {
                flag = flag1;
                if (uriHost.equals(((Address) (obj)).uriHost))
                {
                    flag = flag1;
                    if (uriPort == ((Address) (obj)).uriPort)
                    {
                        flag = flag1;
                        if (Util.equal(sslSocketFactory, ((Address) (obj)).sslSocketFactory))
                        {
                            flag = flag1;
                            if (Util.equal(hostnameVerifier, ((Address) (obj)).hostnameVerifier))
                            {
                                flag = flag1;
                                if (Util.equal(certificatePinner, ((Address) (obj)).certificatePinner))
                                {
                                    flag = flag1;
                                    if (Util.equal(authenticator, ((Address) (obj)).authenticator))
                                    {
                                        flag = flag1;
                                        if (Util.equal(protocols, ((Address) (obj)).protocols))
                                        {
                                            flag = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }

    public Authenticator getAuthenticator()
    {
        return authenticator;
    }

    public List getConnectionSpecs()
    {
        return connectionSpecs;
    }

    public HostnameVerifier getHostnameVerifier()
    {
        return hostnameVerifier;
    }

    public List getProtocols()
    {
        return protocols;
    }

    public Proxy getProxy()
    {
        return proxy;
    }

    public SocketFactory getSocketFactory()
    {
        return socketFactory;
    }

    public SSLSocketFactory getSslSocketFactory()
    {
        return sslSocketFactory;
    }

    public String getUriHost()
    {
        return uriHost;
    }

    public int getUriPort()
    {
        return uriPort;
    }

    public int hashCode()
    {
        int l = 0;
        int i1 = uriHost.hashCode();
        int j1 = uriPort;
        int i;
        int j;
        int k;
        int k1;
        if (sslSocketFactory != null)
        {
            i = sslSocketFactory.hashCode();
        } else
        {
            i = 0;
        }
        if (hostnameVerifier != null)
        {
            j = hostnameVerifier.hashCode();
        } else
        {
            j = 0;
        }
        if (certificatePinner != null)
        {
            k = certificatePinner.hashCode();
        } else
        {
            k = 0;
        }
        k1 = authenticator.hashCode();
        if (proxy != null)
        {
            l = proxy.hashCode();
        }
        return (((k + (j + (i + ((i1 + 527) * 31 + j1) * 31) * 31) * 31) * 31 + k1) * 31 + l) * 31 + protocols.hashCode();
    }
}
