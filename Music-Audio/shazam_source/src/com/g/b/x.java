// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b;

import com.g.b.a.a.j;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.g.b:
//            o, d, v, p, 
//            u, n, y

public final class x
{
    public static final class a
    {

        public v a;
        public u b;
        public int c;
        public String d;
        public n e;
        o.a f;
        public y g;
        x h;
        x i;
        x j;

        private static void a(String s, x x1)
        {
            if (x1.g != null)
            {
                throw new IllegalArgumentException((new StringBuilder()).append(s).append(".body != null").toString());
            }
            if (x1.h != null)
            {
                throw new IllegalArgumentException((new StringBuilder()).append(s).append(".networkResponse != null").toString());
            }
            if (x1.i != null)
            {
                throw new IllegalArgumentException((new StringBuilder()).append(s).append(".cacheResponse != null").toString());
            }
            if (x1.j != null)
            {
                throw new IllegalArgumentException((new StringBuilder()).append(s).append(".priorResponse != null").toString());
            } else
            {
                return;
            }
        }

        public final a a(o o1)
        {
            f = o1.a();
            return this;
        }

        public final a a(x x1)
        {
            if (x1 != null)
            {
                a("networkResponse", x1);
            }
            h = x1;
            return this;
        }

        public final a a(String s, String s1)
        {
            f.b(s, s1);
            return this;
        }

        public final x a()
        {
            if (a == null)
            {
                throw new IllegalStateException("request == null");
            }
            if (b == null)
            {
                throw new IllegalStateException("protocol == null");
            }
            if (c < 0)
            {
                throw new IllegalStateException((new StringBuilder("code < 0: ")).append(c).toString());
            } else
            {
                return new x(this, (byte)0);
            }
        }

        public final a b(x x1)
        {
            if (x1 != null)
            {
                a("cacheResponse", x1);
            }
            i = x1;
            return this;
        }

        public final a b(String s, String s1)
        {
            f.a(s, s1);
            return this;
        }

        public final a c(x x1)
        {
            if (x1 != null && x1.g != null)
            {
                throw new IllegalArgumentException("priorResponse.body != null");
            } else
            {
                j = x1;
                return this;
            }
        }

        public a()
        {
            c = -1;
            f = new o.a();
        }

        private a(x x1)
        {
            c = -1;
            a = x1.a;
            b = x1.b;
            c = x1.c;
            d = x1.d;
            e = x1.e;
            f = x1.f.a();
            g = x1.g;
            h = x1.h;
            i = x1.i;
            j = x1.j;
        }

        a(x x1, byte byte0)
        {
            this(x1);
        }
    }


    public final v a;
    public final u b;
    public final int c;
    public final String d;
    public final n e;
    public final o f;
    public final y g;
    public x h;
    public x i;
    final x j;
    private volatile d k;

    private x(a a1)
    {
        a = a1.a;
        b = a1.b;
        c = a1.c;
        d = a1.d;
        e = a1.e;
        f = a1.f.a();
        g = a1.g;
        h = a1.h;
        i = a1.i;
        j = a1.j;
    }

    x(a a1, byte byte0)
    {
        this(a1);
    }

    public final int a()
    {
        return c;
    }

    public final String a(String s)
    {
        s = f.a(s);
        if (s != null)
        {
            return s;
        } else
        {
            return null;
        }
    }

    public final String b()
    {
        return d;
    }

    public final y c()
    {
        return g;
    }

    public final a d()
    {
        return new a(this, (byte)0);
    }

    public final x e()
    {
        return i;
    }

    public final List f()
    {
        String s;
        if (c == 401)
        {
            s = "WWW-Authenticate";
        } else
        if (c == 407)
        {
            s = "Proxy-Authenticate";
        } else
        {
            return Collections.emptyList();
        }
        return com.g.b.a.a.j.b(f, s);
    }

    public final d g()
    {
        d d1 = k;
        if (d1 != null)
        {
            return d1;
        } else
        {
            d d2 = com.g.b.d.a(f);
            k = d2;
            return d2;
        }
    }

    public final String toString()
    {
        return (new StringBuilder("Response{protocol=")).append(b).append(", code=").append(c).append(", message=").append(d).append(", url=").append(a.a.toString()).append('}').toString();
    }
}
