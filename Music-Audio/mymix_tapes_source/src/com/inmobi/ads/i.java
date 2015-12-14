// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import com.inmobi.commons.core.c.a;
import com.inmobi.commons.core.configs.b;
import com.inmobi.commons.core.utilities.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.inmobi.ads:
//            b, AdUnit, q, p, 
//            n, InMobiAdRequestStatus

public final class i
    implements com.inmobi.commons.core.configs.b.b
{
    private class a
        implements AdUnit.a
    {

        final i a;
        private p b;

        public void a()
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, i.d(), "onAdLoadSucceeded called");
        }

        public void a(InMobiAdRequestStatus inmobiadrequeststatus)
        {
            synchronized (a)
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, i.d(), (new StringBuilder()).append("onAdLoadFailed called. Status:").append(inmobiadrequeststatus.getMessage()).toString());
                i.e().remove(b);
            }
            if (inmobiadrequeststatus.getStatusCode() == InMobiAdRequestStatus.StatusCode.NO_FILL)
            {
                inmobiadrequeststatus = new HashMap();
                inmobiadrequeststatus.put("type", b.e());
                com.inmobi.commons.core.c.a.a().a("ads", "PreLoadServerNoFill", inmobiadrequeststatus);
            }
            return;
            inmobiadrequeststatus;
            i1;
            JVM INSTR monitorexit ;
            throw inmobiadrequeststatus;
        }

        public void a(Map map)
        {
        }

        public void b()
        {
        }

        public void b(Map map)
        {
        }

        public void c()
        {
        }

        public void d()
        {
        }

        a(p p1)
        {
            a = i.this;
            super();
            b = p1;
        }
    }


    private static final String a = com/inmobi/ads/i.getSimpleName();
    private static final Object b = new Object();
    private static volatile i c;
    private static Map d;
    private static com.inmobi.ads.b e;

    private i()
    {
        d = new HashMap();
        e = new com.inmobi.ads.b();
        com.inmobi.commons.core.configs.b.a().a(e, this);
        f();
        com.inmobi.commons.core.c.a.a().a(e.a(), e.m());
    }

    public static i a()
    {
        Object obj;
        obj = c;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        Object obj1 = b;
        obj1;
        JVM INSTR monitorenter ;
        i i1 = c;
        obj = i1;
        if (i1 != null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        obj = new i();
        c = ((i) (obj));
        obj1;
        JVM INSTR monitorexit ;
        return ((i) (obj));
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        return ((i) (obj));
    }

    public static String a(Map map)
    {
        if (map == null)
        {
            return null;
        } else
        {
            return (String)map.get("tp");
        }
    }

    static void a(i i1)
    {
        i1.g();
    }

    private void a(String s)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("type", s);
        com.inmobi.commons.core.c.a.a().a("ads", "PreLoadCacheHit", hashmap);
    }

    private void a(String s, String s1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("errorCode", s);
        hashmap.put("type", s1);
        com.inmobi.commons.core.c.a.a().a("ads", "PreLoadCacheMiss", hashmap);
    }

    private boolean a(AdUnit adunit)
    {
        if (adunit.g() == AdUnit.AdState.STATE_LOADING)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "hasAdUnitExpired. Ad unit in loading state.");
        } else
        if (System.currentTimeMillis() - adunit.i() > e.a(adunit.a()).e() * 1000L)
        {
            return true;
        }
        return false;
    }

    private void c(p p1)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(p1);
        int i1 = com.inmobi.ads.q.a().a(arraylist, e.n().c());
        if (i1 > 0)
        {
            p1 = new HashMap();
            p1.put("count", Integer.valueOf(i1));
            com.inmobi.commons.core.c.a.a().a("ads", "PreLoadPidOverflow", p1);
        }
    }

    static String d()
    {
        return a;
    }

    static Map e()
    {
        return d;
    }

    private void f()
    {
        Application application = (Application)com.inmobi.commons.a.a.b();
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            application.registerComponentCallbacks(new ComponentCallbacks2() {

                final i a;

                public void onConfigurationChanged(Configuration configuration)
                {
                }

                public void onLowMemory()
                {
                }

                public void onTrimMemory(int i1)
                {
                    if (i1 == 80 || i1 == 15)
                    {
                        com.inmobi.ads.i.a(a);
                    }
                }

            
            {
                a = i.this;
                super();
            }
            });
            return;
        } else
        {
            application.registerComponentCallbacks(new ComponentCallbacks() {

                final i a;

                public void onConfigurationChanged(Configuration configuration)
                {
                }

                public void onLowMemory()
                {
                    com.inmobi.ads.i.a(a);
                }

            
            {
                a = i.this;
                super();
            }
            });
            return;
        }
    }

    private void g()
    {
        (new Handler(com.inmobi.commons.a.a.b().getMainLooper())).post(new Runnable() {

            final i a;

            public void run()
            {
                this;
                JVM INSTR monitorenter ;
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, i.d(), "Flushing ad unit cache due to low memory.");
                for (Iterator iterator = i.e().entrySet().iterator(); iterator.hasNext(); iterator.remove())
                {
                    ((AdUnit)((java.util.Map.Entry)iterator.next()).getValue()).t();
                }

                break MISSING_BLOCK_LABEL_70;
                Exception exception;
                exception;
                this;
                JVM INSTR monitorexit ;
                throw exception;
                this;
                JVM INSTR monitorexit ;
            }

            
            {
                a = i.this;
                super();
            }
        });
    }

    private void h()
    {
        int i1;
        if (e.n().b())
        {
            if ((i1 = com.inmobi.ads.q.a().a(e.n().a())) > 0)
            {
                HashMap hashmap = new HashMap();
                hashmap.put("count", Integer.valueOf(i1));
                com.inmobi.commons.core.c.a.a().a("ads", "PreLoadPidExpiry", hashmap);
                return;
            }
        }
    }

    private void i()
    {
        Iterator iterator = d.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            AdUnit adunit = (AdUnit)entry.getValue();
            if (a(adunit))
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("cleanUpExpiredCachedAdUnits. pid:").append(((p)entry.getKey()).c()).append(" tp:").append(((p)entry.getKey()).d()).toString());
                adunit.t();
                iterator.remove();
            }
        } while (true);
    }

    private void j()
    {
        if (e.n().b())
        {
            ArrayList arraylist = (ArrayList)l();
            int i1 = 0;
            while (i1 < arraylist.size()) 
            {
                b((p)arraylist.get(i1));
                i1++;
            }
        }
    }

    private void k()
    {
        if (d.size() >= e.n().c())
        {
            ArrayList arraylist = (ArrayList)com.inmobi.ads.q.a().b();
            Iterator iterator = d.entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                if (!arraylist.contains(entry.getKey()))
                {
                    ((AdUnit)entry.getValue()).t();
                    iterator.remove();
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Removing extra ad unit from ad unit cache. Pid:").append(((p)entry.getKey()).c()).append(" tp:").append(((p)entry.getKey()).d()).toString());
                }
            } while (true);
        }
    }

    private List l()
    {
        return com.inmobi.ads.q.a().b();
    }

    AdUnit a(p p1)
    {
        if (!e.n().b())
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("No cached ad unit found as config is disabled. pid:").append(p1.c()).append(" tp:").append(p1.d()).toString());
            return null;
        }
        this;
        JVM INSTR monitorenter ;
        AdUnit adunit;
        c(p1);
        adunit = (AdUnit)d.get(p1);
        if (adunit != null)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("No cached ad unit found for pid:").append(p1.c()).append(" tp:").append(p1.d()).toString());
        a("Other", p1.e());
        this;
        JVM INSTR monitorexit ;
        return null;
        if (!a(adunit))
        {
            break MISSING_BLOCK_LABEL_225;
        }
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Expired cached ad unit found for pid:").append(p1.c()).append(" tp:").append(p1.d()).toString());
        adunit.t();
        d.remove(p1);
        a("AdUnitExpired", p1.e());
        this;
        JVM INSTR monitorexit ;
        return null;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Cached ad unit found for pid:").append(p1.c()).append(" tp:").append(p1.d()).toString());
        d.remove(p1);
        a(p1.e());
        this;
        JVM INSTR monitorexit ;
        return adunit;
        p1;
        this;
        JVM INSTR monitorexit ;
        throw p1;
    }

    public void a(com.inmobi.commons.core.configs.a a1)
    {
        e = (com.inmobi.ads.b)a1;
        com.inmobi.commons.core.c.a.a().a(e.a(), e.m());
    }

    public void b()
    {
        h();
        i();
        j();
    }

    public void b(p p1)
    {
        k();
        if (e.n().b() && !d.containsKey(p1))
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("preLoadAdUnit. pid:").append(p1.c()).append(" tp:").append(p1.d()).toString());
            if (p1.a() == null && p1.d() != null)
            {
                HashMap hashmap = new HashMap();
                hashmap.put("tp", p1.d());
                p1.a(hashmap);
            }
            n n1 = new n(com.inmobi.commons.a.a.b(), p1.c(), new a(p1));
            n1.a(p1.b());
            n1.a(p1.a());
            n1.a(true);
            d.put(p1, n1);
            n1.o();
            p1 = new HashMap();
            p1.put("type", n1.a());
            com.inmobi.commons.core.c.a.a().a("ads", "AdPreLoadRequested", p1);
        }
    }

    public void c()
    {
        h();
        i();
    }

}
