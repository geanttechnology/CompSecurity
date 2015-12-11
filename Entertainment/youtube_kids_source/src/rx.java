// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.text.TextUtils;

public final class rx
{

    final Context a;
    final ckk b;
    final rv c;
    public final rs d;
    public final cxf e;
    public rg f;
    ub g;
    boolean h;
    private final bje i;
    private final sa j;
    private final AudioManager k;
    private final android.media.AudioManager.OnAudioFocusChangeListener l;
    private final Handler m;
    private final ctw n;
    private final sf o;
    private final rw p;
    private final ud q;
    private final cxc r;
    private cke s;
    private cto t;
    private boolean u;
    private boolean v;
    private final rb w;
    private final Runnable x;

    protected rx()
    {
        x = new ry(this);
        a = null;
        i = null;
        b = null;
        k = null;
        l = null;
        v = true;
        c = null;
        n = null;
        m = null;
        f = null;
        j = null;
        d = null;
        e = null;
        o = null;
        p = null;
        w = null;
        q = null;
        r = null;
    }

    public rx(Context context, bje bje1, ckk ckk1, cxf cxf1, rv rv1, ctw ctw1, rw rw1, 
            rs rs1, sf sf1, ud ud1, cxc cxc1)
    {
        x = new ry(this);
        a = (Context)b.a(context);
        i = (bje)b.a(bje1);
        b = (ckk)b.a(ckk1);
        k = (AudioManager)a.getSystemService("audio");
        l = new rz(this);
        v = true;
        c = (rv)b.a(rv1);
        n = (ctw)b.a(ctw1);
        q = (ud)b.a(ud1);
        r = (cxc)b.a(cxc1);
        p = (rw)b.a(rw1);
        d = (rs)b.a(rs1);
        f = rw1.a();
        bje1.a(rs1);
        e = cxf1;
        bje1.a(cxf1);
        o = sf1;
        if (sf1 != null)
        {
            bje1.a(sf1);
        }
        j = new sa(this);
        m = new Handler(context.getMainLooper());
        w = new rb(context, bje1);
        context = w;
        context.b = (rx)b.a(this);
        if (!((rb) (context)).c)
        {
            ((rb) (context)).a.registerReceiver(context, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            context.c = true;
        }
    }

    private void handleVideoStageEvent(ctf ctf1)
    {
        if (ctf1.a == 2 && !h)
        {
            s();
        }
    }

    private void s()
    {
        if (v)
        {
            k.requestAudioFocus(l, 0x80000000, 1);
        }
    }

    public final void a()
    {
        b.m();
        f.j();
        a(false);
        f = p.a();
        t = null;
        if (g != null)
        {
            g.k();
            g = null;
        }
        if (o != null)
        {
            sf sf1 = o;
            sf1.b = (rx)b.a(this);
            sf1.c = 0;
        }
    }

    public final void a(float f1)
    {
        f.a(f1);
    }

    public final void a(int i1)
    {
        f.b(i1);
    }

    public final void a(cke cke1)
    {
        s = cke1;
        rv rv1 = c;
        if (rv1.c)
        {
            rv1.c = false;
            rv1.a();
        }
        f.a(cke1);
        if (g != null)
        {
            g.s();
        }
        if (q() || u)
        {
            Intent intent = new Intent(a, rc);
            intent.putExtra("background_mode", q());
            a.startService(intent);
            u = true;
        }
        cke1.a(true);
    }

    public final void a(cto cto1)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        b.a(cto1);
        i.d(new csn());
        s();
        flag = flag1;
        if (!(g instanceof ug)) goto _L2; else goto _L1
_L1:
        if (cto1 != null) goto _L4; else goto _L3
_L3:
        flag = flag1;
_L2:
        if (!flag) goto _L6; else goto _L5
_L5:
        t = cto1;
        ((ug)g).a(cto1);
        n.a(cto1.g());
_L8:
        return;
_L4:
        if (cto1.a.h && f.a(ctt.b) && !f.b(ctt.j) && TextUtils.equals(cto1.a.a, f.m()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            flag = flag1;
            if (!g.a(cto1.a.c))
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        flag = true;
        continue; /* Loop/switch isn't completed */
_L6:
        a();
        t = cto1;
        g = q.a(cto1);
        n.a(cto1.g());
        if (cto1.a.o)
        {
            i.c(cth.a);
        }
        if (g == null) goto _L8; else goto _L7
_L7:
        g.l();
        j.a();
        return;
        if (true) goto _L2; else goto _L9
_L9:
    }

    public final void a(cxu cxu)
    {
        e.a(cxu);
    }

    public final void a(uy uy1)
    {
        i.d(new csn());
        a();
        boolean flag = uy1.e;
        v = flag;
        w.d = flag;
        s();
        t = uy1.a;
        rv rv1 = c;
        uw uw1 = uy1.b;
        rv1.a = uw1.a;
        rv1.b = uw1.b;
        rv1.c = uw1.c;
        rv1.d = uw1.d;
        rv1.e = uw1.e;
        g = q.a(uy1.d);
        if (g != null)
        {
            uy1 = uy1.c;
            if (uy1 == null)
            {
                g.l();
            } else
            {
                f.a(uy1);
                g.m();
            }
            j.a();
        }
        if (g != null && t != null)
        {
            n.a(t.g());
        }
        p();
    }

    void a(boolean flag)
    {
        sa sa1;
        if (flag)
        {
            f.h();
        } else
        {
            f.i();
        }
        sa1 = j;
        if (sa1.a)
        {
            sa1.b.a.unregisterReceiver(sa1);
            sa1.a = false;
        }
    }

    public final void b()
    {
        i.d(new csl());
        a();
    }

    public final void b(boolean flag)
    {
        g.a(flag);
    }

    public final boolean b(cto cto1)
    {
        while (cto1 == null || t == null || !TextUtils.isEmpty(cto1.a.a) && !cto1.a.a.equals(d()) || !TextUtils.isEmpty(cto1.a.c) && !cto1.a.c.equals(c()) || g != null && g.u() != cto1.a.d || cto1.d() != null || t.a.i != cto1.a.i || t.g() != cto1.g() || t.a.g != t.a.g || t.a.h != cto1.a.h) 
        {
            return false;
        }
        return true;
    }

    public final String c()
    {
        if (g != null)
        {
            return g.t();
        } else
        {
            return null;
        }
    }

    public final void c(boolean flag)
    {
        if (s != null)
        {
            s.a(false);
            s = null;
        }
        if (q())
        {
            return;
        }
        Intent intent = new Intent(a, rc);
        a.stopService(intent);
        u = false;
        r.a();
        if (flag)
        {
            b();
            return;
        } else
        {
            a(true);
            f.p();
            return;
        }
    }

    public final String d()
    {
        if (t != null)
        {
            return f.m();
        } else
        {
            return null;
        }
    }

    public final void d(boolean flag)
    {
        rv rv1 = c;
        if (flag != rv1.b)
        {
            rv1.b = flag;
            rv1.a();
        }
    }

    public final int e()
    {
        if (g != null)
        {
            return g.u();
        } else
        {
            return -1;
        }
    }

    public final uy e(boolean flag)
    {
        if (g != null)
        {
            return new uy(t, c.c(), g.f(), f.c(false), v);
        } else
        {
            return new uy(null, c.c(), null, null, v);
        }
    }

    public final int f()
    {
        return f.n();
    }

    public final void g()
    {
        f.c();
    }

    public final void h()
    {
        f.d();
    }

    public final void i()
    {
        f.g();
    }

    public final boolean j()
    {
        if (g != null)
        {
            f.q();
            g.r();
            return true;
        } else
        {
            return false;
        }
    }

    public final boolean k()
    {
        if (g == null)
        {
            return false;
        } else
        {
            return g.c_();
        }
    }

    public final boolean l()
    {
        return g != null && g.e_();
    }

    public final boolean m()
    {
        return g != null && g.d_();
    }

    public final void n()
    {
        if (g != null)
        {
            g.p();
        }
    }

    public final void o()
    {
        if (g != null)
        {
            g.o();
        }
    }

    public final void p()
    {
        m.post(x);
    }

    public final boolean q()
    {
        return c.c;
    }

    public final cxu r()
    {
        return e.d;
    }
}
