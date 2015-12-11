// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;

import com.a.a.a;
import com.a.a.a.j;
import com.a.a.a.u;
import com.a.a.b;
import com.a.a.c;
import com.a.a.v;
import com.a.a.w;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public final class ac
{

    final URI a;
    final ProxySelector b;
    final w c;
    boolean d;
    private final a e;
    private final c f;
    private final j g;
    private Proxy h;
    private InetSocketAddress i;
    private Proxy j;
    private Iterator k;
    private InetAddress l[];
    private int m;
    private int n;
    private int o;
    private final List p = new LinkedList();

    public ac(a a1, URI uri, ProxySelector proxyselector, c c1, j j1, w w1)
    {
        o = -1;
        e = a1;
        a = uri;
        b = proxyselector;
        f = c1;
        g = j1;
        c = w1;
        a1 = a1.a;
        d = true;
        if (a1 != null)
        {
            j = a1;
        } else
        {
            a1 = b.select(uri);
            if (a1 != null)
            {
                k = a1.iterator();
                return;
            }
        }
    }

    private Proxy d()
    {
        if (j != null)
        {
            d = false;
            return j;
        }
        if (k != null)
        {
            while (k.hasNext()) 
            {
                Proxy proxy = (Proxy)k.next();
                if (proxy.type() != java.net.Proxy.Type.DIRECT)
                {
                    return proxy;
                }
            }
        }
        d = false;
        return Proxy.NO_PROXY;
    }

    public final b a(String s)
    {
_L2:
        Object obj = f.a(e);
        if (obj != null)
        {
            if (s.equals("GET") || ((b) (obj)).b())
            {
                return ((b) (obj));
            }
            ((b) (obj)).close();
            continue; /* Loop/switch isn't completed */
        }
        int i1;
        boolean flag;
        if (!b())
        {
            if (!a())
            {
                if (!d)
                {
                    if (!c())
                    {
                        throw new NoSuchElementException();
                    } else
                    {
                        return new b((v)p.remove(0));
                    }
                }
                h = d();
                obj = h;
                l = null;
                if (((Proxy) (obj)).type() == java.net.Proxy.Type.DIRECT)
                {
                    obj = a.getHost();
                    n = u.a(a);
                } else
                {
                    obj = ((Proxy) (obj)).address();
                    if (!(obj instanceof InetSocketAddress))
                    {
                        throw new IllegalArgumentException((new StringBuilder("Proxy.address() is not an InetSocketAddress: ")).append(obj.getClass()).toString());
                    }
                    InetSocketAddress inetsocketaddress = (InetSocketAddress)obj;
                    obj = inetsocketaddress.getHostName();
                    n = inetsocketaddress.getPort();
                }
                l = g.a(((String) (obj)));
                m = 0;
            }
            obj = l;
            i1 = m;
            m = i1 + 1;
            obj = new InetSocketAddress(obj[i1], n);
            if (m == l.length)
            {
                l = null;
                m = 0;
            }
            i = ((InetSocketAddress) (obj));
            if (e.d != null)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            o = i1;
        }
        if (o == 1)
        {
            o = 0;
            i1 = 1;
        } else
        {
label0:
            {
                if (o != 0)
                {
                    break label0;
                }
                o = -1;
                i1 = 0;
            }
        }
        if (i1 == true)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = new v(e, h, i, flag);
        if (c.b(((v) (obj))))
        {
            p.add(obj);
        } else
        {
            return new b(((v) (obj)));
        }
        continue; /* Loop/switch isn't completed */
        throw new AssertionError();
        if (true) goto _L2; else goto _L1
_L1:
    }

    final boolean a()
    {
        return l != null;
    }

    final boolean b()
    {
        return o != -1;
    }

    final boolean c()
    {
        return !p.isEmpty();
    }
}
