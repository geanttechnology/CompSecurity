// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;

public abstract class to
    implements ub
{

    private ctw a;
    private cvi b;
    public final rg c;
    public final bje d;
    public final blx e;
    public final bmw f;
    public volatile cts g;
    public volatile bxb h;
    public volatile bum i;
    public volatile bvy j;
    public volatile boolean k;
    public volatile boolean l;
    private final boolean m;
    private final int n;

    public to(rh rh, rg rg1, bje bje1, ctw ctw1, blx blx1, cvi cvi1, bmw bmw1, 
            cwb cwb1)
    {
        this(rh, rg1, bje1, ctw1, blx1, cvi1, bmw1, false, 0);
        j = new bvy(bmw1, cwb1.a);
    }

    public to(rh rh, rg rg1, bje bje1, ctw ctw1, blx blx1, cvi cvi1, bmw bmw1, 
            boolean flag, int i1)
    {
        b.a(rh);
        c = (rg)b.a(rg1);
        d = (bje)b.a(bje1);
        e = (blx)b.a(blx1);
        b = (cvi)b.a(cvi1);
        f = (bmw)b.a(bmw1);
        a = (ctw)b.a(ctw1);
        m = flag;
        n = i1;
        d.a(this, ctd, new tr(this));
        d.a(this, ctl, new tq(this));
        a.a();
        rh = String.valueOf(getClass().getSimpleName());
        if (rh.length() != 0)
        {
            rh = "SequencerStage: New ".concat(rh);
        } else
        {
            rh = new String("SequencerStage: New ");
        }
        bmo.e(rh);
    }

    private void v()
    {
        bxb bxb1 = g();
        bum bum1;
        bvy bvy1;
        if (g == cts.e)
        {
            bum1 = (bum)b.a(i);
        } else
        {
            bum1 = null;
        }
        bvy1 = j;
        d.d(new csy(g, bxb1, bum1, bvy1));
    }

    private void w()
    {
        j = new bvy(f);
    }

    abstract void a(int i1);

    protected final void a(bxb bxb1)
    {
        h = bxb1;
        if (!g.a(cts.d))
        {
            a(cts.d);
        }
        b.a(bxb1.f(), new tp(this), a.g());
    }

    protected final void a(cse cse)
    {
        a(cts.c);
        d.c(cse);
    }

    protected final void a(ctk ctk1)
    {
        ctk ctk2;
        ctk ctk3;
        ctk ctk4;
        int i1;
        boolean flag;
        flag = true;
        ctk2 = ctk.b;
        ctk3 = ctk.c;
        ctk4 = ctk.d;
        i1 = 0;
_L3:
        if (i1 >= 3)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        if (ctk1 != (new ctk[] {
            ctk2, ctk3, ctk4
        })[i1]) goto _L2; else goto _L1
_L1:
        i1 = ((flag) ? 1 : 0);
_L4:
        if (i1 != 0)
        {
            d.c(new css());
        }
        d.c(new ctj(ctk1));
        return;
_L2:
        i1++;
          goto _L3
        i1 = 0;
          goto _L4
    }

    protected void a(cts cts1)
    {
        g = cts1;
        cts1 = String.valueOf(cts1.toString());
        if (cts1.length() != 0)
        {
            cts1 = "SequencerStage: ".concat(cts1);
        } else
        {
            cts1 = new String("SequencerStage: ");
        }
        bmo.e(cts1);
        v();
    }

    public final boolean a(String s1)
    {
        return !TextUtils.isEmpty(s1) && TextUtils.equals(s1, t());
    }

    public cwh f()
    {
        return new cwb(j.a);
    }

    bxb g()
    {
        if (g.a(new cts[] {
    cts.d, cts.e
}))
        {
            return (bxb)b.a(h);
        } else
        {
            return null;
        }
    }

    protected final void h()
    {
        d.c(new csx(e_(), d_(), k, l));
    }

    protected final void i()
    {
        d.c(new cti(t()));
    }

    public final void j()
    {
        v();
        h();
    }

    public final void k()
    {
        a();
        d.c(new csw(false));
        a.b();
        d.b(this);
    }

    public void l()
    {
        w();
        a(ctk.a);
        c.b();
        c.a(m);
        c.a(n);
    }

    public final void m()
    {
        a(ctk.a);
        cts cts2 = g;
        cts cts1;
        if (n())
        {
            cts1 = cts.e;
        } else
        {
            cts1 = cts.d;
        }
        if (cts2.a(cts1))
        {
            a(g());
            return;
        } else
        {
            l();
            return;
        }
    }

    protected abstract boolean n();

    public void o()
    {
        w();
        a(ctk.b);
        c.b();
    }

    public void p()
    {
        w();
        a(ctk.c);
        c.b();
    }

    public void q()
    {
        w();
        a(ctk.d);
        c.b();
    }

    public void r()
    {
        a(ctk.e);
    }

    public void s()
    {
    }
}
