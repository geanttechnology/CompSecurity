// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.fl;
import com.google.android.gms.internal.fn;

// Referenced classes of package com.google.android.gms.tagmanager:
//            ca, ce, cq, cp, 
//            bf, Container, TagManager, n, 
//            bh, cg, r, ContainerHolder, 
//            bg

class o extends ca
{
    static interface a
    {

        public abstract boolean b(Container container);
    }

    private class b
        implements bg
    {

        final o Ul;

        public void a(com.google.android.gms.internal.jd.a a1)
        {
            com.google.android.gms.internal.c.j j;
            if (a1.Yc != null)
            {
                j = a1.Yc;
            } else
            {
                com.google.android.gms.internal.c.f f1 = a1.fV;
                j = new com.google.android.gms.internal.c.j();
                j.fV = f1;
                j.fU = null;
                j.fW = f1.fr;
            }
            o.a(Ul, j, a1.Yb, true);
        }

        public void a(bg.a a1)
        {
            if (!o.b(Ul))
            {
                o.a(Ul, 0L);
            }
        }

        public void i(Object obj)
        {
            a((com.google.android.gms.internal.jd.a)obj);
        }

        public void iM()
        {
        }

        private b()
        {
            Ul = o.this;
            super();
        }

    }

    private class c
        implements bg
    {

        final o Ul;

        public void a(bg.a a1)
        {
            if (o.f(Ul) != null)
            {
                Ul.a(o.f(Ul));
            } else
            {
                Ul.a(Ul.O(Status.zS));
            }
            o.a(Ul, 0x36ee80L);
        }

        public void b(com.google.android.gms.internal.c.j j)
        {
label0:
            {
                synchronized (Ul)
                {
                    if (j.fV != null)
                    {
                        break MISSING_BLOCK_LABEL_59;
                    }
                    if (o.c(Ul).fV != null)
                    {
                        break label0;
                    }
                    bh.t("Current resource is null; network resource is also null");
                    o.a(Ul, 0x36ee80L);
                }
                return;
            }
            j.fV = o.c(Ul).fV;
            o.a(Ul, j, o.a(Ul).currentTimeMillis(), false);
            bh.v((new StringBuilder()).append("setting refresh time to current time: ").append(o.d(Ul)).toString());
            if (!o.e(Ul))
            {
                o.a(Ul, j);
            }
            o1;
            JVM INSTR monitorexit ;
            return;
            j;
            o1;
            JVM INSTR monitorexit ;
            throw j;
        }

        public void i(Object obj)
        {
            b((com.google.android.gms.internal.c.j)obj);
        }

        public void iM()
        {
        }

        private c()
        {
            Ul = o.this;
            super();
        }

    }

    private class d
        implements n.a
    {

        final o Ul;

        public void bc(String s1)
        {
            Ul.bc(s1);
        }

        public String iF()
        {
            return Ul.iF();
        }

        public void iH()
        {
            if (o.g(Ul).cl())
            {
                o.a(Ul, 0L);
            }
        }

        private d()
        {
            Ul = o.this;
            super();
        }

    }

    static interface e
        extends Releasable
    {

        public abstract void a(bg bg);

        public abstract void bf(String s1);

        public abstract void d(long l, String s1);
    }

    static interface f
        extends Releasable
    {

        public abstract void a(bg bg);

        public abstract void b(com.google.android.gms.internal.jd.a a1);

        public abstract cr.c bP(int i);

        public abstract void iN();
    }


    private final String TM;
    private long TR;
    private final TagManager TY;
    private final fl Ty;
    private final d Ub;
    private final cg Uc;
    private final int Ud;
    private f Ue;
    private volatile n Uf;
    private volatile boolean Ug;
    private com.google.android.gms.internal.c.j Uh;
    private String Ui;
    private e Uj;
    private a Uk;
    private final Context mContext;
    private final Looper zs;

    o(Context context, TagManager tagmanager, Looper looper, String s1, int i, f f1, e e1, 
            fl fl1, cg cg)
    {
        Looper looper1;
        if (looper == null)
        {
            looper1 = Looper.getMainLooper();
        } else
        {
            looper1 = looper;
        }
        super(looper1);
        mContext = context;
        TY = tagmanager;
        context = looper;
        if (looper == null)
        {
            context = Looper.getMainLooper();
        }
        zs = context;
        TM = s1;
        Ud = i;
        Ue = f1;
        Uj = e1;
        Ub = new d();
        Uh = new com.google.android.gms.internal.c.j();
        Ty = fl1;
        Uc = cg;
        if (iL())
        {
            bc(ce.ju().jw());
        }
    }

    public o(Context context, TagManager tagmanager, Looper looper, String s1, int i, r r)
    {
        this(context, tagmanager, looper, s1, i, ((f) (new cq(context, s1))), ((e) (new cp(context, s1, r))), fn.eI(), ((cg) (new bf(30, 0xdbba0L, 5000L, "refreshing", fn.eI()))));
    }

    static fl a(o o1)
    {
        return o1.Ty;
    }

    private void a(com.google.android.gms.internal.c.j j)
    {
        this;
        JVM INSTR monitorenter ;
        if (Ue != null)
        {
            com.google.android.gms.internal.jd.a a1 = new com.google.android.gms.internal.jd.a();
            a1.Yb = TR;
            a1.fV = new com.google.android.gms.internal.c.f();
            a1.Yc = j;
            Ue.b(a1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        j;
        throw j;
    }

    private void a(com.google.android.gms.internal.c.j j, long l, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (!flag) goto _L2; else goto _L1
_L1:
        flag = Ug;
        if (!flag) goto _L2; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (isReady())
        {
            if (Uf != null);
        }
        Uh = j;
        TR = l;
        s(Math.max(0L, Math.min(0x2932e00L, (TR + 0x2932e00L) - Ty.currentTimeMillis())));
        j = new Container(mContext, TY.getDataLayer(), TM, l, j);
        if (Uf != null)
        {
            break; /* Loop/switch isn't completed */
        }
        Uf = new n(TY, zs, j, Ub);
_L5:
        if (!isReady() && Uk.b(j))
        {
            a(((Result) (Uf)));
        }
        if (true) goto _L3; else goto _L4
        j;
        throw j;
_L4:
        Uf.a(j);
          goto _L5
    }

    static void a(o o1, long l)
    {
        o1.s(l);
    }

    static void a(o o1, com.google.android.gms.internal.c.j j)
    {
        o1.a(j);
    }

    static void a(o o1, com.google.android.gms.internal.c.j j, long l, boolean flag)
    {
        o1.a(j, l, flag);
    }

    static boolean b(o o1)
    {
        return o1.Ug;
    }

    static com.google.android.gms.internal.c.j c(o o1)
    {
        return o1.Uh;
    }

    static long d(o o1)
    {
        return o1.TR;
    }

    static boolean e(o o1)
    {
        return o1.iL();
    }

    static n f(o o1)
    {
        return o1.Uf;
    }

    static cg g(o o1)
    {
        return o1.Uc;
    }

    private boolean iL()
    {
        ce ce1 = ce.ju();
        return (ce1.jv() == ce.a.VX || ce1.jv() == ce.a.VY) && TM.equals(ce1.getContainerId());
    }

    private void s(long l)
    {
        this;
        JVM INSTR monitorenter ;
        if (Uj != null) goto _L2; else goto _L1
_L1:
        bh.w("Refresh requested, but no network load scheduler.");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Uj.d(l, Uh.fW);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private void z(boolean flag)
    {
        Ue.a(new b());
        Uj.a(new c());
        cr.c c1 = Ue.bP(Ud);
        if (c1 != null)
        {
            Uf = new n(TY, zs, new Container(mContext, TY.getDataLayer(), TM, 0L, c1), Ub);
        }
        Uk = new a(flag) {

            final o Ul;
            final boolean Um;

            public boolean b(Container container)
            {
                if (!Um) goto _L2; else goto _L1
_L1:
                if (container.getLastRefreshTime() + 0x2932e00L < o.a(Ul).currentTimeMillis()) goto _L4; else goto _L3
_L3:
                return true;
_L4:
                return false;
_L2:
                if (container.isDefault())
                {
                    return false;
                }
                if (true) goto _L3; else goto _L5
_L5:
            }

            
            {
                Ul = o.this;
                Um = flag;
                super();
            }
        };
        if (iL())
        {
            Uj.d(0L, "");
            return;
        } else
        {
            Ue.iN();
            return;
        }
    }

    protected ContainerHolder O(Status status)
    {
        if (Uf != null)
        {
            return Uf;
        }
        if (status == Status.zS)
        {
            bh.t("timer expired: setting result to failure");
        }
        return new n(status);
    }

    void bc(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        Ui = s1;
        if (Uj != null)
        {
            Uj.bf(s1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    protected Result d(Status status)
    {
        return O(status);
    }

    String iF()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = Ui;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public void iI()
    {
        Object obj = Ue.bP(Ud);
        if (obj != null)
        {
            obj = new Container(mContext, TY.getDataLayer(), TM, 0L, ((cr.c) (obj)));
            a(new n(TY, zs, ((Container) (obj)), new n.a() {

                final o Ul;

                public void bc(String s1)
                {
                    Ul.bc(s1);
                }

                public String iF()
                {
                    return Ul.iF();
                }

                public void iH()
                {
                    bh.w("Refresh ignored: container loaded as default only.");
                }

            
            {
                Ul = o.this;
                super();
            }
            }));
        } else
        {
            bh.t("Default was requested, but no default container was found");
            a(O(new Status(10, "Default was requested, but no default container was found", null)));
        }
        Uj = null;
        Ue = null;
    }

    public void iJ()
    {
        z(false);
    }

    public void iK()
    {
        z(true);
    }
}
