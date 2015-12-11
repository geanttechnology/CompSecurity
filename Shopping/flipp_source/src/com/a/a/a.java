// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import com.a.a.a.u;
import java.net.Proxy;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package com.a.a:
//            o

public final class a
{

    public final Proxy a;
    public final String b;
    public final int c;
    public final SSLSocketFactory d;
    public final HostnameVerifier e;
    final o f;
    public final List g;

    public a(String s, int i, SSLSocketFactory sslsocketfactory, HostnameVerifier hostnameverifier, o o, Proxy proxy, List list)
    {
        if (s == null)
        {
            throw new NullPointerException("uriHost == null");
        }
        if (i <= 0)
        {
            throw new IllegalArgumentException((new StringBuilder("uriPort <= 0: ")).append(i).toString());
        }
        if (o == null)
        {
            throw new IllegalArgumentException("authenticator == null");
        }
        if (list == null)
        {
            throw new IllegalArgumentException("transports == null");
        } else
        {
            a = proxy;
            b = s;
            c = i;
            d = sslsocketfactory;
            e = hostnameverifier;
            f = o;
            g = u.a(list);
            return;
        }
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof a)
        {
            obj = (a)obj;
            flag = flag1;
            if (u.a(a, ((a) (obj)).a))
            {
                flag = flag1;
                if (b.equals(((a) (obj)).b))
                {
                    flag = flag1;
                    if (c == ((a) (obj)).c)
                    {
                        flag = flag1;
                        if (u.a(d, ((a) (obj)).d))
                        {
                            flag = flag1;
                            if (u.a(e, ((a) (obj)).e))
                            {
                                flag = flag1;
                                if (u.a(f, ((a) (obj)).f))
                                {
                                    flag = flag1;
                                    if (u.a(g, ((a) (obj)).g))
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
        return flag;
    }

    public final int hashCode()
    {
        int l = 0;
        int i1 = b.hashCode();
        int j1 = c;
        int i;
        int j;
        int k;
        if (d != null)
        {
            i = d.hashCode();
        } else
        {
            i = 0;
        }
        if (e != null)
        {
            j = e.hashCode();
        } else
        {
            j = 0;
        }
        if (f != null)
        {
            k = f.hashCode();
        } else
        {
            k = 0;
        }
        if (a != null)
        {
            l = a.hashCode();
        }
        return ((k + (j + (i + ((i1 + 527) * 31 + j1) * 31) * 31) * 31) * 31 + l) * 31 + g.hashCode();
    }
}
