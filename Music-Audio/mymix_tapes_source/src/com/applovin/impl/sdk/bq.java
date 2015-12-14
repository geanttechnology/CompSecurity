// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.sdk.AppLovinLogger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.applovin.impl.sdk:
//            w, AppLovinSdkImpl, br, bw, 
//            cr, cq, c, bv, 
//            ay

abstract class bq
    implements w, AppLovinNativeAdLoadListener
{

    protected final AppLovinSdkImpl a;
    protected final AppLovinLogger b;
    protected final Object c = new Object();
    protected final Map d = a();
    protected final Map e = new HashMap();
    protected final Set f = new HashSet();

    bq(AppLovinSdkImpl applovinsdkimpl)
    {
        a = applovinsdkimpl;
        b = applovinsdkimpl.getLogger();
    }

    private br h(c c1)
    {
        return (br)d.get(c1);
    }

    abstract bv a(c c1);

    abstract c a(ay ay);

    abstract Map a();

    abstract void a(Object obj, ay ay);

    abstract void a(Object obj, c c1, int i);

    public boolean a(c c1, Object obj)
    {
        Object obj1 = c;
        obj1;
        JVM INSTR monitorenter ;
        if (g(c1)) goto _L2; else goto _L1
_L1:
        b(c1, obj);
        boolean flag = true;
_L4:
        obj1;
        JVM INSTR monitorexit ;
        return flag;
        c1;
        obj1;
        JVM INSTR monitorexit ;
        throw c1;
_L2:
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public ay b(c c1)
    {
        synchronized (c)
        {
            c1 = h(c1).e();
        }
        return c1;
        c1;
        obj;
        JVM INSTR monitorexit ;
        throw c1;
    }

    void b(ay ay)
    {
        f(a(ay));
    }

    protected void b(c c1, int i)
    {
        Object obj1;
        b.d("PreloadManager", (new StringBuilder()).append("Failed to pre-load an ad of spec ").append(c1).append(", error code ").append(i).toString());
        synchronized (c)
        {
            obj1 = e.remove(c1);
            f.add(c1);
        }
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        a(obj1, c1, i);
        return;
        c1;
        obj;
        JVM INSTR monitorexit ;
        throw c1;
        c1;
        a.getLogger().userError("PreloadManager", "Encountered exception while invoking user callback", c1);
        return;
    }

    public void b(c c1, Object obj)
    {
        synchronized (c)
        {
            if (e.containsKey(c1))
            {
                b.w("PreloadManager", "Possibly missing prior registered preload callback.");
            }
            e.put(c1, obj);
        }
        return;
        c1;
        obj1;
        JVM INSTR monitorexit ;
        throw c1;
    }

    protected void c(ay ay)
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        c c1;
        Object obj1;
        c1 = a(ay);
        obj1 = e.get(c1);
        e.remove(c1);
        f.add(c1);
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        h(c1).a(ay);
        b.d("PreloadManager", (new StringBuilder()).append("Ad enqueued: ").append(ay).toString());
_L1:
        obj;
        JVM INSTR monitorexit ;
        if (obj1 != null)
        {
            b.d("PreloadManager", (new StringBuilder()).append("Called additional callback regarding ").append(ay).toString());
            try
            {
                a(obj1, ay);
            }
            catch (Throwable throwable)
            {
                a.getLogger().userError("PreloadManager", "Encountered throwable while notifying user callback", throwable);
            }
            b(ay);
        }
        b.d("PreloadManager", (new StringBuilder()).append("Pulled ad from network and saved to preload cache: ").append(ay).toString());
        return;
        b.d("PreloadManager", "Additional callback found, skipping enqueue.");
          goto _L1
        ay;
        obj;
        JVM INSTR monitorexit ;
        throw ay;
    }

    public boolean c(c c1)
    {
        boolean flag;
        synchronized (c)
        {
            flag = h(c1).c();
        }
        return flag;
        c1;
        obj;
        JVM INSTR monitorexit ;
        throw c1;
    }

    public void d(c c1)
    {
        int j;
        synchronized (c)
        {
            br br1 = h(c1);
            j = br1.b() - br1.a();
        }
        if (j > 0)
        {
            for (int i = 0; i < j; i++)
            {
                f(c1);
            }

        }
        break MISSING_BLOCK_LABEL_60;
        c1;
        obj;
        JVM INSTR monitorexit ;
        throw c1;
    }

    public boolean e(c c1)
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        if (!h(c1).d())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        c1;
        obj;
        JVM INSTR monitorexit ;
        throw c1;
    }

    public void f(c c1)
    {
        if (((Boolean)a.a(bw.G)).booleanValue() && !c(c1))
        {
            b.d("PreloadManager", (new StringBuilder()).append("Preloading ad for spec ").append(c1).append("...").toString());
            a.a().a(a(c1), cr.a, 500L);
        }
    }

    boolean g(c c1)
    {
        boolean flag;
        synchronized (c)
        {
            flag = f.contains(c1);
        }
        return flag;
        c1;
        obj;
        JVM INSTR monitorexit ;
        throw c1;
    }
}
