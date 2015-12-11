// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.text.TextUtils;
import java.util.concurrent.Executor;

public final class ug extends tm
{

    final cuf m;
    final cud n;
    final Handler o;
    final csb p;
    cto q;
    private final Executor r;
    private final rv s;
    private final boolean t;
    private dfh u;
    private cto v;
    private volatile uk w;

    public ug(rh rh, rg rg1, bje bje1, rv rv1, ctw ctw, cuf cuf, blx blx, 
            cvi cvi, bmw bmw, csb csb1, Executor executor, ctx ctx, cud cud1, cwk cwk1)
    {
        super(rh, rg1, bje1, ctw, blx, cvi, bmw, ctx, cwk1.g);
        b.a(cwk1);
        s = (rv)b.a(rv1);
        r = (Executor)b.a(executor);
        p = (csb)b.a(csb1);
        h = cwk1.a;
        i = cwk1.b;
        q = cwk1.c;
        v = cwk1.d;
        l = cwk1.e;
        k = cwk1.f;
        m = cuf;
        n = (cud)b.a(cud1);
        o = new Handler();
        t = true;
        a(cts.a);
        if (h != null)
        {
            a(cts.d);
            if (i != null)
            {
                a(cts.e);
            }
        }
        s();
        i();
    }

    public ug(rh rh, rg rg1, bje bje1, rv rv1, ctw ctw, cuf cuf, blx blx, 
            cvi cvi, bmw bmw, csb csb1, Executor executor, ctx ctx, cud cud1, boolean flag, 
            cto cto1)
    {
        super(rh, rg1, bje1, ctw, blx, cvi, bmw, ctx, cto1.a.m, cto1.a.k);
        s = (rv)b.a(rv1);
        r = (Executor)b.a(executor);
        m = cuf;
        n = (cud)b.a(cud1);
        p = (csb)b.a(csb1);
        o = new Handler();
        t = flag;
        v = (cto)b.a(cto1);
        a(cts.a);
        i();
    }

    private void a(cto cto1, boolean flag, boolean flag1)
    {
        if (j == null || !flag1)
        {
            j = new bvy(f, cto1.e());
        }
        if (flag)
        {
            a();
            a(cts.b);
        }
        v = (cto)b.a(cto1);
        if (TextUtils.isEmpty(v.a.a) && TextUtils.isEmpty(v.a.c))
        {
            cto1 = String.valueOf(v.a.a);
            String s1 = String.valueOf(v.a.c);
            int i = v.a.d;
            bmo.c((new StringBuilder(String.valueOf(cto1).length() + 72 + String.valueOf(s1).length())).append("Malformed WatchEndpoint [videoId=").append(cto1).append(",playlistId=").append(s1).append(",playlistIndex=").append(i).append("]").toString());
            return;
        } else
        {
            w = new uk(this, v, flag);
            r.execute(w);
            return;
        }
    }

    public final void a()
    {
        boolean flag;
        flag = true;
        super.a();
        if (w == null) goto _L2; else goto _L1
_L1:
        uk uk1 = w;
        if (uk1.b)
        {
            uk1.a = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L4; else goto _L3
_L3:
        w = null;
_L2:
        if (h == null) goto _L6; else goto _L5
_L5:
        if (i == null) goto _L8; else goto _L7
_L7:
        g = cts.e;
_L4:
        return;
_L8:
        g = cts.d;
        return;
_L6:
        if (g == cts.b)
        {
            a(cts.a);
            return;
        }
        if (true) goto _L4; else goto _L9
_L9:
    }

    public final void a(cto cto1)
    {
        b.a(cto1);
        boolean flag;
        if (a(cto1.a.c))
        {
            a(ctk.f);
            c.b();
            flag = true;
        } else
        {
            a(cts.a);
            flag = false;
        }
        d.c(new cti(cto1.a.c));
        a(cto1, flag, false);
    }

    public final void a(boolean flag)
    {
        k = flag;
        s();
    }

    protected final String b()
    {
        if (g.a(cts.e))
        {
            b.a(q);
            return q.a.a;
        }
        if (g.a(cts.d))
        {
            b.a(h);
            return bxb.a(h.a);
        } else
        {
            return v.a.a;
        }
    }

    protected final int c()
    {
        if (g.a(cts.e))
        {
            b.a(q);
            return q.a.d;
        } else
        {
            return v.a.d;
        }
    }

    public final boolean c_()
    {
        if (v == null || !g.a(new cts[] {
    cts.d, cts.e
}))
        {
            return false;
        } else
        {
            a(v, false, true);
            return true;
        }
    }

    protected final byte[] d()
    {
        if (g.a(cts.e))
        {
            b.a(q);
            return q.e();
        } else
        {
            return v.e();
        }
    }

    public final boolean d_()
    {
        while (u == null || u.d == null || u.d.e == null && u.d.h == null) 
        {
            return false;
        }
        return true;
    }

    protected final String e()
    {
        if (g.a(cts.e))
        {
            b.a(q);
            return q.a.l;
        } else
        {
            return v.a.l;
        }
    }

    public final boolean e_()
    {
        while (u == null || u.e == null || u.e.e == null && u.e.h == null) 
        {
            return false;
        }
        return true;
    }

    public final cwh f()
    {
        return new cwk(h, i, q, v, l, k, (cwb)super.f());
    }

    public final uc f_()
    {
        if (u != null && u.c != null && u.c.e != null && t)
        {
            return uc.b;
        }
        if (i != null)
        {
            return uc.a;
        } else
        {
            return uc.c;
        }
    }

    public final void l()
    {
        if (v != null)
        {
            super.l();
            a(v, true, false);
        }
    }

    protected final boolean n()
    {
        return true;
    }

    public final void o()
    {
        if ((w == null || !w.a(new ui(this))) && d_())
        {
            super.o();
            a(new cto(u.d), true, false);
        }
    }

    public final void p()
    {
        if ((w == null || !w.a(new uj(this))) && e_())
        {
            super.p();
            a(new cto(u.e), true, false);
        }
    }

    public final void q()
    {
        if ((w == null || !w.a(new uh(this))) && f_() == uc.b)
        {
            super.q();
            a(new cto(u.c), true, false);
        }
    }

    public final void r()
    {
        if (v != null)
        {
            super.r();
            a(v, true, true);
        }
    }

    public final void s()
    {
        boolean flag1;
        flag1 = true;
        if (i == null || i.c == null)
        {
            break MISSING_BLOCK_LABEL_345;
        }
        if (!k) goto _L2; else goto _L1
_L1:
        boolean flag;
        boolean flag2;
        if (i != null && i.c != null && i.c.b())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L2; else goto _L3
_L3:
        flag2 = true;
_L7:
        k = flag2;
        if (!l) goto _L5; else goto _L4
_L4:
        if (i != null && i.c != null && i.c.a())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L5; else goto _L6
_L6:
        flag2 = true;
_L8:
        l = flag2;
        Object obj = i.c;
        flag2 = k;
        boolean flag3 = l;
        boolean flag4 = s.c;
        if (flag2 && ((bso) (obj)).b())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag3 || !((bso) (obj)).a())
        {
            flag1 = false;
        }
        if (!flag && !flag1)
        {
            if (flag4 && ((bso) (obj)).e != null)
            {
                obj = ((bso) (obj)).e;
            } else
            {
                obj = ((bso) (obj)).a;
            }
        } else
        if (!flag)
        {
            if (flag4 && ((bso) (obj)).g != null)
            {
                obj = ((bso) (obj)).g;
            } else
            {
                obj = ((bso) (obj)).c;
            }
        } else
        if (!flag1)
        {
            if (flag4 && ((bso) (obj)).f != null)
            {
                obj = ((bso) (obj)).f;
            } else
            {
                obj = ((bso) (obj)).b;
            }
        } else
        if (flag4 && ((bso) (obj)).h != null)
        {
            obj = ((bso) (obj)).h;
        } else
        {
            obj = ((bso) (obj)).d;
        }
        u = ((dfh) (obj));
_L9:
        h();
        return;
_L2:
        flag2 = false;
          goto _L7
_L5:
        flag2 = false;
          goto _L8
        u = null;
          goto _L9
    }

    public final String t()
    {
        if (g.a(cts.e))
        {
            b.a(q);
            return q.a.c;
        } else
        {
            return v.a.c;
        }
    }

    public final int u()
    {
        if (q != null)
        {
            return q.a.d;
        } else
        {
            return -1;
        }
    }
}
