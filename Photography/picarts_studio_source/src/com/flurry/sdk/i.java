// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.flurry.android.FlurryFullscreenTakeoverActivity;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            kf, kc, jv, bb, 
//            bc, l, ab, af, 
//            du, lb, jo, ld, 
//            lp, o, z, q, 
//            w, k, di, dh, 
//            m, jy, jx, cp, 
//            av, ay, be, g, 
//            gt, hd

public class i
    implements kf
{

    private static final String a = com/flurry/sdk/i.getSimpleName();
    private final jx b = new _cls1();
    private final jx c = new _cls2();
    private o d;
    private z e;
    private q f;
    private w g;
    private k h;
    private di i;
    private dh j;
    private m k;
    private bc l;
    private ab m;
    private File n;
    private File o;
    private jv p;
    private jv q;
    private cp r;

    public i()
    {
    }

    private void A()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        kc.a(4, a, "Loading FreqCap data.");
        obj = (List)p.a();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        bb bb1;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); l.a(bb1))
        {
            bb1 = (bb)((Iterator) (obj)).next();
        }

        break MISSING_BLOCK_LABEL_158;
        Exception exception;
        exception;
        throw exception;
        if (!n.exists())
        {
            break MISSING_BLOCK_LABEL_158;
        }
        kc.a(4, a, "Legacy FreqCap data found, converting.");
        exception = com.flurry.sdk.l.a(n);
        if (exception == null)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        bb bb2;
        for (exception = exception.iterator(); exception.hasNext(); l.a(bb2))
        {
            bb2 = (bb)exception.next();
        }

        l.b();
        n.delete();
        t();
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        l.b();
          goto _L1
    }

    private void B()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = m.a();
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object obj;
        kc.a(4, a, "Loading CachedAsset data.");
        obj = (List)q.a();
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj = ((List) (obj)).iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            af af1 = (af)((Iterator) (obj)).next();
            m.a(af1);
        }
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L4:
        if (!o.exists()) goto _L1; else goto _L5
_L5:
        kc.a(4, a, "Legacy CachedAsset data found, deleting.");
        o.delete();
          goto _L1
    }

    static cp a(i i1, cp cp)
    {
        i1.r = cp;
        return cp;
    }

    private du a(lb lb1)
    {
        if (lb1 == null)
        {
            return null;
        } else
        {
            return (du)lb1.c(com/flurry/sdk/du);
        }
    }

    public static i a()
    {
        com/flurry/sdk/i;
        JVM INSTR monitorenter ;
        i i1 = (i)jo.a().a(com/flurry/sdk/i);
        com/flurry/sdk/i;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    static q a(i i1)
    {
        return i1.f;
    }

    private void a(long l1, long l2)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = m.a();
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        kc.a(3, a, "Precaching: initing from FlurryAdModule");
        m.a(l1, l2);
        m.e();
        jo.a().b(new _cls6());
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static void a(i i1, long l1, long l2)
    {
        i1.a(l1, l2);
    }

    static w b(i i1)
    {
        return i1.g;
    }

    private void b(Context context)
    {
        if (context.getPackageManager().resolveActivity(new Intent(context, com/flurry/android/FlurryFullscreenTakeoverActivity), 0) == null)
        {
            kc.b(a, "com.flurry.android.FlurryFullscreenTakeoverActivity must be declared in manifest.");
        }
    }

    static cp c(i i1)
    {
        return i1.r;
    }

    static k d(i i1)
    {
        return i1.h;
    }

    static void e(i i1)
    {
        i1.A();
    }

    static void f(i i1)
    {
        i1.B();
    }

    private du v()
    {
        return a(ld.a().e());
    }

    private String w()
    {
        return (new StringBuilder(".flurryfreqcap.")).append(Integer.toString(jo.a().d().hashCode(), 16)).toString();
    }

    private String x()
    {
        return (new StringBuilder(".flurrycachedasset.")).append(Integer.toString(jo.a().d().hashCode(), 16)).toString();
    }

    private String y()
    {
        return (new StringBuilder(".yflurryfreqcap.")).append(Long.toString(lp.i(jo.a().d()), 16)).toString();
    }

    private String z()
    {
        return (new StringBuilder(".yflurrycachedasset")).append(Long.toString(lp.i(jo.a().d()), 16)).toString();
    }

    public av a(String s1)
    {
        du du1 = v();
        if (du1 != null)
        {
            return du1.a(s1);
        } else
        {
            return null;
        }
    }

    public void a(Context context)
    {
        lb.a(com/flurry/sdk/du);
        d = new o();
        e = new z();
        f = new q();
        g = new w();
        h = new k();
        i = new di();
        j = new dh();
        k = new m();
        l = new bc();
        m = new ab();
        r = null;
        jy.a().a("com.flurry.android.sdk.ActivityLifecycleEvent", b);
        jy.a().a("com.flurry.android.sdk.AdConfigurationEvent", c);
        n = context.getFileStreamPath(w());
        o = context.getFileStreamPath(x());
        p = new jv(context.getFileStreamPath(y()), ".yflurryfreqcap.", 2, new _cls3());
        q = new jv(context.getFileStreamPath(z()), ".yflurrycachedasset", 1, new _cls4());
        jo.a().b(new _cls5());
        b(context);
    }

    public void a(String s1, ay ay, boolean flag, Map map)
    {
        du du1 = v();
        if (du1 != null)
        {
            du1.a(s1, ay, flag, map);
        }
    }

    public void b()
    {
        jy.a().a(b);
        jy.a().a(c);
        if (e != null)
        {
            e.a();
            e = null;
        }
        f = null;
        g = null;
        h = null;
        i = null;
        if (d != null)
        {
            d.a();
            d = null;
        }
        if (j != null)
        {
            j.c();
            j = null;
        }
        k = null;
        r = null;
        lb.b(com/flurry/sdk/du);
    }

    public z c()
    {
        return e;
    }

    public q d()
    {
        return f;
    }

    public w e()
    {
        return g;
    }

    public k f()
    {
        return h;
    }

    public di g()
    {
        return i;
    }

    public o h()
    {
        return d;
    }

    public dh i()
    {
        return j;
    }

    public m j()
    {
        return k;
    }

    public bc k()
    {
        return l;
    }

    public ab l()
    {
        return m;
    }

    public cp m()
    {
        return r;
    }

    public be n()
    {
        du du1 = v();
        if (du1 != null)
        {
            return du1.b();
        } else
        {
            return null;
        }
    }

    public g o()
    {
        du du1 = v();
        if (du1 != null)
        {
            return du1.c();
        } else
        {
            return null;
        }
    }

    public gt p()
    {
        du du1 = v();
        if (du1 != null)
        {
            return du1.d();
        } else
        {
            return null;
        }
    }

    public hd q()
    {
        du du1 = v();
        if (du1 != null)
        {
            return du1.e();
        } else
        {
            return null;
        }
    }

    public void r()
    {
        du du1 = v();
        if (du1 != null)
        {
            du1.h();
        }
    }

    public String s()
    {
        du du1 = v();
        if (du1 != null)
        {
            return du1.i();
        } else
        {
            return null;
        }
    }

    public void t()
    {
        this;
        JVM INSTR monitorenter ;
        kc.a(4, a, "Saving FreqCap data.");
        l.b();
        p.a(l.a());
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void u()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = m.a();
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        kc.a(4, a, "Saving CachedAsset data.");
        q.a(m.d());
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls5 {}

}
