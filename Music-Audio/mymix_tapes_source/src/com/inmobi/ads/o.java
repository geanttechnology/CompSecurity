// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.c.e;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.d;
import com.inmobi.rendering.RenderView;
import com.inmobi.rendering.a.c;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.ads:
//            AdUnit, InMobiNative, m, a, 
//            b, InMobiAdRequestStatus

class o extends AdUnit
{

    private static final String a = com/inmobi/ads/o.getSimpleName();
    private Map b;
    private WeakHashMap c;
    private String d;
    private String e;
    private m f;
    private URL g;
    private String h;
    private int i;
    private long j;

    public o(long l, AdUnit.a a1)
    {
        super(com.inmobi.commons.a.a.b(), l, a1);
        b = new HashMap();
        c = new WeakHashMap();
        i = 0;
        j = 0L;
    }

    private String b(Map map)
    {
        com.inmobi.commons.core.utilities.d.a(map);
        if (map == null || map.isEmpty())
        {
            return (new StringBuilder()).append(e).append("recordEvent(8)").toString();
        } else
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append((new StringBuilder()).append(e).append("recordEvent(8, ").toString());
            stringbuilder.append((new JSONObject(map)).toString());
            stringbuilder.append(");");
            return stringbuilder.toString();
        }
    }

    void A()
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Impression record requested for Ad unit (").append(hashCode()).append(")").toString());
        if (AdUnit.AdState.STATE_ATTACHED == g())
        {
            a(AdUnit.AdState.STATE_RENDERED);
            String s = (new StringBuilder()).append(e).append("recordEvent(18)").toString();
            n().b(s);
            if (h != null)
            {
                n().b(h);
            }
            if (g != null)
            {
                com.inmobi.rendering.a.c.a().a(g.toExternalForm(), true);
            }
        }
    }

    void B()
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Open landing page requested");
        com.inmobi.commons.core.c.a.a().a(new e("ads", "OpenLandingPage"));
        if (AdUnit.AdState.STATE_RENDERED == g() || AdUnit.AdState.STATE_ATTACHED == g())
        {
            String s = (new StringBuilder()).append(e).append("openLandingPage()").toString();
            n().b(s);
        }
    }

    protected String a()
    {
        return "native";
    }

    public void a(View view)
    {
        if (view != null && AdUnit.AdState.STATE_ATTACHED == g())
        {
            a(AdUnit.AdState.STATE_LOADED);
            InMobiNative.sMappedAdUnits.remove(view);
            f.a(view);
            b.remove(this);
            view = (o)c.remove(view);
            if (view != null)
            {
                view.a(AdUnit.AdState.STATE_LOADED);
                b.remove(view);
                return;
            }
        }
    }

    public void a(View view, URL url, String s)
    {
        boolean flag1 = true;
        Object obj = new HashMap();
        boolean flag;
        if (s != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((Map) (obj)).put("customScript", Boolean.valueOf(flag));
        if (url != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        ((Map) (obj)).put("customUrl", Boolean.valueOf(flag));
        com.inmobi.commons.core.c.a.a().a("ads", "TrackImpression", ((Map) (obj)));
        obj = (WeakReference)b.get(this);
        if (obj != null)
        {
            obj = (View)((WeakReference) (obj)).get();
        } else
        {
            obj = null;
        }
        if (!view.equals(obj))
        {
            if (AdUnit.AdState.STATE_LOADED == g() || AdUnit.AdState.STATE_ATTACHED == g())
            {
                a(((View) (obj)));
                a(view);
                b.put(this, new WeakReference(view));
                c.put(view, this);
                g = url;
                h = s;
                f.a(view, this);
                a(AdUnit.AdState.STATE_ATTACHED);
            } else
            if (g() != AdUnit.AdState.STATE_RENDERED && g() != AdUnit.AdState.STATE_ACTIVE)
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, a, "Please wait for the ad to finish loading before making a call to bind.");
                return;
            }
        }
    }

    public void a(com.inmobi.ads.a a1)
    {
        super.a(a1);
        if (AdUnit.AdState.STATE_AVAILABLE == g())
        {
            b(d);
        }
    }

    void a(Map map, URL url, String s)
    {
        boolean flag1 = false;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Click record requested");
        HashMap hashmap = new HashMap();
        boolean flag;
        if (s != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hashmap.put("customScript", Boolean.valueOf(flag));
        flag = flag1;
        if (url != null)
        {
            flag = true;
        }
        hashmap.put("customUrl", Boolean.valueOf(flag));
        com.inmobi.commons.core.c.a.a().a("ads", "ReportClick", hashmap);
        if (AdUnit.AdState.STATE_ATTACHED == g() || AdUnit.AdState.STATE_RENDERED == g())
        {
            map = b(map);
            n().b(map);
            if (s != null)
            {
                n().b(s);
            }
            if (url != null)
            {
                com.inmobi.rendering.a.c.a().a(url.toExternalForm(), true);
            }
            return;
        } else
        {
            com.inmobi.commons.core.c.a.a().a(new e("ads", "InvalidClickReport"));
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, a, "reportAdClick call made in wrong state");
            return;
        }
    }

    public boolean b(com.inmobi.ads.a a1)
    {
        if (super.b(a1)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        a1 = new JSONObject(a1.b());
        d = a1.getString("contextCode");
        e = a1.getString("namespace");
        if (d == null || d.trim().length() == 0 || e == null) goto _L1; else goto _L3
_L3:
        int k = e.trim().length();
        if (k != 0)
        {
            return true;
        }
          goto _L1
        a1;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Exception while parsing ad.", a1);
        return false;
    }

    protected String c()
    {
        return null;
    }

    public void c(RenderView renderview)
    {
        super.c(renderview);
        if (AdUnit.AdState.STATE_AVAILABLE == g())
        {
            u();
            a(AdUnit.AdState.STATE_LOADED);
            w();
            m().a();
            r();
        }
    }

    protected com.inmobi.rendering.RenderingProperties.PlacementType d()
    {
        return com.inmobi.rendering.RenderingProperties.PlacementType.INLINE;
    }

    public void e(RenderView renderview)
    {
        super.e(renderview);
        if (AdUnit.AdState.STATE_RENDERED == g() || AdUnit.AdState.STATE_ATTACHED == g())
        {
            i = i + 1;
            a(AdUnit.AdState.STATE_ACTIVE);
            m().b();
        } else
        if (g() == AdUnit.AdState.STATE_ACTIVE)
        {
            i = i + 1;
            return;
        }
    }

    public void f(RenderView renderview)
    {
        super.f(renderview);
        if (AdUnit.AdState.STATE_ACTIVE == g())
        {
            i = i - 1;
            if (i == 0)
            {
                a(AdUnit.AdState.STATE_RENDERED);
                renderview = new HashMap();
                renderview.put("type", a());
                renderview.put("impId", j());
                com.inmobi.commons.core.c.a.a().a("ads", "AdRendered", renderview);
                m().c();
            }
        }
    }

    public void o()
    {
        if (j != 0L)
        {
            int k = l().f();
            if (SystemClock.elapsedRealtime() - j < (long)(k * 1000))
            {
                a((new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.EARLY_REFRESH_REQUEST)).setCustomMessage((new StringBuilder()).append("Ad cannot be refreshed before ").append(k).append(" seconds").toString()), false);
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, a, (new StringBuilder()).append("Ad cannot be refreshed before ").append(k).append(" seconds").toString());
                return;
            }
        }
        j = SystemClock.elapsedRealtime();
        super.o();
        f = new m(l().l());
    }

    protected void t()
    {
        k();
        b.clear();
        c.clear();
        if (f != null)
        {
            f.b();
        }
        h = null;
        g = null;
        if (n() != null && n().getParent() != null)
        {
            ((ViewGroup)n().getParent()).removeView(n());
        }
        super.t();
    }

    public void x()
    {
        if (AdUnit.AdState.STATE_ATTACHED == g())
        {
            Object obj = (WeakReference)b.get(this);
            if (obj != null)
            {
                obj = (View)((WeakReference) (obj)).get();
                if (f != null && obj != null)
                {
                    f.a(((View) (obj)), this);
                }
            }
        }
    }

    public void y()
    {
        if (AdUnit.AdState.STATE_ATTACHED == g())
        {
            Object obj = (WeakReference)b.get(this);
            if (obj != null)
            {
                obj = (View)((WeakReference) (obj)).get();
                if (f != null && obj != null)
                {
                    f.a(((View) (obj)));
                }
            }
        }
    }

    public Object z()
    {
        return h();
    }

}
