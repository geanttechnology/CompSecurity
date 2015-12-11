// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package com.paypal.android.sdk:
//            hl, fu, fm

public final class fl
{

    final String a;
    final int b;
    final SocketFactory c;
    final SSLSocketFactory d;
    final HostnameVerifier e;
    final fu f;
    final fm g;
    final List h;
    final List i;
    private Proxy j;
    private ProxySelector k;

    public fl(String s, int l, SocketFactory socketfactory, SSLSocketFactory sslsocketfactory, HostnameVerifier hostnameverifier, fu fu, fm fm, 
            Proxy proxy, List list, List list1, ProxySelector proxyselector)
    {
        if (s == null)
        {
            throw new NullPointerException("uriHost == null");
        }
        if (l <= 0)
        {
            throw new IllegalArgumentException((new StringBuilder("uriPort <= 0: ")).append(l).toString());
        }
        if (fm == null)
        {
            throw new IllegalArgumentException("authenticator == null");
        }
        if (list == null)
        {
            throw new IllegalArgumentException("protocols == null");
        }
        if (proxyselector == null)
        {
            throw new IllegalArgumentException("proxySelector == null");
        } else
        {
            j = proxy;
            a = s;
            b = l;
            c = socketfactory;
            d = sslsocketfactory;
            e = hostnameverifier;
            f = fu;
            g = fm;
            h = hl.a(list);
            i = hl.a(list1);
            k = proxyselector;
            return;
        }
    }

    public final Proxy a()
    {
        return j;
    }

    public final ProxySelector b()
    {
        return k;
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof fl)
        {
            obj = (fl)obj;
            flag = flag1;
            if (hl.a(j, ((fl) (obj)).j))
            {
                flag = flag1;
                if (a.equals(((fl) (obj)).a))
                {
                    flag = flag1;
                    if (b == ((fl) (obj)).b)
                    {
                        flag = flag1;
                        if (hl.a(d, ((fl) (obj)).d))
                        {
                            flag = flag1;
                            if (hl.a(e, ((fl) (obj)).e))
                            {
                                flag = flag1;
                                if (hl.a(f, ((fl) (obj)).f))
                                {
                                    flag = flag1;
                                    if (hl.a(g, ((fl) (obj)).g))
                                    {
                                        flag = flag1;
                                        if (hl.a(h, ((fl) (obj)).h))
                                        {
                                            flag = flag1;
                                            if (hl.a(i, ((fl) (obj)).i))
                                            {
                                                flag = flag1;
                                                if (hl.a(k, ((fl) (obj)).k))
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
            }
        }
        return flag;
    }

    public final int hashCode()
    {
        int k1 = 0;
        int l;
        int i1;
        int j1;
        int l1;
        int i2;
        if (j != null)
        {
            l = j.hashCode();
        } else
        {
            l = 0;
        }
        l1 = a.hashCode();
        i2 = b;
        if (d != null)
        {
            i1 = d.hashCode();
        } else
        {
            i1 = 0;
        }
        if (e != null)
        {
            j1 = e.hashCode();
        } else
        {
            j1 = 0;
        }
        if (f != null)
        {
            k1 = f.hashCode();
        }
        return (((((j1 + (i1 + (((l + 527) * 31 + l1) * 31 + i2) * 31) * 31) * 31 + k1) * 31 + g.hashCode()) * 31 + h.hashCode()) * 31 + i.hashCode()) * 31 + k.hashCode();
    }
}
