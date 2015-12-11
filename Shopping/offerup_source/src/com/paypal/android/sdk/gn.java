// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.support.design.widget.al;
import java.net.CookieHandler;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package com.paypal.android.sdk:
//            gp, hl, gb, go, 
//            ha, hk, gd, fn, 
//            fq, kk, fu, jh, 
//            fz, hc, fm, gq

public class gn
    implements Cloneable
{

    private static final List a;
    private static final List b;
    private static SSLSocketFactory c;
    private int A;
    private final hk d;
    private gd e;
    private Proxy f;
    private List g;
    private List h;
    private final List i;
    private final List j;
    private ProxySelector k;
    private CookieHandler l;
    private al m;
    private fn n;
    private SocketFactory o;
    private SSLSocketFactory p;
    private HostnameVerifier q;
    private fu r;
    private fm s;
    private fz t;
    private hc u;
    private boolean v;
    private boolean w;
    private boolean x;
    private int y;
    private int z;

    public gn()
    {
        i = new ArrayList();
        j = new ArrayList();
        v = true;
        w = true;
        x = true;
        y = 10000;
        z = 10000;
        A = 10000;
        d = new hk();
        e = new gd();
    }

    private gn(gn gn1)
    {
        i = new ArrayList();
        j = new ArrayList();
        v = true;
        w = true;
        x = true;
        y = 10000;
        z = 10000;
        A = 10000;
        d = gn1.d;
        e = gn1.e;
        f = gn1.f;
        g = gn1.g;
        h = gn1.h;
        i.addAll(gn1.i);
        j.addAll(gn1.j);
        k = gn1.k;
        l = gn1.l;
        n = gn1.n;
        al al;
        if (n != null)
        {
            al = n.a;
        } else
        {
            al = gn1.m;
        }
        m = al;
        o = gn1.o;
        p = gn1.p;
        q = gn1.q;
        r = gn1.r;
        s = gn1.s;
        t = gn1.t;
        u = gn1.u;
        v = gn1.v;
        w = gn1.w;
        x = gn1.x;
        y = gn1.y;
        z = gn1.z;
        A = gn1.A;
    }

    static hc a(gn gn1)
    {
        return gn1.u;
    }

    private SSLSocketFactory x()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = c;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        obj = SSLContext.getInstance("TLS");
        ((SSLContext) (obj)).init(null, null, null);
        c = ((SSLContext) (obj)).getSocketFactory();
        obj = c;
        this;
        JVM INSTR monitorexit ;
        return ((SSLSocketFactory) (obj));
        Object obj1;
        obj1;
        throw new AssertionError();
        obj1;
        this;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public final int a()
    {
        return y;
    }

    public final fq a(gq gq)
    {
        return new fq(this, gq);
    }

    public final gn a(fu fu1)
    {
        r = fu1;
        return this;
    }

    public final gn a(HostnameVerifier hostnameverifier)
    {
        q = hostnameverifier;
        return this;
    }

    public final gn a(SSLSocketFactory sslsocketfactory)
    {
        p = sslsocketfactory;
        return this;
    }

    public final void a(long l1, TimeUnit timeunit)
    {
        if (l1 < 0L)
        {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeunit == null)
        {
            throw new IllegalArgumentException("unit == null");
        }
        long l2 = timeunit.toMillis(l1);
        if (l2 > 0x7fffffffL)
        {
            throw new IllegalArgumentException("Timeout too large.");
        }
        if (l2 == 0L && l1 > 0L)
        {
            throw new IllegalArgumentException("Timeout too small.");
        } else
        {
            y = (int)l2;
            return;
        }
    }

    public final int b()
    {
        return z;
    }

    public final int c()
    {
        return A;
    }

    public Object clone()
    {
        return new gn(this);
    }

    public final Proxy d()
    {
        return f;
    }

    public final ProxySelector e()
    {
        return k;
    }

    public final CookieHandler f()
    {
        return l;
    }

    final al g()
    {
        return m;
    }

    public final SocketFactory h()
    {
        return o;
    }

    public final SSLSocketFactory i()
    {
        return p;
    }

    public final HostnameVerifier j()
    {
        return q;
    }

    public final fu k()
    {
        return r;
    }

    public final fm l()
    {
        return s;
    }

    public final fz m()
    {
        return t;
    }

    public final boolean n()
    {
        return v;
    }

    public final boolean o()
    {
        return w;
    }

    public final boolean p()
    {
        return x;
    }

    final hk q()
    {
        return d;
    }

    public final gd r()
    {
        return e;
    }

    public final List s()
    {
        return g;
    }

    public final List t()
    {
        return h;
    }

    public final List u()
    {
        return i;
    }

    public final List v()
    {
        return j;
    }

    final gn w()
    {
        gn gn1 = new gn(this);
        if (gn1.k == null)
        {
            gn1.k = ProxySelector.getDefault();
        }
        if (gn1.l == null)
        {
            gn1.l = CookieHandler.getDefault();
        }
        if (gn1.o == null)
        {
            gn1.o = SocketFactory.getDefault();
        }
        if (gn1.p == null)
        {
            gn1.p = x();
        }
        if (gn1.q == null)
        {
            gn1.q = kk.a;
        }
        if (gn1.r == null)
        {
            gn1.r = fu.a;
        }
        if (gn1.s == null)
        {
            gn1.s = jh.a;
        }
        if (gn1.t == null)
        {
            gn1.t = fz.a();
        }
        if (gn1.g == null)
        {
            gn1.g = a;
        }
        if (gn1.h == null)
        {
            gn1.h = b;
        }
        if (gn1.u == null)
        {
            gn1.u = hc.a;
        }
        return gn1;
    }

    static 
    {
        a = hl.a(new gp[] {
            gp.d, gp.c, gp.b
        });
        b = hl.a(new gb[] {
            gb.a, gb.b, gb.c
        });
        ha.b = new go();
    }
}
