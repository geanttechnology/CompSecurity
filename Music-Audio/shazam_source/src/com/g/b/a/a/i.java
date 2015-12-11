// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.a;

import c.m;
import c.r;
import com.g.b.a.d;
import com.g.b.v;
import com.g.b.x;
import com.g.b.y;
import com.g.b.z;
import java.net.Proxy;
import java.net.Socket;

// Referenced classes of package com.g.b.a.a:
//            t, e, g, k, 
//            j, n, m

public final class i
    implements t
{

    private final g a;
    private final e b;

    public i(g g1, e e1)
    {
        a = g1;
        b = e1;
    }

    public final r a(v v1, long l)
    {
        if ("chunked".equalsIgnoreCase(v1.a("Transfer-Encoding")))
        {
            v1 = b;
            if (((e) (v1)).e != 1)
            {
                throw new IllegalStateException((new StringBuilder("state: ")).append(((e) (v1)).e).toString());
            } else
            {
                v1.e = 2;
                return new e.b(v1, (byte)0);
            }
        }
        if (l != -1L)
        {
            v1 = b;
            if (((e) (v1)).e != 1)
            {
                throw new IllegalStateException((new StringBuilder("state: ")).append(((e) (v1)).e).toString());
            } else
            {
                v1.e = 2;
                return new e.d(v1, l, (byte)0);
            }
        } else
        {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
    }

    public final y a(x x1)
    {
        Object obj;
        if (!g.a(x1))
        {
            obj = b.a(0L);
        } else
        if ("chunked".equalsIgnoreCase(x1.a("Transfer-Encoding")))
        {
            obj = b;
            g g1 = a;
            if (((e) (obj)).e != 4)
            {
                throw new IllegalStateException((new StringBuilder("state: ")).append(((e) (obj)).e).toString());
            }
            obj.e = 5;
            obj = new e.c(((e) (obj)), g1);
        } else
        {
            long l = j.a(x1);
            if (l != -1L)
            {
                obj = b.a(l);
            } else
            {
                obj = b;
                if (((e) (obj)).e != 4)
                {
                    throw new IllegalStateException((new StringBuilder("state: ")).append(((e) (obj)).e).toString());
                }
                obj.e = 5;
                obj = new e.f(((e) (obj)), (byte)0);
            }
        }
        return new k(x1.f, m.a(((c.s) (obj))));
    }

    public final void a()
    {
        b.a();
    }

    public final void a(g g1)
    {
        e e1 = b;
        d.b.a(e1.b, g1);
    }

    public final void a(n n1)
    {
        e e1 = b;
        if (e1.e != 1)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(e1.e).toString());
        } else
        {
            e1.e = 3;
            n1.a(e1.d);
            return;
        }
    }

    public final void a(v v1)
    {
        a.b();
        Object obj = a.b.b.b.type();
        com.g.b.u u = a.b.g;
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(v1.b);
        stringbuilder.append(' ');
        boolean flag;
        if (!v1.e() && obj == java.net.Proxy.Type.HTTP)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            stringbuilder.append(v1.a());
        } else
        {
            stringbuilder.append(m.a(v1.a()));
        }
        stringbuilder.append(' ');
        stringbuilder.append(m.a(u));
        obj = stringbuilder.toString();
        b.a(v1.c, ((String) (obj)));
    }

    public final com.g.b.x.a b()
    {
        return b.c();
    }

    public final void c()
    {
        if (d())
        {
            e e1 = b;
            e1.f = 1;
            if (e1.e == 0)
            {
                e1.f = 0;
                d.b.a(e1.a, e1.b);
            }
        } else
        {
            e e2 = b;
            e2.f = 2;
            if (e2.e == 0)
            {
                e2.e = 6;
                e2.b.c.close();
                return;
            }
        }
    }

    public final boolean d()
    {
        if (!"close".equalsIgnoreCase(a.g.a("Connection")) && !"close".equalsIgnoreCase(a.f().a("Connection")))
        {
            boolean flag;
            if (b.e == 6)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                return true;
            }
        }
        return false;
    }
}
