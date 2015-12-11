// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.text.TextUtils;

public final class aku
{

    final bje a;
    final Handler b = new akv(this);
    final bmi c;
    amj d;
    alu e;
    amn f;
    amb g;
    amb h;
    alw i;
    buz j;
    String k;
    String l;
    boolean m;
    long n;
    long o;
    long p;
    long q;
    int r;
    private final chq s;

    public aku(bje bje1, bmi bmi1, chq chq1)
    {
        d = amj.e;
        i = alw.f;
        k = "";
        l = "";
        r = 30;
        a = bje1;
        c = bmi1;
        s = chq1;
        a(amn.a);
        a(amb.a);
        b(amb.a);
    }

    final void a()
    {
        m = false;
        b.removeMessages(1);
    }

    final void a(long l1)
    {
label0:
        {
            while (m) 
            {
                if (Math.abs(l1 - n) > 2000L)
                {
                    break label0;
                }
                a();
            }
            n = l1;
            o = c.b();
        }
    }

    final void a(alu alu)
    {
        b.a(alu);
        if (d == amj.e)
        {
            s.b("Remote control trying to move to ERROR state while OFFLINE");
            return;
        } else
        {
            e = alu;
            d = amj.f;
            chq chq1 = s;
            alu = String.valueOf(alu);
            chq1.a((new StringBuilder(String.valueOf(alu).length() + 42)).append("MDX state moved to error state with error ").append(alu).toString());
            a.c(new amk(d));
            return;
        }
    }

    final void a(alw alw1)
    {
        if (!i.equals(alw1))
        {
            i = alw1;
            a.d(new alv(i));
        }
    }

    final void a(amb amb1)
    {
        if (g == amb1)
        {
            return;
        }
        g = amb1;
        amb1 = s;
        String s1 = String.valueOf(g);
        amb1.a((new StringBuilder(String.valueOf(s1).length() + 32)).append("MDX video player state moved to ").append(s1).toString());
        akw.a[g.ordinal()];
        JVM INSTR tableswitch 1 2: default 96
    //                   1 115
    //                   2 115;
           goto _L1 _L2 _L2
_L1:
        a.d(new amm(g));
        return;
_L2:
        b();
        if (true) goto _L1; else goto _L3
_L3:
    }

    final void a(ame ame)
    {
        a.d(new amh(ame));
    }

    final void a(amj amj1)
    {
        boolean flag;
        if (amj1 != amj.f)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.a(flag);
        if (d == amj1)
        {
            return;
        } else
        {
            d = amj1;
            amj1 = s;
            String s1 = String.valueOf(d);
            amj1.a((new StringBuilder(String.valueOf(s1).length() + 19)).append("MDX state moved to ").append(s1).toString());
            a.c(new amk(d));
            return;
        }
    }

    final void a(amn amn1)
    {
        if (f == amn1)
        {
            return;
        } else
        {
            f = amn1;
            amn1 = s;
            String s1 = String.valueOf(f);
            amn1.a((new StringBuilder(String.valueOf(s1).length() + 25)).append("MDX video stage moved to ").append(s1).toString());
            a.d(new amo(f));
            return;
        }
    }

    final void a(String s1)
    {
        k = s1;
        if ("".equals(s1))
        {
            s1 = alw.f;
        } else
        if (i.a() && i.b(s1))
        {
            s1 = i;
        } else
        if (!"".equals(l))
        {
            s1 = (new alx()).a(l).b(s1).a(1).a();
        } else
        {
            s.b("Screen states: first video Id is not set");
            return;
        }
        a.d(new amc(s1));
    }

    final void b()
    {
        a();
        a(0L);
    }

    final void b(long l1)
    {
        p = l1;
        q = c.b();
    }

    final void b(amb amb1)
    {
        if (h == amb1)
        {
            return;
        }
        h = amb1;
        amb1 = s;
        String s1 = String.valueOf(h);
        amb1.a((new StringBuilder(String.valueOf(s1).length() + 29)).append("MDX ad player state moved to ").append(s1).toString());
        if (!h.l)
        {
            b(0L);
        }
        a.d(new aln(h));
    }

    final void b(String s1)
    {
        String s2 = s1;
        if (TextUtils.isEmpty(s1))
        {
            s2 = "";
        }
        l = s2;
    }

    final void c()
    {
        b(amb.a);
        b(0L);
    }
}
