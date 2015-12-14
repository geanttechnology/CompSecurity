// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.content.Context;
import android.os.SystemClock;
import android.util.Base64;
import android.view.ViewGroup;
import com.inmobi.commons.core.c.a;
import com.inmobi.commons.core.configs.b;
import com.inmobi.commons.core.configs.f;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.uid.c;
import com.inmobi.commons.core.utilities.uid.d;
import com.inmobi.rendering.RenderView;
import com.inmobi.rendering.RenderingProperties;
import com.inmobi.signals.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.ads:
//            b, r, h, InMobiAdRequestStatus, 
//            g, a

abstract class AdUnit
    implements g.a, com.inmobi.commons.core.configs.b.b, com.inmobi.rendering.RenderView.b
{
    public static final class AdState extends Enum
    {

        private static final AdState $VALUES[];
        public static final AdState STATE_ACTIVE;
        public static final AdState STATE_ATTACHED;
        public static final AdState STATE_AVAILABLE;
        public static final AdState STATE_CREATED;
        public static final AdState STATE_FAILED;
        public static final AdState STATE_LOADED;
        public static final AdState STATE_LOADING;
        public static final AdState STATE_READY;
        public static final AdState STATE_RENDERED;

        public static AdState valueOf(String s1)
        {
            return (AdState)Enum.valueOf(com/inmobi/ads/AdUnit$AdState, s1);
        }

        public static AdState[] values()
        {
            return (AdState[])$VALUES.clone();
        }

        static 
        {
            STATE_CREATED = new AdState("STATE_CREATED", 0);
            STATE_LOADING = new AdState("STATE_LOADING", 1);
            STATE_AVAILABLE = new AdState("STATE_AVAILABLE", 2);
            STATE_FAILED = new AdState("STATE_FAILED", 3);
            STATE_LOADED = new AdState("STATE_LOADED", 4);
            STATE_READY = new AdState("STATE_READY", 5);
            STATE_ATTACHED = new AdState("STATE_ATTACHED", 6);
            STATE_RENDERED = new AdState("STATE_RENDERED", 7);
            STATE_ACTIVE = new AdState("STATE_ACTIVE", 8);
            $VALUES = (new AdState[] {
                STATE_CREATED, STATE_LOADING, STATE_AVAILABLE, STATE_FAILED, STATE_LOADED, STATE_READY, STATE_ATTACHED, STATE_RENDERED, STATE_ACTIVE
            });
        }

        private AdState(String s1, int i1)
        {
            super(s1, i1);
        }
    }

    static interface a
    {

        public abstract void a();

        public abstract void a(InMobiAdRequestStatus inmobiadrequeststatus);

        public abstract void a(Map map);

        public abstract void b();

        public abstract void b(Map map);

        public abstract void c();

        public abstract void d();
    }


    private static final String a = com/inmobi/ads/AdUnit.getSimpleName();
    private AdState b;
    private Context c;
    private long d;
    private String e;
    private Map f;
    private com.inmobi.ads.b g;
    private String h;
    private String i;
    private long j;
    private boolean k;
    private a l;
    private RenderView m;
    private r n;
    private long o;
    private long p;

    public AdUnit(Context context, long l1, a a1)
    {
        k = false;
        p = 0L;
        c = context;
        d = l1;
        l = a1;
        x();
        a(AdState.STATE_CREATED);
    }

    private void x()
    {
        g = new com.inmobi.ads.b();
        com.inmobi.commons.core.configs.b.a().a(new f(), null);
        com.inmobi.commons.core.configs.b.a().a(g, this);
        n = new r(this);
        com.inmobi.commons.core.c.a.a().a(g.a(), g.m());
    }

    private h y()
    {
        h h1 = new h();
        h1.b(e);
        h1.a(f);
        h1.a(d);
        h1.c(a());
        h1.a(l().a(a()));
        h1.b(e());
        h1.d(b());
        h1.a(g.e());
        h1.a(g.h());
        h1.e(c());
        h1.a(new d(g.o().a()));
        return h1;
    }

    private void z()
    {
        u();
        n.sendEmptyMessageDelayed(0, l().j().i() * 1000);
    }

    protected abstract String a();

    protected void a(AdState adstate)
    {
        b = adstate;
    }

    final void a(a a1)
    {
        l = a1;
    }

    public void a(InMobiAdRequestStatus inmobiadrequeststatus)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Ad fetch failed. Status:").append(inmobiadrequeststatus.getStatusCode()).toString());
        a(inmobiadrequeststatus, true);
        if (inmobiadrequeststatus.getStatusCode() == InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR)
        {
            c("InternalError");
        }
    }

    protected void a(InMobiAdRequestStatus inmobiadrequeststatus, boolean flag)
    {
        if (g() == AdState.STATE_LOADING && flag)
        {
            a(AdState.STATE_FAILED);
        }
        m().a(inmobiadrequeststatus);
        if (inmobiadrequeststatus.getStatusCode() == InMobiAdRequestStatus.StatusCode.NO_FILL)
        {
            c("NoFill");
        } else
        {
            if (inmobiadrequeststatus.getStatusCode() == InMobiAdRequestStatus.StatusCode.SERVER_ERROR)
            {
                c("ServerError");
                return;
            }
            if (inmobiadrequeststatus.getStatusCode() == InMobiAdRequestStatus.StatusCode.NETWORK_UNREACHABLE)
            {
                c("NetworkUnreachable");
                return;
            }
            if (inmobiadrequeststatus.getStatusCode() == InMobiAdRequestStatus.StatusCode.AD_ACTIVE)
            {
                c("AdActive");
                return;
            }
            if (inmobiadrequeststatus.getStatusCode() == InMobiAdRequestStatus.StatusCode.REQUEST_PENDING)
            {
                c("RequestPending");
                return;
            }
            if (inmobiadrequeststatus.getStatusCode() == InMobiAdRequestStatus.StatusCode.REQUEST_INVALID)
            {
                c("RequestInvalid");
                return;
            }
            if (inmobiadrequeststatus.getStatusCode() == InMobiAdRequestStatus.StatusCode.REQUEST_TIMED_OUT)
            {
                c("RequestTimedOut");
                return;
            }
            if (inmobiadrequeststatus.getStatusCode() == InMobiAdRequestStatus.StatusCode.EARLY_REFRESH_REQUEST)
            {
                c("EarlyRefreshRequest");
                return;
            }
        }
    }

    public void a(com.inmobi.ads.a a1)
    {
label0:
        {
            if (g() == AdState.STATE_LOADING)
            {
                if (!b(a1))
                {
                    break label0;
                }
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Ad fetch successful");
                a(AdState.STATE_AVAILABLE);
            }
            return;
        }
        c("ParsingFailed");
        a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true);
    }

    void a(h h1)
    {
        o = System.currentTimeMillis();
        (new g(h1, this)).a();
    }

    public void a(com.inmobi.commons.core.configs.a a1)
    {
        g = (com.inmobi.ads.b)a1;
        com.inmobi.commons.core.c.a.a().a(g.a(), g.m());
    }

    public void a(RenderView renderview)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Render view signaled ad ready");
    }

    public void a(RenderView renderview, HashMap hashmap)
    {
        com.inmobi.commons.core.utilities.Logger.InternalLogLevel internalloglevel = com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL;
        String s1 = a;
        StringBuilder stringbuilder = (new StringBuilder()).append("Ad reward action completed. Params:");
        if (hashmap == null)
        {
            renderview = null;
        } else
        {
            renderview = hashmap.toString();
        }
        Logger.a(internalloglevel, s1, stringbuilder.append(renderview).toString());
        m().b(hashmap);
    }

    public void a(String s1)
    {
        e = s1;
    }

    public void a(Map map)
    {
        f = map;
    }

    protected void a(boolean flag)
    {
        k = flag;
    }

    protected String b()
    {
        return "json";
    }

    public void b(RenderView renderview)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Render view signaled ad failed");
        c("RenderFailed");
    }

    public void b(RenderView renderview, HashMap hashmap)
    {
        com.inmobi.commons.core.utilities.Logger.InternalLogLevel internalloglevel = com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL;
        String s1 = a;
        StringBuilder stringbuilder = (new StringBuilder()).append("Ad interaction. Params:");
        if (hashmap == null)
        {
            renderview = null;
        } else
        {
            renderview = hashmap.toString();
        }
        Logger.a(internalloglevel, s1, stringbuilder.append(renderview).toString());
        m().a(hashmap);
    }

    protected void b(String s1)
    {
        p = SystemClock.elapsedRealtime();
        n().a(s1);
        z();
    }

    public boolean b(com.inmobi.ads.a a1)
    {
        boolean flag1 = false;
        boolean flag;
        try
        {
            JSONObject jsonobject = new JSONObject(a1.b());
            j = a1.d();
            i = a1.c();
            h = (new String(Base64.decode(jsonobject.getString("pubContent"), 0))).trim();
        }
        // Misplaced declaration of an exception variable
        catch (com.inmobi.ads.a a1)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Exception while parsing received ad.", a1);
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (com.inmobi.ads.a a1)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Invalid Base64 encoding in received ad.", a1);
            return false;
        }
        flag = flag1;
        if (h == null)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        flag = flag1;
        if (h.trim().length() == 0)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        h = h.replace("@__imm_aft@", String.valueOf(System.currentTimeMillis() - o));
        flag = true;
        return flag;
    }

    protected abstract String c();

    public void c(RenderView renderview)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "RenderView completed loading ad content");
    }

    protected void c(String s1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("impId", j());
        hashmap.put("errorCode", s1);
        hashmap.put("type", a());
        if (s1 != null && (s1.trim().equalsIgnoreCase("RenderFailed") || s1.trim().equalsIgnoreCase("RenderTimeOut")))
        {
            hashmap.put("renderLatency", Long.valueOf(SystemClock.elapsedRealtime() - p));
        }
        com.inmobi.commons.core.c.a.a().a("ads", "AdLoadFailed", hashmap);
    }

    protected abstract com.inmobi.rendering.RenderingProperties.PlacementType d();

    public void d(RenderView renderview)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Renderview visible");
    }

    protected void d(String s1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("impId", j());
        hashmap.put("errorCode", s1);
        hashmap.put("type", a());
        com.inmobi.commons.core.c.a.a().a("ads", "AdShowFailed", hashmap);
    }

    protected Map e()
    {
        return null;
    }

    public void e(RenderView renderview)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Ad displayed");
    }

    protected Context f()
    {
        return c;
    }

    public void f(RenderView renderview)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Ad dismissed");
    }

    public AdState g()
    {
        return b;
    }

    public void g(RenderView renderview)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "User left application");
        m().d();
    }

    protected String h()
    {
        return h;
    }

    long i()
    {
        return j;
    }

    protected String j()
    {
        return i;
    }

    protected void k()
    {
        h = null;
    }

    protected final com.inmobi.ads.b l()
    {
        return g;
    }

    protected final a m()
    {
        return l;
    }

    protected final RenderView n()
    {
        return m;
    }

    public void o()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("type", a());
        com.inmobi.commons.core.c.a.a().a("ads", "AdLoadRequested", hashmap);
        if (!com.inmobi.commons.core.utilities.d.a())
        {
            a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.NETWORK_UNREACHABLE), true);
            return;
        }
        if (b == AdState.STATE_LOADING || b == AdState.STATE_AVAILABLE)
        {
            a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REQUEST_PENDING), false);
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, a, "An ad load is already in progress. Please wait for the load to complete before requesting for another ad");
            return;
        }
        if (g() == AdState.STATE_ACTIVE)
        {
            a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_ACTIVE), false);
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, a, "An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad");
            return;
        } else
        {
            t();
            b = AdState.STATE_LOADING;
            com.inmobi.signals.o.a().j();
            q();
            s();
            a(y());
            return;
        }
    }

    protected boolean p()
    {
        return k;
    }

    protected void q()
    {
        m = new RenderView(f(), new RenderingProperties(d()));
        m.a(this, l().j(), l().k());
    }

    protected void r()
    {
        m.b("inmobi.recordEvent(120,null);");
    }

    void s()
    {
        com.inmobi.commons.core.utilities.uid.c.a().e();
    }

    protected void t()
    {
        i = null;
        RenderView renderview = n();
        if (renderview != null)
        {
            android.view.ViewParent viewparent = renderview.getParent();
            renderview.removeAllViews();
            if (viewparent != null)
            {
                ((ViewGroup)viewparent).removeView(renderview);
            }
            renderview.destroy();
        }
    }

    protected void u()
    {
        n.removeMessages(0);
    }

    protected void v()
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Renderview timed out.");
        c("RenderTimeOut");
        if (g() == AdState.STATE_AVAILABLE)
        {
            a(AdState.STATE_FAILED);
            m().a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
        }
    }

    protected void w()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("type", a());
        hashmap.put("renderLatency", Long.valueOf(SystemClock.elapsedRealtime() - p));
        com.inmobi.commons.core.c.a.a().a("ads", "AdLoadSuccessful", hashmap);
    }

}
