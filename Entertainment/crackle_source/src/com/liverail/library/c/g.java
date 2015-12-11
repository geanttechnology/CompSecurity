// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.c;

import com.liverail.library.a.d;
import com.liverail.library.b.a;
import com.liverail.library.g.f;
import java.util.Date;

// Referenced classes of package com.liverail.library.c:
//            f, l, i, j, 
//            h

public class g extends com.liverail.library.c.f
{

    private d d;
    private int e;
    private String f;
    private com.a.a.a.a g;
    private j h;
    private String i;
    private com.liverail.library.g.g j;
    private g k;
    private long l;
    private long m;
    private long n;
    private boolean o;

    public g(int i1, f f1, d d1, int j1)
    {
        super(i1, f1);
        d = d1;
        e = j1;
        l = (new Date()).getTime();
    }

    static long a(g g1)
    {
        return g1.l;
    }

    private void a(int i1, String s)
    {
        g = null;
        i = s;
        if (i == null || i.length() == 0)
        {
            b("1");
            return;
        }
        j = com.liverail.library.c.l.a().a(i);
        if (j == null)
        {
            i();
            return;
        }
        if (j.a && j.c != null && j.c.length() > 0)
        {
            if (e > 0)
            {
                com.liverail.library.b.a.a((new StringBuilder("(")).append(a).append(") * found VAST Wrapper to ").append(j.c).toString());
                k = new g(a, b, d, e - 1);
                k.a(((j) (new i(this))));
                k.a(j.c);
                return;
            } else
            {
                com.liverail.library.b.a.d((new StringBuilder("(")).append(a).append(") * found VAST Wrapper but wrapper limit reached").toString());
                b("1");
                return;
            }
        } else
        {
            i();
            return;
        }
    }

    static void a(g g1, int i1, String s)
    {
        g1.a(i1, s);
    }

    static void a(g g1, long l1)
    {
        g1.n = l1;
    }

    static void a(g g1, String s)
    {
        g1.b(s);
    }

    static void a(g g1, Throwable throwable, String s)
    {
        g1.a(throwable, s);
    }

    private void a(Throwable throwable, String s)
    {
        b("300");
    }

    static long b(g g1)
    {
        return g1.n;
    }

    private void b(String s)
    {
        c = (int)((new Date()).getTime() - m);
        o = false;
        b.b(s);
        g = null;
        if (h != null)
        {
            h.a(s);
        }
    }

    static String c(g g1)
    {
        return g1.f;
    }

    static void d(g g1)
    {
        g1.i();
    }

    private void i()
    {
        c = (int)((new Date()).getTime() - m);
        o = true;
        g = null;
        if (h != null)
        {
            h.a();
        }
    }

    public void a(j j1)
    {
        h = j1;
    }

    public void a(String s)
    {
        f = s;
        g = new com.a.a.a.a();
        m = (new Date()).getTime();
        s = g;
        d.getClass();
        s.a("Mozilla/5.0 (Linux; Android; Device) LiveRailSDK/2.1.0");
        g.a(d.g);
        g.a(d.b());
        try
        {
            g.a(d.c, f, new h(this));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.liverail.library.b.a.d((new StringBuilder("(")).append(a).append(") ~ HTTP failed ").append(s.getMessage()).toString());
        }
        b("300");
    }

    public void d()
    {
        h = null;
        if (k != null)
        {
            k.a(((j) (null)));
            k.d();
        }
        if (g != null)
        {
            g.a(d.c, true);
        }
    }

    public String e()
    {
        return i;
    }

    public boolean f()
    {
        return o;
    }

    public g g()
    {
        return k;
    }

    public boolean h()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (j != null)
        {
            flag = flag1;
            if (j.a)
            {
                flag = flag1;
                if (j.d)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }
}
