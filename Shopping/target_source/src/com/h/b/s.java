// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.h.b;

import com.h.b.a.a.a;
import com.h.b.a.c;
import com.h.b.a.d;
import com.h.b.a.d.b;
import com.h.b.a.f;
import com.h.b.a.i;
import com.h.b.a.j;
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

// Referenced classes of package com.h.b:
//            t, l, n, c, 
//            e, g, k, b, 
//            u

public class s
    implements Cloneable
{

    private static final List a;
    private static final List b;
    private static SSLSocketFactory c;
    private int A;
    private final i d;
    private n e;
    private Proxy f;
    private List g;
    private List h;
    private final List i;
    private final List j;
    private ProxySelector k;
    private CookieHandler l;
    private d m;
    private com.h.b.c n;
    private SocketFactory o;
    private SSLSocketFactory p;
    private HostnameVerifier q;
    private g r;
    private com.h.b.b s;
    private k t;
    private f u;
    private boolean v;
    private boolean w;
    private boolean x;
    private int y;
    private int z;

    public s()
    {
        i = new ArrayList();
        j = new ArrayList();
        v = true;
        w = true;
        x = true;
        d = new i();
        e = new n();
    }

    private s(s s1)
    {
        i = new ArrayList();
        j = new ArrayList();
        v = true;
        w = true;
        x = true;
        d = s1.d;
        e = s1.e;
        f = s1.f;
        g = s1.g;
        h = s1.h;
        i.addAll(s1.i);
        j.addAll(s1.j);
        k = s1.k;
        l = s1.l;
        n = s1.n;
        d d1;
        if (n != null)
        {
            d1 = n.a;
        } else
        {
            d1 = s1.m;
        }
        m = d1;
        o = s1.o;
        p = s1.p;
        q = s1.q;
        r = s1.r;
        s = s1.s;
        t = s1.t;
        u = s1.u;
        v = s1.v;
        w = s1.w;
        x = s1.x;
        y = s1.y;
        z = s1.z;
        A = s1.A;
    }

    static f a(s s1)
    {
        return s1.u;
    }

    private SSLSocketFactory y()
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

    public e a(u u1)
    {
        return new e(this, u1);
    }

    public final s a(com.h.b.c c1)
    {
        n = c1;
        m = null;
        return this;
    }

    public final s a(List list)
    {
        list = com.h.b.a.j.a(list);
        if (!list.contains(com.h.b.t.b))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("protocols doesn't contain http/1.1: ").append(list).toString());
        }
        if (list.contains(com.h.b.t.a))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("protocols must not contain http/1.0: ").append(list).toString());
        }
        if (list.contains(null))
        {
            throw new IllegalArgumentException("protocols must not contain null");
        } else
        {
            g = com.h.b.a.j.a(list);
            return this;
        }
    }

    public final s a(HostnameVerifier hostnameverifier)
    {
        q = hostnameverifier;
        return this;
    }

    public final s a(SSLSocketFactory sslsocketfactory)
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

    public final void a(boolean flag)
    {
        w = flag;
    }

    public final int b()
    {
        return z;
    }

    public final void b(long l1, TimeUnit timeunit)
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
            z = (int)l2;
            return;
        }
    }

    public final int c()
    {
        return A;
    }

    public final void c(long l1, TimeUnit timeunit)
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
            A = (int)l2;
            return;
        }
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return x();
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

    final d g()
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

    public final g k()
    {
        return r;
    }

    public final com.h.b.b l()
    {
        return s;
    }

    public final k m()
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

    final i q()
    {
        return d;
    }

    public final n r()
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

    public List u()
    {
        return i;
    }

    public List v()
    {
        return j;
    }

    final s w()
    {
        s s1 = new s(this);
        if (s1.k == null)
        {
            s1.k = ProxySelector.getDefault();
        }
        if (s1.l == null)
        {
            s1.l = CookieHandler.getDefault();
        }
        if (s1.o == null)
        {
            s1.o = SocketFactory.getDefault();
        }
        if (s1.p == null)
        {
            s1.p = y();
        }
        if (s1.q == null)
        {
            s1.q = b.a;
        }
        if (s1.r == null)
        {
            s1.r = com.h.b.g.a;
        }
        if (s1.s == null)
        {
            s1.s = a.a;
        }
        if (s1.t == null)
        {
            s1.t = com.h.b.k.a();
        }
        if (s1.g == null)
        {
            s1.g = a;
        }
        if (s1.h == null)
        {
            s1.h = b;
        }
        if (s1.u == null)
        {
            s1.u = f.a;
        }
        return s1;
    }

    public final s x()
    {
        s s1;
        try
        {
            s1 = (s)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            throw new AssertionError();
        }
        return s1;
    }

    static 
    {
        a = com.h.b.a.j.a(new t[] {
            com.h.b.t.d, com.h.b.t.c, com.h.b.t.b
        });
        b = com.h.b.a.j.a(new l[] {
            com.h.b.l.a, com.h.b.l.b, com.h.b.l.c
        });
        c.b = new _cls1();
    }

    /* member class not found */
    class _cls1 {}

}
