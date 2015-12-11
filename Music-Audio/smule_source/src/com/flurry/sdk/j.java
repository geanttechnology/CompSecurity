// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import com.flurry.android.FlurryAdListener;
import com.flurry.android.ICustomAdNetworkHandler;
import java.lang.ref.WeakReference;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            e, hg

public class j
{

    private static j a;
    private static final String b = com/flurry/sdk/j.getSimpleName();
    private WeakReference c;
    private ICustomAdNetworkHandler d;
    private final e e = new e();
    private volatile String f;
    private volatile String g;
    private volatile boolean h;

    private j()
    {
        c = new WeakReference(null);
        d = null;
        f = null;
        g = null;
        h = false;
    }

    public static j a()
    {
        com/flurry/sdk/j;
        JVM INSTR monitorenter ;
        j j1;
        if (a == null)
        {
            a = new j();
        }
        j1 = a;
        com/flurry/sdk/j;
        JVM INSTR monitorexit ;
        return j1;
        Exception exception;
        exception;
        throw exception;
    }

    private boolean j()
    {
        return ((Boolean)hg.a().a("UseHttps")).booleanValue();
    }

    public void a(FlurryAdListener flurryadlistener)
    {
        c = new WeakReference(flurryadlistener);
    }

    public void a(ICustomAdNetworkHandler icustomadnetworkhandler)
    {
        d = icustomadnetworkhandler;
    }

    public void a(String s)
    {
        e.setFixedAdId(s);
    }

    public void a(Map map)
    {
        e.setUserCookies(map);
    }

    public void a(boolean flag)
    {
        e.setEnableTestAds(flag);
    }

    public FlurryAdListener b()
    {
        return (FlurryAdListener)c.get();
    }

    public void b(String s)
    {
        f = s;
    }

    public void b(Map map)
    {
        e.setKeywords(map);
    }

    public ICustomAdNetworkHandler c()
    {
        return d;
    }

    public void c(String s)
    {
        g = s;
    }

    public e d()
    {
        return e;
    }

    public void e()
    {
        e.clearUserCookies();
    }

    public void f()
    {
        e.clearUserCookies();
    }

    public String g()
    {
        if (f != null)
        {
            return (new StringBuilder()).append(f).append("/v12/getAds.do").toString();
        }
        if (j())
        {
            return "https://ads.flurry.com/v12/getAds.do";
        } else
        {
            return "http://ads.flurry.com/v12/getAds.do";
        }
    }

    public String h()
    {
        if (g != null)
        {
            return g;
        }
        if (j())
        {
            return "https://adlog.flurry.com";
        } else
        {
            return "http://adlog.flurry.com";
        }
    }

    public String i()
    {
        return (new StringBuilder()).append(h()).append("/v2/postAdLog.do").toString();
    }

}
