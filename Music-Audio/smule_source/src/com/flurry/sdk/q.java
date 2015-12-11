// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.flurry.android.impl.ads.protocol.v13.AdUnit;
import com.flurry.android.impl.ads.protocol.v13.AdViewType;
import com.flurry.android.impl.ads.protocol.v13.ScreenOrientationType;
import java.lang.ref.WeakReference;

// Referenced classes of package com.flurry.sdk:
//            o, s, hn, gd, 
//            hp, fj, av, cq, 
//            ap, ax, cr, fp, 
//            eg, ch, d, i, 
//            y, ec, ci, x, 
//            hq

public class q extends o
    implements s
{

    private static final String a = com/flurry/sdk/q.getSimpleName();
    private a b;
    private WeakReference c;
    private boolean d;
    private long e;
    private long f;

    public q(Context context, ViewGroup viewgroup, String s1)
    {
        super(context, viewgroup, s1);
        b = a.a;
        c = new WeakReference(null);
    }

    private boolean A()
    {
        if (hn.a())
        {
            gd.a(3, a, (new StringBuilder()).append("Device is locked: banner will NOT rotate for adSpace: ").append(g()).toString());
            return false;
        }
        if (c.get() == null)
        {
            gd.a(3, a, (new StringBuilder()).append("No banner holder: banner will NOT rotate for adSpace: ").append(g()).toString());
            return false;
        } else
        {
            return true;
        }
    }

    private void a(long l)
    {
        gd.a(3, a, (new StringBuilder()).append("Scheduled banner rotation for adSpace: ").append(g()).toString());
        e = l;
        f = l;
    }

    static void a(q q1)
    {
        q1.y();
    }

    static void b(q q1)
    {
        q1.z();
    }

    private void y()
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
        Object obj1;
        gd.a(3, a, (new StringBuilder()).append("render banner (").append(this).append(")").toString());
        obj = e();
        obj1 = f();
        if (!fj.a().c())
        {
            gd.a(5, a, "There is no network connectivity (ad will not display)");
            cq.b(this, av.c);
            return;
        }
        break MISSING_BLOCK_LABEL_115;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        if (obj == null)
        {
            cq.b(this, av.e);
            return;
        }
        if (obj1 == null)
        {
            cq.b(this, av.u);
            return;
        }
        obj = n();
        if (obj == null)
        {
            cq.b(this, av.d);
            return;
        }
        obj1 = ((ap) (obj)).a();
        if (obj1 == null)
        {
            cq.b(this, av.f);
            return;
        }
        if (!AdViewType.BANNER.equals(((AdUnit) (obj1)).adViewType))
        {
            cq.a(this, av.w);
            return;
        }
        if (!ax.a.equals(((ap) (obj)).d()))
        {
            cq.a(this, av.w);
            return;
        }
        if (!cr.b().equals(((AdUnit) (obj1)).screenOrientation))
        {
            cq.b(this, av.t);
            return;
        } else
        {
            o();
            fp.a().a(new hq() {

                final q a;

                public void safeRun()
                {
                    q.b(a);
                }

            
            {
                a = q.this;
                super();
            }
            });
            return;
        }
    }

    private void z()
    {
        hp.a();
        a(0L);
        p();
        eg.a(e(), this);
        cq.b(this);
    }

    public void a()
    {
        fp.a().a(new hq() {

            final q a;

            public void safeRun()
            {
                a.t();
            }

            
            {
                a = q.this;
                super();
            }
        });
        super.a();
    }

    public void a(RelativeLayout relativelayout)
    {
        c = new WeakReference(relativelayout);
    }

    public void a(ap ap1, long l)
    {
        boolean flag;
        if (s() != null && s().getChildCount() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            a(l);
            return;
        } else
        {
            h().a(this, i(), j());
            return;
        }
    }

    protected void a(d d1)
    {
        super.a(d1);
        if (!d.a.a.equals(d1.b)) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (!a.a.equals(b)) goto _L4; else goto _L3
_L3:
        b = a.b;
_L6:
        this;
        JVM INSTR monitorexit ;
        if (d || a.d.equals(b))
        {
            fp.a().b(new hq() {

                final q a;

                public void safeRun()
                {
                    q.a(a);
                }

            
            {
                a = q.this;
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
    }

    public void b()
    {
        super.b();
    }

    public void c()
    {
        super.c();
        f = e;
    }

    public ci i()
    {
        return com.flurry.sdk.i.a().c().a(g(), cr.b(), l()).a();
    }

    public x j()
    {
        return com.flurry.sdk.i.a().c().a(g(), cr.b(), l()).b();
    }

    protected void r()
    {
        super.r();
        if (e > 0L)
        {
            f = f - (System.currentTimeMillis() - q());
            if (f <= 0L)
            {
                if (A())
                {
                    gd.a(3, a, (new StringBuilder()).append("Rotating banner for adSpace: ").append(g()).toString());
                    h().a(this, i(), j());
                }
                f = e;
            }
        }
    }

    public RelativeLayout s()
    {
        return (RelativeLayout)c.get();
    }

    public void t()
    {
        hp.a();
        RelativeLayout relativelayout = (RelativeLayout)c.get();
        if (relativelayout != null)
        {
            do
            {
                if (relativelayout.getChildCount() <= 0)
                {
                    break;
                }
                android.view.View view = relativelayout.getChildAt(0);
                relativelayout.removeView(view);
                if (view instanceof ec)
                {
                    ((ec)view).onActivityDestroy();
                }
            } while (true);
            ViewGroup viewgroup = f();
            if (viewgroup != null)
            {
                viewgroup.removeView(relativelayout);
                viewgroup.setBackgroundColor(0);
            }
        }
        c.clear();
    }

    public boolean u()
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

    public void v()
    {
        d = false;
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

    public void w()
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

            final q a;

            public void safeRun()
            {
                q.a(a);
            }

            
            {
                a = q.this;
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

    public void x()
    {
        d = true;
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
        fp.a().b(new hq() {

            final q a;

            public void safeRun()
            {
                q.a(a);
            }

            
            {
                a = q.this;
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
            return (a)Enum.valueOf(com/flurry/sdk/q$a, s1);
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
