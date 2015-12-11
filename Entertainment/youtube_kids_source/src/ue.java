// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.List;

public class ue extends tm
{

    public String o[];
    public final byte p[];
    public String q;
    public bhx r;
    public int s;
    public int t;

    public ue(rh rh, rg rg, bje bje, ctw ctw, blx blx, cvi cvi, bmw bmw, 
            ctx ctx1, cwi cwi1)
    {
        super(rh, rg, bje, ctw, blx, cvi, bmw, ctx1, cwi1.h);
        b.a(cwi1);
        o = cwi1.a;
        p = cwi1.b;
        q = cwi1.c;
        s = cwi1.d;
        t = cwi1.e;
        h = cwi1.f;
        k = cwi1.g;
        if (h != null)
        {
            a(cts.d);
        } else
        {
            a(cts.a);
        }
        i();
    }

    public ue(rh rh, rg rg, bje bje, ctw ctw, blx blx, cvi cvi, bmw bmw, 
            ctx ctx1, List list, int i, byte abyte0[], String s1, boolean flag, int j)
    {
        super(rh, rg, bje, ctw, blx, cvi, bmw, ctx1, flag, j);
        b.a(list);
        p = (byte[])b.a(abyte0);
        q = s1;
        o = (String[])list.toArray(new String[list.size()]);
        i = b(i);
        s = i - 1;
        t = i;
        a(cts.a);
        i();
    }

    private void v()
    {
        if (k && g_())
        {
            c(0);
            return;
        } else
        {
            c(s + 1);
            return;
        }
    }

    public void a()
    {
        super.a();
        if (r != null)
        {
            r.a = true;
            r = null;
        }
        if (!g.a(cts.d) || s < 0 || s >= o.length)
        {
            a(cts.a);
            return;
        } else
        {
            a(cts.d);
            return;
        }
    }

    protected final void a(cts cts1)
    {
        super.a(cts1);
        h();
    }

    public final void a(boolean flag)
    {
        k = flag;
        h();
    }

    protected int b(int i)
    {
        b.a(o);
        return Math.max(0, Math.min(o.length - 1, i));
    }

    protected final String b()
    {
        if (g.a(cts.d))
        {
            boolean flag;
            if (s >= 0 && s < o.length)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            b.b(flag);
            return o[s];
        }
        if (t >= 0 && t < o.length)
        {
            return o[t];
        } else
        {
            return null;
        }
    }

    protected int c()
    {
        return -1;
    }

    protected void c(int i)
    {
        t = b(i);
        if (i < o.length && i >= 0)
        {
            r = bhx.a(new uf(this));
            a.a(o[i], p, q, "", -1, -1, r);
            a(cts.b);
        } else
        if (o.length == 0)
        {
            s = t;
            a(cts.f);
            return;
        }
    }

    public boolean c_()
    {
        return false;
    }

    protected byte[] d()
    {
        return p;
    }

    public final boolean d_()
    {
        while (k || !g_()) 
        {
            return true;
        }
        return false;
    }

    protected final String e()
    {
        return q;
    }

    public final boolean e_()
    {
        return s > 0;
    }

    public cwh f()
    {
        return new cwi(o, p, q, s, t, h, k, (cwb)super.f());
    }

    public final uc f_()
    {
        if (d_())
        {
            return uc.b;
        } else
        {
            return uc.a;
        }
    }

    protected boolean g_()
    {
        return s >= o.length - 1;
    }

    public final void l()
    {
        a();
        super.l();
        c(t);
    }

    protected boolean n()
    {
        return false;
    }

    public final void o()
    {
        a();
        super.o();
        v();
    }

    public final void p()
    {
        a();
        super.p();
        c(s - 1);
    }

    public final void q()
    {
        a();
        super.q();
        v();
    }

    public final void r()
    {
        a();
        super.r();
        c(t);
    }

    public String t()
    {
        return "";
    }

    public final int u()
    {
        return s;
    }
}
