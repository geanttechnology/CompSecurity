// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import com.flurry.android.impl.ads.protocol.v13.Configuration;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            gg, gd, fw, az, 
//            ba, l, aa, ae, 
//            cm, hb, fp, hc, 
//            hp, n, y, p, 
//            v, k, cf, ce, 
//            m, fz, fy, at, 
//            aw, bc, g, ef, 
//            eo, fs, fx, cg, 
//            cz, ha, gw, gx, 
//            hq

public class i
    implements gg
{

    private static final String a = com/flurry/sdk/i.getSimpleName();
    private final fy b = new fy() {

        final i a;

        public void a(fs fs1)
        {
            if (fs.a.c.equals(fs1.b))
            {
                i.a(a).b(fs1.a);
                i.b(a).a(fs1.a);
            } else
            {
                if (fs.a.d.equals(fs1.b))
                {
                    i.a(a).c(fs1.a);
                    i.b(a).b(fs1.a);
                    return;
                }
                if (fs.a.b.equals(fs1.b))
                {
                    i.a(a).d(fs1.a);
                    i.b(a).c(fs1.a);
                    return;
                }
            }
        }

        public void notify(fx fx)
        {
            a((fs)fx);
        }

            
            {
                a = i.this;
                super();
            }
    };
    private final fy c = new fy() {

        final i a;

        public void a(cg cg1)
        {
label0:
            {
                synchronized (a)
                {
                    if (i.c(a) != null)
                    {
                        break label0;
                    }
                    i.a(a, cg1.a);
                }
                i.a(a, (long)i.c(a).cacheSizeMb * 1024L * 1204L, (long)i.c(a).maxAssetSizeKb * 1024L);
                cz.a(i.c(a).maxBitRateKbps);
                i.d(a).a(i.c(a).sdkAssetUrl);
                i.d(a).c();
                return;
            }
            i1;
            JVM INSTR monitorexit ;
            return;
            cg1;
            i1;
            JVM INSTR monitorexit ;
            throw cg1;
        }

        public void notify(fx fx)
        {
            a((cg)fx);
        }

            
            {
                a = i.this;
                super();
            }
    };
    private n d;
    private y e;
    private p f;
    private v g;
    private k h;
    private cf i;
    private ce j;
    private m k;
    private ba l;
    private aa m;
    private File n;
    private File o;
    private fw p;
    private fw q;
    private Configuration r;

    public i()
    {
    }

    private void A()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        gd.a(4, a, "Loading FreqCap data.");
        obj = (List)p.a();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        az az1;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); l.a(az1))
        {
            az1 = (az)((Iterator) (obj)).next();
        }

        break MISSING_BLOCK_LABEL_158;
        Exception exception;
        exception;
        throw exception;
        if (!n.exists())
        {
            break MISSING_BLOCK_LABEL_158;
        }
        gd.a(4, a, "Legacy FreqCap data found, converting.");
        exception = com.flurry.sdk.l.a(n);
        if (exception == null)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        az az2;
        for (exception = exception.iterator(); exception.hasNext(); l.a(az2))
        {
            az2 = (az)exception.next();
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
        gd.a(4, a, "Loading CachedAsset data.");
        obj = (List)q.a();
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj = ((List) (obj)).iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            ae ae1 = (ae)((Iterator) (obj)).next();
            m.a(ae1);
        }
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L4:
        if (!o.exists()) goto _L1; else goto _L5
_L5:
        gd.a(4, a, "Legacy CachedAsset data found, deleting.");
        o.delete();
          goto _L1
    }

    static Configuration a(i i1, Configuration configuration)
    {
        i1.r = configuration;
        return configuration;
    }

    private cm a(hb hb1)
    {
        if (hb1 == null)
        {
            return null;
        } else
        {
            return (cm)hb1.c(com/flurry/sdk/cm);
        }
    }

    public static i a()
    {
        com/flurry/sdk/i;
        JVM INSTR monitorenter ;
        i i1 = (i)fp.a().a(com/flurry/sdk/i);
        com/flurry/sdk/i;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    static p a(i i1)
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
        gd.a(3, a, "Precaching: initing from FlurryAdModule");
        m.a(l1, l2);
        m.e();
        fp.a().b(new hq() {

            final i a;

            public void safeRun()
            {
                i.f(a);
            }

            
            {
                a = i.this;
                super();
            }
        });
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

    static v b(i i1)
    {
        return i1.g;
    }

    static Configuration c(i i1)
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

    private cm v()
    {
        return a(hc.a().e());
    }

    private String w()
    {
        return (new StringBuilder()).append(".flurryfreqcap.").append(Integer.toString(fp.a().d().hashCode(), 16)).toString();
    }

    private String x()
    {
        return (new StringBuilder()).append(".flurrycachedasset.").append(Integer.toString(fp.a().d().hashCode(), 16)).toString();
    }

    private String y()
    {
        return (new StringBuilder()).append(".yflurryfreqcap.").append(Long.toString(hp.i(fp.a().d()), 16)).toString();
    }

    private String z()
    {
        return (new StringBuilder()).append(".yflurrycachedasset").append(Long.toString(hp.i(fp.a().d()), 16)).toString();
    }

    public at a(String s1)
    {
        cm cm1 = v();
        if (cm1 != null)
        {
            return cm1.a(s1);
        } else
        {
            return null;
        }
    }

    public void a(Context context)
    {
        hb.a(com/flurry/sdk/cm);
        d = new n();
        e = new y();
        f = new p();
        g = new v();
        h = new k();
        i = new cf();
        j = new ce();
        k = new m();
        l = new ba();
        m = new aa();
        r = null;
        fz.a().a("com.flurry.android.sdk.ActivityLifecycleEvent", b);
        fz.a().a("com.flurry.android.sdk.AdConfigurationEvent", c);
        n = context.getFileStreamPath(w());
        o = context.getFileStreamPath(x());
        p = new fw(context.getFileStreamPath(y()), ".yflurryfreqcap.", 2, new ha() {

            final i a;

            public gx a(int i1)
            {
                return new gw(new az.a());
            }

            
            {
                a = i.this;
                super();
            }
        });
        q = new fw(context.getFileStreamPath(z()), ".yflurrycachedasset", 1, new ha() {

            final i a;

            public gx a(int i1)
            {
                return new gw(new ae.a());
            }

            
            {
                a = i.this;
                super();
            }
        });
        fp.a().b(new hq() {

            final i a;

            public void safeRun()
            {
                i.e(a);
            }

            
            {
                a = i.this;
                super();
            }
        });
    }

    public void a(String s1, aw aw, boolean flag, Map map)
    {
        cm cm1 = v();
        if (cm1 != null)
        {
            cm1.a(s1, aw, flag, map);
        }
    }

    public void b()
    {
        fz.a().a(b);
        fz.a().a(c);
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
            j.b();
            j = null;
        }
        k = null;
        r = null;
        hb.b(com/flurry/sdk/cm);
    }

    public y c()
    {
        return e;
    }

    public p d()
    {
        return f;
    }

    public v e()
    {
        return g;
    }

    public k f()
    {
        return h;
    }

    public cf g()
    {
        return i;
    }

    public n h()
    {
        return d;
    }

    public ce i()
    {
        return j;
    }

    public m j()
    {
        return k;
    }

    public ba k()
    {
        return l;
    }

    public aa l()
    {
        return m;
    }

    public Configuration m()
    {
        return r;
    }

    public bc n()
    {
        cm cm1 = v();
        if (cm1 != null)
        {
            return cm1.b();
        } else
        {
            return null;
        }
    }

    public g o()
    {
        cm cm1 = v();
        if (cm1 != null)
        {
            return cm1.c();
        } else
        {
            return null;
        }
    }

    public ef p()
    {
        cm cm1 = v();
        if (cm1 != null)
        {
            return cm1.d();
        } else
        {
            return null;
        }
    }

    public eo q()
    {
        cm cm1 = v();
        if (cm1 != null)
        {
            return cm1.e();
        } else
        {
            return null;
        }
    }

    public void r()
    {
        cm cm1 = v();
        if (cm1 != null)
        {
            cm1.h();
        }
    }

    public String s()
    {
        cm cm1 = v();
        if (cm1 != null)
        {
            return cm1.i();
        } else
        {
            return null;
        }
    }

    public void t()
    {
        this;
        JVM INSTR monitorenter ;
        gd.a(4, a, "Saving FreqCap data.");
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
        gd.a(4, a, "Saving CachedAsset data.");
        q.a(m.d());
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

}
