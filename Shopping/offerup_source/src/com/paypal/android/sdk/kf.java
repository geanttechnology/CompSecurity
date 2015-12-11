// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

// Referenced classes of package com.paypal.android.sdk:
//            ha, fl, gn, gi, 
//            gq, hc, gx, hk

public final class kf
{

    private final fl a;
    private final gi b;
    private final hc c;
    private final gn d;
    private final hk e;
    private Proxy f;
    private InetSocketAddress g;
    private List h;
    private int i;
    private List j;
    private int k;
    private final List l = new ArrayList();

    private kf(fl fl1, gi gi1, gn gn1)
    {
        h = Collections.emptyList();
        j = Collections.emptyList();
        a = fl1;
        b = gi1;
        d = gn1;
        e = ha.b.b(gn1);
        c = ha.b.c(gn1);
        fl1 = fl1.a();
        if (fl1 != null)
        {
            h = Collections.singletonList(fl1);
        } else
        {
            h = new ArrayList();
            fl1 = d.e().select(gi1.b());
            if (fl1 != null)
            {
                h.addAll(fl1);
            }
            h.removeAll(Collections.singleton(Proxy.NO_PROXY));
            h.add(Proxy.NO_PROXY);
        }
        i = 0;
    }

    public static kf a(fl fl1, gq gq1, gn gn1)
    {
        return new kf(fl1, gq1.a(), gn1);
    }

    private void a(Proxy proxy)
    {
        j = new ArrayList();
        int i1;
        if (proxy.type() == java.net.Proxy.Type.DIRECT || proxy.type() == java.net.Proxy.Type.SOCKS)
        {
            proxy = a.a;
            i1 = a.b;
        } else
        {
            proxy = proxy.address();
            if (!(proxy instanceof InetSocketAddress))
            {
                throw new IllegalArgumentException((new StringBuilder("Proxy.address() is not an InetSocketAddress: ")).append(proxy.getClass()).toString());
            }
            InetSocketAddress inetsocketaddress = (InetSocketAddress)proxy;
            proxy = inetsocketaddress.getAddress();
            if (proxy == null)
            {
                proxy = inetsocketaddress.getHostName();
            } else
            {
                proxy = proxy.getHostAddress();
            }
            i1 = inetsocketaddress.getPort();
        }
        if (i1 <= 0 || i1 > 65535)
        {
            throw new SocketException((new StringBuilder("No route to ")).append(proxy).append(":").append(i1).append("; port is out of range").toString());
        }
        proxy = c.a(proxy);
        int k1 = proxy.length;
        for (int j1 = 0; j1 < k1; j1++)
        {
            InetAddress inetaddress = proxy[j1];
            j.add(new InetSocketAddress(inetaddress, i1));
        }

        k = 0;
    }

    private boolean c()
    {
        return i < h.size();
    }

    private boolean d()
    {
        return k < j.size();
    }

    private boolean e()
    {
        return !l.isEmpty();
    }

    public final void a(gx gx1, IOException ioexception)
    {
        if (gx1.b.type() != java.net.Proxy.Type.DIRECT && a.b() != null)
        {
            a.b().connectFailed(b.b(), gx1.b.address(), ioexception);
        }
        e.a(gx1);
    }

    public final boolean a()
    {
        return d() || c() || e();
    }

    public final gx b()
    {
_L8:
        if (d()) goto _L2; else goto _L1
_L1:
        if (c()) goto _L4; else goto _L3
_L3:
        Object obj;
        if (!e())
        {
            throw new NoSuchElementException();
        }
        obj = (gx)l.remove(0);
_L6:
        return ((gx) (obj));
_L4:
        if (!c())
        {
            throw new SocketException((new StringBuilder("No route to ")).append(a.a).append("; exhausted proxy configurations: ").append(h).toString());
        }
        obj = h;
        int i1 = i;
        i = i1 + 1;
        obj = (Proxy)((List) (obj)).get(i1);
        a(((Proxy) (obj)));
        f = ((Proxy) (obj));
_L2:
        gx gx1;
        if (!d())
        {
            throw new SocketException((new StringBuilder("No route to ")).append(a.a).append("; exhausted inet socket addresses: ").append(j).toString());
        }
        obj = j;
        int j1 = k;
        k = j1 + 1;
        g = (InetSocketAddress)((List) (obj)).get(j1);
        gx1 = new gx(a, f, g);
        obj = gx1;
        if (!e.c(gx1)) goto _L6; else goto _L5
_L5:
        l.add(gx1);
        if (true) goto _L8; else goto _L7
_L7:
    }
}
