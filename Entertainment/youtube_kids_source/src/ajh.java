// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

public final class ajh
    implements rg
{

    final Handler a;
    private final Context b;
    private final bmi c;
    private final bje d;
    private final amd e;
    private final ctw f;
    private final chq g;
    private bxb h;
    private ctt i;
    private int j;

    ajh(Context context, bmi bmi1, bje bje1, amd amd1, ctw ctw1, chq chq1)
    {
        b = (Context)b.a(context);
        c = (bmi)b.a(bmi1);
        d = (bje)b.a(bje1);
        e = (amd)b.a(amd1);
        f = (ctw)b.a(ctw1);
        g = (chq)b.a(chq1);
        a = new aji(this, context.getMainLooper(), amd1);
        v();
    }

    private void a(int i1, boolean flag)
    {
        if (j == i1)
        {
            return;
        } else
        {
            j = i1;
            chq chq1 = g;
            (new StringBuilder(45)).append("MdxDirector PlayerState move to : ").append(i1);
            d.d(new ctf(i1, flag));
            return;
        }
    }

    private void a(amb amb1)
    {
        Object obj = g;
        obj = String.valueOf(amb1);
        (new StringBuilder(String.valueOf(obj).length() + 37)).append("MdxDirector: handle MDx player state ").append(((String) (obj)));
        ajj.b[amb1.ordinal()];
        JVM INSTR tableswitch 1 9: default 96
    //                   1 138
    //                   2 138
    //                   3 147
    //                   4 172
    //                   5 181
    //                   6 190
    //                   7 198
    //                   8 212
    //                   9 212;
           goto _L1 _L2 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L8
_L1:
        if (amb1 != amb.c) goto _L10; else goto _L9
_L9:
        r();
        if (!a.hasMessages(1))
        {
            a.sendMessageDelayed(Message.obtain(a, 1), 1000L);
        }
_L12:
        return;
_L2:
        a(5, true);
        continue; /* Loop/switch isn't completed */
_L3:
        if (i.a())
        {
            c(1);
        }
        a(7, false);
        continue; /* Loop/switch isn't completed */
_L4:
        a(3, true);
        continue; /* Loop/switch isn't completed */
_L5:
        a(2, true);
        continue; /* Loop/switch isn't completed */
_L6:
        c(3);
        continue; /* Loop/switch isn't completed */
_L7:
        u();
        a(8, false);
        continue; /* Loop/switch isn't completed */
_L8:
        a(4, false);
        continue; /* Loop/switch isn't completed */
_L10:
        if (!a.hasMessages(1)) goto _L12; else goto _L11
_L11:
        a.removeMessages(1);
        return;
        if (true) goto _L1; else goto _L13
_L13:
    }

    private void a(amn amn1)
    {
        Object obj = g;
        obj = String.valueOf(amn1);
        (new StringBuilder(String.valueOf(obj).length() + 36)).append("MdxDirector: handle MDx video stage ").append(((String) (obj)));
        switch (ajj.a[amn1.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (h != null)
            {
                c(ctt.b);
            } else
            {
                c(ctt.a);
            }
            j = -1;
            return;

        case 2: // '\002'
            c(ctt.f);
            j = -1;
            r();
            return;

        case 3: // '\003'
            c(ctt.i);
            j = -1;
            r();
            return;

        case 4: // '\004'
            c(ctt.j);
            return;
        }
    }

    private void c(int i1)
    {
        d.d(new crz(e.r(), i1));
    }

    private void c(ctt ctt1)
    {
        if (i == ctt1)
        {
            return;
        } else
        {
            i = ctt1;
            Object obj = g;
            obj = String.valueOf(ctt1);
            (new StringBuilder(String.valueOf(obj).length() + 33)).append("MdxDirector VideoStage move to : ").append(((String) (obj)));
            d.d(new ctd(ctt1, h, null, e.r(), false));
            return;
        }
    }

    private void s()
    {
        if (e.i() != amj.b)
        {
            return;
        }
        i = null;
        a(e.k());
        if (e.k().a())
        {
            a(e.m());
            return;
        } else
        {
            a(e.l());
            return;
        }
    }

    private void t()
    {
        if (h == null)
        {
            g.b("MdxDirector: can not fling video, missing playerResponse");
            return;
        } else
        {
            e.a((new alx()).a(bxb.a(h.a)).b(f.h()).a(1).a());
            return;
        }
    }

    private void u()
    {
        d.d(new cse(csf.c, alu.h.k, b.getString(alu.h.j)));
    }

    private void v()
    {
        h = null;
        c(ctt.a);
        a(4, false);
        r();
        a.removeMessages(1);
    }

    public final void a()
    {
        s();
    }

    public final void a(float f1)
    {
        int i1 = 100;
        int j1 = (int)f1 * 100;
        amd amd1 = e;
        if (j1 <= 100)
        {
            i1 = j1;
        }
        amd1.b(i1);
    }

    public final void a(int i1)
    {
    }

    public final void a(bxb bxb1)
    {
        if (e.i() != amj.b)
        {
            return;
        }
        h = bxb1;
        g.a("MdxDirector load videoId: %s, playlistId: %s", new Object[] {
            bxb.a(bxb1.a), f.h()
        });
        c(ctt.b);
        if (!bxb1.f().a())
        {
            u();
            return;
        }
        bxb1 = bxb.a(bxb1.a);
        if (TextUtils.isEmpty(e.o())) goto _L2; else goto _L1
_L1:
        if (!e.o().equals(bxb1)) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L6:
        if (flag)
        {
            g.a("MdxDirector: remote screen already play videoId %s", new Object[] {
                bxb1
            });
            s();
            return;
        } else
        {
            t();
            return;
        }
_L2:
        if (!TextUtils.isEmpty(e.h()) && e.h().equals(bxb1))
        {
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
_L4:
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void a(cke cke)
    {
    }

    public final void a(ri ri)
    {
    }

    public final void a(boolean flag)
    {
    }

    public final boolean a(ctt ctt1)
    {
        return i.a(ctt1);
    }

    public final void b()
    {
    }

    public final void b(int i1)
    {
        e.a(Math.max(i1, 0));
    }

    public final void b(boolean flag)
    {
    }

    public final boolean b(ctt ctt1)
    {
        return i.a(new ctt[] {
            ctt1
        });
    }

    public final ri c(boolean flag)
    {
        return null;
    }

    public final void c()
    {
        if (e.k() != amn.a)
        {
            e.a();
        } else
        if (b(ctt.b))
        {
            t();
            return;
        }
    }

    public final void d()
    {
        if (e.k() != amn.a)
        {
            e.a();
        }
    }

    public final boolean e()
    {
        return e.k().a();
    }

    public final boolean f()
    {
        return e.k() == amn.c;
    }

    public final void g()
    {
        e.b();
    }

    public final void h()
    {
    }

    public final void handleMdxAdPlayerStateChangedEvent(aln aln1)
    {
        if (e.k().a() && a(ctt.b))
        {
            a(aln1.a);
        }
    }

    public final void handleMdxVideoPlayerStateChangedEvent(amm amm1)
    {
        boolean flag;
        if (e.k() == amn.c)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && a(ctt.b))
        {
            a(amm1.a);
        }
    }

    public final void handleMdxVideoStageEvent(amo amo1)
    {
        if (a(ctt.b))
        {
            a(amo1.a);
        }
    }

    public final void handleSubtitleTrackChangedEvent(csz csz1)
    {
        e.a(csz1.a);
    }

    public final void i()
    {
    }

    public final void j()
    {
        v();
    }

    public final void k()
    {
    }

    public final void l()
    {
        e.s();
    }

    public final String m()
    {
        return e.o();
    }

    public final int n()
    {
        return (int)e.p();
    }

    public final int o()
    {
        if (a(ctt.b))
        {
            return h.e() * 1000;
        } else
        {
            return 0;
        }
    }

    public final void p()
    {
    }

    public final void q()
    {
        v();
    }

    void r()
    {
        ajj.a[e.k().ordinal()];
        JVM INSTR tableswitch 1 4: default 48
    //                   1 123
    //                   2 56
    //                   3 129
    //                   4 167;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        throw new IllegalArgumentException();
_L3:
        int i1;
        int j1;
        j1 = (int)e.q();
        if (e.r() != null)
        {
            i1 = e.r().k * 1000;
        } else
        {
            i1 = 0;
        }
_L7:
        d.d(new cte(j1, i1, 0L, c.b(), false));
_L2:
        return;
_L4:
        j1 = (int)e.p();
        if (h != null)
        {
            i1 = h.e() * 1000;
        } else
        {
            i1 = 0;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (h != null)
        {
            i1 = h.e() * 1000;
        } else
        {
            i1 = 0;
        }
        j1 = i1;
        if (true) goto _L7; else goto _L6
_L6:
    }
}
