// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.flurry.sdk:
//            ak, gt, ae, ah, 
//            gd, ad, fp, f, 
//            am, ai, fn, an, 
//            hq

public class z
{

    private static final String b = com/flurry/sdk/z.getSimpleName();
    final Map a = new HashMap();
    private final Map c = new LinkedHashMap();
    private final Map d = new LinkedHashMap();
    private a e;
    private final ak f;
    private final long g;
    private final int h;

    z(String s, long l1, long l2, boolean flag)
    {
        int i1 = 1;
        super();
        e = a.a;
        f = new ak(new gt(), s, l1, flag);
        g = l2;
        if (Runtime.getRuntime().availableProcessors() > 1)
        {
            i1 = 2;
        }
        h = i1;
    }

    private void a(ae ae1, ah ah1)
    {
        while (ae1 == null || ah1 == null || ah1.equals(ae1.b())) 
        {
            return;
        }
        gd.a(3, b, (new StringBuilder()).append("Asset status changed for asset:").append(ae1.a()).append(" from:").append(ae1.b()).append(" to:").append(ah1).toString());
        ae1.a(ah1);
        ad ad1 = new ad();
        ad1.a = ae1.a();
        ad1.b = ah1;
        ad1.b();
    }

    static void a(z z1)
    {
        z1.o();
    }

    static void a(z z1, ae ae1)
    {
        z1.f(ae1);
    }

    static void a(z z1, ae ae1, ah ah1)
    {
        z1.a(ae1, ah1);
    }

    private void b(ae ae1)
    {
        while (ae1 == null || TextUtils.isEmpty(ae1.a()) || a.containsKey(ae1.a())) 
        {
            return;
        }
        gd.a(3, b, (new StringBuilder()).append("Precaching: adding cached asset info from persisted storage: ").append(ae1.a()).append(" asset exp: ").append(ae1.c()).append(" saved time: ").append(ae1.f()).toString());
        synchronized (a)
        {
            a.put(ae1.a(), ae1);
        }
        return;
        ae1;
        map;
        JVM INSTR monitorexit ;
        throw ae1;
    }

    static void b(z z1)
    {
        z1.m();
    }

    static Map c(z z1)
    {
        return z1.d;
    }

    private void c(ae ae1)
    {
        ah ah1;
        while (ae1 == null || ah.d.equals(ah1 = d(ae1))) 
        {
            return;
        }
        if (ah.c.equals(ah1) || ah.b.equals(ah1))
        {
            synchronized (c)
            {
                if (!c.containsKey(ae1.a()))
                {
                    c.put(ae1.a(), ae1);
                }
            }
        } else
        {
            gd.a(3, b, (new StringBuilder()).append("Precaching: Queueing asset:").append(ae1.a()).toString());
            com.flurry.sdk.f.a().a("precachingDownloadRequested", 1);
            a(ae1, ah.b);
            synchronized (c)
            {
                c.put(ae1.a(), ae1);
            }
        }
        fp.a().b(new hq() {

            final z a;

            public void safeRun()
            {
                z.b(a);
            }

            
            {
                a = z.this;
                super();
            }
        });
        return;
        ae1;
        map;
        JVM INSTR monitorexit ;
        throw ae1;
        ae1;
        map1;
        JVM INSTR monitorexit ;
        throw ae1;
    }

    private ae d(String s)
    {
        while (!a() || TextUtils.isEmpty(s)) 
        {
            return null;
        }
        ae ae1;
        synchronized (a)
        {
            ae1 = (ae)a.get(s);
        }
        s = ae1;
        if (ae1 != null)
        {
            if (ae1.d())
            {
                gd.a(3, b, (new StringBuilder()).append("Precaching: expiring cached asset: ").append(ae1.a()).append(" asset exp: ").append(ae1.c()).append(" device epoch").append(System.currentTimeMillis()).toString());
                a(ae1.a());
                s = null;
            } else
            {
                d(ae1);
                ae1.e();
                s = ae1;
            }
        }
        return s;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    private ah d(ae ae1)
    {
        if (ae1 == null)
        {
            return ah.a;
        }
        if (ae1.d())
        {
            return ah.a;
        }
        if (ah.d.equals(ae1.b()) && !f.d(ae1.a()))
        {
            a(ae1, ah.f);
        }
        return ae1.b();
    }

    private void e(ae ae1)
    {
        com.flurry.sdk.f.a().a("precachingDownloadStarted", 1);
        gd.a(3, b, (new StringBuilder()).append("Precaching: Submitting for download: ").append(ae1.a()).toString());
        am am1 = new am(f, ae1.a());
        am1.a(ae1.a());
        am1.a(40000);
        am1.a(f);
        am1.a(new ai.a(ae1) {

            final ae a;
            final z b;

            public void a(ai ai1)
            {
                synchronized (z.c(b))
                {
                    z.c(b).remove(a.a());
                }
                z.a(b, a);
                if (ai1.a())
                {
                    long l1 = ai1.c();
                    gd.a(3, z.l(), (new StringBuilder()).append("Precaching: Download success: ").append(a.a()).append(" size: ").append(l1).toString());
                    a.a(l1);
                    z.a(b, a, ah.d);
                    com.flurry.sdk.f.a().a("precachingDownloadSuccess", 1);
                } else
                {
                    gd.a(3, z.l(), (new StringBuilder()).append("Precaching: Download error: ").append(a.a()).toString());
                    z.a(b, a, ah.g);
                    com.flurry.sdk.f.a().a("precachingDownloadError", 1);
                }
                fp.a().b(new hq(this) {

                    final _cls4 a;

                    public void safeRun()
                    {
                        z.b(a.b);
                    }

            
            {
                a = _pcls4;
                super();
            }
                });
                return;
                ai1;
                map1;
                JVM INSTR monitorexit ;
                throw ai1;
            }

            
            {
                b = z.this;
                a = ae1;
                super();
            }
        });
        am1.d();
        synchronized (d)
        {
            d.put(ae1.a(), am1);
        }
        a(ae1, ah.c);
        return;
        ae1;
        map;
        JVM INSTR monitorexit ;
        throw ae1;
    }

    private void f(ae ae1)
    {
        if (ae1 == null)
        {
            return;
        }
        synchronized (c)
        {
            c.remove(ae1.a());
        }
        return;
        ae1;
        map;
        JVM INSTR monitorexit ;
        throw ae1;
    }

    static String l()
    {
        return b;
    }

    private void m()
    {
        if (!b())
        {
            return;
        }
        gd.a(3, b, "Precaching: Download files");
        Map map = c;
        map;
        JVM INSTR monitorenter ;
        Iterator iterator = c.values().iterator();
_L3:
        ae ae1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_176;
        }
        ae1 = (ae)iterator.next();
        if (!f.d(ae1.a())) goto _L2; else goto _L1
_L1:
        gd.a(3, b, (new StringBuilder()).append("Precaching: Asset already cached.  Skipping download:").append(ae1.a()).toString());
        iterator.remove();
        a(ae1, ah.d);
          goto _L3
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        if (ah.c.equals(d(ae1))) goto _L3; else goto _L4
_L4:
        if (fn.a().b(this) < (long)h)
        {
            break MISSING_BLOCK_LABEL_168;
        }
        gd.a(3, b, "Precaching: Download limit reached");
        map;
        JVM INSTR monitorexit ;
        return;
        e(ae1);
          goto _L3
        map;
        JVM INSTR monitorexit ;
        gd.a(3, b, "Precaching: No more files to download");
        return;
    }

    private void n()
    {
        gd.a(3, b, "Precaching: Cancelling in-progress downloads");
        Map map = d;
        map;
        JVM INSTR monitorenter ;
        for (Iterator iterator = d.entrySet().iterator(); iterator.hasNext(); ((ai)((java.util.Map.Entry)iterator.next()).getValue()).e()) { }
        break MISSING_BLOCK_LABEL_69;
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
        d.clear();
        map;
        JVM INSTR monitorexit ;
        map = c;
        map;
        JVM INSTR monitorenter ;
        Iterator iterator1 = c.entrySet().iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            ae ae1 = (ae)((java.util.Map.Entry)iterator1.next()).getValue();
            if (!ah.d.equals(d(ae1)))
            {
                gd.a(3, b, (new StringBuilder()).append("Precaching: Download cancelled: ").append(ae1.f()).toString());
                a(ae1, ah.e);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_189;
        iterator1;
        map;
        JVM INSTR monitorexit ;
        throw iterator1;
        map;
        JVM INSTR monitorexit ;
    }

    private void o()
    {
        Iterator iterator = j().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ae ae1 = (ae)iterator.next();
            if (!ah.d.equals(d(ae1)))
            {
                gd.a(3, b, (new StringBuilder()).append("Precaching: expiring cached asset: ").append(ae1.a()).append(" asset exp: ").append(ae1.c()).append(" device epoch: ").append(System.currentTimeMillis()).toString());
                a(ae1.a());
            }
        } while (true);
    }

    public void a(ae ae1)
    {
        this;
        JVM INSTR monitorenter ;
        b(ae1);
        this;
        JVM INSTR monitorexit ;
        return;
        ae1;
        throw ae1;
    }

    public void a(String s)
    {
        while (!a() || TextUtils.isEmpty(s)) 
        {
            return;
        }
        synchronized (a)
        {
            a.remove(s);
        }
        f.c(s);
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    public boolean a()
    {
        this;
        JVM INSTR monitorenter ;
        if (a.b.equals(e)) goto _L2; else goto _L1
_L1:
        boolean flag = a.c.equals(e);
        if (!flag) goto _L3; else goto _L2
_L2:
        flag = true;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L3:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    public boolean a(String s, an an1, long l1)
    {
        ae ae1;
        while (!a() || TextUtils.isEmpty(s) || an1 == null || !an.c.equals(an1) && !an.b.equals(an1)) 
        {
            return false;
        }
        ae1 = d(s);
        if (ae1 != null) goto _L2; else goto _L1
_L1:
        an1 = new ae(s, an1, l1);
        synchronized (a)
        {
            a.put(an1.a(), an1);
        }
        c(an1);
_L4:
        return true;
        an1;
        s;
        JVM INSTR monitorexit ;
        throw an1;
_L2:
        if (!ah.d.equals(d(ae1)))
        {
            c(ae1);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public ah b(String s)
    {
        if (!a())
        {
            return ah.a;
        } else
        {
            return d(d(s));
        }
    }

    public boolean b()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a.b.equals(e);
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public al.b c(String s)
    {
        while (!a() || TextUtils.isEmpty(s)) 
        {
            return null;
        }
        return f.a(s);
    }

    public boolean c()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a.c.equals(e);
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public List d()
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist = new ArrayList();
        synchronized (a)
        {
            arraylist.addAll(a.values());
        }
        this;
        JVM INSTR monitorexit ;
        return arraylist;
        exception1;
        map;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void e()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = b();
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        gd.a(3, b, "Precaching: Starting AssetCache");
        f.a();
        fp.a().b(new hq() {

            final z a;

            public void safeRun()
            {
                z.a(a);
                z.b(a);
            }

            
            {
                a = z.this;
                super();
            }
        });
        e = a.b;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void f()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a();
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        gd.a(3, b, "Precaching: Stopping AssetCache");
        n();
        f.b();
        e = a.a;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void g()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a();
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (c())
        {
            gd.a(3, b, "Precaching: Resuming AssetCache");
            fp.a().b(new hq() {

                final z a;

                public void safeRun()
                {
                    z.a(a);
                    z.b(a);
                }

            
            {
                a = z.this;
                super();
            }
            });
            e = a.b;
        }
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void h()
    {
        if (!a())
        {
            return;
        }
        for (Iterator iterator = j().iterator(); iterator.hasNext(); a(((ae)iterator.next()).a())) { }
        f.c();
    }

    public void i()
    {
        if (a())
        {
            Iterator iterator = j().iterator();
            while (iterator.hasNext()) 
            {
                d((ae)iterator.next());
            }
        }
    }

    public List j()
    {
        ArrayList arraylist;
        synchronized (a)
        {
            arraylist = new ArrayList(a.values());
        }
        return arraylist;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public List k()
    {
        i();
        return j();
    }


    private class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        private static final a d[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/flurry/sdk/z$a, s);
        }

        public static a[] values()
        {
            return (a[])d.clone();
        }

        static 
        {
            a = new a("INIT", 0);
            b = new a("ACTIVE", 1);
            c = new a("PAUSED", 2);
            d = (new a[] {
                a, b, c
            });
        }

        private a(String s, int i1)
        {
            super(s, i1);
        }
    }

}
