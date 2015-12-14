// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.content.Context;
import com.inmobi.commons.core.c.a;
import com.inmobi.rendering.RenderView;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.inmobi.ads:
//            AdUnit, InMobiBanner, a

class k extends AdUnit
{

    private static final String a = com/inmobi/ads/k.getSimpleName();
    private InMobiBanner b;
    private boolean c;
    private boolean d;
    private int e;

    public k(InMobiBanner inmobibanner, Context context, long l, AdUnit.a a1)
    {
        super(context, l, a1);
        c = true;
        d = false;
        e = 0;
        b = inmobibanner;
    }

    protected String a()
    {
        return "banner";
    }

    public void a(com.inmobi.ads.a a1)
    {
        super.a(a1);
        if (g() == AdUnit.AdState.STATE_AVAILABLE)
        {
            b(h());
        }
    }

    public void b(boolean flag)
    {
        c = flag;
        super.o();
    }

    protected String c()
    {
        return b.getFrameSizeString();
    }

    public void c(RenderView renderview)
    {
        super.c(renderview);
        if (g() == AdUnit.AdState.STATE_AVAILABLE)
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

    public void d(RenderView renderview)
    {
        super.d(renderview);
        if (g() == AdUnit.AdState.STATE_LOADED)
        {
            a(AdUnit.AdState.STATE_RENDERED);
            renderview = new HashMap();
            renderview.put("type", a());
            renderview.put("impId", j());
            com.inmobi.commons.core.c.a.a().a("ads", "AdRendered", renderview);
        }
    }

    protected Map e()
    {
        HashMap hashmap = new HashMap();
        String s;
        if (c)
        {
            s = String.valueOf(1);
        } else
        {
            s = String.valueOf(0);
        }
        hashmap.put("u-rt", s);
        hashmap.put("mk-ad-slot", b.getFrameSizeString());
        return hashmap;
    }

    public void e(RenderView renderview)
    {
        this;
        JVM INSTR monitorenter ;
        super.e(renderview);
        if (g() != AdUnit.AdState.STATE_RENDERED) goto _L2; else goto _L1
_L1:
        e = e + 1;
        a(AdUnit.AdState.STATE_ACTIVE);
        m().b();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (g() == AdUnit.AdState.STATE_ACTIVE)
        {
            e = e + 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        renderview;
        throw renderview;
    }

    public void f(RenderView renderview)
    {
        this;
        JVM INSTR monitorenter ;
        super.f(renderview);
        if (g() == AdUnit.AdState.STATE_ACTIVE)
        {
            e = e - 1;
            if (e == 0)
            {
                a(AdUnit.AdState.STATE_RENDERED);
                m().c();
            }
        }
        this;
        JVM INSTR monitorexit ;
        return;
        renderview;
        throw renderview;
    }

    protected void q()
    {
        super.q();
        if (d)
        {
            n().o();
        }
    }

    void x()
    {
        d = true;
        if (n() != null)
        {
            n().o();
        }
    }

    boolean y()
    {
        return d;
    }

    boolean z()
    {
        return g() == AdUnit.AdState.STATE_ACTIVE;
    }

}
