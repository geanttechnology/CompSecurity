// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.text.TextUtils;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;

public final class tu extends to
{

    final Context a;
    final cud b;
    final s m;
    final crs n;
    final byte o[];
    final Executor p;
    final String q;
    final String r;
    volatile cdu s;
    volatile List t;
    volatile int u[];
    volatile int v;
    private final Executor w;
    private int x;
    private tv y;

    public tu(Context context, rh rh, rg rg, bje bje, ctw ctw, blx blx, cvi cvi, 
            bmw bmw1, Executor executor, cud cud1, s s1, crs crs1, cto cto1)
    {
        this(context, rh, rg, bje, ctw, blx, cvi, bmw1, executor, ((Executor) (new bis())), cud1, s1, crs1, cto1);
        a(cts.a);
    }

    public tu(Context context, rh rh, rg rg, bje bje, ctw ctw, blx blx, cvi cvi, 
            bmw bmw1, Executor executor, cud cud1, s s1, crs crs1, cwf cwf1)
    {
        this(context, rh, rg, bje, ctw, blx, cvi, bmw1, executor, ((Executor) (new bis())), cud1, s1, crs1, cwf1);
    }

    private tu(Context context, rh rh, rg rg, bje bje, ctw ctw, blx blx, cvi cvi, 
            bmw bmw1, Executor executor, Executor executor1, cud cud1, s s1, crs crs1, cto cto1)
    {
        super(rh, rg, bje, ctw, blx, cvi, bmw1, cto1.a.m, cto1.a.k);
        a = (Context)b.a(context);
        b = (cud)b.a(cud1);
        m = (s)b.a(s1);
        n = (crs)b.a(crs1);
        w = (Executor)b.a(executor);
        o = (byte[])b.a(cto1.e());
        p = (Executor)b.a(executor1);
        if (!TextUtils.isEmpty(cto1.a.c))
        {
            q = null;
            r = cto1.a.c;
        } else
        {
            q = (String)b.a(cto1.a.a);
            r = null;
        }
        x = Math.max(cto1.a.d, 0);
        v = x - 1;
        i();
    }

    private tu(Context context, rh rh, rg rg, bje bje, ctw ctw, blx blx, cvi cvi, 
            bmw bmw1, Executor executor, Executor executor1, cud cud1, s s1, crs crs1, cwf cwf1)
    {
        super(rh, rg, bje, ctw, blx, cvi, bmw1, cwf1.i);
        b.a(cwf1);
        a = (Context)b.a(context);
        b = (cud)b.a(cud1);
        m = (s)b.a(s1);
        n = (crs)b.a(crs1);
        w = (Executor)b.a(executor);
        o = (byte[])b.a(cwf1.e);
        p = (Executor)b.a(executor1);
        q = cwf1.c;
        r = cwf1.d;
        h = cwf1.a;
        i = cwf1.b;
        v = cwf1.f;
        x = cwf1.g;
        k = cwf1.h;
        a(cts.a);
        if (h != null)
        {
            a(cts.d);
            if (i != null)
            {
                a(cts.e);
            }
        }
        i();
    }

    static void a(tu tu1)
    {
        if (tu1.u == null) goto _L2; else goto _L1
_L1:
        Object obj;
        int j1;
        int i = tu1.v;
        if (tu1.l)
        {
            i = tu1.u[tu1.v];
        }
        j1 = tu1.u.length;
        for (int k = 0; k < j1; k++)
        {
            tu1.u[k] = k;
        }

        tu1.u[0] = i;
        tu1.u[i] = 0;
        obj = tu1.f;
        tu1 = tu1.u;
        obj = ((bmw) (obj)).a();
        if (tu1 != null && obj != null) goto _L3; else goto _L2
_L2:
        return;
_L3:
        int i1 = Math.max(1, 0);
        if (j1 >= 0 && i1 < j1)
        {
            int j = tu1.length;
            if (j != 0 && i1 < j)
            {
                j = Math.min(j1, j) - i1 - 1;
                while (j >= 0) 
                {
                    int k1 = j + i1;
                    int l1 = ((Random) (obj)).nextInt(j + 1) + i1;
                    int i2 = tu1[k1];
                    tu1[k1] = tu1[l1];
                    tu1[l1] = i2;
                    j--;
                }
            }
        }
        if (true) goto _L2; else goto _L4
_L4:
    }

    private void b(int i)
    {
        this;
        JVM INSTR monitorenter ;
        int j;
        a(cts.b);
        if (t == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        j = t.size() - 1;
_L1:
        x = Math.max(0, Math.min(j, i));
        y = new ty(this, i);
        w.execute(y);
        this;
        JVM INSTR monitorexit ;
        return;
        j = 0x7fffffff;
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    private void w()
    {
        if (k && x())
        {
            b(0);
            return;
        } else
        {
            b(v + 1);
            return;
        }
    }

    private boolean x()
    {
        return t != null && v >= t.size() - 1;
    }

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
        if (y != null)
        {
            tv.a(y);
            y = null;
        }
        if (h == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        if (i == null) goto _L2; else goto _L1
_L1:
        g = cts.e;
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        g = cts.d;
          goto _L3
        Exception exception;
        exception;
        throw exception;
        a(cts.a);
          goto _L3
    }

    final void a(int i)
    {
        y = new tv(this, x);
        w.execute(y);
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

    public final boolean c_()
    {
        return false;
    }

    public final boolean d_()
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (t == null)
            {
                break label0;
            }
            flag = flag1;
            if (t.isEmpty())
            {
                break label0;
            }
            if (!k)
            {
                flag = flag1;
                if (x())
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    public final boolean e_()
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (t == null)
            {
                break label0;
            }
            flag = flag1;
            if (t.isEmpty())
            {
                break label0;
            }
            if (!k)
            {
                flag = flag1;
                if (v <= 0)
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    public final cwh f()
    {
        return new cwf(q, r, o, h, i, v, x, k, (cwb)super.f());
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

    public final void l()
    {
        a();
        super.l();
        b(x);
    }

    protected final boolean n()
    {
        return true;
    }

    public final void o()
    {
        a();
        super.o();
        w();
    }

    public final void p()
    {
        a();
        super.p();
        if (k && v == 0 && t != null)
        {
            b(t.size() - 1);
            return;
        } else
        {
            b(v - 1);
            return;
        }
    }

    public final void q()
    {
        a();
        super.q();
        w();
    }

    public final void r()
    {
        a();
        super.r();
        b(x);
    }

    public final String t()
    {
        if (v())
        {
            return r;
        } else
        {
            return "";
        }
    }

    public final int u()
    {
        return v;
    }

    boolean v()
    {
        return r != null;
    }
}
