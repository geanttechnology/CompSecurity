// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Intent;
import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            bd, bc, ct, db, 
//            dd, n, az, cz, 
//            aq, h, ak, bj, 
//            aa, ag, bl, s, 
//            bq, ay, bo, ap, 
//            bs, am, bx, bt, 
//            o, AdColonyOverlay, AdColonyFullscreen, bh, 
//            q, bk

class be
{

    bd a;
    bc b;
    ct c;
    db d;
    dd e;
    n f;
    az g;
    cz h;
    ArrayList i;
    ArrayList j;
    volatile boolean k;
    boolean l;
    aq m;

    be()
    {
        a = new bd(this);
        b = new bc(this);
        c = new ct(this);
        d = new db(this);
        e = new dd(this);
        f = new n(this);
        g = new az(this);
        h = new cz(this);
        i = new ArrayList();
        j = new ArrayList();
        m = new aq();
    }

    int a(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = a.i.f(s1);
_L2:
        this;
        JVM INSTR monitorexit ;
        return i1;
        s1;
        ak.a(s1);
        i1 = 0;
        if (true) goto _L2; else goto _L1
_L1:
        s1;
        throw s1;
    }

    void a()
    {
        while (l || !ak.d()) 
        {
            return;
        }
_L2:
        if (l && (k || i.size() <= 0))
        {
            break; /* Loop/switch isn't completed */
        }
        l = true;
        j.addAll(i);
        i.clear();
        int i1 = 0;
_L3:
        if (i1 < j.size())
        {
            if (j.get(i1) != null)
            {
                ((bj)j.get(i1)).b();
            }
            break MISSING_BLOCK_LABEL_144;
        }
        try
        {
            j.clear();
        }
        catch (RuntimeException runtimeexception)
        {
            l = false;
            j.clear();
            i.clear();
            ak.a(runtimeexception);
            return;
        }
        if (true) goto _L2; else goto _L1
_L1:
        l = false;
        return;
        i1++;
          goto _L3
    }

    void a(double d1, s s1)
    {
        new bj(this, d1, s1) {

            final double a;
            final s b;
            final be c;

            void b()
            {
                n.d.a(a, b);
            }

            
            {
                c = be.this;
                a = d1;
                b = s1;
                super(be2);
            }
        };
    }

    void a(int i1)
    {
        ak.a(i1);
    }

    void a(aa aa1)
    {
        this;
        JVM INSTR monitorenter ;
        a.b(aa1.b);
        this;
        JVM INSTR monitorexit ;
        return;
        aa1;
        throw aa1;
    }

    void a(ag ag1)
    {
        this;
        JVM INSTR monitorenter ;
        a.c(ag1.b);
        this;
        JVM INSTR monitorexit ;
        return;
        ag1;
        throw ag1;
    }

    void a(bj bj1)
    {
label0:
        {
            synchronized (i)
            {
                if (ak.d())
                {
                    break label0;
                }
            }
            return;
        }
        i.add(bj1);
        if (!k)
        {
            g();
        }
        arraylist;
        JVM INSTR monitorexit ;
        return;
        bj1;
        arraylist;
        JVM INSTR monitorexit ;
        throw bj1;
    }

    void a(s s1)
    {
        this;
        JVM INSTR monitorenter ;
        a.n = 0.0D;
        bl.a.b("Tracking ad event - start");
        ay ay1 = s1.c.k;
        ay1.d = ay1.d + 1;
        if (!s1.h())
        {
            s1.c.j();
            h.a(s1.b, s1.d.d);
        }
        new bj(this, s1) {

            final s a;
            final be b;

            void b()
            {
                if (q.c(a.b) || !a.f.equals("native"))
                {
                    b.a("start", (new StringBuilder()).append("{\"ad_slot\":").append(a.c.k.d).append(", \"replay\":").append(a.n).append("}").toString(), a);
                }
            }

            
            {
                b = be.this;
                a = s1;
                super(be2);
            }
        };
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    void a(String s1, String s2, s s3)
    {
        new bj(this, s1, s2, s3) {

            final String a;
            final String b;
            final s c;
            final be d;

            void b()
            {
                n.d.a(a, bk.b(b), c);
            }

            
            {
                d = be.this;
                a = s1;
                b = s2;
                c = s3;
                super(be2);
            }
        };
    }

    void a(String s1, String s2, String as[])
    {
        this;
        JVM INSTR monitorenter ;
        a(ak.e);
        bl.c.a("==== Configuring AdColony ").a(a.b).b(" ====");
        bl.a.a("package name: ").b(ap.e());
        a.j = s2;
        a.k = as;
        a.a(s1);
        m.a();
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        ak.a(s1);
        if (true) goto _L2; else goto _L1
_L1:
        s1;
        throw s1;
    }

    void a(boolean flag, s s1)
    {
        int i1;
        int j1;
        j1 = 0;
        i1 = 1;
        boolean flag1 = true;
        this;
        JVM INSTR monitorenter ;
        if (s1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        a(1.0D, s1);
        if (flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        ag ag1;
        String s2;
        int k1;
        int l1;
        if (!s1.h())
        {
            continue; /* Loop/switch isn't completed */
        }
        s1.c.j();
        h.a(s1.b, s1.d.d);
        ag1 = (ag)ak.A;
        s2 = ag1.j();
        k1 = ag1.k();
        l1 = ag1.l();
        if (l1 <= 1)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        i1 = h.c(ag1.j()) + 1;
        if (i1 >= l1)
        {
            i1 = ((flag1) ? 1 : 0);
        } else
        {
            boolean flag2 = false;
            j1 = i1;
            i1 = ((flag2) ? 1 : 0);
        }
        h.b(ag1.j(), j1);
        if (i1 == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (ag1.c.j.e)
        {
            a(true, s2, k1);
        }
        new bj(this, s2, k1, s1) {

            final String a;
            final int b;
            final s c;
            final be d;

            void b()
            {
                h h1 = new h();
                h1.b("v4vc_name", a);
                h1.b("v4vc_amount", b);
                n.d.a("reward_v4vc", h1, c);
            }

            
            {
                d = be.this;
                a = s1;
                b = i1;
                c = s2;
                super(be2);
            }
        };
        if (true) goto _L1; else goto _L3
_L3:
        s1;
        throw s1;
    }

    void a(boolean flag, String s1, int i1)
    {
        this;
        JVM INSTR monitorenter ;
        ak.E.a(flag, s1, i1);
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    boolean a(String s1, boolean flag, boolean flag1)
    {
        boolean flag3 = false;
        this;
        JVM INSTR monitorenter ;
        boolean flag2 = ak.d();
        if (flag2) goto _L2; else goto _L1
_L1:
        flag2 = flag3;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag2;
_L2:
        flag2 = flag3;
        try
        {
            if (b.b(s1, flag))
            {
                flag2 = b.j.n.a(s1).b(flag1);
            }
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (String s1) { }
        finally
        {
            this;
        }
        ak.a(s1);
        flag2 = flag3;
        if (true) goto _L4; else goto _L3
_L3:
        throw s1;
    }

    void b()
    {
        k = true;
        new bj(this) {

            final be a;

            void b()
            {
                n.e.c();
            }

            
            {
                a = be.this;
                super(be2);
            }
        };
    }

    boolean b(aa aa1)
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        String s1;
        boolean flag1;
        ak.A = aa1;
        s1 = aa1.b;
        flag1 = e(s1);
        if (flag1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        bl.a.a("Showing ad for zone ").b(s1);
        a(aa1);
        flag1 = b(((s) (aa1)));
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        aa1;
        ak.a(aa1);
        if (true) goto _L1; else goto _L3
_L3:
        aa1;
        throw aa1;
    }

    boolean b(ag ag1)
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        String s1;
        boolean flag1;
        ak.A = ag1;
        s1 = ag1.b;
        flag1 = f(s1);
        if (flag1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        bl.a.a("Showing v4vc for zone ").b(s1);
        a(ag1);
        flag1 = b(((s) (ag1)));
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        ag1;
        ak.a(ag1);
        if (true) goto _L1; else goto _L3
_L3:
        ag1;
        throw ag1;
    }

    boolean b(s s1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!a.l.b()) goto _L2; else goto _L1
_L1:
        ak.A.a = 3;
        boolean flag = false;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        a(s1);
        o.a();
        if (ak.d)
        {
            bl.a.b("Launching AdColonyOverlay");
            s1 = new Intent(ak.b(), com/jirbo/adcolony/AdColonyOverlay);
            ak.b().startActivity(s1);
            break MISSING_BLOCK_LABEL_115;
        }
        bl.a.b("Launching AdColonyFullscreen");
        s1 = new Intent(ak.b(), com/jirbo/adcolony/AdColonyFullscreen);
        ak.b().startActivity(s1);
        break MISSING_BLOCK_LABEL_115;
        s1;
        throw s1;
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
    }

    boolean b(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a.i.g(s1);
_L2:
        this;
        JVM INSTR monitorexit ;
        return flag;
        s1;
        ak.a(s1);
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
        s1;
        throw s1;
    }

    boolean b(String s1, boolean flag, boolean flag1)
    {
        boolean flag3 = false;
        this;
        JVM INSTR monitorenter ;
        boolean flag2 = ak.d();
        if (flag2) goto _L2; else goto _L1
_L1:
        flag2 = flag3;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag2;
_L2:
        flag2 = flag3;
        try
        {
            if (b.b(s1, flag))
            {
                flag2 = b.j.n.a(s1).c(flag1);
            }
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (String s1) { }
        finally
        {
            this;
        }
        ak.a(s1);
        flag2 = flag3;
        if (true) goto _L4; else goto _L3
_L3:
        throw s1;
    }

    String c(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = a.i.d(s1);
_L2:
        this;
        JVM INSTR monitorexit ;
        return s1;
        s1;
        ak.a(s1);
        s1 = null;
        if (true) goto _L2; else goto _L1
_L1:
        s1;
        throw s1;
    }

    void c()
    {
        k = false;
        new bj(this) {

            final be a;

            void b()
            {
                n.e.d();
            }

            
            {
                a = be.this;
                super(be2);
            }
        };
    }

    int d(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = h.c(s1);
        this;
        JVM INSTR monitorexit ;
        return i1;
        s1;
        throw s1;
    }

    void d()
    {
        new bj(this) {

            final be a;

            void b()
            {
                n.e.e();
            }

            
            {
                a = be.this;
                super(be2);
            }
        };
    }

    String e()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = b.c();
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    boolean e(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a(s1, false, true);
        this;
        JVM INSTR monitorexit ;
        return flag;
        s1;
        throw s1;
    }

    String f()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = b.d();
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    boolean f(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = b(s1, false, true);
        this;
        JVM INSTR monitorexit ;
        return flag;
        s1;
        throw s1;
    }

    bq g(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = b.j.n.a(s1);
        this;
        JVM INSTR monitorexit ;
        return s1;
        s1;
        throw s1;
    }

    void g()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = ak.c();
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        a();
        if (!ak.g)
        {
            if (bh.m() != null || m.b() > 5D)
            {
                a.a();
                ak.g = true;
            }
            ak.i = true;
        }
        b.f();
        c.e();
        e.b();
        d.d();
        h.d();
        g.c();
        continue; /* Loop/switch isn't completed */
        Object obj;
        obj;
        ak.a(((RuntimeException) (obj)));
        if (true) goto _L1; else goto _L3
_L3:
        obj;
        throw obj;
    }
}
