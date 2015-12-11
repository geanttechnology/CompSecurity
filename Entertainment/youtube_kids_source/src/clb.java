// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Handler;
import java.util.Iterator;
import java.util.List;

public final class clb
    implements ckk
{

    final ckk a;
    final ckk b;
    final ckl c;
    boolean d;
    private final Handler e = new Handler(new cle(this));
    private final Handler f = new Handler(new clc(this));
    private ckk g;
    private bww h;
    private String i;
    private bwp j;

    public clb(ckk ckk1, ckk ckk2, bmi bmi1)
    {
        a = (ckk)b.a(ckk1);
        b = (ckk)b.a(ckk2);
        ckk1.a(e);
        ckk2.a(f);
        c = new cjd((bmi)b.a(bmi1));
        g = ckk2;
    }

    public final cku a(bww bww1, bwp bwp1, boolean flag)
    {
        ckk ckk1;
        if (flag)
        {
            ckk1 = b;
        } else
        {
            ckk1 = a;
        }
        return ckk1.a(bww1, bwp1, flag);
    }

    public final void a(float f1)
    {
        a.a(f1);
        b.a(f1);
    }

    public final void a(Handler handler)
    {
        c.a(handler);
    }

    public final void a(bww bww1, int i1, String s, bwp bwp1)
    {
        h = (bww)b.a(bww1);
        i = b.a(s);
        j = (bwp)b.a(bwp1);
        if (a())
        {
            a.a(bww1, i1, s, bwp1);
            return;
        }
        if (bww1.g)
        {
            c.a(new cnd("fmt.unplayable", 0));
            return;
        } else
        {
            b.a(bww1, i1, s, bwp1);
            return;
        }
    }

    public final void a(cke cke)
    {
        if (b.l())
        {
            c.a(true);
        }
        a.a(cke);
        if (a()) goto _L2; else goto _L1
_L1:
        if (!b.l() && !b.k() || h == null)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        if (d) goto _L2; else goto _L3
_L3:
        cke = h.a.iterator();
_L7:
        if (!cke.hasNext()) goto _L5; else goto _L4
_L4:
        if (((bwb)cke.next()).d()) goto _L7; else goto _L6
_L6:
        char c1 = '\0';
_L8:
        if (c1 != 0)
        {
            c1 = '\u07D0';
        } else
        {
            c1 = '\u0FA0';
        }
        a.a(h, c1 + b.h(), i, j);
        d = true;
_L2:
        return;
_L5:
        c1 = '\001';
          goto _L8
        g = a;
        if (h != null)
        {
            a.a(h, b.h(), i, j);
            a.e();
            return;
        }
          goto _L2
    }

    public final void a(String s, Uri uri)
    {
        g.a(s, uri);
    }

    boolean a()
    {
        return g == a;
    }

    public final bwb b()
    {
        return g.b();
    }

    public final void b(int i1)
    {
        if (d)
        {
            o();
        }
        g.b(i1);
    }

    public final bwb c()
    {
        return g.c();
    }

    public final void d()
    {
        if (d)
        {
            o();
        }
        g.d();
    }

    public final void e()
    {
        g.e();
    }

    public final void f()
    {
        a.f();
        b.f();
        h = null;
    }

    public final void g()
    {
        a.g();
        b.g();
        h = null;
    }

    public final int h()
    {
        return g.h();
    }

    public final int i()
    {
        return g.i();
    }

    public final int j()
    {
        if (d)
        {
            return a.j();
        } else
        {
            return g.j();
        }
    }

    public final boolean k()
    {
        return g.k();
    }

    public final boolean l()
    {
        return g.l();
    }

    public final void m()
    {
        a.m();
        c.a(false);
    }

    public final void n()
    {
        boolean flag;
        if (h != null && !h.g && (a.l() || a.k()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d = false;
        if (a() && flag)
        {
            b.a(h, a.h() + 200, i, j);
        }
        g = b;
        a.g();
        a.n();
    }

    void o()
    {
        d = false;
        g = a;
        b.e();
        c.a(false);
    }
}
