// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import com.flurry.android.impl.ads.protocol.v13.AdUnit;
import com.flurry.android.impl.ads.protocol.v13.AdViewType;
import com.flurry.android.impl.ads.protocol.v13.ScreenOrientationType;

// Referenced classes of package com.flurry.sdk:
//            o, hp, gd, fj, 
//            av, cq, ap, cr, 
//            fp, i, eo, en, 
//            d, y, ch, ci, 
//            x, hq

public class t extends o
{

    private static final String a = com/flurry/sdk/t.getSimpleName();
    private a b;

    public t(Context context, String s1)
    {
        super(context, null, s1);
        b = a.a;
    }

    static void a(t t1)
    {
        t1.v();
    }

    static void b(t t1)
    {
        t1.w();
    }

    private void v()
    {
        hp.b();
        this;
        JVM INSTR monitorenter ;
        if (a.b.equals(b) || a.d.equals(b))
        {
            break MISSING_BLOCK_LABEL_34;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        b = a.c;
        this;
        JVM INSTR monitorexit ;
        Object obj;
        gd.a(3, a, (new StringBuilder()).append("render interstitial (").append(this).append(")").toString());
        obj = e();
        if (!fj.a().c())
        {
            gd.a(5, a, "There is no network connectivity (ad will not display)");
            cq.b(this, av.c);
            return;
        }
        break MISSING_BLOCK_LABEL_110;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        if (obj == null)
        {
            cq.b(this, av.e);
            return;
        }
        obj = n();
        if (obj == null)
        {
            cq.b(this, av.d);
            return;
        }
        obj = ((ap) (obj)).a();
        if (obj == null)
        {
            cq.b(this, av.f);
            return;
        }
        if (((AdUnit) (obj)).combinable == 1)
        {
            cq.b(this, av.f);
            return;
        }
        if (!AdViewType.INTERSTITIAL.equals(((AdUnit) (obj)).adViewType))
        {
            cq.a(this, av.w);
            return;
        }
        if (!cr.b().equals(((AdUnit) (obj)).screenOrientation))
        {
            cq.b(this, av.t);
            return;
        } else
        {
            o();
            fp.a().a(new hq() {

                final t a;

                public void safeRun()
                {
                    t.b(a);
                }

            
            {
                a = t.this;
                super();
            }
            });
            return;
        }
    }

    private void w()
    {
        hp.a();
        p();
        en en1 = com.flurry.sdk.i.a().q().a(e(), this);
        if (en1 != null)
        {
            en1.a();
        }
        cq.b(this);
    }

    public void a()
    {
        super.a();
    }

    protected void a(d d1)
    {
        super.a(d1);
        if (!d.a.a.equals(d1.b)) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        this;
        JVM INSTR monitorenter ;
        if (!a.a.equals(b)) goto _L4; else goto _L3
_L3:
        b = a.b;
_L6:
        this;
        JVM INSTR monitorexit ;
        this;
        JVM INSTR monitorexit ;
        if (a.d.equals(b))
        {
            fp.a().b(new hq() {

                final t a;

                public void safeRun()
                {
                    t.a(a);
                }

            
            {
                a = t.this;
                super();
            }
            });
        }
_L2:
        return;
_L4:
        if (!a.c.equals(b)) goto _L6; else goto _L5
_L5:
        b = a.d;
          goto _L6
        d1;
        this;
        JVM INSTR monitorexit ;
        throw d1;
        d1;
        this;
        JVM INSTR monitorexit ;
        throw d1;
    }

    public ci i()
    {
        return com.flurry.sdk.i.a().c().a(g(), cr.b(), l()).a();
    }

    public x j()
    {
        return com.flurry.sdk.i.a().c().a(g(), cr.b(), l()).b();
    }

    public boolean s()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a.b.equals(b);
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void t()
    {
        this;
        JVM INSTR monitorenter ;
        if (!a.a.equals(b)) goto _L2; else goto _L1
_L1:
        h().a(this, i(), j());
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!a.b.equals(b)) goto _L4; else goto _L3
_L3:
        cq.a(this);
          goto _L5
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L4:
        if (!a.c.equals(b) && !a.d.equals(b)) goto _L5; else goto _L6
_L6:
        cq.b(this);
          goto _L5
    }

    public void u()
    {
        this;
        JVM INSTR monitorenter ;
        if (!a.a.equals(b)) goto _L2; else goto _L1
_L1:
        cq.b(this, av.s);
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!a.b.equals(b)) goto _L4; else goto _L3
_L3:
        fp.a().b(new hq() {

            final t a;

            public void safeRun()
            {
                t.a(a);
            }

            
            {
                a = t.this;
                super();
            }
        });
          goto _L5
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L4:
        if (!a.c.equals(b) && !a.d.equals(b)) goto _L5; else goto _L6
_L6:
        cq.b(this);
          goto _L5
    }


    private class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        private static final a e[];

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/flurry/sdk/t$a, s1);
        }

        public static a[] values()
        {
            return (a[])e.clone();
        }

        static 
        {
            a = new a("INIT", 0);
            b = new a("READY", 1);
            c = new a("DISPLAY", 2);
            d = new a("NEXT", 3);
            e = (new a[] {
                a, b, c, d
            });
        }

        private a(String s1, int k)
        {
            super(s1, k);
        }
    }

}
