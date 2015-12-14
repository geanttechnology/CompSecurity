// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.SystemClock;
import com.inmobi.commons.core.c.a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.rendering.InMobiAdActivity;
import com.inmobi.rendering.RenderView;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.inmobi.ads:
//            AdUnit, InMobiAdRequestStatus, b, a

class n extends AdUnit
{

    private static final String a = com/inmobi/ads/n.getSimpleName();
    private int b;
    private boolean c;
    private int d;
    private long e;

    public n(Context context, long l, AdUnit.a a1)
    {
        super(context, l, a1);
        b = 0;
        c = false;
        d = -1;
        e = 0L;
    }

    void A()
    {
        c = true;
        if (n() != null)
        {
            n().o();
        }
    }

    protected String a()
    {
        return "int";
    }

    public void a(int i, int j)
    {
        try
        {
            f().getResources().getAnimation(i);
            f().getResources().getAnimation(j);
            d = i;
            n().setFullScreenExitAnimation(j);
        }
        catch (android.content.res.Resources.NotFoundException notfoundexception)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, a, "The supplied resource id with show for animations is invalid", notfoundexception);
        }
        x();
    }

    public void a(com.inmobi.ads.a a1)
    {
        super.a(a1);
        if (g() == AdUnit.AdState.STATE_AVAILABLE)
        {
            b(h());
        }
    }

    public void a(RenderView renderview)
    {
        super.a(renderview);
        if (g() == AdUnit.AdState.STATE_LOADED)
        {
            u();
            a(AdUnit.AdState.STATE_READY);
            w();
            m().a();
            r();
        }
    }

    public void b(RenderView renderview)
    {
        super.b(renderview);
        if (g() == AdUnit.AdState.STATE_LOADED)
        {
            u();
            a(AdUnit.AdState.STATE_FAILED);
            m().a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
        }
    }

    protected String c()
    {
        return null;
    }

    public void c(RenderView renderview)
    {
        super.c(renderview);
        if (g() == AdUnit.AdState.STATE_AVAILABLE)
        {
            a(AdUnit.AdState.STATE_LOADED);
        }
    }

    protected com.inmobi.rendering.RenderingProperties.PlacementType d()
    {
        return com.inmobi.rendering.RenderingProperties.PlacementType.FULL_SCREEN;
    }

    protected Map e()
    {
        HashMap hashmap = new HashMap();
        String s;
        if (p())
        {
            s = String.valueOf(1);
        } else
        {
            s = String.valueOf(0);
        }
        hashmap.put("preload-request", s);
        return hashmap;
    }

    public void e(RenderView renderview)
    {
        this;
        JVM INSTR monitorenter ;
        super.e(renderview);
        if (g() != AdUnit.AdState.STATE_RENDERED) goto _L2; else goto _L1
_L1:
        b = b + 1;
        if (b != 1) goto _L4; else goto _L3
_L3:
        m().b();
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        a(AdUnit.AdState.STATE_ACTIVE);
          goto _L5
        renderview;
        throw renderview;
_L2:
        if (g() != AdUnit.AdState.STATE_ACTIVE) goto _L5; else goto _L6
_L6:
        b = b + 1;
          goto _L5
    }

    public void f(RenderView renderview)
    {
        this;
        JVM INSTR monitorenter ;
        super.f(renderview);
        if (g() != AdUnit.AdState.STATE_ACTIVE) goto _L2; else goto _L1
_L1:
        b = b - 1;
        if (b == 1)
        {
            a(AdUnit.AdState.STATE_RENDERED);
        }
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (g() == AdUnit.AdState.STATE_RENDERED)
        {
            b = b - 1;
            a(AdUnit.AdState.STATE_CREATED);
            renderview = new HashMap();
            renderview.put("impId", j());
            com.inmobi.commons.core.c.a.a().a("ads", "IntClosed", renderview);
            m().c();
            t();
        }
        if (true) goto _L4; else goto _L3
_L3:
        renderview;
        throw renderview;
    }

    public void o()
    {
        if (e != 0L)
        {
            int i = l().f();
            if (SystemClock.elapsedRealtime() - e < (long)(i * 1000))
            {
                a((new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.EARLY_REFRESH_REQUEST)).setCustomMessage((new StringBuilder()).append("Ad cannot be refreshed before ").append(i).append(" seconds").toString()), false);
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, a, (new StringBuilder()).append("Ad cannot be refreshed before ").append(i).append(" seconds").toString());
                return;
            }
        }
        if (g() == AdUnit.AdState.STATE_RENDERED)
        {
            a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_ACTIVE), false);
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, a, "An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad.");
            return;
        } else
        {
            e = SystemClock.elapsedRealtime();
            super.o();
            return;
        }
    }

    protected void q()
    {
        super.q();
        if (c)
        {
            n().o();
        }
    }

    protected void t()
    {
        super.t();
        d = -1;
    }

    protected void v()
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Renderview timed out.");
        c("RenderTimeOut");
        if (g() == AdUnit.AdState.STATE_LOADED)
        {
            a(AdUnit.AdState.STATE_FAILED);
            m().a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
        }
    }

    public void x()
    {
        HashMap hashmap = new HashMap();
        String s = j();
        if (s != null)
        {
            hashmap.put("impId", s);
        }
        com.inmobi.commons.core.c.a.a().a("ads", "ShowInt", hashmap);
        if (!z())
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, a, "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling show.");
            d("ShowIntBeforeReady");
            return;
        } else
        {
            hashmap.put("type", a());
            com.inmobi.commons.core.c.a.a().a("ads", "AdRendered", hashmap);
            a(AdUnit.AdState.STATE_RENDERED);
            y();
            return;
        }
    }

    void y()
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append(">>> Starting ").append(com/inmobi/rendering/InMobiAdActivity.getSimpleName()).append(" to display interstitial ad ...").toString());
        int i = InMobiAdActivity.a(n());
        Intent intent = new Intent(f(), com/inmobi/rendering/InMobiAdActivity);
        intent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_RENDERVIEW_INDEX", i);
        intent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 102);
        intent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_IS_FULL_SCREEN", true);
        if (!(f() instanceof Activity))
        {
            intent.addFlags(0x10000000);
        }
        f().startActivity(intent);
        if ((f() instanceof Activity) && d != -1)
        {
            ((Activity)f()).overridePendingTransition(d, 0);
        }
    }

    public boolean z()
    {
        return g() == AdUnit.AdState.STATE_READY;
    }

}
