// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.content.Context;
import android.graphics.Point;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.applovin.impl.sdk:
//            bv, dg, cb, bw, 
//            AppLovinSdkImpl, q, cr, cq, 
//            n, r, t, m, 
//            a, dh, u, s, 
//            bz, cv, w, c, 
//            db, dd, cn, cx

class cm extends bv
    implements dg
{

    private final AppLovinAdSize a;
    private final AppLovinAdType b;
    private final AppLovinAdLoadListener c;
    private boolean d;

    cm(AppLovinAdSize applovinadsize, AppLovinAdType applovinadtype, AppLovinAdLoadListener applovinadloadlistener, AppLovinSdkImpl applovinsdkimpl)
    {
        super("FetchNextAd", applovinsdkimpl);
        d = false;
        a = applovinadsize;
        b = applovinadtype;
        c = applovinadloadlistener;
    }

    private void a(cb cb1)
    {
        long l = cb1.b("ad_session_start");
        if (System.currentTimeMillis() - l > (long)((Integer)f.a(bw.x)).intValue() * 60000L)
        {
            cb1.b("ad_session_start", System.currentTimeMillis());
            cb1.c("ad_imp_session");
        }
    }

    static void a(cm cm1, int k)
    {
        cm1.b(k);
    }

    static void a(cm cm1, JSONObject jsonobject)
    {
        cm1.b(jsonobject);
    }

    private void b(int k)
    {
        g.e(e, (new StringBuilder()).append("Unable to fetch ").append(a).append(" ad: server returned ").append(k).toString());
        try
        {
            a(k);
        }
        catch (Throwable throwable)
        {
            g.userError(e, "Unable process a failure to recieve an ad", throwable);
        }
        q.b(k, f);
    }

    private void b(JSONObject jsonobject)
    {
        bv bv1 = a(jsonobject);
        f.a().a(bv1, cr.a);
        q.a(jsonobject, f);
    }

    private void d(Map map)
    {
        map.put("api_did", f.a(bw.c));
        map.put("sdk_key", f.getSdkKey());
        map.put("sdk_version", "6.1.4");
        String s1 = (String)f.a(bw.F);
        if (s1 != null && s1.length() > 0)
        {
            map.put("plugin_version", s1);
        }
        map.put("accept", g());
        map.put("v1", Boolean.toString(n.a("android.permission.WRITE_EXTERNAL_STORAGE", h)));
        map.put("v2", Boolean.toString(n.a(com/applovin/adview/AppLovinInterstitialActivity, h)));
        map.put("preloading", String.valueOf(d));
        map.put("size", a.getLabel());
        map.put("format", "json");
        map.put("ia", Long.toString(f.getDataCollector().b().d));
    }

    private void e(Map map)
    {
        if (((Boolean)f.a(bw.N)).booleanValue())
        {
            cb cb1 = f.b();
            map.put("li", String.valueOf(cb1.b("ad_imp")));
            map.put("si", String.valueOf(cb1.b("ad_imp_session")));
        }
    }

    private void f(Map map)
    {
        if (((Boolean)f.a(bw.N)).booleanValue())
        {
            Map map1 = ((m)f.getTargetingData()).a();
            if (map1 != null && !map1.isEmpty())
            {
                map.putAll(map1);
            }
        }
    }

    private String g()
    {
        String s2 = "custom_size,launch_app";
        String s1 = s2;
        if (n.b())
        {
            s1 = s2;
            if (n.a(com/applovin/adview/AppLovinInterstitialActivity, h))
            {
                s1 = (new StringBuilder()).append("custom_size,launch_app").append(",video").toString();
            }
        }
        return s1;
    }

    private void g(Map map)
    {
        Map map1 = com.applovin.impl.sdk.a.a(f);
        if (map1.isEmpty())
        {
            try
            {
                h(map1);
                com.applovin.impl.sdk.a.a(map1, f);
            }
            catch (Exception exception)
            {
                g.e(e, "Unable to populate device information", exception);
            }
        }
        map.putAll(map1);
        map.put("network", q.a(f));
        j(map);
        map.put("vz", dh.a(f.getApplicationContext().getPackageName(), f));
    }

    private void h(Map map)
    {
        u u1 = f.getDataCollector().a();
        map.put("brand", dh.c(u1.c));
        map.put("carrier", dh.c(u1.g));
        map.put("locale", u1.h.toString());
        map.put("model", dh.c(u1.a));
        map.put("os", dh.c(u1.b));
        map.put("platform", "android");
        map.put("revision", dh.c(u1.d));
        i(map);
    }

    private void i(Map map)
    {
        Point point = n.a(f.getApplicationContext());
        map.put("dx", Integer.toString(point.x));
        map.put("dy", Integer.toString(point.y));
    }

    private void j(Map map)
    {
        s s1 = f.getDataCollector().c();
        String s2 = s1.b;
        boolean flag = s1.a;
        if ((!flag || ((Boolean)f.getSettingsManager().a(bw.be)).booleanValue()) && AppLovinSdkUtils.isValidString(s2))
        {
            map.put("idfa", s2);
        }
        map.put("dnt", Boolean.toString(flag));
    }

    protected bv a(JSONObject jsonobject)
    {
        return new cv(jsonobject, c, f);
    }

    protected void a(int k)
    {
label0:
        {
            if (c != null)
            {
                if (!(c instanceof w))
                {
                    break label0;
                }
                ((w)c).a(new c(a, b), k);
            }
            return;
        }
        c.failedToReceiveAd(k);
    }

    protected void a(Map map)
    {
        f(map);
        g(map);
        e(map);
        d(map);
        b(map);
        c(map);
    }

    public void a(boolean flag)
    {
        d = flag;
    }

    void b()
    {
        super.b();
        b(-410);
    }

    protected void b(Map map)
    {
        if (b != null)
        {
            map.put("require", b.getLabel());
        }
    }

    String c()
    {
        HashMap hashmap = new HashMap();
        a(hashmap);
        String s1 = d();
        return (new StringBuilder()).append(s1).append("?").append(dh.a(hashmap)).toString();
    }

    protected void c(Map map)
    {
        Object obj = db.a().a("tFNA");
        if (obj != null)
        {
            map.put("etf", Long.toString(((dd) (obj)).b()));
            map.put("ntf", ((dd) (obj)).a());
        }
        obj = db.a().a("tRA");
        if (obj != null)
        {
            map.put("etr", Long.toString(((dd) (obj)).b()));
            map.put("ntr", ((dd) (obj)).a());
            if (((dd) (obj)).c())
            {
                obj = "1";
            } else
            {
                obj = "0";
            }
            map.put("fvr", obj);
        }
    }

    protected String d()
    {
        return q.b("2.0/ad", f);
    }

    public String e()
    {
        return "tFNA";
    }

    public boolean f()
    {
        return false;
    }

    public void run()
    {
        cb cb1;
        if (d)
        {
            g.d(e, "Preloading next ad...");
        } else
        {
            g.d(e, "Fetching next ad...");
        }
        cb1 = f.b();
        cb1.a("ad_req");
        a(cb1);
        try
        {
            cn cn1 = new cn(this, "RepeatFetchNextAd", bw.i, f);
            cn1.a(bw.l);
            cn1.run();
            return;
        }
        catch (Throwable throwable)
        {
            g.e(e, (new StringBuilder()).append("Unable to fetch ").append(a).append(" ad").toString(), throwable);
        }
        b(0);
    }
}
