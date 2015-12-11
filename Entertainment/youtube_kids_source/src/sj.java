// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

public final class sj
    implements si
{

    final sh a;
    final blu b;
    final Handler c = new Handler(Looper.getMainLooper());
    buz d;
    dre e;
    bhx f;
    private final bje g;
    private final rx h;
    private final bpj i;
    private final bqe j;
    private final bmi k = new bmi();
    private final rs l;
    private sl m;
    private boolean n;
    private boolean o;

    public sj(sh sh1, bje bje1, rx rx1, bpj bpj1, blu blu1, bqe bqe1)
    {
        a = (sh)b.a(sh1);
        g = (bje)b.a(bje1);
        h = (rx)b.a(rx1);
        i = bpj1;
        b = (blu)b.a(blu1);
        j = (bqe)b.a(bqe1);
        l = rx1.d;
        sh1.a(this);
    }

    private void c()
    {
        if (f != null)
        {
            f.a = true;
            f = null;
        }
        if (m != null)
        {
            m.a = true;
            m = null;
        }
        e = null;
        o = false;
        a.a();
    }

    public final void a()
    {
        if (d != null && d.f())
        {
            rs rs1 = l;
            if (rs1.b != null)
            {
                rs1.b.f();
            }
        }
    }

    public final void a(int i1, int j1)
    {
        if (d != null && d.f())
        {
            rs rs1 = l;
            if (rs1.b != null)
            {
                rs1.b.a(i1, j1);
            }
            h.f.l();
        }
    }

    void a(boolean flag)
    {
        g.c(new bfd(flag));
    }

    public final void b()
    {
        if (e != null)
        {
            rs rs1 = l;
            if (rs1.b != null)
            {
                rs1.b.l();
            }
            j.a(e);
        }
    }

    public final void handleVideoStageEvent(ctd ctd1)
    {
        boolean flag;
        boolean flag1 = false;
        Object obj;
        if (ctd1.b == ctt.f)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        n = flag;
        if (!ctd1.b.a() || ctd1.d == null || ctd1.d.V != null) goto _L2; else goto _L1
_L1:
        if (d != null) goto _L4; else goto _L3
_L3:
        d = ctd1.d;
        c();
        if (!TextUtils.isEmpty(d.c)) goto _L6; else goto _L5
_L5:
        if (d.p != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(flag);
_L4:
        if (n && d.b(k) && !o)
        {
            flag = flag1;
            if (d.f())
            {
                flag = flag1;
                if (d.k > 7)
                {
                    flag = true;
                }
            }
            ctd1 = a;
            obj = d;
            if (((buz) (obj)).L == null)
            {
                ((buz) (obj)).b();
            }
            obj = d.p;
            obj = d.d;
            ctd1.a(flag);
            o = true;
        }
        return;
_L6:
        if (i != null)
        {
            bpl bpl1 = i.a();
            bpl1.a(d.c);
            bpl1.e = true;
            if (!TextUtils.isEmpty(d.f))
            {
                ctd1 = d.f;
            } else
            {
                ctd1 = "";
            }
            bpl1.d = (String)b.a(ctd1);
            m = new sl(this, d.c);
            i.a(bpl1, m);
        }
        if (true) goto _L4; else goto _L2
_L2:
        d = null;
        c();
        return;
    }

    public final void handleVideoTimeEvent(cte cte1)
    {
        if (n)
        {
            a.a((int)cte1.a, (int)cte1.b);
        }
    }
}
